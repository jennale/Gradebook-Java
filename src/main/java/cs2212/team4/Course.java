package cs2212.team4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Stack;
import au.com.bytecode.opencsv.CSVReader;

/**
 *
 * Course is the class that will be used to store all course students, deliverables, grades, and course information.
 *
 * team4-gradebook application
 *
 * @author Zaid Albirawi
 * @version 1.6 3/25/2014
 */

public class Course implements CourseADT, Serializable
{
	/* ************************************************************
	 * Instance Variables
	 ************************************************************ */

	// The Course Class version
	private static final long serialVersionUID = 1L;
	// The Course object title, term, and code.
	private String title = "", term = "", code = "", description="";
	// The Course object student list.
	private ArrayList<Student> studentList = new ArrayList<Student>();
	// The Course object deliverable list.
	private ArrayList<Deliverable> deliverableList = new ArrayList<Deliverable>();
	// The Course object empty deliverable slots
	private Stack<Integer> stkDeliver = new Stack<Integer>();
	//A collection of reports containing various information on a student
	//public static Collection<Report> student_info = new ArrayList<Report>();
    //Variable used to keep track of deliverable weights -- Optional if we want to keep
    //deliverable weights <= 100
    private double runningTotal=0;

	/**
	 * Constructor that creates a course with a given title, term, and code
	 * 
	 * @param title The title of the course
	 * @param term The term of the course
	 * @param code The course code
	 * 
	 */
	public Course(String title, String term, String code) {
		this.title = title;
		this.term  = term;
		this.code  = code;
	}

	/* ************************************************************
	 * Accessor Methods
	 ************************************************************ */

	/**
	 * Gets the course title
	 * 
	 * @return The title of the course
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the course term
	 * 
	 * @return The term of the course
	 * 
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * Gets the course code
	 * 
	 * @return The course code
	 * 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the course description
	 * 
	 * @return The course description
	 * 
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Gets a specified student of this course
	 * 
	 * @param stud An index number pertaining to a student in a list
	 * @return The student that is indexed at the passed number. If the student index is out of bounds from the list, return null
	 * 
	 */
	public Student getStudent(int stud) {
		if (stud > studentList.size() - 1)
			return null;
		return studentList.get(stud);
	}

	/**
	 * Gets a specified Deliverable of this course
	 * 
	 * @param deliver An index number pertaining to a deliverable in this course's list of deliverables
	 * @return The Deliverable that is indexed at the passed number. If the deliverable index is out of bounds from the list, return null
	 * 
	 */
	public Deliverable getDeliverable(int deliver) {
		if (deliver < deliverableList.size())
			return deliverableList.get(deliver);
		return null;
	}

	/**
	 * Gets a specific student grade
	 * 
	 * @param stud	A student of this course
	 * @param grade An index number pertaining to a grade in this student's list of grades
	 * @return The specidied student's specified grade. If the grade index is out of bounds from the list, return -1
	 * 
	 */
	public double getGrade(Student stud, int grade) {
		if (grade > studentList.size() - 1)
			return -1;
		return stud.getGrade(grade);
	}

    /**
     * Returns the running total of course deliverable weights so far...
     * @return the running total
     */
    public double getRunningTotal(){
        return runningTotal;
    }

    /**
     * Checks whether this weight can be added to the course's running total of grades
     *
     * @param weight the weight of the deliverable to be added
     * @return true if it can be added, false otherwise
     */

    public boolean updateRunningTot(double weight){
        if (runningTotal+weight>100)
            return false;
        else {
            return true;
        }
    }

    /**
     * Overloaded constructor to update runningtotal when editing deliverable weights
     * Makes sure that the new deliv weight will keep the runningtotal < 100. It will only
     * edit the runningtotal value if the weight is valid.
     *
     * @param weight        current weight of the edited deliverable
     * @param newWeight     new weight of the edited deliverable
     * @return  true if successful, false otherwise.
     */
    public boolean updateRunningTot(double weight, double newWeight){
        double check = runningTotal;
        check = check - weight + newWeight;
        if (check > 100)
            return false;
        else {
            runningTotal = check;
            return true;
        }
    }

	/**
	 * Gets the average for a course
	 *
	 * @return The average between all the students' grades in the course. If there are no students or no deliverables in the course, return -1
	 *
	 */
	public double getClassAvg(){
		if (studentList.size()>0&&deliverableList.size()>0){
			double avg=0, tempAvg;
			int ctr=0;
			for (int i=0; i<studentList.size();i++){
				tempAvg = studentList.get(i).getAvg();
	            if (tempAvg > -1){
				    avg += tempAvg;
	                ctr++;
	            }
			}
			if (ctr>0)
				return avg/ctr;
			return 0;
		}
		return -1;
	}


