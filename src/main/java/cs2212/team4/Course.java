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
	  * Constructor.
	  * 
	  * @param		title		String, the Course object title.
	  * @param		term		String, the Course object term.
	  * @param		code		String, the Course object code.
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
	  * Gets the course title.
	  * 
	  * @return		String, the Course object title.
	  * 
	  */
	public String getTitle() {
		return title;
	}

	/**
	  * Gets the course term.
	  * 
	  * @return		String, the Course object term.
	  * 
	  */
	public String getTerm() {
		return term;
	}

	/**
	  * Gets the course code.
	  * 
	  * @return		String, the Course object code.
	  * 
	  */
	public String getCode() {
		return code;
	}
        
        public String getDescription(){
        return description;
}
	
	/**
	  * Gets the Student object inside the studentList list at location stud.
	  * 
	  * @return		Student, the Student object.
	  * 
	  */
	public Student getStudent(int stud) {
		if (stud > studentList.size() - 1)
			return null;
		return studentList.get(stud);
	}
	
	/**
	  * Gets the Deliverable object inside the DeliverableList list at location deliver.
	  * 
	  * @return		Deliverable, the Deliverable object.
	  * 
	  */
	public Deliverable getDeliverable(int deliver) {
		if (deliver < deliverableList.size())
			return deliverableList.get(deliver);
		return null;
	}
	
	/**
	  * Gets the grade object inside the Grades object inside the Student object at location grade.
	  * 
	  * @param		stud		Student, Student object.
	  * @param		grade		Integer, the location of the grade.
	  * 
	  * @return		Double, the grade of the Student object.
	  * 
	  */
	public double getGrade(Student stud, int grade) {
		if (grade > studentList.size() - 1)
			return -1;
		return stud.getGrade(grade);
	}
        
     /**
	  * Gets the deliverableList size.
	  * 
	  * @return		Integer, the deliverableList size.
	  * 
	  */
	public int getDeliverableListSize() {
		return deliverableList.size();
	}
	
	/**
	  * Gets the studentList size.
	  * 
	  * @return		Integer, the studentList size.
	  * 
	  */
	public int getStudentListSize() {
		return studentList.size();
	}
	
	/**
	  * Gets the studentList.
	  * 
	  * @return		ArrayList<Student>, the studentList.
	  * 
	  */
	public ArrayList<Student> getStudents() {
		return studentList;
	}
	
	/**
	  * Gets the deliverableList.
	  * 
	  * @return		ArrayList<Deliverable>, the deliverableList.
	  * 
	  */
	public ArrayList<Deliverable> getDeliverables() {
		return deliverableList;
	}
	
	/* ************************************************************
	* Mutator Methods
	************************************************************ */
	
	/**
	  * Sets the course title.
	  * 
	  * @param		title			String, the Course Object title.
	  * 
	  */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	  * Sets the course term.
	  * 
	  * @param		term			String, the Course Object term.
	  * 
	  */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	  * Sets the course code.
	  * 
	  * @param		code			String, the Course Object code.
	  * 
	  */
	public void setCode(String code) {
		this.code = code;
	}
        
        public void setDescription(String description){
            this.description=description;
        }
	
	/* ************************************************************
	* Helper Methods
	************************************************************ */
	
	/**
	  * Checks if the integer provided already belongs to another Student object inside the studentList list.
	  * 
	  * @param		number			String, the Student object unique number.
	  * 
	  * @return		boolean, true if the number exists, false otherwise.
	  * 
	  */
	private boolean checkNumber(String number) {
		if (findStudent(number) == -1)
			return false;
		return true;
	}

	/**s
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
	  * @param		path				String, the path were the file is located.
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
