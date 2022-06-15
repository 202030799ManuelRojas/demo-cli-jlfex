package com.mrojas;

import java.io.*;

%%
%public
%class DemoLexer

digit = [0-9]
letter = [a-zA-Z]
whitespace = [\t\r]
newline = [\n]

%type Token

%eofval{
    return new Token(TokenConstants.EOF, null);
    /*Hacer algo al final del archivo*/
%eofval}
%%
({whitespace}|{newline}) {/*ignorar*/}
{letter}({letter}|{digit})* {return new Token(TokenConstants.ID, yytext());}
{digit}+ {return new Token(TokenConstants.NUM, yytext());}
[^] {throw new java.io.IOException("La cadena es ilegal > " + yytext());}