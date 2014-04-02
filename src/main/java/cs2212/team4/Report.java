package cs2212.team4;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;/**
 * Gets the report data for a student in a particular course
 * 
 * @param student The student for whom we fetch the report data
 * @param course The course for which we fetch the report data of the student
 * @return A collection of report data for the student in this course
 * 
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
*
* Report class will generate a report for a specific student based on their grade
*
* team4-gradebook application
*
* @author Zaid Albirawi
* @version 1.6 3/25/2014
*/

public class Report {

	//The course for which the report will be generated
	private Course course;
	//The student for whom the report will be generated
	private Student student;

	/**
	 * Constructor that creates a report for a student in a specific course
	 * @param course The course for which the report will be generated
	 * @param student The student for whom the report will be generated
	 * 
	 */
	public Report(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

	/**
	 * Gets an input stream based on the file passed
	 * 
	 * @param filename The name of the file we are fetching
	 * @return the file as a stream
	 * 
	 */
	private static InputStream loadResource(String filename) {
		return GradebookGUI.class.getClassLoader()
				.getResourceAsStream(filename);
	}

	/**
	 * Gets the report data for a student in a particular course
	 * 
	 * @param student The student for whom we fetch the report data
	 * @param course The course for which we fetch the report data of the student
	 * @return A collection of report data for the student in this course
	 * 
	 */
	public static Collection<StudentReportData> reportData(Student student,
			Course course) {
		Collection<StudentReportData> temp = new ArrayList<StudentReportData>();
		temp.add(new StudentReportData(student, course, -1));
		for (int i = 0; i < course.getDeliverableListSize(); i++) {
			if (course.getDeliverable(i) != null) {
				temp.add(new StudentReportData(student, course, i));
			}
		}
		return temp;
	}

	/**
	 * Generates the report for the student from a jrxml file to a pdf
	 * 
	 * @return an empty string if the report was successfully generated. If the logo or the report.jrxml cannot be found, string indicating the issue returned
	 * @throws JRException If a JRE exception occured 
	 * @throws IOException If an input/output exception occured
	 * 
	 */
	public String generateReport() {
		try {
			InputStream logoStream = loadResource("cs2212/team4/logo.png");
			if (logoStream == null)
				return "Cannot find logo.png";
			InputStream reportStream = loadResource("cs2212/team4/report.jrxml");
			if (reportStream == null)
				return "Cannot find report.jrxml";
			BufferedImage logo = ImageIO.read(logoStream);
			Collection<StudentReportData> reportData = reportData(student,
					course);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					reportData);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("logo", logo);
			JasperDesign jasperDesign = JRXmlLoader.load(reportStream);
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"src/main/resources/cs2212/team4/report.pdf");
		} catch (JRException e) {
			return "File is non-writable";
		} catch (IOException e) {
			return "Gradebook was unable to import required files";
		}
		return "";
	}
}
