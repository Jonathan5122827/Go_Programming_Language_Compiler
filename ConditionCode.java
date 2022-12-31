import java.util.*;

public class ConditionCode	{

	private String code;
	private String falseLabel, trueLabel;

	public ConditionCode(String code, String trueLabel, String falseLabel)	{

		this.code = code;
		this.trueLabel = trueLabel;
		this.falseLabel = falseLabel;
	}

	public String code()	{return code;}

	public String falseLabel()	{return falseLabel;}

	public String trueLabel()	{return trueLabel;}
}
