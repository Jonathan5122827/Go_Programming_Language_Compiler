import java_cup . runtime . *;
import java.io.*;

public class GOParsST	{

	public static void main	(String args[])

		throws IOException	{

			System.out.println("Source Program");
                        System.out.println("--------------");
                        System.out.println();

	try	{

		SymbolFactory symbolFatory = new ComplexSymbolFactory();

		GOParserST parser =
			new GOParserST (new GOLexer (new InputStreamReader(System.in),
				symbolFatory));

//		parser.parse();


      java_cup .runtime . Symbol parserValue = parser . parse ();
      SymbolTable env = (SymbolTable) parserValue . value;
//      SymbolTable env2 = new SymbolTable();
//env2 = (SymbolTable) parserValue . value;

      env . print ("main");

	}

	catch(Exception e)	{

		System . out . println ("Error in invoking parser/lexer");
		System . out . println (e);
	}
}
}
