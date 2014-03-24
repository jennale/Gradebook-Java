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
 * @version 1.5 2/28/2014
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
	  * Gets the average for a course
	  *
	 * @return The average between all the students' grades in the course. If there are no students or no deliverables in the course, return -1
	 *
	 */
	public double getClassAvg(){
		double average = -1;
		int numStudents = studentList.size();
		if (numStudents > 0 && deliverableList.size() > 0){
		    average = 0;
		  for (int i = 0; i < numStudents; i++){
		      average = average + studentList.get(i).getAvg();
		  }
		  average = average/numStudents;
		}
		return average;
	}
        
	 /**
	  * Gets the size of a list of deliverables pertaining to the course
	  * 
	  * @return The size of the list of the delicerables in this course
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
	  * @param The desired title for the course
	  * 
	  */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	  * Sets the course term
	  * 
	  * @param The desired term for the course
	  * 
	  */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	  * Sets the course code
	  * 
	  * @param The desired course code
	  * 
	  */
	public void setCode(String code) {
		this.code = code;
	}
        
        /**
	  * Sets the course description
	  * 
	  * @param The desired course description
	  * 
	  */
        public void setDescription(String description){
            this.description=description;
        }
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Checks to make sure that the integer passed doesn't currently belong to another student in the course
	  * 
	  * @param The student's ID number that we want to check for authenticity
	  * @return true if the number is unique, false if a student in the course already has this ID
	  * 
	  */
	private boolean checkNumber(String number) {
		if (findStudent(number) == -1)
			return false;
		return true;
	}

	/**
	  * Checks if the string provided already belongs to another Student object inside the studentList list.
	  * 
	  * @param		email			String,the Student object unique email.
	  * 
	  * @return		boolean, true if the email exists, false otherwise.
	  * 
	  */
	private boolean checkEmail(String email) {
		for (int i = 0; i < studentList.size(); i++)
			if (studentList.get(i).getEmail().equals(email))
				return true;
		return false;
	}

	/**
	  * Edits the Student object number, if the number does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		number			String, the Student object unique number.
	  * 
	  * @return		boolean, true if the number has been edited, false otherwise.
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
	  * Edits the Student object email, if the email does not belong to another Student object inside the studentList list.
	  * 
	  * @param		stud			Student, Student object.
	  * @param		email			String, the Student object unique email.
	  * 
	  * @return		boolean, true if the email has been edited, false otherwise.
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
	  * Finds the Student object inside the StudentList list.
	  * 
	  * @param		number			String, the Student object's unique number.
	  * 
	  * @return		Integer, the position of the Student object in the studentList if the object exists, otherwise will return -1.
	  * 
	  */
	public int findStudent(String number) {
		for (int i = 0; i < studentList.size(); i++)
			if (studentList.get(i).getNumber().equals(number))
				return i;
		return -1;
	}
	
	/**
	  * Adds a Student object to the studentList list, if there does not exist a Student object inside the studentList list with the same number or email.
	  * 
	  * @param		nameFirst			String, the Student object first name.
	  * @param		nameLast			String, the Student object Last name.
	  * @param		number				String, the Student object unique number.
	  * @param		email				String, the Student object unique email.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
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
	  * Removes a Student object from the studentList list.
	  * 
	  * @param		i					Integer, the Student object number in the studentList.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
	  * 
	  */
	public boolean removeStudent(int i) {
		if (i >= studentList.size())
			return false;
		studentList.remove(i);
		return true;
	}
	
	/**
	  * Finds the Deliverable object inside the deliverableList list.
	  * 
	  * @param		deliver			Deliverable, the Deliverable object.
	  * 
	  * @return		Integer, the position of the Deliverable object in the deliverableList list if the object exists, otherwise it will return -1.
	  * 
	  */
	public int findDeliverable(Deliverable deliver) {
		for (int i = 0; i < deliverableList.size(); i++)
			if (deliverableList.get(i)!=null&&deliverableList.get(i).equals(deliver))
				return i;
		return -1;
	}
	
	/**
	  * Adds a Deliverable object to the deliverableList list, if there does not exist a duplicate Deliverable object inside the deliverableList list.
	  * 
	  * @param		name				String, the Deliverable object name.
	  * @param		type				String, the Deliverable object type.
	  * @param		weight				Double, the Deliverable object weight.
	  * 
	  * @return		boolean, true if the addition was a success, false otherwise.
	  * 
	  */
	public boolean addDeliverable(String name, String type, double weight) {
		if (findDeliverable(new Deliverable(name, type, weight, 0)) != -1)
			return false;
		if (!stkDeliver.isEmpty())
			deliverableList.add(new Deliverable(name, type, weight, stkDeliver
					.pop()));
		else
			deliverableList.add(new Deliverable(name, type, weight,
					deliverableList.size()));
		return true;
	}

	/**
	  * Removes a Deliverable object from the deliverableList list.
	  * 
	  * @param		i deliver - Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the object was removed, false otherwise.
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
		deliverableList.set(i, null);
		stkDeliver.push(i);

		return true;
	}
	
	/**
	  * Adds a grade to a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * @param		grade				Double, the grade.
	  * 
	  * @return		boolean, true if the grade was inserted successfully, false otherwise.
	  * 
	  */
	public boolean addGrade(Student stud, Deliverable deliver, double grade) {
		return stud.addGrade(deliver.getObjId(), grade, deliver.getType(),
				deliver.getWeight());
	}
	
	/**
	  * Removes a grade from a Student object.
	  * 
	  * @param		stud				Student, the Student object.
	  * @param		deliver				Deliverable, the Deliverable object.
	  * 
	  * @return		boolean, true if the grade was removed successfully, false otherwise.
	  * 
	  */
	public boolean removeGrade(Student stud, Deliverable deliver) {
		return stud.removeGrade(deliver.getObjId(), deliver.getType());
	}

	/**
	  * Imports a Student objects into the Course object.
	  * 
	  * @param		file path - String, the path were the file is located.
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
	  * Exports the Student objects located in studentList list to a .csv file.
	  * 
	  * @param		file path - String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Student objects were exported, false otherwise.
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
	  * Imports a Deliverable objects into the Course object.
	  * 
	  * @param		file				File, the path were the file is located.
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
	  * Exports the Deliverable objects located in deliverableList list to a .csv file.
	  * 
	  * @param		file path - String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Deliverable objects were exported, false otherwise.
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
	  * Imports a Student objects' Grade objects into the Course object.
	  * 
	  * @param		file				String, the path were the file is located.
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
	  * Exports the Grade objects located in every Student object inside the studentList list.
	  * 
	  * @param		file path String, the path were the file is located.
	  * 
	  * @return		boolean, true if the Grade objects were exported, false otherwise.
	  * 
	  */
	public boolean exportGrades(File file) {
		ArrayList<Integer> dilvers = new ArrayList<Integer>();
		try {
			Writer bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file)));
			String str = "\"nameLast\", \"nameFirst\", \"number\", \"email\"";
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
	  * An equals method.
	  * 
	  * @param		crs			Course, the Course object.		
	  * 
	  * @return		boolean, true if the Course object is equal to this, false otherwise.
	  * 
	  */
	public boolean equals(Course crs) {
		if (this.toString().equalsIgnoreCase(crs.toString()))
			return true;
		return false;
	}
	
	/**
	  * A toString method.
	  * 
	  * @return		String, the Course object information string.
	  * 
	  */
	public String toString() {
		return ("\"" + title + "\", \"" + term + "\", \"" + code + "\"\n");
	}
}
