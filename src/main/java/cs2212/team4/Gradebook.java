/**
 * team4-gradebook application
 * 
 * Gradebook is the class that will hold the information about all the courses in the application.
 *
 * @author Zaid Albirawi
 * @version 1.2 2/28/2014
 */

package cs2212.team4;

import java.util.ArrayList;

public class Gradebook implements GradebookADT
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The Gradebook object Course object list.
	private ArrayList<Course> courseList;

	/**
	  * A constructor of the gradebook class, will create an empty gradebook object.
	  */
	public Gradebook(){courseList = new ArrayList<Course>();}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Finds the Course object inside the courseList list.
	  * 
	  * @param		crs			Course, the Course object.
	  * 
	  * @return		Integer, the position of the Course object in the courseList if the object exists, otherwise will return -1.
	  * 
	  */
	public int findCourse(Course crs)
	{
		for (int i=0; i<courseList.size(); i++)if (courseList.get(i).equals(crs))return i;
		return -1;
	}

	/**
	  * Adds a Course object to the courseList list, if there does not exist a duplicate Course object inside the courseList list.
	  * 
	  * @param		name			String, the Course object name.
	  * @param		term			String, the Course object term.
	  * @param		code			String, the Course object code.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addCourse(String name, String term, String code)
	{
		Course crs;
		if (findCourse(crs=new Course(name, term, code))!=-1)return false;
		else courseList.add(crs);return true;
	}

	/**
	  * Removes a Course object from the courseList list.
	  * 
	  * @param		crs				Course, the Course object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeCourse(Course crs)
	{
		int i;
		if ((i=findCourse(crs))==-1)return false;
		else courseList.remove(i);return true;
	}
}
