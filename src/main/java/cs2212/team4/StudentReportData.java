package cs2212.team4;

/**
*
* A class that fetches report data for a student
*
* team4-gradebook application
*
* @author Zaid Albirawi
* @version 1.6 3/25/2014
*/

public class StudentReportData {
	private Student student;
	private Course course;
	private int i;

	/**
	 * Constructor that creates report data object for a student in a given course
	 * 
	 * @param student The student for whom to generate report data
	 * @param course The course from which to generate report data
	 * @param i the variable counter
	 * 
	 */
	public StudentReportData(Student student, Course course, int i) {
		this.student = student;
		this.course = course;
		this.i = i;
	}

	/**
	 * Gets the course title
	 * 
	 * @return The title of the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getCourseTitle() {
		if (i > -1)
			return "";
		return course.getTitle();
	}

	/**
	 * Gets the course term
	 * 
	 * @return The term of the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getCourseTerm() {
		if (i > -1)
			return "";
		return course.getTerm();
	}

	/**
	 * Gets the course code
	 * 
	 * @return The code of the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getCourseCode() {
		if (i > -1)
			return "";
		return course.getCode();
	}

	/**
	 * Gets the class average for the course
	 * 
	 * @return The class average for the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public double getClassAvg() {
		if (i > -1)
			return -1;
		return course.getClassAvg();
	}

	/**
	 * Gets the class assignment average for the course
	 * 
	 * @return The class assignment average for the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public double getClassAsnAvg() {
		if (i > -1)
			return -1;
		return course.getClassAsnAvg();
	}

	/**
	 * Gets the class exam average for the course
	 * 
	 * @return The class exam average for the course, empty string if the variable counter exceeds -1
	 * 
	 */
	public double getClassExamAvg() {
		if (i > -1)
			return -1;
		return course.getClassExamAvg();
	}

	/**
	 * Gets the student's first name
	 * 
	 * @return The student's first name, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getStudentFirstName() {
		if (i > -1)
			return "";
		return student.getNameFirst();
	}

	/**
	 * Gets the student's last name
	 * 
	 * @return The student's last name, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getStudentLastName() {
		if (i > -1)
			return "";
		return student.getNameLast();
	}

	/**
	 * Gets the student's number
	 * 
	 * @return The student's number, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getStudentNumber() {
		if (i > -1)
			return "";
		return student.getNumber();
	}
	
	/**
	 * Gets the student's email
	 * 
	 * @return The student's email, empty string if the variable counter exceeds -1
	 * 
	 */
	public String getStudentEmail() {
		if (i > -1)
			return "";
		return student.getEmail();
	}

	/**
	 * Gets the student's average
	 * 
	 * @return The student's average, -1 if the variable counter exceeds -1
	 * 
	 */
	public double getStudentAvg() {
		if (i > -1)
			return -1;
		return student.getAvg();
	}
	
	/**
	 * Gets the student's assignment average
	 * 
	 * @return The student's assignment average, -1 if the variable counter exceeds -1
	 * 
	 */
	public double getStudentAsnAvg() {
		if (i > -1)
			return -1;
		return student.getAsnAvg();
	}

	/**
	 * Gets the student's exam average
	 * 
	 * @return The student's exams average, -1 if the variable counter exceeds -1
	 * 
	 */
	public double getStudentExamAvg() {
		if (i > -1)
			return -1;
		return student.getExmAvg();
	}

	/**
	 * Gets the student's grade
	 * 
	 * @return The student's grade, -1 if the variable counter is -1
	 * 
	 */
	public double getGrade() {
		if (i == -1)
			return -1;
		return student.getGrade(i);
	}

	/**
	 * Gets the weight for the deliverable
	 * 
	 * @return The weight for a deliverable, -1 if the variable counter is -1
	 * 
	 */
	public double getWeight() {
		if (i == -1)
			return -1;
		return course.getDeliverable(i).getWeight();
	}
	
	/**
	 * Gets the average for the deliverable
	 * 
	 * @return The deliverable average, -1 if the variable counter is -1
	 * 
	 */
	public double getDeliverAvg(){
		if (i == -1)
			return -1;
		return course.getClassDeliverableAvg(i);
	}
	
	/**
	 * Gets the name for the deliverable
	 * 
	 * @return The deliverable name, empty string if the variable counter is -1
	 * 
	 */
	public String getDeliverName() {
		if (i == -1)
			return "";
		return course.getDeliverable(i).getName();
	}
	
	/**
	 * Gets the type for the deliverable
	 * 
	 * @return The deliverable type, empty string if the variable counter is -1
	 * 
	 */
	public String getDeliverType() {
		if (i == -1)
			return "";
		return course.getDeliverable(i).getType();
	}
}
