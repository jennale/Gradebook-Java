/**
 * team4-gradebook application
 * course.java
 * Purpose: course.java is a java object that holds the information of a specific course in the gradebook application.
 * The course class will contain the list of students enrolled in the class and all the class deliverables. It also allows
 * the user to perform many operations, such as, editing the course title, term and code; adding, removing, importing, 
 * and exporting students; adding, removing, importing, and exporting deliverables; and finally, importing and exporting
 * students' grades.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Course implements CourseADT
{
	private String title="", term="", code="";
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Deliverable> deliverableList = new ArrayList<Deliverable>();

	/**
	  * A constructor of the course class, will create an empty course object.
	  * 
	  * @param		title		String, will hold the course title value.
	  * @param		term		String, will hold the course term value.
	  * @param		code		String, will hold the course code value.
	  * 
	  */
	public Course(String title, String term, String code)
	{
		this.title=title;
		this.term=term;
		this.code=code;
	}

	/**
	  * An overloaded constructor of the course class, will create a class object with a list of student objects.
	  * 
	  * @param		title			String, will hold the course title value.
	  * @param		term			String, will hold the course term value.
	  * @param		code			String, will hold the course code value.
	  * @param		studentList		ArrayList<student>, will hold a list of student objects.
	  * 
	  */
	public Course(String title, String term, String code, ArrayList<Student> studentList)
	{
		this.title=title;
		this.term=term;
		this.code=code;
		this.studentList=studentList;
	}

	/**
	  * An overloaded constructor of the course class, will create a class object with a list of student objects and
	  * a list of deliverable objects.
	  * 
	  * @param		title			String, will hold the course title value.
	  * @param		term			String, will hold the course term value.
	  * @param		code			String, will hold the course code value.
	  * @param		studentList		ArrayList<student>, will hold a list of student objects.
	  * @param		deliverableList	ArrayList<deliverable>, will hold a list of deliverable objects.
	  * 
	  */
	public Course(String title, String term, String code, ArrayList<Student> studentList, ArrayList<Deliverable> deliverableList)
	{
		this.title=title;
		this.term=term;
		this.code=code;
		this.studentList=studentList;
		this.deliverableList=deliverableList;
	}

	/**
	  * A getter for the course title value.
	  * 
	  * @return		String, will hold the course title value.
	  * 
	  */
	public String getTitle(){return title;}

	/**
	  * A getter for the course term value.
	  * 
	  * @return		String, will hold the course term value.
	  * 
	  */
	public String getTerm(){return term;}

	/**
	  * A getter for the course code value.
	  * 
	  * @return		String, will hold the course code value.
	  * 
	  */
	public String getCode(){return code;}

	/**
	  * A getter for a student object in the course's studentList.
	  * 
	  * @param		int, will hold the position of the student in studentList.
	  * 
	  * @return		student, will hold the student object information.
	  * 
	  */
	public Student getStudent(int stud){return studentList.get(stud);}
	
	/**
	  * A setter for the course title value.
	  * 
	  * @param		title			String, will hold the course title new value.
	  * 
	  */
	public void setTitle(String title){this.title=title;}

	/**
	  * A setter for the course term value.
	  * 
	  * @param		term			String, will hold the course term new value.
	  * 
	  */
	public void setTerm(String term){this.term=term;}

	/**
	  * A setter for the course code value.
	  * 
	  * @param		code			String, will hold the course code new value.
	  * 
	  */
	public void setCode(String code){this.code=code;}

	/**
	  * checkNumber is a helper method for editStudentNumber and addStudent methods; checkNumber checks if the
	  * student number is assigned to an already existing student object; if it is the method return true, otherwise
	  * false.
	  * 
	  * @param		number			int, will hold the student object's unique number value.
	  * 
	  * @return		boolean, true if the number exists, false otherwise.
	  * 
	  */
	private boolean checkNumber(int number)
	{
		for (int i=0; i<studentList.size(); i++)
		{
			if (studentList.get(i).getNumber()==number)return true;
		}return false;
	}

	/**
	  * checkEmail is a helper method for editStudentemail and addStudent methods; checkEmail checks if the
	  * student email is assigned to an already existing student object; if it is the method return true,
	  * otherwise false.
	  * 
	  * @param		email			String, will hold the student object's unique email value.
	  * 
	  * @return		boolean, true if the email exists, false otherwise.
	  * 
	  */
	private boolean checkEmail(String email)
	{
		for (int i=0; i<studentList.size(); i++)
		{
			if (studentList.get(i).getEmail()==email)return true;
		}return false;
	}

	/**
	  * editStudentNumber is a method that allows the user to edit the student object's unique student number.
	  * 
	  * @param		stud			student, will hold the information of a specific student object.
	  * @param		number			int, will hold the student object's new unique number value.
	  * 
	  * @return		boolean, true if the number has been edited, false otherwise.
	  * 
	  */
	public boolean editStudentNumber(Student stud, int number)
	{
		if (stud.getNumber()==number)return true;
		else if (checkNumber(number))return false;
		else stud.setNumber(number);return true;
	}

	/**
	  * editStudentEmail is a method that allows the user to edit the student object's unique student email.
	  * 
	  * @param		stud			student, will hold the information of a specific student object.
	  * @param		emal			String, will hold the student object's new unique email value.
	  * 
	  * @return		boolean, true if the email has been edited, false otherwise.
	  * 
	  */
	public boolean editStudentEmail(Student stud, String email)
	{
		if (stud.getEmail()==email)return true;
		else if (checkEmail(email))return false;
		else stud.setEmail(email);return true;
	}
	
	/**
	  * A find method that will iterate through the studentList to find a specific student object. If the student
	  * object is found, the method returns the position of the student object in the studentList, else it returns -1.
	  * 
	  * @param		number			int, will hold the student object's unique number value.
	  * 
	  * @return		int, will hold the position of the student object in the studentList if the object exists, else -1.
	  * 
	  */
	public int findStudent(int number)
	{
		for (int i=0; i<studentList.size(); i++)
		{
			if (studentList.get(i).getNumber()==number)return i;
		}return -1;
	}
	
	/**
	  * addStudent method will add a student object to the studentList.
	  * 
	  * @param		nameFirst			String, will hold the student object's nameFirst value.
	  * @param		nameLast			String, will hold the student object's nameLast value.
	  * @param		number				int, will hold the student object's unique number value.
	  * @param		email				String, will hold the student object's unique email value.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addStudent(String nameFirst, String nameLast, int number, String email)
	{
		ArrayList<Deliverable> deliverableList=new ArrayList<Deliverable>();deliverableList.addAll(this.deliverableList);
		if (!(checkNumber(number)||checkEmail(email)))
		{
			studentList.add(new Student(nameFirst, nameLast, number, email, deliverableList));return true;
		}return false;
	}

	/**
	  * removeStudent method will remove a specific student object from the studentList.
	  * 
	  * @param		number				int, will hold the student object's unique number value.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeStudent(int number)
	{
		int i;
		if ((i=findStudent(number))==-1)return false;
		else studentList.remove(i);return true;
	}
	
	/**
	  * processStudentImport is a helper that will process the imported students.
	  * 
	  * @param		line				String, will hold information about a specific student.
	  * 
	  * @return		boolean, true if the student object was imported, and false if it already exists.
	  * 
	  */
	private boolean processStudentImport(String line)
	{
		return false;
	}
	
	/**
	  * importStudents method will import a studentList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importStudents(String path)
	{
		processStudentImport("");
	}

	/**
	  * exportStudents method will export the studentList to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file will be saved.
	  * 
	  * @return		boolean, true if the studentList was exported, false otherwise.
	  * 
	  */
	public boolean exportStudents(String path)
	{
		try
		{
			Writer bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+code+term+"student.csv"))));
			bw.write("\"nameLast\", \"nameFirst\", \"number\", \"email\"\n");
			for(int i=0; i<studentList.size(); i++)bw.write(studentList.get(i).toString());
			bw.close();return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	/**
	  * A find method that will iterate through the deliverableList to find a specific deliverable object. If the 
	  * deliverable object is found, the method returns the position of the deliverable object in the deliverableList,
	  * else it returns -1.
	  * 
	  * @param		name			String, will hold the name value of the deliverable object.
	  * @param		type			String, will hold the type value of the deliverable object.
	  * 
	  * @return		int, will hold the position of the deliverable object in the deliverableList if the object exists, else -1.
	  * 
	  */
	public int findDeliverable(String name, String type)
	{
		String tempName, tempType;
		for (int i=0; i<deliverableList.size(); i++)
		{
			tempName=deliverableList.get(i).getName();
			tempType=deliverableList.get(i).getType();
			if (tempName==name&&tempType==type)return i;
		}return -1;
	}
	
	/**
	  * addDeliverable method will add a deliverable object to the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addDeliverable(String name, String type, double weight)
	{
		Deliverable deliver;
		if (findDeliverable(name, type)!=-1)return false;
		else
		{
			deliverableList.add(deliver = new Deliverable(name, type, weight));
			for (int i=0; i<studentList.size(); i++)studentList.get(i).addDeliverable(deliver);
		}return true;
	}

	/**
	  * removeDeliverable method will remove a specific deliverable object from the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeDeliverable(String name, String type)
	{
		int i;
		if ((i= findDeliverable(name, type))==-1)return false;
		else 
		{
			deliverableList.remove(i);
			for (int j=0; j<studentList.size(); j++)studentList.get(j).removeDeliverable(i);
		}return true;
	}
	
	/**
	  * processDeliverableImport is a helper that will process the imported deliverables.
	  * 
	  * @param		line				String, will hold information about a specific deliverable.
	  * 
	  * @return		boolean, true if the deliverable object was imported, and false if it already exists.
	  * 
	  */
	private boolean processDeliverableImport(String line)
	{
		return false;
	}
	
	/**
	  * importDeliverables method will import a deliverableList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importDeliverables(String path)
	{
		processDeliverableImport("");
	}

	/**
	  * exportDeliverables method will export the deliverableList to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file will be saved.
	  * 
	  * @return		boolean, true if the deliverableList was exported, false otherwise.
	  * 
	  */
	public boolean exportDeliverables(String path)
	{
		try
		{
			Writer bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+code+term+"deliver.csv"))));
			bw.write("\"name\", \"term\", \"type\"\n");
			for(int i=0; i<deliverableList.size(); i++)bw.write(deliverableList.get(i).toString());
			bw.close();return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	/**
	  * processGradeImport is a helper that will process the imported grades.
	  * 
	  * @param		line				String, will hold information about a specific student object grade.
	  * 
	  * @return		boolean, true if the grade was imported, and false if the student does not exist.
	  * 
	  */
	private boolean processGradeImport(String line)
	{
		return false;
	}
	
	/**
	  * importGrades method will import grade values for the studentList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importGrades(String path)
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		    String line;
		    if ((line = br.readLine()) != null && !line.substring(0, 15).equals("\"Student Number\""))
		    {
		    	//errmsg
		    }
		    while ((line = br.readLine()) != null)
		    {
		    	processGradeImport(line);
		    }
		    br.close();
		}
		catch (FileNotFoundException e)
		{
			//msg
		}
		catch (IOException e)
		{
			//msg
		}
	}

	/**
	  * exportGrades method will export all studentList's student object grades to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public boolean exportGrades(String path)
	{
		try
		{
			Writer bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path+code+term+"grades.csv"))));
			String str="\"number\"";
			for (int i=0; i<deliverableList.size(); i++)str=str+", \""+deliverableList.get(i).getName()+"\"";
			bw.write(str+"\n");
			for(int i=0; i<studentList.size(); i++)bw.write(studentList.get(i).gradeExportString());
			bw.close();return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}
}
