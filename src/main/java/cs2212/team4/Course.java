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
	
	
}
