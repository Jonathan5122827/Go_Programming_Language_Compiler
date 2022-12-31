import java_cup . runtime . *;
import java.io.*;

public class GOPars	{

	public static void main	(String args[])	throws IOException 	{

		System.out.println("Source Program");
                System.out.println("--------------");
                System.out.println();

		try	{

			SymbolFactory symbolFactory = new ComplexSymbolFactory	();

			GOParser parser = new GOParser
							(new GOLexer
								(new InputStreamReader(System.in),
									symbolFactory));

			parser.parse();
		}

		catch(Exception e)	{

			System.out.println("Error in invoking parser/lexer");
		}
	}
}
