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
	  * Gets the Student object first name.
	  * 
	  * @return		String, the Student object first name.
	  * 
	  */
	public String getNameFirst();

	/**
	  * Gets the Student object last name.
	  * 
	  * @return		String, the Student object last name.
	  * 
	  */
	public String getNameLast();

	/**
	  * Gets the Student object number.
	  * 
	  * @return		Integer, the Student object number.
	  * 
	  */
	public String getNumber();

	/**
	  * Gets the Student object email.
	  * 
	  * @return		String, the Student object email.
	  * 
	  */
	public String getEmail();
	
	/**
	  * Gets a Student object Grade object.
	  * 
	  * @return		Grade, a Student object Grade object.
	  * 
	  */
	public double getGrade(int grade);
	
	/**
	  * Gets the Student object average.
	  * 
	  * @return		Double, the Student object average.
	  * 
	  */
	public double getAvg();
	
	/**
	  * Gets the Student object assignment average.
	  * 
	  * @return		Double, the Student object assignment average.
	  * 
	  */
	public double getAsnAvg();
	
	/**
	  * Gets the Student object exam average.
	  * 
	  * @return		Double, the Student object exam average.
	  * 
	  */
	public double getExmAvg();
	
	/**
	  * Sets the Student object first name.
	  * 
	  * @param		nameFirst		String, the Student object first name.
	  * 
	  */
	public void setNameFirst(String nameFirst);

	/**
	  * Sets the Student object last name.
	  * 
	  * @param		nameLast		String, the Student object last name.
	  * 
	  */
	public void setNameLast(String nameLast);

	/**
	  * Sets the Student object number.
	  * 
	  * @param		number		String, the Student object number.
	  * 
	  */
	public void setNumber(String number);

	/**
	  * Sets the Student object email.
	  * 
	  * @param		email			String, the Student object email.
	  * 
	  */
	public void setEmail(String email);
	
	/**
	  * Sets the Student object average.
	  * 
	  * @param		avg				Double, the Student object average.
	  * 
	  */
	public void setAvg(double avg);
	
	/**
	  * Sets the Student object assignment average.
	  * 
	  * @param		asnAvg			Double, the Student object assignment average.
	  * 
	  */
	public void setAsnAvg(double asnAvg);
	
	/**
	  * Sets the Student object exam average.
	  * 
	  * @param		exmAvg			Double, the Student object exam average.
	  * 
	  */
	public void setExmAvg(double exmAvg);
	
	/**
	  * Adds a grade to the StudentGrades object.
	  * 
	  * @param		deliver				Integer, the grade insertion position.
	  * @param		grade				Double, the grade.
	  * @param		type				String, the deliverable type.
	  * @param		weight				Double, the grade weight.
	  * 
	  * @return		boolean, true if the grade was inserted successfully, false otherwise.
	  * 
	  */
	public boolean addGrade(int deliver, double grade, String type, double weight);
	
	/**
	  * Removes a grade from the StudentGrades object.
	  *
	  * @param		deliver				Integer, the position at where the grade will be inserted.
	  * @param		type				String, the type of the deliverable.
	  * 
	  * @return		boolean, true if the grade was removed successfully, false otherwise.
	  * 
	  */
	public boolean removeGrade(int deliver, String type);
	
	/**
	  * An equals method.
	  * 
	  * @param		stud				Student, the Student object.		
	  * 
	  * @return		boolean, true if the Student object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Student stud);

	/**
	  * A toString method.
	  * 
	  * @return		String, the Student object information string.
	  * 
	  */
	public String toString();
}
