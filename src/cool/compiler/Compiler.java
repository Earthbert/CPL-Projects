package cool.compiler;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.stringtemplate.v4.ST;

import cool.ast.ASTBuilderVisitor;
import cool.ast.nodes.ASTNode;
import cool.ast.visitors.ASTPrintVisitor;
import cool.ast.visitors.semantic.ASTSemanticVisitor;
import cool.lexer.CoolLexer;
import cool.mipsgen.MIPSGen;
import cool.parser.CoolParser;
import cool.semantic.symbol.SymbolTable;

public class Compiler {
	// Annotates class nodes with the names of files where they are defined.
	public static ParseTreeProperty<String> fileNames = new ParseTreeProperty<>();

	public static Boolean printAST = false;

	public static void main(final String[] args) throws IOException {
		if (args.length == 0) {
			System.err.println("No file(s) given");
			return;
		}

		CoolLexer lexer = null;
		CommonTokenStream tokenStream = null;
		CoolParser parser = null;
		ParserRuleContext globalTree = null;

		// True if any lexical or syntax errors occur.
		boolean lexicalSyntaxErrors = false;

		// Parse each input file and build one big parse tree out of
		// individual parse trees.
		for (final var fileName : args) {
			final var input = CharStreams.fromFileName(fileName);

			// Lexer
			if (lexer == null)
				lexer = new CoolLexer(input);
			else
				lexer.setInputStream(input);

			// Token stream
			if (tokenStream == null)
				tokenStream = new CommonTokenStream(lexer);
			else
				tokenStream.setTokenSource(lexer);

			// Parser
			if (parser == null)
				parser = new CoolParser(tokenStream);
			else
				parser.setTokenStream(tokenStream);

			// Customized error listener, for including file names in error
			// messages.
			final var errorListener = new BaseErrorListener() {
				public boolean errors = false;

				@Override
				public void syntaxError(final Recognizer<?, ?> recognizer,
						final Object offendingSymbol,
						final int line, final int charPositionInLine,
						final String msg,
						final RecognitionException e) {
					String newMsg = "\"" + new File(fileName).getName() + "\", line " +
							line + ":" + (charPositionInLine + 1) + ", ";

					final Token token = (Token) offendingSymbol;
					if (token.getType() == CoolLexer.ERROR)
						newMsg += "Lexical error: " + token.getText();
					else
						newMsg += "Syntax error: " + msg;

					System.err.println(newMsg);
					this.errors = true;
				}
			};

			parser.removeErrorListeners();
			parser.addErrorListener(errorListener);

			// Actual parsing
			final var tree = parser.program();
			if (globalTree == null)
				globalTree = tree;
			else
				// Add the current parse tree's children to the global tree.
				for (int i = 0; i < tree.getChildCount(); i++)
					globalTree.addAnyChild(tree.getChild(i));

			// Annotate class nodes with file names, to be used later
			// in semantic error messages.
			for (int i = 0; i < tree.getChildCount(); i++) {
				final var child = tree.getChild(i);
				// The only ParserRuleContext children of the program node
				// are class nodes.
				if (child instanceof ParserRuleContext)
					fileNames.put(child, fileName);
			}

			// Record any lexical or syntax errors.
			lexicalSyntaxErrors |= errorListener.errors;
		}

		// Stop before semantic analysis phase, in case errors occurred.
		if (lexicalSyntaxErrors) {
			System.err.println("Compilation halted");
			return;
		}

		final ASTNode astRoot = globalTree.accept(new ASTBuilderVisitor());

		if (printAST) {
			astRoot.accept(new ASTPrintVisitor());
			return;
		}

		SymbolTable.defineBasicClasses();

		ASTSemanticVisitor.applyVisitor(astRoot);

		if (SymbolTable.hasSemanticErrors()) {
			System.err.println("Compilation halted");
			return;
		}

		final ST data = new MIPSGen().generateProgram(astRoot);

		if (System.getenv("OUTPUT_FILE") != null)
			try (final var writer = new java.io.PrintWriter(System.getenv("OUTPUT_FILE"))) {
				writer.println(data.render());
			}
		else
			System.out.println(data.render());
	}
}
