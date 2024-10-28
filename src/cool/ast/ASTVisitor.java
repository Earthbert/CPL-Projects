package cool.ast;

import cool.ast.nodes.*;

public interface ASTVisitor<T> {
	T visit(ASTAssignment astAssignment);

	T visit(ASTInteger node);

	T visit(ASTString node);

	T visit(ASTBoolean node);

	T visit(ASTSelf astSelf);

	T visit(ASTClass astClass);

	T visit(ASTDef astDef);

	T visit(ASTField astField);

	T visit(ASTType astType);

	T visit(ASTMethod astMethod);

	T visit(ASTFormal astFormal);

	T visit(ASTLet astLet);

	T visit(ASTIf astIf);

	T visit(ASTWhile astWhile);

	T visit(ASTCase astCase);

	T visit(ASTBlock astBlock);

	T visit(ASTArithmetic astArithmetic);

	T visit(ASTComparison astComparison);

	T visit(ASTId astId);

	T visit(ASTNot astNot);

	T visit(ASTNeg astNeg);

	T visit(ASTIsVoid astIsVoid);

	T visit(ASTNew astNew);

	T visit(ASTCall astCall);

	T visit(ASTRoot astRoot);
}
