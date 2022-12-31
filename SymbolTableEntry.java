import java.util.*;

class SymbolTableEntry	{

	private Category category;
	private SymbolTable localEnv;
	private String funcCode;
        private Type type;
	private LinkedList<Type> argTypes;

	public SymbolTableEntry(Category category)	{

		this.category = category;
	}

        public SymbolTableEntry(Category category, Type type)        {

                this.category = category;
		this.type = type;
        }

	public SymbolTableEntry(Category category, SymbolTable env)        {

		this.category = category;
		this.localEnv = env;
	}

        public SymbolTableEntry(Category category, SymbolTable env, String code)        {

                this.category = category;
                this.localEnv = env;
                this.funcCode = code;
        }

        public SymbolTableEntry(Category category, Type type, LinkedList<Type> argTypes, SymbolTable env)        {

                this.category = category;
                this.type = type;
                this.localEnv = env;
		this.argTypes = argTypes;
        }


	public Category category()	{return category;}

	public SymbolTable localEnv()	{return localEnv;}

	public String funcCode()	{return funcCode;}

        public void setCode(String code)        {funcCode = code;}

        public Type type()        {return type;}

	public String toString()	{

		String printString = category.name();

		if(category == Category.VARIABLE || category == Category.FUNCTION)	{
			if(category == Category.VARIABLE )	{

				printString = printString + " " + type;
			}

			else	{

				printString = printString + " " + argTypes + "->" + type;
			}
		}

		return printString;
	}
}
