package cs2212.team4;

/**
 * Created by Jenna on 2014-03-12.
 */

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Jenna on 2014-03-11.
 */

public class GradesTable extends DefaultTableModel {
    int delivSize;
    private final List<Student> studentGrades = new ArrayList<>();
    Course currCourse;

    /**
     * Constructor method to create a table for student grades
     *
     * @param currCourse
     */
    public GradesTable(Course currCourse) {
        addColumn("Course Grade");
        this.currCourse = currCourse;
        if (currCourse.getDeliverableListSize()>0){
        for (int i = 0; i < currCourse.getDeliverableListSize(); i++){
            //Creates a column header read as: DeliverableName [Weight%]
            if(currCourse.getDeliverable(i)!=null){
                addColumn(currCourse.getDeliverable(i).getName()+" ["+(int)currCourse.getDeliverable(i).getWeight()+"%]");
            }
        }
        delivSize = currCourse.getDeliverableListSize();
        }
    }

    /**
     * Overloaded constructor method to create new Grades table.
     */
    public GradesTable(){
        addColumn("Course Grade");
        delivSize=0;
    }

    /**
     * Adds the grades of a student in a row.
     * @param s
     */
    public void addGrades(Student s){
        double[] grades = new double[delivSize];
        studentGrades.add(s);
        if(s.getNumGrades()>0){
            if(s.getAvg()!=0.0){
                grades[0]=s.getAvg();
            }
        for (int i = 1; i < grades.length;i++){
            if(s.getGrade(i)>=0){
                grades[i]=s.getGrade(i);
                }
            }
        }
        else addRow(new Object[] {null});
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= currCourse.getDeliverableListSize()))
            return;
        else if (columnIndex > 0){
            currCourse
                    .getStudent(currCourse
                    .findStudent(studentGrades.get(rowIndex).getNumber()))
                    .addGrade(columnIndex-1,Double.parseDouble((String)aValue),currCourse.getDeliverable(columnIndex-1)
                            .getType(),currCourse.getDeliverable(columnIndex-1).getWeight());
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    /**
     * Method to restrict the user from manually editing a student's calculated course grade.
     * This grade is calculated automatically by the program, and so does not need to be edited.
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0)
            return false;
        else
            return true;
    }


}
//    public void add(Student s) {
//        double[] grades = new Grades();
//        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
////        refreshNames();
//        fireTableDataChanged();
//
//    }
//
//    public void addColumn(Course c) {
//
//    }
//    public List<Student> getStudentGrades() {
//        return studentGrades;
//    }
//
//    @Override
//    public int getRowCount() {
//        return studentGrades.size();
//    }
//
//    public int getNumStudents() {
//        return studentGrades.size() - 1;
//    }
//
//    public void addStudent(Student s){
//        studentGrades.add(s);
//        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
//        fireTableDataChanged();
//    }
//
//    public void addStudent (Course c, String studNum){
//        Student s = c.getStudent(c.findStudent(studNum));
//        studentGrades.add(s);
//        Double[] grades = new Double[s.getNumGrades()];
//        for (int i = 0; i<s.getNumGrades();i++){
//            grades[i] = s.getGrade(i);
//        }
//        addRow(grades);
//        fireTableDataChanged();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return COLUMN_COUNT;
//    }
//
//    public int getNumDeliv() {
//        return COLUMN_COUNT;
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return (columnIndex <= 4 ? Double.class : String.class);
//    }
//
//    @Override
//    public String getColumnName(int columnIndex) {
//        switch (columnIndex) {
//            case IDX_COURSEGRD:
//                return "Course Grade";
//            default:
//                return "Gradebook Item";
//        }
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if ((rowIndex < 0) || (rowIndex >= studentGrades.size()))
//            return null;
//        else {
//            switch (columnIndex) {
//                case IDX_COURSEGRD:
//                    return "none";
//                default:
//                    return "none";
//            }
//        }
//    }
//

//




