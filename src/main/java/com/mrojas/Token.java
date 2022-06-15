package com.mrojas;

public class Token {
    private TokenConstants tokenType;
    private String lexeme;

    public Token(TokenConstants tokenType, String lexeme) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
    }

    public TokenConstants getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenConstants tokenType) {
        this.tokenType = tokenType;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "Token [lexeme=" + lexeme + ", tokenType=" + tokenType + "]";
    }
    
    

}
