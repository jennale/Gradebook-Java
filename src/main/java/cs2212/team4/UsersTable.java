package cs2212.team4;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenna on 2014-03-12.
 */
public class UsersTable extends DefaultTableModel{

    private GradesTable grades;
    private final List<Student> studentNames = new ArrayList<>();
    private Course currCourse;
    private final String[] columnNames = {"First Name", "Last Name", "Email", "Student #"};

    /**
     * Constructor, takes no parameters to create a default empty UserTable
     */

    public UsersTable() {
        for (int i = 0; i < columnNames.length; i++){
            addColumn(columnNames[i]);
        }
        grades = new GradesTable();
    }

    /**
     * Overloaded constructor, allows for the deactivation of some columns. User
     * will input '0' or '1', whether they want to hide or show the column, respectively.
     *
     * @param first     0 - hide, 1 - show first name column
     * @param last      0 - hide, 1 - show last name column
     * @param email     0 - hide, 1 - show email column
     * @param num       0 - hide, 1 - show stud. no column
     */

    public UsersTable(Course currCourse, int first,int last, int email, int num) {
        this.currCourse = currCourse;
        int numStud=currCourse.getStudentListSize();

        int[] columns = {first,last,email,num};
        for (int i = 0; i < columnNames.length; i++){
            if (columns[i]==1)
                addColumn(columnNames[i]);
        }
        grades = new GradesTable(currCourse);

        for (int i = 0; i < numStud; i++) {
            Student stud = currCourse.getStudent(i);
            studentNames.add(stud);
            addStudent(stud, first, last, email, num);
            grades.addGrades(stud);
        }
        fillScreen();
    }

    /**
     * Returns the GradesTable - the other half of the Jtables on the GUI.
     * @return
     */
    public GradesTable getGradesTable(){
        return grades;
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
        fireTableDataChanged();
    }

    /**
     * Adds a new student ROW to the usersTable.
     * @param s Student object to be added
     */
    public void addStudent(Student s, int firstName, int lastName, int number, int email){
    	String[] ary = new String [4];
        int ctr=0;
        if (firstName==1)
        	ary[ctr++]=s.getNameFirst();
        if (lastName==1)
        	ary[ctr++]=s.getNameLast();
        if (number==1)
        	ary[ctr++]=s.getEmail();
        if (email==1)
        	ary[ctr++]=s.getNumber();
        addRow(ary);
    }

/**
* Returns the list of students objects currently in the table.
* @return List of students currently in UsersTable
*/
    public List<Student> getStudentNames() {
        return studentNames;
    }

    /**
     * Removes student from table.
     * @param rowIndex row of table where student is to be removed.
     */
    public void removeStudent(int rowIndex){
        removeRow(rowIndex);
        fireTableDataChanged();
    }

    /**
     * Overrides the superclass' setValueat method, to edit the student object's information in the Course
     * @param aValue        String to change the attribute of the student
     * @param rowIndex      Row where attribute is selected
     * @param columnIndex   Column where attribute is selected
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    	String clmn = getColumnName(columnIndex);
        if ((rowIndex < 0) || (rowIndex >= studentNames.size()))
            return;
        else {
            //Checks whether changed value is an empty string -- does not allow the user to change any attribute to blank.
            if(aValue.equals(""))
                return;
            switch (clmn) {
                case "First Name":
                    currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setNameFirst((String) aValue);
                    fireTableCellUpdated(rowIndex,columnIndex);
                    return;
                case "Last Name":
                    currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).setNameLast((String) aValue);
                    fireTableCellUpdated(rowIndex,columnIndex);
                    return;
                case "Email":
                    currCourse.editStudentEmail(currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())), (String) aValue);
                    fireTableCellUpdated(rowIndex,columnIndex);
                    return;
                case "Student #":
                    //Checks whether the student number inputted are only numbers, and does not belong to an already existing student.
                    if((((String)aValue).matches("^[0-9]+$"))){
                        currCourse.editStudentNumber(currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())),(String)aValue);
                        fireTableCellUpdated(rowIndex,columnIndex);
                        return;
                    }
                    else return;
            }
        }


    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (rowIndex > studentNames.size()-1)
            return false;
        else
            return true;
    }

    public void fillScreen(){
        //Fill with columns/rows if there is empty space in the screen
        int width = this.getColumnCount() + grades.getColumnCount();
        int height = this.getRowCount();

        if (width<9){
            for (int i=0; i < 10-width; i++){
                grades.addColumn("");
            }
        }
        if (height<20){
            for (int i=0; i < 20-height; i++){
                this.addRow(new String[]{""});
                grades.addRow(new String[] {""});
            }
        }
    }

}


//    /**
//     * Adds a "Add new student" row below all students
//     * Will add functionality to actually add a student into the course
//     */
//    public void refreshNames(){
//        for (int i = 0; i < getRowCount()-1; i++){
//            if((getValueAt(i,0)).equals("New Student")){
//                removeRow(i);
//                grades.removeRow(i);
//            }
//        }
//        if((getRowCount()>0)){
//            addRow(new String[]{"New Student"});
//            grades.addRow(new Object[]{null});
//        }
//    }