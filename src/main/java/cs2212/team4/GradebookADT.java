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
	  * Gets the data path
	  * 
	  * @return the path with our data
	  * 
	  */
   public String getPath();
   
	/**
	  * Sets the data path
	  * 
	  * @param path What we want to set the data path to
	  * 
	  */
	public void setPath(String path);
	
	/**
	  * Stores the courses from the gradebook
	  * 
	  * @return true if the courses were successfully exported, false otherwise
	  * 
	  */
	public boolean store();

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
