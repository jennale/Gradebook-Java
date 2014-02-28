package cs2212.team4;

public interface GradebookADT 
{
	/**
	  * Finds the Course object inside the courseList list.
	  * 
	  * @param		crs			Course, the Course object.
	  * 
	  * @return		Integer, the position of the Course object in the courseList if the object exists, otherwise will return -1.
	  * 
	  */
	public int findCourse(Course crs);

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
