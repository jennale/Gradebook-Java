package cs2212.team4;

import java.util.ArrayList;
import java.util.Collection;

public class ReportProvider {

	public static Collection<Report> loadStudentInfo() throws Exception {

		Collection<Report> student_info = new ArrayList<Report>();
		Course course = new Course("Engineering", "A", "2222");
		course.addDeliverable("Game", "Assignment", 30.0);
		course.addDeliverable("Database", "Assignment", 25.0);
		course.addStudent("Jim", "Smith", "23045897", "jimsmith90@uwo.ca");
		course.addStudent("Tom", "Jones", "27045897", "tomjones123@uwo.ca");
		course.addStudent("Sara", "Robbins", "28045897", "srobbins6@uwo.ca");
		Report report = new Report(course, "27045897");
		student_info.add(report);

		return student_info;
	}
}