import java_cup . runtime . *;
import java.io.*;

public class GOParsCode	{

	public static void main	(String args[])

		throws IOException	{

			System.out.println("Source Program");
                        System.out.println("--------------");
                        System.out.println();

	try	{

		SymbolFactory symbolFatory = new ComplexSymbolFactory();

		GOParserCode parser =
			new GOParserCode (new GOLexer (new InputStreamReader(System.in),
				symbolFatory));

//		parser.parse();


      java_cup .runtime . Symbol parserValue = parser . parse ();
      Code code = (Code) parserValue . value;
//      SymbolTable env2 = new SymbolTable();
//env2 = (SymbolTable) parserValue . value;

      code.env() . print ("main");

	String outputFile = args[0] + ".c";

	PrintStream outStream = new PrintStream(outputFile);
	outStream.print(code.generate("main"));

	}

	catch(Exception e)	{

		System . out . println ("Error in invoking parser/lexer");
		System . out . println (e);
	}
}
}
