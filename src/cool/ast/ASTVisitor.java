package cool.ast;

import cool.ast.nodes.*;

public interface ASTVisitor<T> {
	T visit(ASTId node);

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
}
