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

    private int COLUMN_COUNT = 5;
    private final String[] columnNames = {"First Name", "Last Name", "Email", "Student No."};
    Object[] values = {"String", 10, 20.0, 30.2, new Boolean(false)};

    private final List<Student> studentNames;
   /**
    * Constructor, takes no parameters to create a default UserTable
    */
    public UsersTable() {
        studentNames = new ArrayList<Student>();
        for (int i = 0; i < columnNames.length; i++){
            addColumn(columnNames[i]);
        }
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
        studentNames = new ArrayList<Student>();
        for (int i = 0; i < COLUMN_COUNT; i++){
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
        studentNames.add(s);
        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
        refreshNames();
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
        studentNames.add(s);
        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
//        refreshNames();
        fireTableDataChanged();
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
        studentNames.remove(rowIndex-1);
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
            }
        }
        if((getRowCount()>0) && !(getValueAt(getRowCount()-1,0)).equals("New Student"))
           addRow(new String[]{"New Student"});
    }
}
