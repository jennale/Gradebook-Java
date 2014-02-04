/**
 * team4-gradebook application
 * gradebookADT.java
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

import java.util.ArrayList;

public interface gradebookADT
{
	/**
	  * A find method that will iterate through the courseList to find a specific course object. If the course
	  * object is found, the method returns the position of the course object in the courseList, else it returns -1.
	  * 
	  * @param		crs			course, will hold the course object's information.
	  * 
	  * @return		course, will hold the position of the course object in the courseList if the object exists, else -1.
	  * 
	  */
	public int findCourse(course crs);

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
	public boolean addCourse(String name, String term, String code);

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
	public boolean addCourse(String name, String term, String code, ArrayList<student> studentList);


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
	public boolean addCourse(String name, String term, String code, ArrayList<student> studentList, ArrayList<deliverable> deliverableList);

	/**
	  * removeCourse method will remove a specific course object from the courseList.
	  * 
	  * @param		crs				course, will hold the course object's information.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeCourse(course crs);
}
