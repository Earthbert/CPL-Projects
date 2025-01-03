package cool.ast;

import cool.ast.nodes.*;
import cool.ast.nodes.ASTCase.ASTCaseBranch;

public interface ASTVisitor<T> {
	default T visit(final ASTAssignment astAssignment) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTCaseBranch astCaseBranch) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTInteger node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTString node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTBoolean node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTClass astClass) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTDef astDef) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTField astField) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTType astType) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTMethod astMethod) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTFormal astFormal) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTLet astLet) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTIf astIf) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTWhile astWhile) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTCase astCase) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTBlock astBlock) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTArithmetic astArithmetic) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTComparison astComparison) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTId astId) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTNot astNot) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTNeg astNeg) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTIsVoid astIsVoid) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTNew astNew) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTCall astCall) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTRoot astRoot) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(final ASTBinaryOp ast2OperandOp) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}
}
