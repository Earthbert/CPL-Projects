package cool.semantic.symbol;

import java.io.File;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import cool.compiler.Compiler;
import cool.parser.CoolParser;
import cool.semantic.scope.GlobalScope;
import cool.semantic.scope.Scope;
import cool.utils.Utils;

public class SymbolTable {

	private static Scope<ClassSymbol> globals;

	private static SelfTypeSymbol selfType;

	private static boolean semanticErrors;

	public static void defineBasicClasses() {
		globals = new GlobalScope();
		semanticErrors = false;

		selfType = new SelfTypeSymbol();

		final ClassSymbol objectClass = new ClassSymbol(Utils.OBJECT, null);
		final ClassSymbol intClass = new ClassSymbol(Utils.INT, objectClass);
		final ClassSymbol stringClass = new ClassSymbol(Utils.STRING, objectClass);
		final ClassSymbol boolClass = new ClassSymbol(Utils.BOOL, objectClass);
		final ClassSymbol ioClass = new ClassSymbol(Utils.IO, objectClass);

		// Set parent classes
		intClass.setParent(objectClass);
		stringClass.setParent(objectClass);
		boolClass.setParent(objectClass);
		ioClass.setParent(objectClass);

		// Add Object methods
		objectClass.addMethod(new MethodSymbol("abort", objectClass, objectClass));
		objectClass.addMethod(new MethodSymbol("type_name", stringClass, objectClass));
		objectClass.addMethod(new MethodSymbol("copy", selfType, objectClass));

		// Add IO methods
		final MethodSymbol outStringMethod = new MethodSymbol("out_string", selfType,
				ioClass);
		final IdSymbol outStringParam = new IdSymbol("x", stringClass, IDSymbolType.FORMAT);
		outStringMethod.add(outStringParam);
		ioClass.addMethod(outStringMethod);

		final MethodSymbol outIntMethod = new MethodSymbol("out_int", selfType, ioClass);
		final IdSymbol outIntParam = new IdSymbol("x", intClass, IDSymbolType.FORMAT);
		outIntMethod.add(outIntParam);
		ioClass.addMethod(outIntMethod);

		ioClass.addMethod(new MethodSymbol("in_string", stringClass, ioClass));
		ioClass.addMethod(new MethodSymbol("in_int", intClass, ioClass));

		// Add String methods
		stringClass.addMethod(new MethodSymbol("length", intClass, stringClass));

		final MethodSymbol concatMethod = new MethodSymbol("concat", stringClass, stringClass);
		final IdSymbol concatParam = new IdSymbol("s", stringClass, IDSymbolType.FORMAT);
		concatMethod.add(concatParam);
		stringClass.addMethod(concatMethod);

		final MethodSymbol substrMethod = new MethodSymbol("substr", stringClass, stringClass);
		final IdSymbol substrParam1 = new IdSymbol("i", intClass, IDSymbolType.FORMAT);
		final IdSymbol substrParam2 = new IdSymbol("l", intClass, IDSymbolType.FORMAT);
		substrMethod.add(substrParam1);
		substrMethod.add(substrParam2);
		stringClass.addMethod(substrMethod);

		List.of(objectClass, intClass, stringClass, boolClass, ioClass).forEach(c -> globals.add(c));
	}

	public static SelfTypeSymbol getSelfType() {
		return selfType;
	}

	/**
	 * Displays a semantic error message.
	 * 
	 * @param ctx  Used to determine the enclosing class context of this error,
	 *             which knows the file name in which the class was defined.
	 * @param info Used for line and column information.
	 * @param str  The error message.
	 */
	public static void error(ParserRuleContext ctx, final Token info, final String str) {
		while (!(ctx.getParent() instanceof CoolParser.ProgramContext))
			ctx = ctx.getParent();

		final String message = "\"" + new File(Compiler.fileNames.get(ctx)).getName()
				+ "\", line " + info.getLine()
				+ ":" + (info.getCharPositionInLine() + 1)
				+ ", Semantic error: " + str;

		System.err.println(message);

		semanticErrors = true;
	}

	public static void error(final String str) {
		final String message = "Semantic error: " + str;

		System.err.println(message);

		semanticErrors = true;
	}

	public static boolean hasSemanticErrors() {
		return semanticErrors;
	}

	public static Scope<ClassSymbol> getGlobals() {
		return globals;
	}
}
