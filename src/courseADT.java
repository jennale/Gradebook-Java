/**
 * team4-gradebook application
 * courseADT.java
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

public interface courseADT
{
	/**
	  * A getter for the course title value.
	  * 
	  * @return		String, will hold the course title value.
	  * 
	  */
	public String getTitle();

	/**
	  * A getter for the course term value.
	  * 
	  * @return		String, will hold the course term value.
	  * 
	  */
	public String getTerm();

	/**
	  * A getter for the course code value.
	  * 
	  * @return		String, will hold the course code value.
	  * 
	  */
	public String getCode();

	/**
	  * A setter for the course title value.
	  * 
	  * @param		title			String, will hold the course title new value.
	  * 
	  */
	public void setTitle(String title);

	/**
	  * A setter for the course term value.
	  * 
	  * @param		term			String, will hold the course term new value.
	  * 
	  */
	public void setTerm(String term);

	/**
	  * A setter for the course code value.
	  * 
	  * @param		code			String, will hold the course code new value.
	  * 
	  */
	public void setCode(String code);
	
	/**
	  * A find method that will iterate through the studentList to find a specific student object. If the student
	  * object is found, the method returns the position of the student object in the studentList, else it returns -1.
	  * 
	  * @param		number			int, will hold the student object's unique number value.
	  * 
	  * @return		int, will hold the position of the student object in the studentList if the object exists, else -1.
	  * 
	  */
	public int findStudent(int number);
	
	/**
	  * addStudent method will add a student object to the studentList.
	  * 
	  * @param		nameFirst			String, will hold the student object's nameFirst value.
	  * @param		nameLast			String, will hold the student object's nameLast value.
	  * @param		number				int, will hold the student object's unique number value.
	  * @param		email				String, will hold the student object's unique email value.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addStudent(String nameFirst, String nameLast, int number, String email);

	/**
	  * removeStudent method will remove a specific student object from the studentList.
	  * 
	  * @param		number				int, will hold the student object's unique number value.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeStudent(int number);
	
	/**
	  * importStudents method will import a studentList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importStudents(String path);

	/**
	  * exportStudents method will export the studentList to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file will be saved.
	  * 
	  * @return		boolean, true if the studentList was exported, false otherwise.
	  * 
	  */
	public boolean exportStudents(String path);

	/**
	  * A find method that will iterate through the deliverableList to find a specific deliverable object. If the 
	  * deliverable object is found, the method returns the position of the deliverable object in the deliverableList,
	  * else it returns -1.
	  * 
	  * @param		name			String, will hold the name value of the deliverable object.
	  * @param		type			String, will hold the type value of the deliverable object.
	  * 
	  * @return		int, will hold the position of the deliverable object in the deliverableList if the object exists, else -1.
	  * 
	  */
	public int findDeliverable(String name, String type);
	
	/**
	  * addDeliverable method will add a deliverable object to the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addDeliverable(deliverable deliver);

	/**
	  * removeDeliverable method will remove a specific deliverable object from the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeDeliverable(deliverable deliver);
	
	/**
	  * importDeliverables method will import a deliverableList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importDeliverables(String path);

	/**
	  * exportDeliverables method will export the deliverableList to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file will be saved.
	  * 
	  * @return		boolean, true if the deliverableList was exported, false otherwise.
	  * 
	  */
	public boolean exportDeliverables(String path);
	
	/**
	  * importGrades method will import grade values for the studentList from a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public void importGrades(String path);

	/**
	  * exportGrades method will export all studentList's student object grades to a .csv file.
	  * 
	  * @param		path				String, will hold the value of the path were the file is located.
	  * 
	  */
	public boolean exportGrades(String path);
}
