package cs2212.team4;

/**
 *
 * GradebookADT implements the method interface for the Gradebook class.
 *
 * @author Zaid Albirawi
 * @version 2.0 3/1/2014
 */


public interface GradebookADT 
{
	/**
	  * Gets a course from the gradebook
	  * 
	  * @param crs The index of the course we want to fetch from the gradebook
	  * @return The course we were searching for, if index passed falls outside of the array, return null
	  * 
	  */
	public Course getCourse(int crs);
   
	/**
	  * Gets the size of the list containing the courses
	  * 
	  * @return The size of the list of courses in the gradebook
	  * 
	  */
	public int getCourseListSize();
   
	/**
	  * Gets the data path
	  * 
	  * @return the path with our data
	  * 
	  */
	public String getPath();
       
	/**
	  * Gets the previous course from the list
	  * 
	  * @return the previous course in the list
	  * 
	  */
	public Course getPrevCourse();
  
	/**
	  * Sets the data path
	  * 
	  * @param path What we want to set the data path to
	  * 
	  */
	public void setPath(String path);
       
       /**
	  * Sets the previous course
	  * 
	  * @param prevCourse What we want the previous course to be set to
	  * 
	  */
	public void setPrevCourse(Course prevCourse);
	
	/**
	  * Stores the courses from the gradebook
	  * 
	  * @return true if the courses were successfully exported, false otherwise
	  * 
	  */
	public boolean store();
	
	/**
	  * Finds a course inside the gradebook
	  * 
	  * @param crs The course we are looking for
	  * @return The index at which the course sits in the list of courses belonging to the gradebook. If indez falls outside size of list, return -1
	  * 
	  */
	public int findCourse(Course crs);

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
	public boolean addCourse(String name, String term, String code);

	/**
	  * Removes a course from the gradebook
	  * 
	  * @param crs The course we want to remove
	  * @return true if the course was removed. If the course we are trying to remove is not found, return false
	  * 
	  */
	public boolean removeCourse(Course crs);
}
