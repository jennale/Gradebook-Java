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
	  * Gets the Course object.
	  * 
	  * @return		Course, the Course object.
	  * 
	  */
    public Course getCourse(int crs);
    
    /**
	  * Gets the data path.
	  * 
	  * @return		Course, the Course object.
	  * 
	  */
   public String getPath();
   
	/**
	  * Sets the data path.
	  * 
	  * @param		path			String, the data path.
	  * 
	  */
	public void setPath(String path);
	
	/**
	  * Stores the Course objects from the courseList list.
	  * 
	  * @return		boolean, true if the objects were successfully exported, false otherwise.
	  * 
	  */
	public boolean store();

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
	public boolean addCourse(String name, String term, String code);

	/**
	  * Removes a Course object from the courseList list.
	  * 
	  * @param		crs				Course, the Course object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeCourse(Course crs);
}
