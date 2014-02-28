package cs2212.team4;

import java.io.Serializable;

/**
 *
 * Deliverable is the class that will be used to store all course deliverables information.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 1.2 2/28/2014
 */

public class Deliverable implements DeliverableADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The Deliverable name and type
	private String name="", type="";
	//The Deliverable weight
	private double weight;
	//The Deliverable id
	private int objId;
	
	/**
	  * Constructor.
	  * 
	  * @param		name		String, the Deliverable object name.
	  * @param		type		String, the Deliverable object type.
	  * @param		weight		Double, the Deliverable object weight.
	  * @param		objId		Integer, the Deliverable object id.
	  * 
	  */
	public Deliverable(String name, String type, double weight, int objId)
	{
		this.name=name;
		this.type=type;
		this.weight=weight;
		this.objId=objId;
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */

	/**
	  * Gets the Deliverable object name.
	  * 
	  * @return		String, the Deliverable object name.
	  * 
	  */
	public String getName(){return name;}

	/**
	  * Gets the Deliverable object type.
	  * 
	  * @return		String, the Deliverable object type.
	  * 
	  */
	public String getType(){return type;}

	/**
	  * Gets the Deliverable object weight.
	  * 
	  * @return		Double, the Deliverable object weight.
	  * 
	  */
	public double getWeight(){return weight;}
	
	/**
	  * Gets the Deliverable object id.
	  * 
	  * @return		Integer, the Deliverable object id.
	  * 
	  */
	public int getObjId(){return objId;}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the Deliverable object name.
	  * 
	  * @param		name			String,the Deliverable object name.
	  * 
	  */
	public void setName(String name){this.name=name;}

	/**
	  * Sets the Deliverable object type.
	  * 
	  * @param		type			String,the Deliverable object type.
	  * 
	  */
	public void setType(String type){this.type=type;}

	/**
	  * Sets the Deliverable object weight.
	  * 
	  * @param		weight			Double,the Deliverable object weight.
	  * 
	  */
	public void setWeight(double weight){this.weight=weight;}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * An equals method.
	  * 
	  * return		boolean, true if the Course object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Deliverable deliver)
	{
		if(this.toString().equalsIgnoreCase(deliver.toString()))return true;
		return false;
	}
	
	/**
	  * A toString method.
	  * 
	  * return		String, the Deliverable object information string.
	  * 
	  */
	public String toString(){return ("\""+name+"\", \""+type+"\", \""+weight+"\"\n");}
}
