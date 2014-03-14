package cs2212.team4;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * The StudentGrades class will contain all the grades for each Student.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 1.0 3/1/2014
 */

public class StudentGrades implements StudentGradesADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	// The StudentGrades Class version
	private static final long serialVersionUID = 1L;
	// The StudentGrades object Grade objects list.
	private ArrayList<Grade> grades;
	// The StudentGrades object assignment grades list.
	private ArrayList<Integer> asn;
	// The StudentGrades object exam grades list.
	private ArrayList<Integer> exm;
	// The StudentGrades object average, assignment average, and exam average.
	private double avg, asnAvg, exmAvg;

	private transient final String ASN = "assignment", EXM = "exam";
	
	/**
	  * Constructor.
	  */
	public StudentGrades() {
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
	public double getAvg() {
		return avg;
	}
	
	/**
	  * Gets the Student object assignment average.
	  * 
	  * @return		Double, the Student object assignment average.
	  * 
	  */
	public double getAsnAvg() {
		return asnAvg;
	}

	/**
	  * Gets the Student object exam average.
	  * 
	  * @return		Double, the Student object exam average.
	  * 
	  */
	public double getExmAvg() {
		return exmAvg;
	}
	
	/**
	  * Gets the Grade object at grade from grades list.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade(int grade) {
		if (grades.get(grade) == null)
			return -1;
		return grades.get(grade).getGrade();
	}
	
	/**
	 * Returns a reference to the grades Arraylist of the student
	 * 
	 * @return
	 */
	public ArrayList<Grade> getGradeList() {
		return grades;
	}
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the Student object average.
	  * 
	  * @param		avg				Double, the Student object average.
	  * 
	  */
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	/**
	  * Sets the Student object assignment average.
	  * 
	  * @param		asnAvg			Double, the Student object assignment average.
	  * 
	  */
	public void setAsnAvg(double asnAvg) {
		this.asnAvg = asnAvg;
	}
	
	/**
	  * Sets the Student object exam average.
	  * 
	  * @param		exmAvg			Double, the Student object exam average.
	  * 
	  */
	public void setExmAvg(double exmAvg) {
		this.exmAvg = exmAvg;
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
	private void calcAvg() {
		double avg = 0;
		double weight = 0;
		Grade temp;
		if (grades.isEmpty()) {
			avg = -1;
			return;
		}
		for (int i = 0; i < grades.size(); i++)
			if (grades.get(i) != null) {
				temp = grades.get(i);
				weight += temp.getWeight();
				avg += temp.getGrade() * temp.getWeight();
			}
		this.avg = avg / weight;
	}
	
	/**
	  * Calculates the Student object assignment average.
	  * 
	  * @return 	Double, the Student object assignment average.
	  * 
	  */
	private void calcAsnAvg() {
		double avg = 0;
		double weight = 0;
		Grade temp;
		if (asn.isEmpty()) {
			asnAvg = -1;
			return;
		}
		for (int i = 0; i < asn.size(); i++) {
			temp = grades.get(asn.get(i));
			weight += temp.getWeight();
			avg += temp.getGrade() * temp.getWeight();
		}
		asnAvg = avg / weight;
	}
	
	/**
	  * Calculates the Student object exam average.
	  * 
	  * @return 	Double, the Student object exam average.
	  * 
	  */
	private void calcExmAvg() {
		double avg = 0;
		Grade temp;
		double weight = 0;
		if (exm.isEmpty()) {
			exmAvg = -1;
			return;
		}
		for (int i = 0; i < exm.size(); i++) {
			temp = grades.get(exm.get(i));
			weight += temp.getWeight();
			avg += temp.getGrade() * temp.getWeight();
		}
		exmAvg = avg / weight;
	}
	
	/**
	  * Adds a grade to the StudentGrades object.
	  * 
	  * @param		deliver				Integer, the grade insertion position.
	  * @param		grade				Double, the grade.
	  * @param		type				String, the deliverable type.
	  * @param		weight				Double, the grade weight.
	  * 
	  * @return		boolean, true if the grade was inserted successfully, false otherwise.
	  * 
	  */
	public boolean add(int deliver, double grade, String type, double weight) {
		boolean boolExm = false, boolAsn = false;
		if (deliver >= grades.size())
			for (int i = grades.size(); i < deliver + 1; i++)
				grades.add(null);
		if (type.equalsIgnoreCase(EXM)) {
			exm.add(deliver);
			boolExm = true;
		} else if (type.equalsIgnoreCase(ASN)) {
			asn.add(deliver);
			boolAsn = true;
		}
		grades.set(deliver, (new Grade(grade, weight)));
		if (boolExm)
			calcExmAvg();
		else if (boolAsn)
			calcAsnAvg();
		calcAvg();
		return true;
	}

	/**
	  * Removes a grade to the StudentGrades object.
	  * 
	  * @param		deliver				Integer, the grade insertion position.
	  * @param		type				String, the deliverable type.
	  * 
	  * @return		boolean, true if the grade was removed successfully, false otherwise.
	  * 
	  */
	public boolean remove(int deliver, String type) {
		boolean boolExm = false, boolAsn = false;
		if (grades.get(deliver) == null)
			return false;
		if (type.equalsIgnoreCase(EXM))
			if (exm.contains(deliver)) {
				exm.remove(exm.indexOf(deliver));
				boolExm = true;
			} else
				return false;
		else if (type.equalsIgnoreCase(ASN))
			if (asn.contains(deliver)) {
				asn.remove(asn.indexOf(deliver));
				boolAsn = true;
			} else
				return false;
		grades.set(deliver, null);
		if (boolExm)
			calcExmAvg();
		else if (boolAsn)
			calcAsnAvg();
		calcAvg();
		return true;
	}
}
