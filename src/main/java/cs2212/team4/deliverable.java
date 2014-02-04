/**
 * team4-gradebook application
 * deliverable.java
 * Purpose: deliverable.java is a java object that will hold the information about a course deliverable. The object will
 * have four attributes which are: name, type, weight and grade.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

public class deliverable implements deliverableADT
{
	private String name="", type="";
	private double weight=0.0, grade=0.0;

	/**
	  * A constructor of the deliverable class, will create a deliverable object.
	  * 
	  * @param		name		String, will hold the deliverable name value.
	  * @param		type		String, will hold the deliverable type value.
	  * @param		weight		double, will hold the deliverable weight value.
	  * 
	  */
	public deliverable(String name, String type, double weight)
	{
		this.name=name;
		this.type=type;
		this.weight=weight;
	}

	/**
	  * A getter for the deliverable name value.
	  * 
	  * @return		String, will hold the deliverable name value.
	  * 
	  */
	public String getName(){return name;}

	/**
	  * A getter for the deliverable type value.
	  * 
	  * @return		String, will hold the deliverable name type.
	  * 
	  */
	public String getType(){return type;}

	/**
	  * A getter for the deliverable weight value.
	  * 
	  * @return		double, will hold the deliverable weight value.
	  * 
	  */
	public double getWeight(){return weight;}

	/**
	  * A getter for the deliverable grade value.
	  * 
	  * @return		double, will hold the deliverable grade value.
	  * 
	  */
	public double getGrade(){return grade;}
	
	/**
	  * A setter for the deliverable name value.
	  * 
	  * @param		name			String, will hold the deliverable name new value.
	  * 
	  */
	public void setName(String name){this.name=name;}

	/**
	  * A setter for the deliverable type value.
	  * 
	  * @param		type			String, will hold the deliverable type new value.
	  * 
	  */
	public void setType(String type){this.type=type;}

	/**
	  * A setter for the deliverable weight value.
	  * 
	  * @param		weight			double, will hold the deliverable weight new value.
	  * 
	  */
	public void setWeight(double weight){this.weight=weight;}

	/**
	  * A setter for the deliverable grade value.
	  * 
	  * @param		grade			double, will hold the deliverable grade new value.
	  * 
	  */
	public void setGrade(double grade){this.grade=grade;}
	
	/**
	  * A toString method.
	  * 
	  * return		String, will hold the deliverable information.
	  * 
	  */
	public String toString(){return ("\""+name+"\", \""+type+"\", \""+weight+"\"\n");}
}
