/**
 * team4-gradebook application
 * student.java
 * Purpose: student.java is a java object that will store information about the students enrolled in an active course.
 * The student object will have a attributes such as, first and last name, unique student number and email, and 
 * exam, assignments and course averages.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/2/2014
 */

package cs2212.team4;

import java.util.ArrayList;

public class Student implements StudentADT
{
	private String nameFirst="", nameLast="", email="";
	private int number=0;
	private double avg=0.0, exmAvg=0.0, asnAvg=0.0;
	private ArrayList<Deliverable> deliverableList;

	/**
	  * A constructor of the student class, will create an empty student object.
	  * 
	  * @param		nameFirst		String, will hold the student nameFirst value.
	  * @param		nameLast		String, will hold the student nameLast value.
	  * @param		number			String, will hold the student unique number value.
	  * @param		email			String, will hold the student unique email value.
	  * @param		deliverableList	ArrayList<deliverable>, will hold the student deliverableList value.
	  * 
	  */
	public Student(String nameFirst, String nameLast, int number, String email, ArrayList<Deliverable> deliverableList)
	{
		this.nameFirst=nameFirst;
		this.nameLast=nameLast;
		this.number=number;
		this.email=email;
		this.deliverableList=deliverableList;
	}

	/**
	  * A getter for the student nameFirst value.
	  * 
	  * @return		String, will hold the student nameFirst value.
	  * 
	  */
	public String getNameFirst(){return nameFirst;}

	/**
	  * A getter for the student nameLast value.
	  * 
	  * @return		String, will hold the student nameLast value.
	  * 
	  */
	public String getNameLast(){return nameLast;}

	/**
	  * A getter for the student number value.
	  * 
	  * @return		int, will hold the student number value.
	  * 
	  */
	public int getNumber(){return number;}

	/**
	  * A getter for the student email value.
	  * 
	  * @return		String, will hold the student email value.
	  * 
	  */
	public String getEmail(){return email;}
	
	/**
	  * A getter for the student avg value.
	  * 
	  * @return		double, will hold the student avg value.
	  * 
	  */
	public double getAvg()
	{
		if (avg==0)return evalAvg();
		return avg;
	}
	
	/**
	  * A getter for the student asnAvg value.
	  * 
	  * @return		double, will hold the student asnAvg value.
	  * 
	  */
	public double getAsnAvg()
	{
		if (asnAvg==0)return evalAsnAvg();
		return asnAvg;
	}
	
	/**
	  * A getter for the student exmAvg value.
	  * 
	  * @return		double, will hold the student exmAvg value.
	  * 
	  */
	public double getExmAvg()
	{
		if (exmAvg==0)return evalExmAvg();
		return exmAvg;
	}

	/**
	  * A method that evaluates the student avg value.
	  * 
	  * @return		double, will hold the student avg value.
	  * 
	  */
	public double evalAvg()
	{
		double sum=0.0, weight=0.0;
		for (int i=0; i<deliverableList.size(); i++)
		{
			sum+=deliverableList.get(i).getGrade();
			weight+=deliverableList.get(i).getWeight();
		}avg=sum/weight;return avg;
	}
	
	/**
	  * A method that evaluates the student asnAvg value.
	  * 
	  * @return		double, will hold the student asnAvg value.
	  * 
	  */
	public double evalAsnAvg()
	{
		double sum=0.0, weight=0.0;
		for (int i=0; i<deliverableList.size(); i++)
		{
			if (deliverableList.get(i).getType().toLowerCase().equals("assignment"))
			{
				sum+=deliverableList.get(i).getGrade();
				weight+=deliverableList.get(i).getWeight();
			}
		}asnAvg=sum/weight;return asnAvg;
	}
	
	/**
	  * A method that evaluates the student exmAvg value.
	  * 
	  * @return		double, will hold the student exmAvg value.
	  * 
	  */
	public double evalExmAvg()
	{
		double sum=0.0, weight=0.0;
		for (int i=0; i<deliverableList.size(); i++)
		{
			if (deliverableList.get(i).getType().toLowerCase().equals("exam"))
			{
				sum+=deliverableList.get(i).getGrade();
				weight+=deliverableList.get(i).getWeight();
			}
		}exmAvg=sum/weight;return exmAvg;
	}
	
	/**
	  * A setter for the student nameFirst value.
	  * 
	  * @param		nameFirst			String, will hold the student nameFirst new value.
	  * 
	  */
	public void setNameFirst(String nameFirst){this.nameFirst=nameFirst;}

	/**
	  * A setter for the student nameLast value.
	  * 
	  * @param		nameLast			String, will hold the student nameLast new value.
	  * 
	  */
	public void setNameLast(String nameLast){this.nameLast=nameLast;}

	/**
	  * A setter for the student number value.
	  * 
	  * @param		number			int, will hold the student number new value.
	  * 
	  */
	public void setNumber(int number){this.number=number;}

	/**
	  * A setter for the student email value.
	  * 
	  * @param		email			String, will hold the student email new value.
	  * 
	  */
	public void setEmail(String email){this.email=email;}
	
	/**
	  * A setter for the student avg value.
	  * 
	  * @param		avg				double, will hold the student avg new value.
	  * 
	  */
	public void setAvg(double avg){this.avg=avg;}
	
	/**
	  * A setter for the student asnAvg value.
	  * 
	  * @param		asnAvg			double, will hold the student asnAvg new value.
	  * 
	  */
	public void setAsnAvg(double asnAvg){this.asnAvg=asnAvg;}
	
	/**
	  * A setter for the student exmAvg value.
	  * 
	  * @param		exmAvg			double, will hold the student exmAvg new value.
	  * 
	  */
	public void setExmAvg(double exmAvg){this.exmAvg=exmAvg;}

	/**
	  * addDeliverable method will add a deliverable object to the deliverableList.
	  * 
	  * @param		deliver				deliverable, will hold the deliverable object's information.
	  * 
	  */
	public void addDeliverable(Deliverable deliver){deliverableList.add(deliver);}
	
	/**
	  * removeDeliverable method will remove a specific deliverable object from the deliverableList.
	  * 
	  * @param		deliver				int, will hold the deliverable object's location in the deliverableList.
	  * 
	  */
	public void removeDeliverable(int deliver){deliverableList.remove(deliver);}

	/**
	  * gradeExportString method is a helper method for the exportGrades method located in course.java.
	  * 
	  * return		String, will hold the student grades information.
	  * 
	  */
	public String gradeExportString()
	{
		String str="\""+number+"\"";
		for (int i=0; i<deliverableList.size(); i++)str=str+", \""+deliverableList.get(i).getGrade()+"\"";
		return str+"\n";
	}

	/**
	  * A toString method.
	  * 
	  * return		String, will hold the student information.
	  * 
	  */
	public String toString(){return ("\""+nameLast+"\", \""+nameFirst+"\", \""+number+"\""+", \""+email+"\"\n");}
}
