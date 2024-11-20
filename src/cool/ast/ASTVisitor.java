package cool.ast;

import cool.ast.nodes.*;
import cool.ast.nodes.ASTCase.ASTCaseBranch;

public interface ASTVisitor<T> {
	default T visit(ASTAssignment astAssignment) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTCaseBranch astCaseBranch) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTInteger node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTString node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTBoolean node) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTClass astClass) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTDef astDef) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTField astField) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTType astType) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTMethod astMethod) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTFormal astFormal) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTLet astLet) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTIf astIf) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTWhile astWhile) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTCase astCase) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTBlock astBlock) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTArithmetic astArithmetic) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTComparison astComparison) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTId astId) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTNot astNot) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTNeg astNeg) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTIsVoid astIsVoid) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTNew astNew) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTCall astCall) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}

	default T visit(ASTRoot astRoot) {
		throw new UnsupportedOperationException("Unimplemented method 'visit'");
	}
}
