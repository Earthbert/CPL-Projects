package cool.ast.nodes;

import cool.ast.ASTVisitor;

public abstract class ASTNode {

    public <T> T accept(final ASTVisitor<T> visitor) {
        return null;
    }
}
