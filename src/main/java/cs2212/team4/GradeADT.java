package cs2212.team4;

/**
 *
 * GradeADT implements the method interface for the Grade class.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/28/2014
 */


public interface GradeADT
{
	/**
	  * Gets the Grade object grade.
	  * 
	  * @return		Double, the Grade object grade.
	  * 
	  */
	public double getGrade();
	
	/**
	  * Gets the Grade object weight.
	  * 
	  * @return		Double, the Grade object weight.
	  * 
	  */
	public double getWeight();
	
	/**
	  * Sets the Grade object grade.
	  * 
	  * @param		grade			Double,the Grade object grade.
	  * 
	  */
	public void setGrade(double grade);
	
	/**
	  * Sets the Grade object weight.
	  * 
	  * @param		weight			Double,the Grade object weight.
	  * 
	  */
	public void setWeight(double weight);
}
