/**
 * team4-gradebook application
 * gradebook.java
 * Purpose: gradebook.java is a java object that will hold the information about all active course objects. The user
 * will able to perform operations, such as, find, add and remove on the course objects.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

import java.util.ArrayList;

public class gradebook implements gradebookADT
{
	private ArrayList<course> courseList = new ArrayList<course>();

	/**
	  * A constructor of the gradebook class, will create an empty gradebook object.
	  */
	public gradebook(){}
	
	/**
	  * A find method that will iterate through the courseList to find a specific course object. If the course
	  * object is found, the method returns the position of the course object in the courseList, else it returns -1.
	  * 
	  * @param		crs			course, will hold the course object's information.
	  * 
	  * @return		course, will hold the position of the course object in the courseList if the object exists, else -1.
	  * 
	  */
	public int findCourse(course crs)
	{
		course tempCourse;
		for (int i=0; i<courseList.size(); i++)
		{
			tempCourse=courseList.get(i);
			if (tempCourse.getTitle()==crs.getTitle()&&tempCourse.getCode()==crs.getCode()&&tempCourse.getTerm()==crs.getTerm())return i;
		}return -1;
	}

	/**
	  * addCourse method will add a course object to the courseList.
	  * 
	  * @param		name				String, will hold the course object's name value.
	  * @param		term				String, will hold the course object's term value.
	  * @param		code				String, will hold the course object's code value.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addCourse(String name, String term, String code)
	{
		course crs;
		if (findCourse(crs=new course(name, term, code))!=-1)return false;
		else courseList.add(crs);return true;
	}

	/**
	  * addCourse overloaded method will add a course object to the courseList.
	  * 
	  * @param		name				String, will hold the course object's name value.
	  * @param		term				String, will hold the course object's term value.
	  * @param		code				String, will hold the course object's code value.
	  * @param		studentList			ArrayList<student>, will hold the course objects studentList value.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addCourse(String name, String term, String code, ArrayList<student> studentList)
	{
		course crs;
		if (findCourse(crs=new course(name, term, code, studentList))!=-1)return false;
		else courseList.add(crs);return true;
	}


	/**
	  * addCourse overloaded method will add a course object to the courseList.
	  * 
	  * @param		name				String, will hold the course object's name value.
	  * @param		term				String, will hold the course object's term value.
	  * @param		code				String, will hold the course object's code value.
	  * @param		studentList			ArrayList<student>, will hold the course objects studentList value.
	  * @param		deliverableList		ArrayList<deliverable>, will hold the course objects deliverableList value.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addCourse(String name, String term, String code, ArrayList<student> studentList, ArrayList<deliverable> deliverableList)
	{
		course crs;
		if (findCourse(crs=new course(name, term, code, studentList, deliverableList))!=-1)return false;
		else courseList.add(crs);return true;
	}

	/**
	  * removeCourse method will remove a specific course object from the courseList.
	  * 
	  * @param		crs				course, will hold the course object's information.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeCourse(course crs)
	{
		int i;
		if ((i=findCourse(crs))==-1)return false;
		else courseList.remove(i);return true;
	}
}
