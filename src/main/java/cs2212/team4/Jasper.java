package cs2212.team4;

import java.util.ArrayList;
import java.util.Collection;

public class Jasper {
	public static Collection<StudentReportData> reportData() {
		Course course;
		Student student;
		course = new Course("Software Engineering", "B", "2212");
		course.addDeliverable("Assignment 1", "Assignment", 10);
		course.addDeliverable("Assignment 2", "Assignment", 10);
		course.addDeliverable("Midterm", "Exam", 25);
		course.addDeliverable("Assignment 3", "Assignment", 10);
		course.addDeliverable("Final Exam", "Exam", 40);
		course.addDeliverable("Other", "Other", 5);
		course.addStudent("Zaid", "Albirawi", "250626065", "zalbiraw@uwo.ca");
		student = course.getStudent(0);
		student.addGrade(0, 100, "Assignment", 10);
		student.addGrade(1, 10, "Assignment", 10);
		student.addGrade(2, 0, "Exam", 25);
		student.addGrade(3, -1, "Assignment", 10);
		student.addGrade(4, 40, "Exam", 40);
		student.addGrade(4, -1, "Other", 5);
		Collection<StudentReportData> temp = new ArrayList<StudentReportData>();
		temp.add(new StudentReportData(student, course, -1));
		for (int i = 0; i < course.getDeliverableListSize(); i++) {
			if (course.getDeliverable(i) != null) {
				temp.add(new StudentReportData(student, course, i));
			}
		}
		return temp;
	}
}