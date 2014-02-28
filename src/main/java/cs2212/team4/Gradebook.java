package cs2212.team4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

/**
 *
 * Gradebook is the class that will hold the information about all the courses in the application.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 1.2 2/28/2014
 */

public class Gradebook implements GradebookADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The Gradebook object Course object list.
	private ArrayList<Course> courseList;

	/**
	  * A constructor of the gradebook class, will create an empty gradebook object.
	  */
	public Gradebook()
	{
		if (!load(" "))courseList = new ArrayList<Course>();
	}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Stores the Course objects from the courseList list.
	  * 
	  * @param		path			String, the path to where the data will be located.
	  * 
	  * @return		boolean, true if the objects were successfully exported, false otherwise.
	  * 
	  */
	public boolean store(String path)
	{ 
		try
		{
			FileOutputStream FOS = new FileOutputStream(path);
			ObjectOutputStream OUS = new ObjectOutputStream(FOS);
			for (int i=0; i<courseList.size(); i++)OUS.writeObject(courseList.get(i));
			OUS.close();FOS.close();return true;
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
	  * Loads the Course objects into the courseList list.
	  * 
	  * @param		path			String, the path to where the data will be located.
	  * 
	  * @return		boolean, true if the objects were successfully imported, false otherwise.
	  * 
	  */
	private boolean load(String path)
	{
		try
		{
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
			while(OIS.available()>0)courseList.add((Course)OIS.readObject());
			OIS.close();return true;
		}
		catch (FileNotFoundException e)
		{
			return false;
		}
		catch (ClassNotFoundException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
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
