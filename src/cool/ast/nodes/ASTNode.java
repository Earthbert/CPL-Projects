package cool.ast.nodes;

import cool.ast.ASTVisitor;

public abstract class ASTNode {
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}
