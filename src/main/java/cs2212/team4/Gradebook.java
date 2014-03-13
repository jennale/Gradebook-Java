package cs2212.team4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * team4-gradebook application
 *
 * Gradebook is the class that will hold the information about all the courses in the application.
 *
 * @author Zaid Albirawi
 * @version 2.0 3/1/2014
 */

public class Gradebook implements GradebookADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	// The Gradebook Class version
	private static final long serialVersionUID = 1L;
	// The Gradebook object Course object list.
	private ArrayList<Course> courseList;
	// The path to where the data will be saved.
	private String path = "";

	/**
	  * Constructor.
	  */
	public Gradebook() {
		if (!load())
			courseList = new ArrayList<Course>();
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */

	/**
	  * Gets the Course object.
	  * 
	  * @return		Course, the Course object.
	  * 
	  */
	public Course getCourse(int crs) {
		if (courseList.size() > crs)
			return courseList.get(crs);
		return null;
	}
    
	/**
	  * Gets the Course List size.
	  * 
	  * @return		Integer, the Course list size.
	  * 
	  */
	public int getCourseListSize() {
		return courseList.size();
	}
    
    /**
	  * Gets the data path.
	  * 
	  * @return		Course, the Course object.
	  * 
	  */
	public String getPath() {
		return path;
	}
   
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
   
	/**
	  * Sets the data path.
	  * 
	  * @param		path			String, the data path.
	  * 
	  */
	public void setPath(String path) {
		this.path = path;
	}

	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Stores the Course objects from the courseList list.
	  * 
	  * @return		boolean, true if the objects were successfully exported, false otherwise.
	  * 
	  */
	public boolean store() {
		try {
			File file = new File(path + "data.dat");
			if (file.exists())
				file.delete();
			ObjectOutputStream OUS = new ObjectOutputStream(
					new FileOutputStream(file));
			OUS.writeObject((ArrayList<Course>) courseList);
			OUS.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	  * Loads the Course objects into the courseList list.
	  * 
	  * @return		boolean, true if the objects were successfully imported, false otherwise.
	  * 
	  */
	@SuppressWarnings("unchecked")
	private boolean load() {
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
					path + "data.dat"));
			courseList = (ArrayList<Course>) OIS.readObject();
			OIS.close();
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
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
	private int findCourse(Course crs) {
		for (int i = 0; i < courseList.size(); i++)
			if (courseList.get(i).equals(crs))
				return i;
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
	public boolean addCourse(String name, String term, String code) {
		Course crs;
		if (findCourse(crs = new Course(name, term, code)) != -1)
			return false;
		else
			courseList.add(crs);
		return true;
	}

	/**
	  * Removes a Course object from the courseList list.
	  * 
	  * @param		crs				Course, the Course object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeCourse(Course crs) {
		int i;
		if ((i = findCourse(crs)) == -1)
			return false;
		else
			courseList.remove(i);
		return true;
	}
}
