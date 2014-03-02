package cs2212.team4;

/**
 *
 * DeliverableADT implements the method interface for the Deliverable class.
 *
 * @author Zaid Albirawi
 * @version 2.0 3/1/2014
 */


public interface DeliverableADT
{
	/**
	  * Gets the Deliverable object name.
	  * 
	  * @return		String, the Deliverable object name.
	  * 
	  */
	public String getName();

	/**
	  * Gets the Deliverable object type.
	  * 
	  * @return		String, the Deliverable object type.
	  * 
	  */
	public String getType();

	/**
	  * Gets the Deliverable object weight.
	  * 
	  * @return		Double, the Deliverable object weight.
	  * 
	  */
	public double getWeight();
	
	/**
	  * Gets the Deliverable object id.
	  * 
	  * @return		Integer, the Deliverable object id.
	  * 
	  */
	public int getObjId();
	
	/**
	  * Sets the Deliverable object name.
	  * 
	  * @param		name			String,the Deliverable object name.
	  * 
	  */
	public void setName(String name);

	/**
	  * Sets the Deliverable object type.
	  * 
	  * @param		type			String,the Deliverable object type.
	  * 
	  */
	public void setType(String type);

	/**
	  * Sets the Deliverable object weight.
	  * 
	  * @param		weight			Double,the Deliverable object weight.
	  * 
	  */
	public void setWeight(double weight);
	
	/**
	  * An equals method.
	  * 
	  * return		boolean, true if the Course object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Deliverable deliver);
	
	/**
	  * A toString method.
	  * 
	  * return		String, the Deliverable object information string.
	  * 
	  */
	public String toString();
}
