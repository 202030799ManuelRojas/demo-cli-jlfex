package com.mrojas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

public class DemoLexerTest {
    
    @Test
    public void marchID() throws IOException{
        String testString = "id13654";
        Reader stringReader = new StringReader(testString);
        DemoLexer lexer = new DemoLexer(stringReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.ID, token.getTokenType());
    }

    @Test
    public void marchNUM() throws IOException{
        String testString = "13654";
        Reader stringReader = new StringReader(testString);
        DemoLexer lexer = new DemoLexer(stringReader);
        Token token = lexer.yylex();
        assertEquals(TokenConstants.NUM, token.getTokenType());
    }

    @Test
    public void noMatch() throws IOException{
        String testString = "@";

        Exception exception = assertThrows(IOException.class, ()->{
            Reader stringReader = new StringReader(testString);
            DemoLexer lexer = new DemoLexer(stringReader);
            Token token = lexer.yylex();
        });
    }
}
