public class Type	{}

class IntegerType extends Type	{

	public String toString	()	{

		return "int";
	}
}

class ArrayType extends Type	{

	private int dimension;
	private Type baseType;

	public ArrayType(int dim, Type base)	{

		dimension = dim;
		baseType = base;
	}

	public int dimension()	{return dimension;}

	public Type baseType()	{return baseType;}

	public String toString()	{

		return "array (" + dimension + ", " + baseType + ")";
	}
}
