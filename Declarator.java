class Declarator	{

	private String id;
	private Type type;

	public Declarator(String id, Type type)	{

		this.id = id;
		this.type = type;
	}

	public String id()	{return id;}
	public Type type()	{return type;}
}

class ArrayDeclarator extends Declarator	{

	private int subscriptNumber;

	public ArrayDeclarator(String id, Type type, int subscriptNumber)	{

		super(id,type);
		this.subscriptNumber = subscriptNumber;
	}

	public int subscriptNumber()	{return subscriptNumber;}
}
