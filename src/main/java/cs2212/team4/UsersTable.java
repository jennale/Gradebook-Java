package cs2212.team4;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenna on 2014-03-12.
 */
public class UsersTable extends DefaultTableModel{
    
    private GradesTable grades;
    private final List<Student> studentNames = new ArrayList<>();
    Course currCourse;


    private int COLUMN_COUNT = 5;
    private final String[] columnNames = {"First Name", "Last Name", "Email", "Student No."};

    /**
    * Constructor, takes no parameters to create a default UserTable
    */
    public UsersTable(Course currCourse) {
        this.currCourse = currCourse;
        int numStud=currCourse.getStudentListSize();
        for (int i = 0; i < columnNames.length; i++){
            addColumn(columnNames[i]);
        }
        grades = new GradesTable(currCourse);

        for (int i = 0; i < numStud; i++) {
            Student stud = currCourse.getStudent(i);
            studentNames.add(stud);
            addStudent(stud);
            grades.addGrades(stud);
        }

        refreshNames();
    }

    public GradesTable getGradesTable(){
        return grades;
    }

////    public void add(Student s) {
////        double[] grades = new Grades();
////        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
//////        refreshNames();
////        fireTableDataChanged();
//
//    }

    public UsersTable() {
        for (int i = 0; i < columnNames.length; i++){
            addColumn(columnNames[i]);
        }
        grades = new GradesTable();

        refreshNames();
    }
    /**
     * Overloaded constructor, allows for the deactivation of some initial columns.
     * 
     * @param first
     * @param last
     * @param email
     * @param num 
     */
    public UsersTable(int first,int last, int email, int num) {
        int[] columns = {first,last,email,num};
        for (int i = 0; i < columnNames.length; i++){
            if (columns[i]==1)
                addColumn(columnNames[i]);
        }
        refreshNames();
    }

/**
 * Adds a new student ROW to the usersTable. 
 * @param s Student object to be added
 */
    public void addStudent(Student s){
        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
//        refreshNames();
        fireTableDataChanged();
    }
/**
 * Adds a new student ROW to the usersTable, overloaded method
 * Assumes the student already exists in the course.
 * @param c Course
 * @param studNum Student's ID number
 */
    public void addStudent (Course c, String studNum){
        Student s = c.getStudent(c.findStudent(studNum));
        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
//        refreshNames();
        fireTableDataChanged();
    }
///**
// * Returns the list of students objects currently in the table. 
// * @return List of students currently in UsersTable
// */
//    public List<Student> getStudentNames() {
//        return studentNames;
//    }

  /**
   * Removes student from table. 
   * @param rowIndex row of table where student is to be removed.
   */
    public void removeStudent(int rowIndex){
        removeRow(rowIndex);
        fireTableDataChanged();
    }
/**
 * Adds a "Add new student" row below all students
 * Will add functionality to actually add a student into the course
 */
    public void refreshNames(){
        for (int i = 0; i < getRowCount()-1; i++){
            if((getValueAt(i,0)).equals("New Student")){
                removeRow(i);
                grades.removeRow(i);
            }
        }
        if((getRowCount()>0)){
           addRow(new String[]{"New Student"});
           grades.addRow(new Object[]{null});
        }

    }

    /**
     * Overrides the superclass' setValueat method, to edit the student object's information in the Course
     * @param aValue        String to change the attribute of the student
     * @param rowIndex      Row where attribute is selected
     * @param columnIndex   Column where attribute is selected
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= studentNames.size()))
            return;
        else {
            if(aValue.equals(""))
                return;
            switch (columnIndex) {
                case 0:
                    currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setNameFirst((String)aValue);
                    return;
                case 1:
                    currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setNameLast((String) aValue);
                    return;
                case 2:
                    currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setEmail((String) aValue);
                    return;
                case 3:
                    if((((String)aValue).matches("^[0-9]+$")) && !(currCourse.studentExists(studentNames.get(rowIndex).getNumber()))){
                        currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setNumber((String) aValue);
                        return;
                    }
                    else return;
            }
        }

    }
}
