import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Test {

    static final boolean PRINT = true;
    static final boolean CLEAN_PRINT = true;

    public static void main(String[] args) throws IOException {
        // var input = CharStreams.fromFileName("main.cl");
        var input = CharStreams.fromString("if 1 then 2 else 3 fi");

        var lexer = new CoolLangLexer(input);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new CoolLangParser(tokenStream);
        var tree = parser.expr();

        System.out.println(tree.toStringTree(parser));
    }
}
