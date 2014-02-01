import java.util.ArrayList;

public class course 
{
	private String title="", term="", code="";
	private ArrayList<student> studentList = new ArrayList<student>();
	private ArrayList<deliverable> deliverableList = new ArrayList<deliverable>();
	
	public course(String title, String term, String code)
	{
		this.title=title;
		this.term=term;
		this.code=code;
	}
	
	public course(String title, String term, String code, ArrayList<student> studentList)
	{
		this.title=title;
		this.term=term;
		this.code=code;
		this.studentList=studentList;
	}
	
	public course(String title, String term, String code, ArrayList<student> studentList, ArrayList<deliverable> deliverableList)
	{
		this.title=title;
		this.term=term;
		this.code=code;
		this.studentList=studentList;
		this.deliverableList=deliverableList;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getTerm()
	{
		return term;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public void setTerm(String term)
	{
		this.term=term;
	}
	
	public void setCode(String code)
	{
		this.code=code;
	}
	
	public void addStudentList(ArrayList<student> studentList)
	{
		this.studentList=studentList;
	}
	
	public boolean checkNumber(int number)
	{
		int tempNumber;
		for (int i=0; i<studentList.size()-1; i++)
		{
			tempNumber=studentList.get(i).getNumber();
			if (tempNumber==number)return true;
		}
		//msg
		return false;
	}
	
	public boolean checkEmail(String email)
	{
		String tempEmail;
		for (int i=0; i<studentList.size()-1; i++)
		{
			tempEmail=studentList.get(i).getEmail();
			if (tempEmail==email)return true;
		}
		//msg
		return false;
	}
	
	public void addStudent(student stud)
	{	
		if (checkNumber(stud.getNumber())&&checkEmail(stud.getEmail()))
		{
			//success
			studentList.add(stud);
		}
	}
	
	public boolean editStudentNumber(student stud, int number)
	{
		if (stud.getNumber()==number)return true;
		else if (checkNumber(number))return false;
		else stud.setNumber(number);
		return true;
	}
	
	public boolean editStudentEmail(student stud, String email)
	{
		if (stud.getEmail()==email)return true;
		else if (checkEmail(email))return false;
		else stud.setEmail(email);
		return true;
	}
	
	public int findStudent(int number)
	{
		int tempNumber;
		for (int i=0; i<studentList.size()-1; i++)
		{
			tempNumber=studentList.get(i).getNumber();
			if (tempNumber==number)return i;
		}
		return -1;
	} 
	
	public boolean removeStudent(int number)
	{
		int i;
		if ((i=findStudent(number))==-1)return false;
		else studentList.remove(i);
		return true;
	}
	
	public void importStudentList(String path)
	{
		
	}
	
	public void exportStudentList(String path)
	{
		
	}
	
	public void addDeliverableList(ArrayList<deliverable> deliverableList)
	{
		this.deliverableList=deliverableList;
		
		for (int i=0; i<studentList.size()-1; i++)
		{
			studentList.get(i).setDeliverableList(deliverableList);
		}
	}
	
	public void addDeliverable(deliverable deliver)
	{
		deliverableList.add(deliver);
		
		for (int i=0; i<studentList.size()-1; i++)
		{
			studentList.get(i).updateDeliverable(deliver);
		}
	}
	
	public int findDeliverable(String name, String type)
	{
		String tempName, tempType;
		for (int i=0; i<deliverableList.size()-1; i++)
		{
			tempName=deliverableList.get(i).getName();
			tempType=deliverableList.get(i).getType();
			if (tempName==name&&tempType==type)return i;
		}
		return -1;
	}
	
	public boolean removeDeliverable(int number)
	{
		int i;
		if ((i=findStudent(number))==-1)return false;
		else deliverableList.remove(i);
		return true;
	}
	
	public String toString()
	{
		return ("Course title: "+title+", Code: "+code+", Term: "+term+".");
	}
}
