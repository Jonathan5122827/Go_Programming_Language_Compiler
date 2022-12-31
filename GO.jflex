

import java_cup.runtime.*;
import java.io.*;
%%

%class GOLexer
%unicode
%line
%column
%cupsym Symbol
%cup
%eofval{

	return symbolFactory.newSymbol("EOF",Symbol.EOF);
%eofval}

%{

	private SymbolFactory symbolFactory;

	public GOLexer(InputStreamReader input, SymbolFactory sf)	{

		this(input);
		symbolFactory = sf;
	}

	private void echo()	{System.out.print(yytext());}

	public int position()	{return yycolumn;}
%} 

/*

Indentifer = [:letter:] [:letter:|:digit:]*

*/
Indentifer = [A-Za-z_$] [A-Za-z_$0-9]*
Integer = [:digit:][:digit:]*

%%

[ \t\n]	{	echo();	}

"//".*	{	}


";"	{echo ();
		return symbolFactory.newSymbol("(punctuation, ;)",Symbol.SEMICOLON);	}

"."     {echo ();
                return symbolFactory.newSymbol("(punctuation, .)",Symbol.PERIOD);    }

","     {echo ();
                return symbolFactory.newSymbol("(punctuation, ,)",Symbol.COMMA);    }

"{"     {echo ();
                return symbolFactory.newSymbol("(punctuation, {)",Symbol.LBRACE);    }

"}"     {echo ();
                return symbolFactory.newSymbol("(punctuation, })",Symbol.RBRACE);    }



"<"     {echo ();
                return symbolFactory.newSymbol("(operator, <)",Symbol.LT);    }

"<="     {echo ();
                return symbolFactory.newSymbol("(operator, <=)",Symbol.LE);    }

">"     {echo ();
                return symbolFactory.newSymbol("(operator, >)",Symbol.GT);    }

">="     {echo ();
                return symbolFactory.newSymbol("(operator, >=)",Symbol.GE);    }

"="     {echo ();
                return symbolFactory.newSymbol("(operator, =)",Symbol.ASSIGN);    }

"=="     {echo ();
                return symbolFactory.newSymbol("(operator, ==)",Symbol.EQ);    }

"!="     {echo ();
                return symbolFactory.newSymbol("(operator, !=)",Symbol.NQ);    }

"|"     {echo ();
                return symbolFactory.newSymbol("(operator, |)",Symbol.OR);    }

"&"     {echo ();
                return symbolFactory.newSymbol("(operator, &)",Symbol.REF);    }

"("     {echo ();
                return symbolFactory.newSymbol("(operator, ()",Symbol.LPAREN);    }

")"     {echo ();
                return symbolFactory.newSymbol("(operator, ))",Symbol.RPAREN);    }

"+"     {echo ();
                return symbolFactory.newSymbol("(operator, +)",Symbol.PLUS);    }

"-"     {echo ();
                return symbolFactory.newSymbol("(operator, -)",Symbol.MINUS);    }

"*"     {echo ();
                return symbolFactory.newSymbol("(operator, *)",Symbol.TIMES);    }

"/"     {echo ();
                return symbolFactory.newSymbol("(operator, ))",Symbol.DIVID);    }

"["     {echo ();
                return symbolFactory.newSymbol("(operator, [)",Symbol.LBRACK);    }

"]"     {echo ();
                return symbolFactory.newSymbol("(operator, ])",Symbol.RBRACK);    }

"\""     {echo ();
                return symbolFactory.newSymbol("(punctuation, \")",Symbol.QUOTE);    }




package     {echo ();
                return symbolFactory.newSymbol("(keyword, package)",Symbol.PACKAGE);    }

main     {echo ();
                return symbolFactory.newSymbol("(keyword, main)",Symbol.MAIN);    }

import     {echo ();
                return symbolFactory.newSymbol("(keyword, import)",Symbol.IMPORT);    }

func     {echo ();
                return symbolFactory.newSymbol("(keyword, func)",Symbol.FUNC);    }

var     {echo ();
                return symbolFactory.newSymbol("(keyword, var)",Symbol.VAR);    }

int     {echo ();
                return symbolFactory.newSymbol("(keyword, int)",Symbol.INT);    }

fmt     {echo ();
                return symbolFactory.newSymbol("(keyword, fmt)",Symbol.FMT);    }

Scanf     {echo ();
                return symbolFactory.newSymbol("(keyword, Scanf)",Symbol.SCANF);    }

for     {echo ();
                return symbolFactory.newSymbol("(keyword, for)",Symbol.FOR);    }

Println     {echo ();
                return symbolFactory.newSymbol("(keyword, Println)",Symbol.PRINTLN);    }

return     {echo ();
                return symbolFactory.newSymbol("(keyword, return)",Symbol.RETURN);    }

if     {echo ();
                return symbolFactory.newSymbol("(keyword, if)",Symbol.IF);    }

else     {echo ();
                return symbolFactory.newSymbol("(keyword, else)",Symbol.ELSE);    }

"\"fmt\""     {echo ();
                return symbolFactory.newSymbol("(string, \"fmt\")",Symbol.FTM2);    }

"\"%d\""     {echo ();
                return symbolFactory.newSymbol("(string, \"%d\")",Symbol.D);    }

{Integer}     {echo ();
                return symbolFactory.newSymbol("(integer, " + yytext() + ")",Symbol.INTEGER,yytext());    }

{Indentifer}     {echo ();
                return symbolFactory.newSymbol("(identifier, " + yytext() + ")",Symbol.ID,yytext());    }

	
.	{echo();	ErrorMessage.print(yychar, "Illegal character");}
