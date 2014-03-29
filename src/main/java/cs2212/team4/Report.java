package cs2212.team4;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

public class Report {
	public Report(Student student, Course course) {
		try {
			InputStream logoStream = loadResource("cs2212/team4/logo.png");
			InputStream reportStream = loadResource("cs2212/team4/report.jrxml");
			BufferedImage logo = ImageIO.read(logoStream);
			Collection<StudentReportData> customers = reportData(student,
					course);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					customers);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("logo", logo);
			JasperDesign jasperDesign = JRXmlLoader.load(reportStream);
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, beanColDataSource);
			JasperExportManager
					.exportReportToPdfFile(jasperPrint, "report.pdf");
		} catch (JRException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static InputStream loadResource(String filename) {
		return GradebookGUI.class.getClassLoader()
				.getResourceAsStream(filename);
	}

	public static Collection<StudentReportData> reportData(Student student,
			Course course) {
		Collection<StudentReportData> temp = new ArrayList<StudentReportData>();
		temp.add(new StudentReportData(student, course, -1));
		for (int i = 0; i < course.getDeliverableListSize(); i++) {
			if (course.getDeliverable(i)!=null){
				temp.add(new StudentReportData(student, course, i));
			}
		}
		return temp;
	}
}
