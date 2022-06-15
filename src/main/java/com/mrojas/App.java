package com.mrojas;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Hello world!
 *
 */
@CommandLine.Command(name = "lexer", mixinStandardHelpOptions = true, version = "0.0.1", description = "Simple lexer que reconoce ID, NUM y EOF")
public class App implements Callable<Integer> {

    @CommandLine.Option(names = { "-f", "--file" }, description = "Archivo a leer", required = false)
    private File file;

    @Override
    public Integer call() throws Exception {

        if (file != null) {
            BufferedReader brf = Files.newBufferedReader(file.toPath());
            DemoLexer lexer = new DemoLexer(brf);
            Token token = lexer.yylex();
            while (token.getTokenType() != TokenConstants.EOF) {
                System.out.println(token);
                token = lexer.yylex();
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            String input = "";
            while (!input.equals("exit")) {
                System.out.print("Ingrese la cadena > ");
                input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                DemoLexer demolexer = new DemoLexer(new StringReader(input));
                Token token = demolexer.yylex();
                System.out.println(token);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
