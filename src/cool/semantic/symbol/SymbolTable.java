package cool.semantic.symbol;

import java.io.File;
import java.util.List;

import org.antlr.v4.runtime.*;

import cool.compiler.Compiler;
import cool.parser.CoolParser;
import cool.semantic.scope.GlobalScope;
import cool.semantic.scope.Scope;
import cool.utils.Utils;

public class SymbolTable {

	private static Scope<ClassSymbol> globals;

	private static boolean semanticErrors;

	public static void defineBasicClasses() {
		globals = new GlobalScope();
		semanticErrors = false;

		ClassSymbol objectClass = new ClassSymbol(Utils.OBJECT, null);
		ClassSymbol intClass = new ClassSymbol(Utils.INT, objectClass);
		ClassSymbol stringClass = new ClassSymbol(Utils.STRING, objectClass);
		ClassSymbol boolClass = new ClassSymbol(Utils.BOOL, objectClass);
		ClassSymbol ioClass = new ClassSymbol(Utils.IO, objectClass);

		// Set parent classes
		intClass.setParent(objectClass);
		stringClass.setParent(objectClass);
		boolClass.setParent(objectClass);
		ioClass.setParent(objectClass);

		// Add Object methods
		objectClass.addMethod(new MethodSymbol("abort", objectClass, objectClass));
		objectClass.addMethod(new MethodSymbol("type_name", stringClass, objectClass));
		objectClass.addMethod(new MethodSymbol("copy", objectClass, objectClass));

		// Add IO methods
		MethodSymbol outStringMethod = new MethodSymbol("out_string", ioClass, ioClass);
		IdSymbol outStringParam = new IdSymbol("x");
		outStringParam.setType(stringClass);
		outStringMethod.add(outStringParam);
		ioClass.addMethod(outStringMethod);

		MethodSymbol outIntMethod = new MethodSymbol("out_int", ioClass, ioClass);
		IdSymbol outIntParam = new IdSymbol("x");
		outIntParam.setType(intClass);
		outIntMethod.add(outIntParam);
		ioClass.addMethod(outIntMethod);

		ioClass.addMethod(new MethodSymbol("in_string", stringClass, ioClass));
		ioClass.addMethod(new MethodSymbol("in_int", intClass, ioClass));

		// Add String methods
		stringClass.addMethod(new MethodSymbol("length", intClass, stringClass));

		MethodSymbol concatMethod = new MethodSymbol("concat", stringClass, stringClass);
		IdSymbol concatParam = new IdSymbol("s");
		concatParam.setType(stringClass);
		concatMethod.add(concatParam);
		stringClass.addMethod(concatMethod);

		MethodSymbol substrMethod = new MethodSymbol("substr", stringClass, stringClass);
		IdSymbol substrParam1 = new IdSymbol("i");
		IdSymbol substrParam2 = new IdSymbol("l");
		substrParam1.setType(intClass);
		substrParam2.setType(intClass);
		substrMethod.add(substrParam1);
		substrMethod.add(substrParam2);
		stringClass.addMethod(substrMethod);

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

	public static Scope<ClassSymbol> getGlobals() {
		return globals;
	}
}
