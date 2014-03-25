package cs2212.team4;

import java.io.Serializable;

/**
 *
 * Student is the class that will store all the student grades and informations.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 20 3/1/2014
 */


public class Student implements StudentADT, Serializable
{
	/* ************************************************************
	* Instance Variables
	************************************************************ */
	
	// The Student Class version
	private static final long serialVersionUID = 1L;
	// The Student object first name, last name, and email.
	private String nameFirst = "", nameLast = "", number = "", email = "";
	// The Student object grades.
	private StudentGrades grades;

	/**
	  * Constructor that creates a student using a first & last name, an id number, and an email
	  * 
	  * @param nameFirst The student's first name
	  * @param nameLast The student's last name
	  * @param number The student's number
	  * @param email The student's email
	  * 
	  */
	public Student(String nameFirst, String nameLast, String number,
			String email) {
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.number = number;
		this.email = email;
		grades = new StudentGrades();
	}

	/* ************************************************************
	* Accessor Methods
	************************************************************ */
	
	/**
	  * Gets the student's first name
	  * 
	  * @return The student's first name
	  * 
	  */
	public String getNameFirst() {
		return nameFirst;
	}

	/**
	  * Gets the student's last name
	  * 
	  * @return The student's last name
	  * 
	  */
	public String getNameLast() {
		return nameLast;
	}

	/**
	  * Gets the student's id number
	  * 
	  * @return The student's id number
	  * 
	  */
	public String getNumber() {
		return number;
	}

	/**
	  * Gets the student's email
	  * 
	  * @return The student's email
	  * 
	  */
	public String getEmail() {
		return email;
	}
	
	/**
	  * Gets a specific grade of the student at the index passed
	  * 
	  * @param grade The grade at the index that we want returned
	  * @return the grade for this student at the index we passed
	  * 
	  */
	public double getGrade(int grade) {
		return grades.getGrade(grade);
	}
	
	/**
	  * Gets the student's average
	  * 
	  * @return An average based on all the student's grades
	  * 
	  */
	public double getAvg() {
		return grades.getAvg();
	}
	
	/**
	  * Gets the Student's assignment average
	  * 
	  * @return An average based solely on this student's assignments
	  * 
	  */
	public double getAsnAvg() {
		return grades.getAsnAvg();
	}
	
	/**
	  * Gets the Student's exam average
	  * 
	  * @return An average based solely on this student's exams
	  * 
	  */
	public double getExmAvg() {
		return grades.getExmAvg();
	}
	
	/**
	 * Returns the number of grades associated with this student
	 * 
	 * @return how many grades are associated with this student
	 */
	public int getNumGrades() {
		return grades.getGradeList().size();
	}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the student's first name
	  * 
	  * @param nameFirst The first name we want this student to have
	  * 
	  */
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	/**
	  * Sets the student's last name
	  * 
	  * @param nameLast The last name we want this student to have
	  * 
	  */
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	/**
	  * Sets the student's id number
	  * 
	  * @param number The id number we want this student to have
	  * 
	  */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	  * Sets the student's email
	  * emailnameFirst The email we want this student to have
	  * 
	  */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	  * Sets the student's average
	  * 
	  * @param avg The new average this student will have
	  * 
	  */
	public void setAvg(double avg) {
		grades.setAvg(avg);
	}
	
	/**
	  * Sets the student's assignment average
	  * 
	  * @param asnAvg The new assignment average this student will have
	  * 
	  */
	public void setAsnAvg(double asnAvg) {
		grades.setAsnAvg(asnAvg);
	}
	
	/**
	  * Sets the student's exam average
	  * 
	  * @param exmAvg The new exam average this student will have
	  * 
	  */
	public void setExmAvg(double exmAvg) {
		grades.setExmAvg(exmAvg);
	}
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Adds a grade for this student
	  * 
	  * @param deliver The grade insertion position
	  * @param grade The grade to be inserted
	  * @param type	The deliverable type
	  * @param weight The grade weight
	  * @return true if the grade was inserted successfully, false otherwise
	  * 
	  */
	public boolean addGrade(int deliver, double grade, String type,
			double weight) {
		return grades.add(deliver, grade, type, weight);
	}
	
	/**
	  * Removes a grade from this student
	  *
	  * @param deliver The grade removal index point
	  * @param type	The type of the deliverable
	  * @return true if the grade was removed successfully, false otherwise
	  * 
	  */
	public boolean removeGrade(int deliver, String type) {
		return grades.remove(deliver, type);
	}
	
	/**
	  * Method that checks for equality between 2 students
	  * 
	  * @param stud	The student we are comparing to	
	  * @return If the student is equal to this student, return true. Otherwise return false
	  * 
	  */
	public boolean equals(Student stud) {
		if (this.toString().equalsIgnoreCase(stud.toString()))
			return true;
		return false;
	}

	/**
	  * A toStringGrade method that creates the string that contains all the information that is to be exported about the student grades
	  * 
	  * @param delivers An array of grades for this student
	  * @return all the student information in the form of a string
	  * 
	  */
	public String toStringGrade(Object [] delivers) {
		String str;
		Double grade;
		str = "\"" + nameLast + "\", \"" + nameFirst + "\", \"" + number + "\""
				+ ", \"" + email + "\"";
		
		for (int i = 0; i < delivers.length; i++) {
			if ((grade = grades.getGrade((int)delivers[i])) == -1)
				str += ", \"No entry\"";
			else
				str += ", \"" + grade + "\"";				
		}
		return str + "\n";
	}
	
	/**
	  * A toString method
	  * 
	  * @return The student's attribute information in the form of a string
	  * 
	  */
	public String toString() {
		return ("\"" + nameLast + "\", \"" + nameFirst + "\", \"" + number
				+ "\"" + ", \"" + email + "\"\n");
	}
}
