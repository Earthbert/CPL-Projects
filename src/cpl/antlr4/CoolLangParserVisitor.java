// Generated from c:/Users/earthbert/University/CPL/Cool-AST/CoolLangParser.g4 by ANTLR 4.13.1
package cpl.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolLangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CoolLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(CoolLangParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(CoolLangParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(CoolLangParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(CoolLangParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolLangParser#case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase(CoolLangParser.CaseContext ctx);
}