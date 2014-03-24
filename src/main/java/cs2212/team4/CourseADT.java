package cs2212.team4;

import java.io.File;

/**
 *
 * CourseADT implements the method interface for the Course class.
 *
 * @author Zaid Albirawi
 * @version 1.0 2/28/2014
 */

public interface CourseADT
{
	/**
	 * Gets the course title
	 * 
	 * @return The title of the course
	 * 
	 */
	public String getTitle();

	/**
	  * Gets the course term
	  * 
	  * @return The term of the course
	  * 
	  */
	public String getTerm();

	/**
	  * Gets the course code
	  * 
	  * @return The course code
	  * 
	  */
	public String getCode();
	
	/**
	  * Gets a specified student of this course
	  * 
	  * @param stud An index number pertaining to a student in a list
	  * @return The student that is indexed at the passed number. If the student index is out of bounds from the list, return null
	  * 
	  */
	public Student getStudent(int stud);
	
	/**
	  * Gets a specified Deliverable of this course
	  * 
	  * @param deliver An index number pertaining to a deliverable in this course's list of deliverables
	  * @return The Deliverable that is indexed at the passed number. If the deliverable index is out of bounds from the list, return null
	  * 
	  */
	public Deliverable getDeliverable(int deliver);
	
	/**
	  * Gets a specific student grade
	  * 
	  * @param stud	A student of this course
	  * @param grade An index number pertaining to a grade in this student's list of grades
	  * @return The specidied student's specified grade. If the grade index is out of bounds from the list, return -1
	  * 
	  */
	public double getGrade(Student stud, int grade);
	
	/**
	  * Sets the course title
	  * 
	  * @param The desired title for the course
	  * 
	  */
	public void setTitle(String title);

	/**
	  * Sets the course term
	  * 
	  * @param The desired term for the course
	  * 
	  */
	public void setTerm(String term);

	/**
	  * Sets the course code
	  * 
	  * @param The desired course code
	  * 
	  */
	public void setCode(String code);

	/**
	  * Edit a student's ID number
	  * 
	  * @param stud	The student whose ID number we want to change
	  * @param number The new ID number we want to change to
	  * @return true if the ID number was changed or if requested change was already the current number. Or, if the number already belongs to another student, return false
	  * 
	  */
	public boolean editStudentNumber(Student stud, String number);

	/**
	  * Edit a student's Email
	  * 
	  * @param stud The student whose email we want to change
	  * @param email The new email we want to change to
	  * @return true if the email was changed or if requested change was already the current email. Or, if the email already belongs to another student, return false
	  * 
	  */
	public boolean editStudentEmail(Student stud, String email);
	
	/**
	  * Finds the index number of the requested student within the course's list of students
	  * 
	  * @param number The student's ID number
	  * @return The index at which the requested student sits in the list of students in this course. Or, if the student doesn't exist, return -1
	  * 
	  */
	public int findStudent(String number);
	
	/**
	  * Adds a student to the course
	  * 
	  * @param nameFirst The student's first name
	  * @param nameLast The student's last name
	  * @param number The student's unique ID number
	  * @param email The student's email
	  * @return true if the student was added to the course. Or, if a student in the course already shares the same email or ID number, return false
	  * 
	  */
	public boolean addStudent(String nameFirst, String nameLast, String number, String email);

	/**
	  * Remove a student from the course
	  * 
	  * @param i The student's index number in the list of students in this course
	  * @return true if the student was removed. Or, if the index given falls our of bounds of the list of students, return false
	  * 
	  */
	public boolean removeStudent(int i);
	
	/**
	  * Finds the index number of the requested deliverable within the course's list of deliverables
	  * 
	  * @param deliver The deliverable we are searching for
	  * @return The index at which the requested deliverable sits in the list of deliverables in this course. Or, if the deliverable doesn't exist, return -1
	  * 
	  */
	public int findDeliverable(Deliverable deliver);
	
	/**
	  * Adds a deliverable to the course
	  * 
	  * @param name The name of the dliverable
	  * @param type	The type of the deliverable
	  * @param weight The weight of the deliverable
	  * @return true if a deliverable was added to the course. Or, if the deliverable already exists, return false
	  * 
	  */
	public boolean addDeliverable(String name, String type, double weight);

	/**
	  * Removes a deliverable from the course
	  * 
	  * @param i The index of the deliverable we want to remove in the list of the deliverables for this course
	  * @return true if the deliverable was removed. Or, if the index falls out of bounds from our list of deliverables in this course, return false
	  * 
	  */
	public boolean removeDeliverable(int i);
	
	/**
	  * Adds a grade for a student in the course
	  * 
	  * @param stud The student who we want to give a grade for
	  * @param deliver The deliverable for which we are adding the grade
	  * @param grade The grade we are adding
	  * @return true if the grade was inserted. False if the grade failed to be inserted
	  * 
	  */
	public boolean addGrade(Student stud, Deliverable deliver, double grade);
	
	/**
	  * removes a grade from a student in the course
	  * 
	  * @param stud The student who we want to remove a grade from
	  * @param deliver The deliverable from which we are removing the grade
	  * @return true if the grade was removed. False if the grade failed to be removed
	  * 
	  */
	public boolean removeGrade(Student stud, Deliverable deliver);

	/**
	  * Imports students into the course
	  * @param file The path where the file containing the students to be imported is located
	  * @return true if the students were imported successfully, otherwise return false
	  * 
	  */
	public boolean importStudents(File file);
	
	/**
	  * Exports the Students of a course into a .csv file
	  * 
	  * @param file The path where we want to export the students
	  * @return true if the students were exported, false otherwise
	  * 
	  */
	public boolean exportStudents(File file);
	
	/**
	  * Imports deliverables into the course
	  * 
	  * @param file The path where the file containing the deliverables to be imported is located
	  * @return true if the deliverables were imported successfully, otherwise return false
	  * 
	  */
	public boolean importDeliverables(File file);

	/**
	  * Exports the deliverables of a course into a .csv file
	  * 
	  * @param file The path where we want to export the deliverables
	  * @return true if the deliverables were exported, false otherwise
	  * 
	  */
	public boolean exportDeliverables(File file);
	
	/**
	  * Imports students' grades into the course
	  * 
	  * @param file The path where the file containing the students' grades to be imported is located
	  * @return true if the grades were imported successfully, otherwise return false
	  * 
	  */
	public boolean importGrades(File file);

	/**
	  * Exports students' grades into a .csv file
	  * 
	  * @param The path where we want to export the grades
	  * @return true if the grades were exported, false otherwise
	  * 
	  */
	public boolean exportGrades(File file);

	/**
	  * A method that test for course equality
	  * 
	  * @param crs The course we are comparing to	
	  * @return true if the course is equal to this course, false otherwise
	  * 
	  */
	public boolean equals(Course crs);
	
	/**
	  * A toString method
	  * 
	  * @return The course information. Including title, term, and code
	  * 
	  */
	public String toString();
}
