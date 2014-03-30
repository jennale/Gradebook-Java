package cs2212.team4;

/**
 *
 * StudentADT implements the method interface for the Student class.
 *
 * @author Zaid Albirawi
 * @version 2.0 3/1/2014
 */


public interface StudentADT
{	
	/**
	  * Gets the student's first name
	  * 
	  * @return The student's first name
	  * 
	  */
	public String getNameFirst();

	/**
	  * Gets the student's last name
	  * 
	  * @return The student's last name
	  * 
	  */
	public String getNameLast();

	/**
	  * Gets the student's id number
	  * 
	  * @return The student's id number
	  * 
	  */
	public String getNumber();

	/**
	  * Gets the student's email
	  * 
	  * @return The student's email
	  * 
	  */
	public String getEmail();
	
	/**
	  * Gets a specific grade of the student at the index passed
	  * 
	  * @param grade The grade at the index that we want returned
	  * @return the grade for this student at the index we passed
	  * 
	  */
	public double getGrade(int grade);
	
	/**
	  * Gets the student's average
	  * 
	  * @return An average based on all the student's grades
	  * 
	  */
	public double getAvg();
	
	/**
	  * Gets the Student's assignment average
	  * 
	  * @return An average based solely on this student's assignments
	  * 
	  */
	public double getAsnAvg();
	
	/**
	  * Gets the Student's exam average
	  * 
	  * @return An average based solely on this student's exams
	  * 
	  */
	public double getExmAvg();
	
	/**
	  * Sets the student's first name
	  * 
	  * @param nameFirst The first name we want this student to have
	  * 
	  */
	public void setNameFirst(String nameFirst);

	/**
	  * Sets the student's last name
	  * 
	  * @param nameLast The last name we want this student to have
	  * 
	  */
	public void setNameLast(String nameLast);

	/**
	  * Sets the student's id number
	  * 
	  * @param number The id number we want this student to have
	  * 
	  */
	public void setNumber(String number);

	/**
	  * Sets the student's email
	  * emailnameFirst The email we want this student to have
	  * 
	  */
	public void setEmail(String email);
	
	/**
	  * Sets the student's average
	  * 
	  * @param avg The new average this student will have
	  * 
	  */
	public void setAvg(double avg);
	
	/**
	  * Sets the student's assignment average
	  * 
	  * @param asnAvg The new assignment average this student will have
	  * 
	  */
	public void setAsnAvg(double asnAvg);
	
	/**
	  * Sets the student's exam average
	  * 
	  * @param exmAvg The new exam average this student will have
	  * 
	  */
	public void setExmAvg(double exmAvg);
	
	/**
	  * Adds a grade for this student
	  * 
	  * @param deliver The grade insertion position
	  * @param grade The grade to be inserted
	  * @param type	The deliverable type
	  * @param weight The grade weight
	  * @return true if the grade was inserted successfully, false otherwise
	  * 
	  */
	public boolean addGrade(int deliver, double grade, String type, double weight);
	
	/**
	  * Removes a grade from this student
	  *
	  * @param deliver The grade removal index point
	  * @param type	The type of the deliverable
	  * @return true if the grade was removed successfully, false otherwise
	  * 
	  */
	public boolean removeGrade(int deliver, String type);
	
	/**
	  * Method that checks for equality between 2 students
	  * 
	  * @param stud	The student we are comparing to	
	  * @return If the student is equal to this student, return true. Otherwise return false
	  * 
	  */
	public boolean equals(Student stud);

	/**
	  * A toString method
	  * 
	  * @return The student's attribute information in the form of a string
	  * 
	  */
	public String toString();
}
