package cs2212.team4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CourseTest.class, DeliverableTest.class, EmailTest.class,
		GradebookTest.class, GradeTest.class, MyAvgTest.class,
		StudentGradesTest.class, StudentReportDataTest.class, StudentTest.class })
public class AllTests {

}
