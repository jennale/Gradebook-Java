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
        
        private Course prevCourse=null;

	/**
	  * Constructor that creates an arrayList of courses representing a gradebook
	  */
	public Gradebook() {
		if (!load())
			courseList = new ArrayList<Course>();
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */

	/**
	  * Gets a course from the gradebook
	  * 
	  * @param crs The index of the course we want to fetch from the gradebook
	  * @return The course we were searching for, if index passed falls outside of the array, return null
	  * 
	  */
	public Course getCourse(int crs) {
		if (courseList.size() > crs)
			return courseList.get(crs);
		return null;
	}
    
	/**
	  * Gets the size of the list containing the courses
	  * 
	  * @return The size of the list of courses in the gradebook
	  * 
	  */
	public int getCourseListSize() {
		return courseList.size();
	}
    
	/**
	  * Gets the data path
	  * 
	  * @return the path with our data
	  * 
	  */
	public String getPath() {
		return path;
	}
        
	/**
	  * Gets the previous course from the list
	  * 
	  * @return the previous course in the list
	  * 
	  */
	public Course getPrevCourse() {
		return prevCourse;
	}
   
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
   
	/**
	  * Sets the data path
	  * 
	  * @param What we want to set the data path to
	  * 
	  */
	public void setPath(String path) {
		this.path = path;
	}
        
        /**
	  * Sets the previous course
	  * 
	  * @param What we want the previous course to be set to
	  * 
	  */
	public void setPrevCourse(Course prevCourse) {
			this.prevCourse = prevCourse;
	}

	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Stores the courses from the gradebook
	  * 
	  * @return true if the courses were successfully exported, false otherwise
	  * 
	  */
	public boolean store() {
		try {
			File file = new File(path + "data.dat");
			if (file.exists())
				file.delete();
			ObjectOutputStream OUS = new ObjectOutputStream(
					new FileOutputStream(file));
			OUS.writeObject((Course) prevCourse);
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
	  * Loads the courses into the gradebook
	  * 
	  * @return true if the courses were successfully imported, false otherwise
	  * 
	  */
	@SuppressWarnings("unchecked")
	private boolean load() {
		try {
			ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(
					path + "data.dat"));
			prevCourse = (Course)OIS.readObject();
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
	  * Finds a course inside the gradebook
	  * 
	  * @param crs The course we are looking for
	  * @return The index at which the course sits in the list of courses belonging to the gradebook. If indez falls outside size of list, return -1
	  * 
	  */
	public int findCourse(Course crs) {
		for (int i = 0; i < courseList.size(); i++)
			if (courseList.get(i).equals(crs))
				return i;
		return -1;
	}

	/**
	  * Adds a course to the gradebook
	  * if there does not exist a duplicate Course object inside the courseList list.
	  * 
	  * @param name	The name of the course we want to add
	  * @param term The term of the course we want to add
	  * @param code The code of the course we want to add
	  * @return true if the course was added. If the course already exists, return false
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
	  * Removes a course from the gradebook
	  * 
	  * @param crs The course we want to remove
	  * @return true if the course was removed. If the course we are trying to remove is not found, return false
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