	/**
	 * Gets the average for a course assignments 
	 *
	 * @return The average between all the students' assignment grades in the course. If there are no students or no deliverables in the course, return -1
	 *
	 */
	public double getClassAsnAvg(){
		if (!(studentList.size()>0&&deliverableList.size()>0)){
			return -1;
		}
		double avg=0, tempAvg;
		int ctr=0;
		for (int i=0; i<studentList.size();i++){
			tempAvg = studentList.get(i).getAsnAvg();
            if (tempAvg > -1){
			    avg += tempAvg;
                ctr++;
            }
		}
		if (ctr>0)
			return avg/ctr;
		return 0;
	}
	
	/**
	 * Gets the average for a course exams 
	 *
	 * @return The average between all the students' exams grades in the course. If there are no students or no deliverables in the course, return -1
	 *
	 */
	public double getClassExamAvg() {
		if (!(studentList.size()>0&&deliverableList.size()>0)){
			return -1;
		}
		double avg=0, tempAvg;
		int ctr=0;
		for (int i=0; i<studentList.size();i++){
			tempAvg = studentList.get(i).getExmAvg();
            if (tempAvg > -1){
			    avg += tempAvg;
                ctr++;
            }
		}
		if (ctr>0)
			return avg/ctr;
		return 0;
	}

	/**
	 * Gets the size of a list of deliverables pertaining to the course
	 * 
	 * @return The size of the list of the deliverables in this course
	 * 
	 */
	public int getDeliverableListSize() {
		return deliverableList.size();
	}

	/**
	 * Gets the size of a list of students pertaining to the course
	 * 
	 * @return The size of the list of the students in this course
	 * 
	 */
	public int getStudentListSize() {
		return studentList.size();
	}

	/**
	 * Gets the list of students pertaining to the course
	 * 
	 * @return The list of students in this course
	 * 
	 */
	public ArrayList<Student> getStudents() {
		return studentList;
	}

	/**
	 * Gets the list of deliverables pertaining to the course
	 * 
	 * @return The list of deliverables in this course
	 * 
	 */
	public ArrayList<Deliverable> getDeliverables() {
		return deliverableList;
	}

	/* ************************************************************
	 * Mutator Methods
	 ************************************************************ */

	/**
	 * Sets the course title
	 * 
	 * @param title The desired title for the course
	 * 
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Sets the course term
	 * 
	 * @param term The desired term for the course
	 * 
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * Sets the course code
	 * 
	 * @param code The desired course code
	 * 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Sets the course description
	 * 
	 * @param description The desired course description
	 * 
	 */
	public void setDescription(String description){
		this.description=description;
	}

	/* ************************************************************
	 * Helper Methods
	 ************************************************************ */

	/**
	 * Checks to make sure that the student ID passed doesn't currently belong to another student in the course
	 * 
	 * @param number The student's ID number that we want to check for authenticity
	 * @return false if the ID number is unique, true if a student in the course already has this ID number
	 * 
	 */
	private boolean checkNumber(String number) {
		if (findStudent(number) == -1)
			return false;
		return true;
	}

	/**
	 * Checks to make sure that the email address passed doesn't currently belong to another student in the course
	 * 
	 * @param email The email of the student that we want to check for authenticity
	 * @return false if the email is unique, true if a student in the course already has this email
	 * 
	 */
	private boolean checkEmail(String email) {
		for (int i = 0; i < studentList.size(); i++)
			if (studentList.get(i).getEmail().equals(email))
				return true;
		return false;
	}

	/**
	 * Edit a student's ID number
	 * 
	 * @param stud	The student whose ID number we want to change
	 * @param number The new ID number we want to change to
	 * @return true if the ID number was changed or if requested change was already the current number. Or, if the number already belongs to another student, return false
	 * 
	 */
	public boolean editStudentNumber(Student stud, String number) {
		if (stud.getNumber().equals(number))
			return true;
		else if (checkNumber(number))
			return false;
		else
			stud.setNumber(number);
		return true;
	}

	/**
	 * Edit a student's Email
	 * 
	 * @param stud The student whose email we want to change
	 * @param email The new email we want to change to
	 * @return true if the email was changed or if requested change was already the current email. Or, if the email already belongs to another student, return false
	 * 
	 */
	public boolean editStudentEmail(Student stud, String email) {
		if (stud.getEmail().equals(email))
			return true;
		else if (checkEmail(email))
			return false;
		else
			stud.setEmail(email);
		return true;
	}

