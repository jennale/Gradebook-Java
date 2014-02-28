/**
 * team4-gradebook application
 * 
 * The StudentGrades class will contain all the grades for each Student.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/28/2014
 */

package cs2212.team4;

import java.util.ArrayList;

public class StudentGrades implements StudentGradesADT
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	//The StudentGrades object Grade objects list.
	private ArrayList<Grade> grades;
	//The StudentGrades object assignment grades list.
	private ArrayList<Integer> asn;
	//The StudentGrades object exam grades list.
	private ArrayList<Integer> exm;
	//The StudentGrades object average, assignment average, and exam average.
	private double avg, asnAvg, exmAvg;
	
	private final String ASN="assignment", EXM="exam";
	private boolean avgSet=false, asnSet=false, exmSet=false;
	
	/**
	  * Constructor.
	  */
	public StudentGrades()
	{
		grades = new ArrayList<Grade>();
		asn = new ArrayList<Integer>();
		exm = new ArrayList<Integer>();
	}
	
	/* ************************************************************
	* Accessor Methods
	************************************************************ */
	
	/**
	  * Gets the Student object average.
	  * 
	  * @return		Double, the Student object average.
	  * 
	  */
	public double getAvg()
	{
		if (avgSet)return avg;
		return calcAvg();
	}
	
	/**
	  * Gets the Student object assignment average.
	  * 
	  * @return		Double, the Student object assignment average.
	  * 
	  */
	public double getAsnAvg()
	{
		if (asnSet)return asnAvg;
		return calcAsnAvg();
	}

	/**
	  * Gets the Student object exam average.
	  * 
	  * @return		Double, the Student object exam average.
	  * 
	  */
	public double getExmAvg()
	{
		if (exmSet)return exmAvg;
		return calcExmAvg();
	}
	
	/**
	  * Gets the Grade object at grade from grades list.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade (int grade){return grades.get(grade).getGrade();}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the Student object average.
	  * 
	  * @param		avg				Double, the Student object average.
	  * 
	  */
	public void setAvg(double avg)
	{
		this.avg=avg;avgSet=true;
	}
	
	/**
	  * Sets the Student object assignment average.
	  * 
	  * @param		asnAvg			Double, the Student object assignment average.
	  * 
	  */
	public void setAsnAvg(double asnAvg)
	{
		this.asnAvg=asnAvg;asnSet=true;
	}
	
	/**
	  * Sets the Student object exam average.
	  * 
	  * @param		exmAvg			Double, the Student object exam average.
	  * 
	  */
	public void setExmAvg(double exmAvg)
	{
		this.exmAvg=exmAvg;exmSet=true;
	}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Calculates the Student object average.
	  * 
	  * @return 	Double, the Student object average.
	  * 
	  */
	private double calcAvg()
	{
		double avg=0;
		int ctr=0;
		Grade temp;
		if (grades.isEmpty())return -1;
		for (int i=0; i<grades.size(); i++)if (grades.get(i)!=null)
		{
			temp = grades.get(i);ctr++;
			avg+=temp.getGrade()/temp.getWeight();
		}return avg/ctr;
	}
	
	/**
	  * Calculates the Student object assignment average.
	  * 
	  * @return 	Double, the Student object assignment average.
	  * 
	  */
	private double calcAsnAvg()
	{
		double avg=0;
		Grade temp;
		if (asn.isEmpty())return -1;
		for (int i=0; i<asn.size(); i++)
		{
			temp = grades.get(asn.get(i));
			avg+=temp.getGrade()/temp.getWeight();
		}return avg/asn.size();
	}
	
	/**
	  * Calculates the Student object exam average.
	  * 
	  * @return 	Double, the Student object exam average.
	  * 
	  */
	private double calcExmAvg()
	{
		double avg=0;
		Grade temp;
		if (asn.isEmpty())return -1;
		for (int i=0; i<exm.size(); i++)
		{
			temp = grades.get(exm.get(i));
			avg+=temp.getGrade()/temp.getWeight();
		}return avg/exm.size();
	}
	
	/**
	  * A helper method that will add the student grades to the grades list.
	  * 
	  * @param		deliver			Integer, will hold the location at which the grade will be inserted in the grades list.
	  * @param		grade			Double, will hold the student's grade value.
	  * 
	  * @return		return a boolean to weather the grade was successfully added or not.
	  * 
	  */
	public boolean add(int deliver, double grade, String type, double weight)
	{
		if (grades.get(deliver)!=null)return false;
		if (type.equals(EXM))exm.add(deliver);
		else if (type.equals(ASN))asn.add(deliver);
		grades.add(deliver, (new Grade(grade, weight)));return true;
	}
	
	/**
	  * A setter for the student email value.
	  * 
	  * @param		email			String, will hold the student email new value.
	  * @return 
	  * 
	  */
	public boolean remove(int deliver, String type)
	{
		if (grades.get(deliver)==null)return false;
		if (type.equals(EXM))exm.remove(deliver);
		else if (type.equals(ASN))asn.remove(deliver);
		grades.set(deliver, null);return true;
	}
}
