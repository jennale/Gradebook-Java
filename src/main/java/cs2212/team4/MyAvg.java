package cs2212.team4;

import java.util.ArrayList;

public class MyAvg {
	Course course;
	Student student;

	public MyAvg(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

<<<<<<< HEAD
	/**
	 * Method to calculate an average for a student in a course.
	 * 
	 * @param reqAvg required average for the course
	 */
	public Object calcAvg(double reqAvg) {
=======
	public double calcAvg(double reqAvg) {
>>>>>>> FETCH_HEAD
		ArrayList<Integer> delivers = new ArrayList<Integer>();
		double remWeight = 0;
		double currAvg = 0;
        int ctr=0;
		for (int i = 0; i < course.getDeliverableListSize(); i++)
			if (course.getDeliverable(i) != null)
				delivers.add(i);

		for (int i = 0; i < delivers.size(); i++) {
			if (student.getGrade(delivers.get(i)) != -1) {
				currAvg += student.getGrade(delivers.get(i))
						* course.getDeliverable(delivers.get(i)).getWeight()
						/ 100;
				remWeight += course.getDeliverable(delivers.get(i)).getWeight() / 100;
                ctr++;
			}
		}
<<<<<<< HEAD
        if (ctr==delivers.size())
            return null;

=======
>>>>>>> FETCH_HEAD
		return (reqAvg - currAvg) / (1 - remWeight);
	}
}
