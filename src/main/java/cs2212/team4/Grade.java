package cs2212.team4;

import java.io.Serializable;

/**
 *
 * Grade is the class that will be used to store student grades.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 1.0 3/1/2014
 */

public class Grade implements GradeADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The Grade Class version
	private static final long serialVersionUID = 1L;
	//The Grade object grade and weight.
	private double grade,weight;
	
	/**
	  * Constructor.
	  * 
	  * @param		grade		Double, the Grade object grade.
	  * @param		weight		Double, the Grade object weight.
	  * 
	  */
	public Grade(double grade, double weight)
	{
		this.grade=grade;
		this.weight=weight;
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */
	
	/**
	  * Gets the Grade object grade.
	  * 
	  * @return		Double, the Grade object grade.
	  * 
	  */
	public double getGrade(){return grade;}
	
	/**
	  * Gets the Grade object weight.
	  * 
	  * @return		Double, the Grade object weight.
	  * 
	  */
	public double getWeight(){return weight;}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the Grade object grade.
	  * 
	  * @param		grade			Double,the Grade object grade.
	  * 
	  */
	public void setGrade(double grade){this.grade=grade;}
	
	/**
	  * Sets the Grade object weight.
	  * 
	  * @param		weight			Double,the Grade object weight.
	  * 
	  */
	public void setWeight(double weight){this.weight=weight;}
}
