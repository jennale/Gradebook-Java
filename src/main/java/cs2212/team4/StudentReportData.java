package cs2212.team4;

public class StudentReportData {
	private Student student;
	private Course course;
	private int i;

	public StudentReportData(Student student, Course course, int i) {
		this.student = student;
		this.course = course;
		this.i = i;
	}

	public String getCourseTitle() {
		if (i > -1)
			return null;
		return course.getTitle();
	}

	public String getCourseTerm() {
		if (i > -1)
			return null;
		return course.getTerm();
	}

	public String getCourseCode() {
		if (i > -1)
			return null;
		return course.getCode();
	}

	public Double getClassAvg() {
		if (i > -1)
			return null;
		return course.getClassAvg();
	}

	public Double getClassAsnAvg() {
		if (i > -1)
			return null;
		return course.getClassAsnAvg();
	}

	public Double getClassExamAvg() {
		if (i > -1)
			return null;
		return course.getClassExamAvg();
	}

	public String getStudentFirstName() {
		if (i > -1)
			return null;
		return student.getNameFirst();
	}

	public String getStudentLastName() {
		if (i > -1)
			return null;
		return student.getNameLast();
	}

	public String getStudentNumber() {
		if (i > -1)
			return null;
		return student.getNumber();
	}

	public String getStudentEmail() {
		if (i > -1)
			return null;
		return student.getEmail();
	}

	public Double getStudentAvg() {
		if (i > -1)
			return null;
		return student.getAvg();
	}

	public Double getStudentAsnAvg() {
		if (i > -1)
			return null;
		return student.getAsnAvg();
	}

	public Double getStudentExamAvg() {
		if (i > -1)
			return null;
		return student.getExmAvg();
	}

	public Double getGrade() {
		if (i == -1)
			return null;
		return student.getGrade(i);
	}

	public Double getWeight() {
		if (i == -1)
			return null;
		return course.getDeliverable(i).getWeight();
	}

	public String getDeliverName() {
		if (i == -1)
			return null;
		return course.getDeliverable(i).getName();
	}
	public String getDeliverType() {
		if (i == -1)
			return null;
		return course.getDeliverable(i).getType();
	}
}