	/**
	 * Finds the index number of the requested student within the course's list of students
	 * 
	 * @param number The student's ID number
	 * @return The index at which the requested student sits in the list of students in this course. Or, if the student doesn't exist, return -1
	 * 
	 */
	public int findStudent(String number) {
		for (int i = 0; i < studentList.size(); i++)
			if (studentList.get(i).getNumber().equals(number))
				return i;
		return -1;
	}

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
	public boolean addStudent(String nameFirst, String nameLast, String number,
			String email) {
		if (!(checkNumber(number) || checkEmail(email))) {
			studentList.add(new Student(nameFirst, nameLast, number, email));
			return true;
		}
		return false;
	}

	/**
	 * Remove a student from the course
	 * 
	 * @param i The student's index number in the list of students in this course
	 * @return true if the student was removed. Or, if the index given falls our of bounds of the list of students, return false
	 * 
	 */
	public boolean removeStudent(int i) {
		if (i >= studentList.size())
			return false;
		studentList.remove(i);
		return true;
	}

	/**
	 * Finds the index number of the requested deliverable within the course's list of deliverables
	 * 
	 * @param deliver The deliverable we are searching for
	 * @return The index at which the requested deliverable sits in the list of deliverables in this course. Or, if the deliverable doesn't exist, return -1
	 * 
	 */
	public int findDeliverable(Deliverable deliver) {
		for (int i = 0; i < deliverableList.size(); i++)
			if (deliverableList.get(i)!=null&&deliverableList.get(i).equals(deliver))
				return i;
		return -1;
	}

	/**
	 * Adds a deliverable to the course
	 * 
	 * @param name The name of the dliverable
	 * @param type	The type of the deliverable
	 * @param weight The weight of the deliverable
	 * @return true if a deliverable was added to the course. Or, if the deliverable already exists, return false
	 * 
	 */
	public boolean addDeliverable(String name, String type, double weight) {
		if (findDeliverable(new Deliverable(name, type, weight, 0)) != -1 || runningTotal + weight>100)
			return false;
		if (!stkDeliver.isEmpty())
			deliverableList.add(new Deliverable(name, type, weight, stkDeliver
					.pop()));
		else {
			deliverableList.add(new Deliverable(name, type, weight,
					deliverableList.size()));
            runningTotal = runningTotal + weight;
        }
		return true;
	}

	/**
	 * Removes a deliverable from the course
	 * 
	 * @param i The index of the deliverable we want to remove in the list of the deliverables for this course
	 * @return true if the deliverable was removed. Or, if the index falls out of bounds from our list of deliverables in this course, return false
	 * 
	 */
	public boolean removeDeliverable(int i) {
		if (i >= deliverableList.size())
			return false;
		//Also Remove this grade item from all the students (to have a correct avg calculation)
		String type = getDeliverable(i).getType();
		for (int j = 0; j<studentList.size(); j++){
			getStudent(j).removeGrade(i,type);
		}
        runningTotal = runningTotal - getDeliverable(i).getWeight();
        deliverableList.set(i, null);
		stkDeliver.push(i);

		return true;
	}

	/**
	 * Adds a grade for a student in the course
	 * 
	 * @param stud The student who we want to give a grade for
	 * @param deliver The deliverable for which we are adding the grade
	 * @param grade The grade we are adding
	 * @return true if the grade was inserted. False if the grade failed to be inserted
	 * 
	 */
	public boolean addGrade(Student stud, Deliverable deliver, double grade) {
		return stud.addGrade(deliver.getObjId(), grade, deliver.getType(),
				deliver.getWeight());
	}

	/**
	 * removes a grade from a student in the course
	 * 
	 * @param stud The student who we want to remove a grade from
	 * @param deliver The deliverable from which we are removing the grade
	 * @return true if the grade was removed. False if the grade failed to be removed
	 * 
	 */
	public boolean removeGrade(Student stud, Deliverable deliver) {
		return stud.removeGrade(deliver.getObjId(), deliver.getType());
	}

