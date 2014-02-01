import java.util.ArrayList;

public class gradebook 
{
	private ArrayList<course> courseList = new ArrayList<course>();
	
	public gradebook(){}
	
	public gradebook(ArrayList<course> courseList)
	{
		this.courseList=courseList; 
	}
	
	public void addCourse(course crs)
	{
		courseList.add(crs);
	}
	
	public void addCourse(String name, String term, String code)
	{
		courseList.add(new course(name, term, code));
	}
	
	public void addCourse(String name, String term, String code, ArrayList<student> studentList)
	{
		courseList.add(new course(name, term, code, studentList));
	}
	
	public void addCourse(String name, String term, String code, ArrayList<student> studentList, ArrayList<deliverable> deliverableList)
	{
		courseList.add(new course(name, term, code, studentList, deliverableList));
	}
	
	public int findCourse(course crs)
	{
		course tempCourse;
		for (int i=0; i<courseList.size()-1; i++)
		{
			tempCourse=courseList.get(i);
			if (tempCourse.getTitle()==crs.getTitle()&&tempCourse.getCode()==crs.getCode()&&tempCourse.getTerm()==crs.getTerm())return i;
		}
		return -1;
	}
	
	public ArrayList<String> approxCourse(course crs)
	{
		ArrayList<String> approxCourseList = new ArrayList<String>();
		
		course tempCourse;
		for (int i=0; i<courseList.size()-1; i++)
		{
			tempCourse=courseList.get(i);
			if (tempCourse.getTitle()==crs.getTitle()&&tempCourse.getCode()==crs.getCode())approxCourseList.add(tempCourse.toString());
			else if(tempCourse.getTitle()==crs.getTitle()&&tempCourse.getTerm()==crs.getTerm())approxCourseList.add(tempCourse.toString());
			else if(tempCourse.getCode()==crs.getCode()&&tempCourse.getTerm()==crs.getTerm())approxCourseList.add(tempCourse.toString());
		}
		return approxCourseList;
	}
	
	public boolean removeCourse(course crs)
	{
		int i;
		if ((i=findCourse(crs))==-1)return false;
		else courseList.remove(i);
		return true;
	}
}
