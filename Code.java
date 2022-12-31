import java.util.*;

public class Code	{

	private static int label;
        private static int temp;

	private SymbolTable env;
	private String code;

	public Code(SymbolTable env, String code)	{

		this.env =env;
		this.code = code;
	}

	public SymbolTable env()	{return env;}

	public String code()	{return code;}

	public String generate (String blockName)	{

		String genCode;

		if(blockName.equals("main"))
			genCode = "int ";
		else
			genCode = "void ";

		genCode = genCode + blockName + " ()	{\n";
		genCode = genCode + env.code();
		genCode = genCode + code;
		if(blockName.equals("main"))
			genCode = genCode + " return 0;\n";
		genCode = genCode + "}\n";
		return genCode;
	}

	public static void initLabel()	{label = 0; }

	public static String newLabel()	{

		String newLabel = "_L" + label;
		label++;

		return newLabel;
	}

        public static void initTemp()  {temp = 0; }

        public static String newTemp() {

                String newTemp = "_T" + label;
                label++;

                return newTemp;
        }


}


