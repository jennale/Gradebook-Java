package cs2212.team4;

import java.io.*;
import java.util.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.data.*;
import net.sf.jasperreports.engine.xml.*;

public class Report {

	private String code, title, term;
	private String firstName, lastName, number, email;
	private ArrayList<Deliverable> deliverables;

	private final static String REPORT_FILENAME = "student_report";
	private static InputStream loadResource (String filename) {
		return Report.class.getClassLoader().getResourceAsStream (filename);}

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

	public String getCode()
	{
		return code;
	}

	public String getTitle()
	{
		return title;
	}

	public String getTerm()
	{
		return term;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getNumber()
	{
		return number;
	}

	public String getEmail()
	{
		return email;
	}

	public ArrayList<Deliverable> getDeliverables()
	{
		return deliverables;
	}

	public void generateReport() throws Exception
	{
		InputStream reportStream = loadResource(REPORT_FILENAME + ".jrxml");

		Collection<Report> student = ReportProvider.loadStudentInfo() ;
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(student);

		Map <String, Object> parameters = new HashMap<String, Object>();

		JasperDesign jasperDesign = JRXmlLoader.load(reportStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource );
		JasperExportManager.exportReportToPdfFile (jasperPrint, REPORT_FILENAME + ".pdf");
	}
}