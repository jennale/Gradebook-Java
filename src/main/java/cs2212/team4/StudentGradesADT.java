package cs2212.team4;

/**
 *
 * StudentGradesADT implements the method interface for the StudentGrades class.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/28/2014
 */

public interface StudentGradesADT
{	
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
	  * Gets the Grade object at grade from grades list.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade (int grade);
	
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
	  * A helper method that will add the student grades to the grades list.
	  * 
	  * @param		deliver			Integer, will hold the location at which the grade will be inserted in the grades list.
	  * @param		grade			Double, will hold the student's grade value.
	  * 
	  * @return		return a boolean to weather the grade was successfully added or not.
	  * 
	  */
	public boolean add(int deliver, double grade, String type, double weight);
	
	/**
     * Removes a grade from the StudentGrades object.
     *
     * @param		deliver				Integer, the position at where the grade will be inserted.
     * @param		type				String, the type of the deliverable.
     *
     * @return		boolean, true if the grade was removed successfully, false otherwise.
     * 
     */
	public boolean remove(int deliver, String type);
}