	/**
	 * Imports students into the course
	 * @param file The path where the file containing the students to be imported is located
	 * @return true if the students were imported successfully, otherwise return false
	 * 
	 */
	public boolean importStudents(File file)
	{
		String[] sAry = { "nameLast", "nameFirst", "number", "email" };
		String[] tempAry;
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			if ((tempAry=reader.readNext())!=null&&tempAry.equals(sAry)) {
				reader.close();
				return false;
			}
			while ((sAry = reader.readNext()) != null) {
				if (sAry.length != 4) {
					reader.close();
					return false;
				}
				addStudent(sAry[1], sAry[0], sAry[2], sAry[3]);
			}
			reader.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Exports the Students of a course into a .csv file
	 * 
	 * @param file The path where we want to export the students
	 * @return true if the students were exported, false otherwise
	 * 
	 */
	public boolean exportStudents(File file) {
		try {
			if (file.exists())
				file.delete();
			Writer bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));
			bw.write("\"nameLast\", \"nameFirst\", \"number\", \"email\"\n");
			for (int i = 0; i < studentList.size(); i++)
				bw.write(studentList.get(i).toString());
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Imports deliverables into the course
	 * 
	 * @param file The path where the file containing the deliverables to be imported is located
	 * @return true if the deliverables were imported successfully, otherwise return false
	 * 
	 */
	public boolean importDeliverables(File file) {
		String[] dAry = { "name", "type", "weight" };
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			if (reader.readNext().equals(dAry)) {
				reader.close();
				return false;
			}
			while ((dAry = reader.readNext()) != null) {
				if (dAry.length != 3) {
					reader.close();
					return false;
				}
				addDeliverable(dAry[0], dAry[1], Double.parseDouble(dAry[2]));
			}
			reader.close();
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Exports the deliverables of a course into a .csv file
	 * 
	 * @param file The path where we want to export the deliverables
	 * @return true if the deliverables were exported, false otherwise
	 * 
	 */
	public boolean exportDeliverables(File file) {
		try {
			Writer bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));
			bw.write("\"name\", \"type\", \"weight\"\n");
			for (int i = 0; i < deliverableList.size(); i++)
				if (deliverableList.get(i)!=null)
					bw.write(deliverableList.get(i).toString());
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Imports students' grades into the course
	 * 
	 * @param file The path where the file containing the students' grades to be imported is located
	 * @return true if the grades were imported successfully, otherwise return false
	 * 
	 */
	public boolean importGrades(File file) {
		ArrayList<Integer> fileLoc = new ArrayList<Integer>();
		ArrayList<Integer> delivers = new ArrayList<Integer>();
		ArrayList<String> nextLine = new ArrayList<String>();
		String [] strAry;
		int numClmn=-1;
		Student stud;
		Deliverable deliver;
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			strAry = reader.readNext();
			for (int i = 0; i < strAry.length; i++)
				nextLine.add(strAry[i]);

			if (nextLine.contains("number"))
				numClmn=nextLine.indexOf("number");
			else if (nextLine.contains("Number"))
				numClmn=nextLine.indexOf("Number");

			for (int i = 0; i < deliverableList.size(); i++)
				if (nextLine.contains(deliverableList.get(i).getName())) {
					delivers.add(i);
					fileLoc.add(nextLine.indexOf(deliverableList.get(i).getName()));
				}

			while ((strAry = reader.readNext()) != null) {
				int j = findStudent(strAry[numClmn]);
				if (j != -1) {
					stud = getStudent(j);
					for (int i = 0; i < delivers.size(); i++) {
						deliver = getDeliverable(delivers.get(i));
						stud.addGrade(delivers.get(i),
								Double.parseDouble(strAry[fileLoc.get(i)]),
								deliver.getType(), deliver.getWeight());
					}
				}
			}
			reader.close();
			return true;
		} catch (NumberFormatException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * Exports students' grades into a .csv file
	 * 
	 * @param file The path where we want to export the grades
	 * @return true if the grades were exported, false otherwise
	 * 
	 */
	public boolean exportGrades(File file) {
		ArrayList<Integer> dilvers = new ArrayList<Integer>();
		try {
			Writer bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));
			String str = "\"Last Name\", \"First Name\", \"Student Number\", \"Email\"";
			for (int i = 0; i < deliverableList.size(); i++)
				if (deliverableList.get(i) != null) {
					str = str + ", \"" + deliverableList.get(i).getName()
							+ "\"";
					dilvers.add(i);
				}
			bw.write(str + "\n");
			for (int i = 0; i < studentList.size(); i++)
				bw.write(studentList.get(i).toStringGrade(dilvers.toArray()));
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * A method that test for course equality
	 * 
	 * @param crs The course we are comparing to	
	 * @return true if the course is equal to this course, false otherwise
	 * 
	 */
	public boolean equals(Course crs) {
		if (this.toString().equalsIgnoreCase(crs.toString()))
			return true;
		return false;
	}

	/**
	 * A toString method
	 * 
	 * @return The course information. Including title, term, and code
	 * 
	 */
	public String toString() {
		return ("\"" + title + "\", \"" + term + "\", \"" + code + "\"\n");
	}
}
