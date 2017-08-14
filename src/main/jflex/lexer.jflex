package parse;

import java_cup.runtime.Symbol;
import static error.ErrorHelper.error;

%%

%public
%final
%class Lexer
%implements SymbolConstants
%cupsym SymbolConstants
%cup
%line
%column

%eofval{
    return tok(EOF);
%eofval}

%ctorarg String unitName

%init{
   this.unit = unitName;
%init}

%{
   private String unit;

   // auxiliary methods to construct terminal symbols at current location

   private Symbol tok(int type, String lexeme, Object value) {
      return new Symbol(type, yyline, yycolumn, value);
   }

   private Symbol tok(int type, Object value) {
      return tok(type, yytext(), value);
   }

   private Symbol tok(int type) {
      return tok(type, null);
   }
%}

litint    = [0-9]+
litfloat1 = [0-9]+ "." [0-9]*
litfloat2 = [0-9]* "." [0-9]+
litfloat3 = ({litint} | {litfloat1} | {litfloat2}) [eE] [+-]? {litint}
litreal   = {litint} | {litfloat1} | {litfloat2} | {litfloat3}

id        = [a-zA-Z][a-zA-Z0-9_]*

%%

[ \t\f\n\r]+         { /* skip */ }

{litreal}            { return tok(NUM, new Double(yytext())); }

print                { return tok(PRINT); }

{id}                 { return tok(ID, yytext().intern()); }

"+"                  { return tok(PLUS); }
"-"                  { return tok(MINUS); }
"*"                  { return tok(TIMES); }
"/"                  { return tok(DIV); }
"("                  { return tok(LPAREN); }
")"                  { return tok(RPAREN); }
","                  { return tok(COMMA); }
";"                  { return tok(SEMICOLON); }
":="                 { return tok(ASSIGN); }

.                    { throw error("unexpected char '%s'", yytext()); }
