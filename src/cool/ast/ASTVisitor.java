package cool.ast;

import cool.ast.nodes.*;

public interface ASTVisitor<T> {
	T visit(ASTId node);
	T visit(ASTInteger node);
	T visit(ASTString node);
	T visit(ASTSelf node);
	T visit(ASTBoolean node);
}
