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
    int delivSize;
    private final List<Student> studentNames = new ArrayList<>();
    Course currCourse;

    public GradesTable(Course currCourse) {
        addColumn("Course Grade");
        this.currCourse = currCourse;
        if (currCourse.getDeliverableListSize()>0){
        for (int i = 0; i < currCourse.getDeliverableListSize(); i++){
            if(currCourse.getDeliverable(i)!=null){
                addColumn(currCourse.getDeliverable(i).getName()+" ["+(int)currCourse.getDeliverable(i).getWeight()+"%]");
            }
        }
        delivSize = currCourse.getDeliverableListSize();
        }
    }

    public GradesTable(){
        addColumn("Course Grade");
        delivSize=0;
    }

//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        if ((rowIndex < 0) || (rowIndex > getRowCount()))
//            return;
//        else {
//            Deliverable d = currCourse.getDeliverable(rowIndex);
//            currCourse.getStudent(currCourse.findStudent(studentNames.get(rowIndex).getNumber())).addGrade(rowIndex,(double)aValue,d.getType(),d.getWeight());
//        }
//    }

    public void addGrades(Student s){
        double[] grades = new double[delivSize];
        if(s.getNumGrades()>0){
        for (int i = 0; i < grades.length;i++){
            if(s.getGrade(i)>=0){
                grades[i]=s.getGrade(i);
            }
        }
        }
        else addRow(new Object[] {null});
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
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        if ((rowIndex < 0) || (rowIndex >= studentGrades.size()))
//            return;
//        else if (columnIndex >= 4) {
//            studentGrades.get(rowIndex).addGrade(columnIndex,90,"Exam",20);
//            fireTableCellUpdated(rowIndex, columnIndex);
//        }
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        if(columnIndex>=4)
//            return true;
//        else
//            return false;
//    }



