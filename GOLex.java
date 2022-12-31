import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;
import java.io.*;

public class GOLex	{

	private static final int MAX_TOKENS = 1000;

	public static void main(String[] args)	throws IOException	{

		int i,n;

		java_cup.runtime.Symbol [] token = new java_cup.runtime.Symbol[MAX_TOKENS];

		SymbolFactory symbolFactory = new ComplexSymbolFactory();

		GOLexer lexer = new GOLexer(new InputStreamReader(System.in),symbolFactory);

		System.out.println("Source Program");
                System.out.println("--------------");
                System.out.println();

		n = -1;

		do	{

			if(n < MAX_TOKENS)	{

				token[++n] = lexer.next_token();
			}

			else	{

				ErrorMessage.print(0,"Maximum number of tokens exceeded");
			}

		}while(token[n].sym != Symbol.EOF);

                System.out.println();
                System.out.println("List of Tokens");
                System.out.println("--------------");
                System.out.println();

		for(i = 0; i < n; i++)	{

	                System.out.println(token[i]);
		}
                System.out.println();
	}
}
