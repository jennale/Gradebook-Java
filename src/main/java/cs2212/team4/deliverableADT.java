/**
 * team4-gradebook application
 * deliverableADT.java
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

public interface deliverableADT
{
	/**
	  * A getter for the deliverable name value.
	  * 
	  * @return		String, will hold the deliverable name value.
	  * 
	  */
	public String getName();

	/**
	  * A getter for the deliverable type value.
	  * 
	  * @return		String, will hold the deliverable name type.
	  * 
	  */
	public String getType();

	/**
	  * A getter for the deliverable weight value.
	  * 
	  * @return		double, will hold the deliverable weight value.
	  * 
	  */
	public double getWeight();

	/**
	  * A getter for the deliverable grade value.
	  * 
	  * @return		double, will hold the deliverable grade value.
	  * 
	  */
	public double getGrade();
	
	/**
	  * A setter for the deliverable name value.
	  * 
	  * @param		name			String, will hold the deliverable name new value.
	  * 
	  */
	public void setName(String name);

	/**
	  * A setter for the deliverable type value.
	  * 
	  * @param		type			String, will hold the deliverable type new value.
	  * 
	  */
	public void setType(String type);
	
	/**
	  * A setter for the deliverable weight value.
	  * 
	  * @param		weight			double, will hold the deliverable weight new value.
	  * 
	  */
	public void setWeight(double weight);

	/**
	  * A setter for the deliverable grade value.
	  * 
	  * @param		grade			double, will hold the deliverable grade new value.
	  * 
	  */
	public void setGrade(double grade);
	
	/**
	  * A toString method.
	  * 
	  * return		String, will hold the deliverable information.
	  * 
	  */
	public String toString();
}
