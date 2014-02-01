public class deliverable 
{
	private String name="", type="";
	private double weight=0.0, grade=0.0;
	
	public deliverable(String name, String type, double weight)
	{
		this.name=name;
		this.type=type;
		this.weight=weight;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public void setWeight(double weight)
	{
		this.weight=weight;
	}
	
	public void setGrade(double grade)
	{
		this.grade=grade;
	}
}
