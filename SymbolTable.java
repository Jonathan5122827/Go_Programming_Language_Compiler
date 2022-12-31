import java.util.TreeMap;
import java.util.*;

public class SymbolTable	{

	private static int maxlen = 2;

	public static int maxLen()	{return maxlen;}

	private SymbolTable parent;

	private TreeMap <String,SymbolTableEntry> table;

	public SymbolTable(SymbolTable staticParent)	{

		parent = staticParent;
		table = new TreeMap<String,SymbolTableEntry> ();
	}


	public SymbolTable parent () { return parent; }

	public SymbolTableEntry entry(String id)	{

		SymbolTableEntry idEntry = table.get(id);
		if(idEntry == null)
			if(parent != null)
				idEntry = parent.entry(id);
		return idEntry;
	}

	public void enter(String id, SymbolTableEntry entry)	{

		SymbolTableEntry idEntry = table.get(id);
		table.put(id,entry);

		if(id.length() > maxlen)	{

			maxlen = id.length();
		}
	}

        public void enterVar(String id,Type type) {

                enter(id, new SymbolTableEntry(Category.VARIABLE,type));
        }

	public void enterFunc(String id, Type type, LinkedList<Type> argTypes, SymbolTable env)	{

		enter(id, new SymbolTableEntry(Category.FUNCTION, type, argTypes, env));
	}

	public void enterFuncCode(String id,String code)	{

		SymbolTableEntry idEntry = table.get(id);
		idEntry.setCode(code);
	}

	public String code()	{

		String genCode = "";
		Iterator <Map.Entry<String, SymbolTableEntry>> envIterator = table.entrySet().iterator();

		while(envIterator.hasNext())	{

			Map.Entry<String,SymbolTableEntry> entry = envIterator.next();
			String id = entry.getKey();
			SymbolTableEntry idEntry = entry.getValue();
			if(idEntry.category() == Category.VARIABLE)
				genCode = genCode + " int " + id + ";\n";
		}
		return genCode;
	}

	public void print(String blockName)	{


		System.out.println("");
                System.out.println("Identifier Table for " + blockName);
                System.out.print("--------------------");

		for(int i = 0; i < blockName.length(); i++)	{

			System.out.print("-");
		}

                System.out.println("");
                System.out.println("");
                System.out.print("ID");

                for(int i = 2; i < maxLen(); i++)     {

			System.out.print(" ");
		}

                System.out.println(" Category Type");
                System.out.print("--");

                for(int i = 2; i < maxLen(); i++)     {

                        System.out.print(" ");
		}

                System.out.println("-------- ----");

		Iterator <Map.Entry <String, SymbolTableEntry >> envIterator =
			table.entrySet().iterator();

		TreeMap <String, SymbolTableEntry> funcList =
			new TreeMap <String, SymbolTableEntry> ();

		while(envIterator.hasNext())	{

			Map.Entry <String, SymbolTableEntry> entry = envIterator.next();
			String id = entry.getKey();
			SymbolTableEntry idEntry = entry.getValue();
			System.out.print(id);

			for(int i = id.length(); i < maxLen(); i++)     {

				System.out.print(" ");
			}

			System.out.print(" ");
			System.out.println(idEntry);

			if(idEntry.category() == Category.FUNCTION)	{

				funcList.put(id,idEntry);
			}
		}

		Iterator <Map.Entry<String, SymbolTableEntry>> funcIterator = funcList.entrySet().iterator();

		while(funcIterator.hasNext())	{

			Map.Entry <String, SymbolTableEntry> entry = funcIterator.next();

			String funcName = entry.getKey();

			SymbolTableEntry idEntry = entry.getValue();

			idEntry.localEnv().print(funcName);
		}
	}

}
