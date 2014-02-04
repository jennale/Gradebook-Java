/**
 * team4-gradebook application
 * studentADT.java
 * 
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

public interface studentADT
{
	/**
	  * A getter for the student nameFirst value.
	  * 
	  * @return		String, will hold the student nameFirst value.
	  * 
	  */
	public String getNameFirst();

	/**
	  * A getter for the student nameLast value.
	  * 
	  * @return		String, will hold the student nameLast value.
	  * 
	  */
	public String getNameLast();

	/**
	  * A getter for the student number value.
	  * 
	  * @return		int, will hold the student number value.
	  * 
	  */
	public int getNumber();

	/**
	  * A getter for the student email value.
	  * 
	  * @return		String, will hold the student email value.
	  * 
	  */
	public String getEmail();
	
	/**
	  * A getter for the student avg value.
	  * 
	  * @return		double, will hold the student avg value.
	  * 
	  */
	public double getAvg();
	
	/**
	  * A getter for the student asnAvg value.
	  * 
	  * @return		double, will hold the student asnAvg value.
	  * 
	  */
	public double getAsnAvg();
	
	/**
	  * A getter for the student exmAvg value.
	  * 
	  * @return		double, will hold the student exmAvg value.
	  * 
	  */
	public double getExmAvg();

	/**
	  * A setter for the student nameFirst value.
	  * 
	  * @param		nameFirst			String, will hold the student nameFirst new value.
	  * 
	  */
	public void setNameFirst(String nameFirst);

	/**
	  * A setter for the student nameLast value.
	  * 
	  * @param		nameLast			String, will hold the student nameLast new value.
	  * 
	  */
	public void setNameLast(String nameLast);

	/**
	  * A setter for the student number value.
	  * 
	  * @param		number			int, will hold the student number new value.
	  * 
	  */
	public void setNumber(int number);

	/**
	  * A setter for the student email value.
	  * 
	  * @param		email			String, will hold the student email new value.
	  * 
	  */
	public void setEmail(String email);
	
	/**
	  * A setter for the student avg value.
	  * 
	  * @param		avg				double, will hold the student avg new value.
	  * 
	  */
	public void setAvg(double avg);
	
	/**
	  * A setter for the student asnAvg value.
	  * 
	  * @param		asnAvg			double, will hold the student asnAvg new value.
	  * 
	  */
	public void setAsnAvg(double asnAvg);
	
	/**
	  * A setter for the student exmAvg value.
	  * 
	  * @param		exmAvg			double, will hold the student exmAvg new value.
	  * 
	  */
	public void setExmAvg(double exmAvg);

	/**
	  * addDeliverable method will add a deliverable object to the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  */
	public void addDeliverable(deliverable deliver);
	
	/**
	  * removeDeliverable method will remove a specific deliverable object from the deliverableList.
	  * 
	  * @param		deliver				int, will hold the deliverable object's location in the deliverableList.
	  * 
	  */
	public void removeDeliverable(int deliver);

	/**
	  * gradeExportString method is a helper method for the exportGrades method located in course.java.
	  * 
	  * return		String, will hold the student grades information.
	  * 
	  */
	public String gradeExportString();

	/**
	  * A toString method.
	  * 
	  * return		String, will hold the student information.
	  * 
	  */
	public String toString();
}
