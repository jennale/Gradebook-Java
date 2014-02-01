import java.util.ArrayList;

public class student 
{
	private String nameFirst="", nameLast="", email="";
	private int number=0;
	
	private ArrayList<deliverable> deliverableList = new ArrayList<deliverable>();
	
	public student(String nameFirst, String nameLast, int number, String email)
	{
		this.nameFirst=nameFirst;
		this.nameLast=nameLast;
		this.number=number;
		this.email=email;
	}
	
	public student(String nameFirst, String nameLast, int number, String email, ArrayList<deliverable> deliverableList)
	{
		this.nameFirst=nameFirst;
		this.nameLast=nameLast;
		this.number=number;
		this.email=email;
		this.deliverableList=deliverableList;
	}
	
	public String getNameFirst()
	{
		return nameFirst;
	}
	
	public String getNameLast()
	{
		return nameLast;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public ArrayList<deliverable> getDeliverableList()
	{
		return deliverableList;
	}
	
	public void setNameFirst(String nameFirst)
	{
		this.nameFirst=nameFirst;
	}
	
	public void setNameLast(String nameLast)
	{
		this.nameLast=nameLast;
	}
	
	public void setNumber(int number)
	{
		this.number=number;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public void setDeliverableList(ArrayList<deliverable> deliverableList)
	{
		this.deliverableList=deliverableList;
	}
	
	public void updateDeliverable(deliverable deliver)
	{
		deliverableList.add(deliver);
	}
	
	public String toString()
	{
		return ("Name: "+nameLast+", "+nameFirst+", Student Number: "+number+", Email: "+email);
	}
}
