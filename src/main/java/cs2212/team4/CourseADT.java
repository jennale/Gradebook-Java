package cs2212.team4;

/**
 *
 * CourseADT implements the method interface for the Course class.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/28/2014
 */

public interface CourseADT
{
	/**
	  * Gets the course title.
	  * 
	  * @return		String, the Course object title.
	  * 
	  */
	public String getTitle();

	/**
	  * Gets the course term.
	  * 
	  * @return		String, the Course object term.
	  * 
	  */
	public String getTerm();

	/**
	  * Gets the course code.
	  * 
	  * @return		String, the Course object code.
	  * 
	  */
	public String getCode();
	
	/**
	  * Gets the Student object inside the studentList list at location stud.
	  * 
	  * @return		Student, the Student object.
	  * 
	  */
	public Student getStudent(int stud);
	
	/**
	  * Gets the Deliverable object inside the DeliverableList list at location deliver.
	  * 
	  * @return		Deliverable, the Deliverable object.
	  * 
	  */
	public Deliverable getDeliverable(int deliver);
	
	/**
	  * Gets the grade object inside the Grades object inside the Student object at location grade.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade(Student stud, int grade);
	
	/**
	  * Sets the course title.
	  * 
	  * @param		title			String, the Course Object title.
	  * 
	  */
	public void setTitle(String title);

	/**
	  * Sets the course term.
	  * 
	  * @param		term			String, the Course Object term.
	  * 
	  */
	public void setTerm(String term);

	/**
	  * Sets the course code.
	  * 
	  * @param		code			String, the Course Object code.
	  * 
	  */
	public void setCode(String code);

	/**
	  * Edits the Student object number, if the number does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		number			Integer, the Student object unique number.
	  * 
	  * @return		boolean, true if the number has been edited, false otherwise.
	  * 
	  */
	public boolean editStudentNumber(Student stud, String number);

	/**
	  * Edits the Student object email, if the email does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		email			String, the Student object unique email.
	  * 
	  * @return		boolean, true if the email has been edited, false otherwise.
	  * 
	  */
	public boolean editStudentEmail(Student stud, String email);
	
	/**
	  * Finds the Student object inside the StudentList list.
	  * 
	  * @param		number			Integer, the Student object's unique number.
	  * 
	  * @return		Integer, the position of the Student object in the studentList if the object exists, otherwise will return -1.
	  * 
	  */
	public int findStudent(String number);
	
	/**
	  * Adds a Student object to the studentList list, if there does not exist a Student object inside the studentList list with the same number or email.
	  * 
	  * @param		nameFirst			String, the Student object first name.
	  * @param		nameLast			String, the Student object Last name.
	  * @param		number				Integer, the Student object unique number.
	  * @param		email				String, the Student object unique email.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addStudent(String nameFirst, String nameLast, String number, String email);

	/**
	  * Removes a Student object from the studentList list.
	  * 
	  * @param		number				Integer, the Student object unique number.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeStudent(String number);
	
	/**
	  * Finds the Deliverable object inside the deliverableList list.
	  * 
	  * @param		deliver			Deliverable, the Deliverable object.
	  * 
	  * @return		Integer, the position of the Deliverable object in the deliverableList list if the object exists, otherwise it will return -1.
	  * 
	  */
	public int findDeliverable(Deliverable deliver);
	
	/**
	  * Adds a Deliverable object to the deliverableList list, if there does not exist a duplicate Deliverable object inside the deliverableList list.
	  * 
	  * @param		name				String, the Deliverable object name.
	  * @param		type				String, the Deliverable object type.
	  * @param		weight				Double, the Deliverable object weight.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addDeliverable(String name, String type, double weight);

	/**
	  * Removes a Deliverable object from the deliverableList list.
	  * 
	  * @param		deliver				Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeDeliverable(Deliverable deliver);
	
	/**
	  * Adds a grade to a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * @param		grade				Double, the grade.
	  * 
	  * @return		boolean, true if the grade was inserted successfully, false otherwise.
	  * 
	  */
	public boolean addGrade(Student stud, Deliverable deliver, double grade);
	
	/**
	  * Removes a grade from a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the grade was removed successfully, false otherwise.
	  * 
	  */
	public boolean removeGrade(Student stud, Deliverable deliver);

	/**
	  * Imports a Student objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importStudents(String path);
	
	/**
	  * Exports the Student objects located in studentList list to a .csv file.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Student objects were exported, false otherwise.
	  * 
	  */
	public boolean exportStudents(String path);
	
	/**
	  * Imports a Deliverable objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importDeliverables(String path);

	/**
	  * Exports the Deliverable objects located in deliverableList list to a .csv file.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Deliverable objects were exported, false otherwise.
	  * 
	  */
	public boolean exportDeliverables(String path);
	
	/**
	  * Imports a Student objects' Grade objects into the Course object.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  */
	public boolean importGrades(String path);

	/**
	  * Exports the Grade objects located in every Student object inside the studentList list.
	  * 
	  * @param		path				String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Grade objects were exported, false otherwise.
	  * 
	  */
	public boolean exportGrades(String path);

	/**
	  * An equals method.
	  * 
	  * @param		crs			Course, the Course object.		
	  * 
	  * @return		boolean, true if the Course object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Course crs);
	
	/**
	  * A toString method.
	  * 
	  * @return		String, the Course object information string.
	  * 
	  */
	public String toString();
}
