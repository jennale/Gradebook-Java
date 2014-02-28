/**
 * team4-gradebook application
 * 
 * Course is the class that will be used to store all course students, deliverables, grades, and course information.
 *
 * @author Zaid Albirawi
 * @version 1.5 2/28/2014
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
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Stack;

public class Course implements CourseADT
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The Course object title, term, and code.
	private String title="", term="", code="";
	//The Course object student list.
	private ArrayList<Student> studentList = new ArrayList<Student>();
	//The Course object deliverable list.
	private ArrayList<Deliverable> deliverableList = new ArrayList<Deliverable>();
	//The Course object empty deliverable slots
	private Stack<Integer> stkDeliver = new Stack<Integer>();

	/**
	  * Constructor.
	  * 
	  * @param		title		String, the Course object title.
	  * @param		term		String, the Course object term.
	  * @param		code		String, the Course object code.
	  * 
	  */
	public Course(String title, String term, String code)
	{
		this.title=title;
		this.term=term;
		this.code=code;
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */

	/**
	  * Gets the course title.
	  * 
	  * @return		String, the Course object title.
	  * 
	  */
	public String getTitle(){return title;}

	/**
	  * Gets the course term.
	  * 
	  * @return		String, the Course object term.
	  * 
	  */
	public String getTerm(){return term;}

	/**
	  * Gets the course code.
	  * 
	  * @return		String, the Course object code.
	  * 
	  */
	public String getCode(){return code;}
	
	/**
	  * Gets the Student object inside the studentList list at location stud.
	  * 
	  * @return		Student, the Student object.
	  * 
	  */
	public Student getStudent(int stud){return studentList.get(stud);}
	
	/**
	  * Gets the Deliverable object inside the DeliverableList list at location deliver.
	  * 
	  * @return		Deliverable, the Deliverable object.
	  * 
	  */
	public Deliverable getDeliverable(int deliver){return deliverableList.get(deliver);}
	
	/**
	  * Gets the grade object inside the Grades object inside the Student object at location grade.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade(Student stud, int grade){return stud.getGrade(grade);}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the course title.
	  * 
	  * @param		title			String, the Course Object title.
	  * 
	  */
	public void setTitle(String title){this.title=title;}

	/**
	  * Sets the course term.
	  * 
	  * @param		term			String, the Course Object term.
	  * 
	  */
	public void setTerm(String term){this.term=term;}

	/**
	  * Sets the course code.
	  * 
	  * @param		code			String, the Course Object code.
	  * 
	  */
	public void setCode(String code){this.code=code;}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Checks if the integer provided already belongs to another Student object inside the studentList list.
	  * 
	  * @param		number			Integer, the Student object unique number.
	  * 
	  * @return		boolean, true if the number exists, false otherwise.
	  * 
	  */
	private boolean checkNumber(int number)
	{
		if (findStudent(number)==-1)return false;
		return true;
	}

	/**
	  * Checks if the string provided already belongs to another Student object inside the studentList list.
	  * 
	  * @param		email			String,the Student object unique email.
	  * 
	  * @return		boolean, true if the email exists, false otherwise.
	  * 
	  */
	private boolean checkEmail(String email)
	{
		for (int i=0; i<studentList.size(); i++)if (studentList.get(i).getEmail()==email)return true;
		return false;
	}

	/**
	  * Edits the Student object number, if the number does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		number			Integer, the Student object unique number.
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
	  * Edits the Student object email, if the email does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		email			String, the Student object unique email.
	  * 
	  * @return		boolean, true if the email has been edited, false otherwise.
	  * 
	  */
	public boolean editStudentEmail(Student stud, String email)
	{
		if (stud.getEmail().equals(email))return true;
		else if (checkEmail(email))return false;
		else stud.setEmail(email);return true;
	}
	
	/**
	  * Finds the Student object inside the StudentList list.
	  * 
	  * @param		number			Integer, the Student object's unique number.
	  * 
	  * @return		Integer, the position of the Student object in the studentList if the object exists, otherwise will return -1.
	  * 
	  */
	public int findStudent(int number)
	{
		for (int i=0; i<studentList.size(); i++)if (studentList.get(i).getNumber()==number)return i;
		return -1;
	}
	
	/**
	  * Adds a Student object to the studentList list, if there does not exist a Student object inside the studentList list with the same number or email.
	  * 
	  * @param		nameFirst			String, the Student object first name.
	  * @param		nameLast			String, the Student object Last name.
	  * @param		number				Integer, the Student object unique number.
	  * @param		email				String, the Student object unique email.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addStudent(String nameFirst, String nameLast, int number, String email)
	{
		if (!(checkNumber(number)||checkEmail(email)))
		{
			studentList.add(new Student(nameFirst, nameLast, number, email));return true;
		}return false;
	}

	/**
	  * Removes a Student object from the studentList list.
	  * 
	  * @param		number				Integer, the Student object unique number.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeStudent(int number)
	{
		int i;
		if ((i=findStudent(number))==-1)return false;
		studentList.remove(i);return true;
	}
	
	/**
	  * Finds the Deliverable object inside the deliverableList list.
	  * 
	  * @param		name			String, the name of the Deliverable object.
	  * @param		type			String, the type of the deliverable object.
	  * 
	  * @return		Integer, the position of the Deliverable object in the deliverableList list if the object exists, otherwise it will return -1.
	  * 
	  */
	public int findDeliverable(Deliverable deliver)
	{
		for (int i=0; i<deliverableList.size(); i++)if (deliverableList.get(i).equals(deliver))return i;
		return -1;
	}
	
	/**
	  * Adds a Deliverable object to the deliverableList list, if there does not exist a duplicate Deliverable object inside the deliverableList list.
	  * 
	  * @param		name				String, the Deliverable object name.
	  * @param		type				String, the Deliverable object type.
	  * @param		weight				Double, the Deliverable object weight.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addDeliverable(String name, String type, double weight)
	{
		if (findDeliverable(new Deliverable(name, type, weight, 0))!=-1)return false;
		if (!stkDeliver.isEmpty())deliverableList.add(new Deliverable(name, type, weight, stkDeliver.pop()));
		else deliverableList.add(new Deliverable(name, type, weight, deliverableList.size()));return true;
	}

	/**
	  * Removes a Deliverable object from the deliverableList list.
	  * 
	  * @param		deliver				Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeDeliverable(Deliverable deliver)
	{
		int i;
		if ((i= findDeliverable(deliver))==-1)return false;
		deliverableList.set(i, null);stkDeliver.push(i);return true;
	}
	
	/**
	  * Adds a grade to a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * @param		grade				Double, the grade.
	  * 
	  * @return		boolean, true if the grade was inserted successfully, false otherwise.
	  * 
	  */
	public boolean addGrade(Student stud, Deliverable deliver, double grade)
	{
		return stud.addGrade(deliver.getObjId(), grade, deliver.getType(), deliver.getWeight());
	}
	
	/**
	  * Removes a grade from a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the grade was removed successfully, false otherwise.
	  * 
	  */
	public boolean removeGrade(Student stud, Deliverable deliver)
	{
		return stud.removeGrade(deliver.getObjId(), deliver.getType());
	}

	/**
	  * Imports a Student objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importStudents(String path)
	{
		return false;
	}
	
	/**
	  * Exports the Student objects located in studentList list to a .csv file.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Student objects were exported, false otherwise.
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
	  * Imports a Deliverable objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importDeliverables(String path)
	{
		return false;
	}

	/**
	  * Exports the Deliverable objects located in deliverableList list to a .csv file.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Deliverable objects were exported, false otherwise.
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
		catch(FileAlreadyExistsException e)
		{
			return false;
		}
		catch(FileNotFoundException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	/**
	  * Imports a Student objects' Grade objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importGrades(String path)
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
		    	
		    }
		    br.close();return true;
		}
		catch(FileNotFoundException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	/**
	  * Exports the Grade objects located in every Student object inside the studentList list.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Grade objects were exported, false otherwise.
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
			for(int i=0; i<studentList.size(); i++)bw.write(studentList.get(i).toString());
			bw.close();return true;
		}
		catch (IOException e)
		{
			return false;
		}
	}

	/**
	  * An equals method.
	  * 
	  * @param		crs			Course, the Course object.		
	  * 
	  * @return		boolean, true if the Course object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Course crs)
	{
		if(this.toString().equalsIgnoreCase(crs.toString()))return true;
		return false;
	}
	
	/**
	  * A toString method.
	  * 
	  * @return		String, the Course object information string.
	  * 
	  */
	public String toString(){return ("\""+title+"\", \""+term+"\", \""+code+"\"\n");}
}
