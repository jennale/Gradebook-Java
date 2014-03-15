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

public class GradesTable extends DefaultTableModel{
    int delivSize;
    private final List<Student> studentGrades = new ArrayList<>();
    private final List<Deliverable> deliverableGrades = new ArrayList<>();
    Course currCourse;

    /**
     * Constructor method to create a table for student grades
     *
     * @param currCourse
     */
    public GradesTable(Course currCourse) {
        addColumn("COURSE");
        this.currCourse = currCourse;
        if (currCourse.getDeliverableListSize() > 0) {
            for (int i = 0; i < currCourse.getDeliverableListSize(); i++) {
                //Creates a column header read as: DeliverableName [Weight%]
                if (currCourse.getDeliverable(i) != null) {
                    deliverableGrades.add(currCourse.getDeliverable(i));
                    addColumn(currCourse.getDeliverable(i).getName() + " [" + (int) currCourse.getDeliverable(i).getWeight() + "%]");
                }
            }
            delivSize = currCourse.getDeliverableListSize();
        }
    }

    /**
     * Overloaded constructor method to create new Grades table.
     */
    public GradesTable() {
        addColumn("Course Grade");
        delivSize = 0;
    }

    /**
     * Adds the grades of a student in a row.
     *
     * @param s
     */
    public void addGrades(Student s) {
        String[] grades = new String[delivSize + 2];
        studentGrades.add(s);
        if (s.getNumGrades() > 0) {
            if (s.getAvg() != 0.0) {
                grades[0] = String.format("%.2f", s.getAvg());
            } else
                grades[0] = "";
            for (int i = 0; i < deliverableGrades.size(); i++) {
                if (deliverableGrades.get(i) != null) {
                    int id = deliverableGrades.get(i).getObjId();
                    if (s.getGrade(id) > 0) {
                        grades[i + 1] = String.format("%.2f",s.getGrade(id));
                    } else
                        grades[i + 1] = "";
                }
            }
            addRow(grades);
        } else addRow(new Object[]{null});
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= currCourse.getDeliverableListSize()))
            return;
        else if (columnIndex > 0) {
            Deliverable d = deliverableGrades.get(columnIndex - 1);
            if (((String)aValue).equals(""))
                currCourse
                        .getStudent(currCourse
                                .findStudent(studentGrades.get(rowIndex).getNumber()))
                        .removeGrade(d.getObjId(), d.getType());
            else if(!(((String)aValue).matches("\\d+(\\.\\d+)?")))
                return;
            else {
                if (Double.parseDouble((String) aValue)>100||Double.parseDouble((String) aValue)<0)
                    return;
            currCourse
                    .getStudent(currCourse
                            .findStudent(studentGrades.get(rowIndex).getNumber()))
                    .addGrade(d.getObjId(), Double.parseDouble((String) aValue), d.getType(), d.getWeight());
            }
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    /**
     * Method to restrict the user from manually editing a student's calculated course grade.
     * This grade is calculated automatically by the program, and so does not need to be edited.
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0 || columnIndex > deliverableGrades.size() || rowIndex > studentGrades.size()-1)
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




