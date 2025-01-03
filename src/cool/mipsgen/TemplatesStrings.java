package cool.mipsgen;

public class TemplatesStrings {
	
	public static class P {
		public static final String SEQUENCE = "sequence";
		public static final String SPACED_SEQUENCE = "sequenceSpaced";
		public static final String E = "e";

		public static final String PROGRAM = "program";

		public static final String DATA = "data";
		public static final String TEXT = "text";
	}

	public static class T {
		public static final String PROLOGUE = "prologue";

		public static final String INIT_OBJECT = "initObject";
		public static final String OBJECT_LABEL = "objectLabel";
		public static final String FIELDS_INIT = "fieldsInit";
		public static final String PARENT_INIT_LABEL = "parentInitLabel";
		
		public static final String METHOD_DEFINITION = "methodDefinition";
		public static final String METHOD_LABEL = "methodLabel";
		public static final String METHOD_BODY = "methodBody";
		public static final String PARAMS_SIZE = "paramsSize";
		public static final String FP_OFFSET = "fpOffset";
		
		public static final String STACK_SIZE = "stackSize";

		public static final String METHOD_CALL = "methodCall";
		public static final String SUBJECT = "subject";
		public static final String STATIC_TYPE = "staticType";
		public static final String METHOD_OFFSET = "methodOffset";
		public static final String DISPATCH_LABEL = "dispatchLabel";
		public static final String FILE_NAME_LABEL = "fileNameLabel";
		public static final String LINE = "line";
		public static final String PARAMS = "params";

		public static final String NEW = "new";
		public static final String CLASS_NAME = "className";
		public static final String NEW_SELF = "newSelf";

		public static final String LET = "let";
		public static final String INIT_EXPR = "initExpr";
		public static final String EXPR = "expr";

		public static final String IF = "if";
		public static final String CONDITION = "condition";
		public static final String THEN_BRANCH = "thenBranch";
		public static final String ELSE_BRANCH = "elseBranch";
		public static final String ELSE_LABEL = "elseLabel";
		public static final String END_LABEL = "endLabel";

		public static final String ISVOID = "isvoid";
		public static final String TRUE_LABEL = "trueLabel";
		public static final String FALSE_LABEL = "falseLabel";

		public static final String EVALUATE_SELF = "evaluateSelf";

		public static final String LOAD_ADDRESS = "loadAddress";
		public static final String ADDRESS = "address";

		public static final String RESERVE_STACK = "reserveStack";
		public static final String STORE_STACK = "storeStack";
		public static final String STORE_FIELD = "storeField";
		public static final String LOAD_FIELD = "loadField";
		public static final String STORE_FORMAL = "storeFormal";
		public static final String LOAD_FORMAL = "loadFormal";
		public static final String LOAD_LOCAL = "loadLocal";
		public static final String STORE_LOCAL = "storeLocal";
		public static final String LOAD_IMMEDIATE = "loadImmediate";
		
		public static final String VALUE = "value";
		public static final String SIZE = "size";
		public static final String OFFSET = "offset";
	}

	public static class D {
		public static final String PROLOGUE = "prologue";

		public static final String CLASS_TAG = "classTag";
		public static final String NAME = "name";
		public static final String TAG = "tag";

		public static final String CLASS_NAMES_TABLE = "classNamesTable";
		public static final String CLASS_OBJ_TABLE = "classObjTable";
		public static final String CLASS_DISP_TABLE = "classDispTable";

		public static final String METADATA = "metadata";
		public static final String LABEL = "label";
		public static final String CLASS_NAME = "className";
		public static final String SIZE = "size";

		public static final String PROTOTYPE = "prototype";
		public static final String DATA = "data";

		public static final String ASCII = "ascii";
		public static final String WORD = "word";
		public static final String VALUE = "value";
	}
}
