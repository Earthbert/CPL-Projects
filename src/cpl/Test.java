package cpl;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import cpl.antlr4.*;

public class Test {

    static final boolean PRINT = true;
    static final boolean CLEAN_PRINT = true;

    public static void main(String[] args) throws IOException {
        var input = CharStreams.fromFileName("main.cl");

        var lexer = new CoolLangLexer(input);
        var tokenStream = new CommonTokenStream(lexer);

        var parser = new CoolLangParser(tokenStream);
        var tree = parser.program();

        System.out.println(tree.toStringTree(parser));
    }
}
