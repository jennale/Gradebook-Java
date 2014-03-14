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

//Not yet complete - waiting for deliverables bug to be fixed

public class GradesTable extends DefaultTableModel {
    private int COLUMN_COUNT;
    private final static int IDX_COURSEGRD = 0;

    private final List<Student> studentGrades;
    private final Course currCourse;  //Reference to current course

    public GradesTable(Course c) {
        studentGrades = new ArrayList<Student>();
        currCourse = c;
        COLUMN_COUNT = currCourse.getDeliverableListSize();
    }

    public void addColumn(Course c) {

    }
    public List<Student> getStudentGrades() {
        return studentGrades;
    }

    @Override
    public int getRowCount() {
        return studentGrades.size();
    }

    public int getNumStudents() {
        return studentGrades.size() - 1;
    }

    public void addStudent(Student s){
        studentGrades.add(s);
        addRow(new String [] {s.getNameFirst(),s.getNameLast(),s.getEmail(),s.getNumber()});
        fireTableDataChanged();
    }

    public void addStudent (Course c, String studNum){
        Student s = c.getStudent(c.findStudent(studNum));
        studentGrades.add(s);
        Double[] grades = new Double[s.getNumGrades()];
        for (int i = 0; i<s.getNumGrades();i++){
            grades[i] = s.getGrade(i);
        }
        addRow(grades);
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    public int getNumDeliv() {
        return COLUMN_COUNT;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return (columnIndex <= 4 ? Double.class : String.class);
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case IDX_COURSEGRD:
                return "Course Grade";
            default:
                return "Gradebook Item";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= studentGrades.size()))
            return null;
        else {
            switch (columnIndex) {
                case IDX_COURSEGRD:
                    return "none";
                default:
                    return "none";
            }
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= studentGrades.size()))
            return;
        else if (columnIndex >= 4) {
            studentGrades.get(rowIndex).addGrade(columnIndex,90,"Exam",20);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex>=4)
            return true;
        else
            return false;
    }



}

