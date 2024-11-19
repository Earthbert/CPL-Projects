package cool.semantic.symbol;

import java.io.File;
import java.util.List;

import org.antlr.v4.runtime.*;

import cool.compiler.Compiler;
import cool.parser.CoolParser;
import cool.semantic.scope.Scope;
import cool.utils.Utils;

public class SymbolTable {
	private static Scope globals;

	private static boolean semanticErrors;

	public static void defineBasicClasses() {
		globals = new Scope(null);
		semanticErrors = false;

		ClassSymbol objectClass = new ClassSymbol(Utils.OBJECT, globals);
		ClassSymbol intClass = new ClassSymbol(Utils.INT, objectClass.getScope());
		ClassSymbol stringClass = new ClassSymbol(Utils.STRING, objectClass.getScope());
		ClassSymbol boolClass = new ClassSymbol(Utils.BOOL, objectClass.getScope());
		ClassSymbol ioClass = new ClassSymbol(Utils.IO, objectClass.getScope());

		// Set parent classes
		intClass.setParent(objectClass);
		stringClass.setParent(objectClass);
		boolClass.setParent(objectClass);
		ioClass.setParent(objectClass);

		// Add Object methods
		objectClass.getScope().addMethod(new MethodSymbol("abort", objectClass, objectClass.getScope()));
		objectClass.getScope().addMethod(new MethodSymbol("type_name", stringClass, objectClass.getScope()));
		objectClass.getScope().addMethod(new MethodSymbol("copy", objectClass, objectClass.getScope()));

		// Add IO methods
		MethodSymbol outStringMethod = new MethodSymbol("out_string", ioClass, ioClass.getScope());
		IdSymbol outStringParam = new IdSymbol("x");
		outStringParam.setType(stringClass);
		outStringMethod.getScope().add(outStringParam);
		ioClass.getScope().addMethod(outStringMethod);

		MethodSymbol outIntMethod = new MethodSymbol("out_int", ioClass, ioClass.getScope());
		IdSymbol outIntParam = new IdSymbol("x");
		outIntParam.setType(intClass);
		outIntMethod.getScope().add(outIntParam);
		ioClass.getScope().addMethod(outIntMethod);

		ioClass.getScope().addMethod(new MethodSymbol("in_string", stringClass, ioClass.getScope()));
		ioClass.getScope().addMethod(new MethodSymbol("in_int", intClass, ioClass.getScope()));

		// Add String methods
		stringClass.getScope().addMethod(new MethodSymbol("length", intClass, stringClass.getScope()));

		MethodSymbol concatMethod = new MethodSymbol("concat", stringClass, stringClass.getScope());
		IdSymbol concatParam = new IdSymbol("s");
		concatParam.setType(stringClass);
		concatMethod.getScope().add(concatParam);
		stringClass.getScope().addMethod(concatMethod);

		MethodSymbol substrMethod = new MethodSymbol("substr", stringClass, stringClass.getScope());
		IdSymbol substrParam1 = new IdSymbol("i");
		IdSymbol substrParam2 = new IdSymbol("l");
		substrParam1.setType(intClass);
		substrParam2.setType(intClass);
		substrMethod.getScope().add(substrParam1);
		substrMethod.getScope().add(substrParam2);
		stringClass.getScope().addMethod(substrMethod);

		List.of(objectClass, intClass, stringClass, boolClass, ioClass).forEach(c -> globals.add(c));
	}

	/**
	 * Displays a semantic error message.
	 * 
	 * @param ctx  Used to determine the enclosing class context of this error,
	 *             which knows the file name in which the class was defined.
	 * @param info Used for line and column information.
	 * @param str  The error message.
	 */
	public static void error(ParserRuleContext ctx, Token info, String str) {
		while (!(ctx.getParent() instanceof CoolParser.ProgramContext))
			ctx = ctx.getParent();

		String message = "\"" + new File(Compiler.fileNames.get(ctx)).getName()
				+ "\", line " + info.getLine()
				+ ":" + (info.getCharPositionInLine() + 1)
				+ ", Semantic error: " + str;

		System.err.println(message);

		semanticErrors = true;
	}

	public static void error(String str) {
		String message = "Semantic error: " + str;

		System.err.println(message);

		semanticErrors = true;
	}

	public static boolean hasSemanticErrors() {
		return semanticErrors;
	}

	public static Scope getGlobals() {
		return globals;
	}
}
