package cs2212.team4;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.xml.*;

public class Report {

	//Data serialization
	private static final long serialVersionUID = 1L;
	//course and student attributes
	private String code, title, term, firstName, lastName, number, email;
	//course deliverables
	private List<Deliverable> deliverables = new ArrayList<Deliverable>();
	//name of jrxml file used
	private final static String REPORT_FILENAME = "student_report";
	//method to load file
	private static InputStream loadResource (String filename) {
		return Report.class.getClassLoader().getResourceAsStream (filename);
	}
	
	public static Collection<Report> student_info = new ArrayList<Report>();


	/**
	 * Constructor that creates a report, using course and student attributes
	 * 
	 * @param course A course from which we wish to generate reports
	 * @param number The index of the student that we wish to fetch from this course
	 * 
	 */
	public Report(Course course, String number)
	{	
		if(course.findStudent(number) >= 0)
		{
			int studNumber = course.findStudent(number);
			Student stud = course.getStudent(studNumber);
			this.code = course.getCode();
			this.title = course.getTitle();
			this.term = course.getTerm();
			this.firstName = stud.getNameFirst();
			this.lastName = stud.getNameLast();
			this.number = stud.getNumber();
			this.email = stud.getEmail();
			this.deliverables = course.getDeliverables();
		}
	}

	/**
	 * Gets the code representing this report
	 * 
	 * @return the code representing this report
	 * 
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Gets the title of this report
	 * 
	 * @return the title of this report
	 * 
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Gets the term of this report
	 * 
	 * @return the term of this report
	 * 
	 */
	public String getTerm()
	{
		return term;
	}

	/**
	 * Gets The first name of the student for whom we are generating the report
	 * 
	 * @return the first name of the student for whom this report is for
	 * 
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Gets The last name of the student for whom we are generating the report
	 * 
	 * @return the last name of the student for whom this report is for
	 * 
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Gets The id number of the student for whom we are generating the report
	 * 
	 * @return the id number of the student for whom this report is for
	 * 
	 */
	public String getNumber()
	{
		return number;
	}

	/**
	 * Gets The email of the student for whom we are generating the report
	 * 
	 * @return the email of the student for whom this report is for
	 * 
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Gets list of deliverables in the course
	 * 
	 * @return list of deliverables in the course
	 */
	public List<Deliverable> getDeliverables()
	{
		return deliverables;
	}

	/**
	 * Generates a report for a student containing various course and grade related information
	 */
	public void generateReport() throws Exception
	{
		InputStream reportStream = loadResource(REPORT_FILENAME + ".jrxml");

		Collection<Report> student = Course.loadStudentInfo();
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(student);

		Map <String, Object> parameters = new HashMap<String, Object>();

		JasperDesign jasperDesign = JRXmlLoader.load(reportStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource );
		JasperExportManager.exportReportToPdfFile (jasperPrint, REPORT_FILENAME + ".pdf");
	}
}
