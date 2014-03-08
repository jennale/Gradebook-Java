package cs2212.team4;

import java.awt.Color;

public class GradebookGUI extends javax.swing.JFrame {
    
    private Gradebook gradebook = new Gradebook();
    
    public GradebookGUI() {
        initComponents();
        getContentPane().setBackground(new Color(51,160,200));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activeCourse = new javax.swing.JLabel();
        myCourses = new javax.swing.JLabel();
        lblTabGrades = new javax.swing.JLabel();
        lblTabSetup = new javax.swing.JLabel();
        lblTabReport = new javax.swing.JLabel();
        container = new javax.swing.JLayeredPane();
        tabGrades = new javax.swing.JPanel();
        gradesScroll = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        deliversScroll = new javax.swing.JScrollPane();
        deliverList = new javax.swing.JList();
        courseName = new javax.swing.JLabel();
        editCourseIcon = new javax.swing.JLabel();
        addStudent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tabReports = new javax.swing.JPanel();
        tabSetup = new javax.swing.JPanel();
        gradebookMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gradebook Application");
        setBackground(new java.awt.Color(51, 105, 232));
        setName("Gradebook"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        activeCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/activeCourseTab.png"))); // NOI18N
        activeCourse.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        myCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/myCourses.png"))); // NOI18N

        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOn.png"))); // NOI18N
        lblTabGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabGradesMouseClicked(evt);
            }
        });

        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOff.png"))); // NOI18N
        lblTabSetup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabSetupMouseClicked(evt);
            }
        });

        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOff.png"))); // NOI18N
        lblTabReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabReportMouseClicked(evt);
            }
        });

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setOpaque(true);

        tabGrades.setBackground(new java.awt.Color(255, 255, 255));

        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Frist Name", "Last Name", "Student Number", "E-mail"
            }
        ));
        gradesScroll.setViewportView(gradesTable);

        deliverList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "No Deliverables" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        deliverList.setPreferredSize(new java.awt.Dimension(35, 80));
        deliversScroll.setViewportView(deliverList);

        courseName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/course.png"))); // NOI18N
        courseName.setText("Course Name");

        editCourseIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editCourseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/settings.png"))); // NOI18N
        editCourseIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addStudent.png"))); // NOI18N
        addStudent.setText("Add Student");
        addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudent.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addDeliver.png"))); // NOI18N
        jLabel1.setText("Add Deliverable");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 25));

        javax.swing.GroupLayout tabGradesLayout = new javax.swing.GroupLayout(tabGrades);
        tabGrades.setLayout(tabGradesLayout);
        tabGradesLayout.setHorizontalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGradesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deliversScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCourseIcon))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(gradesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        tabGradesLayout.setVerticalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(gradesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabGradesLayout.createSequentialGroup()
                                .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(editCourseIcon)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deliversScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(10, 10, 10))
        );

        tabReports.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabReportsLayout = new javax.swing.GroupLayout(tabReports);
        tabReports.setLayout(tabReportsLayout);
        tabReportsLayout.setHorizontalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tabReportsLayout.setVerticalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabSetup.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabSetupLayout = new javax.swing.GroupLayout(tabSetup);
        tabSetup.setLayout(tabSetupLayout);
        tabSetupLayout.setHorizontalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tabSetupLayout.setVerticalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addGap(448, 448, 448)
                    .addComponent(tabReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addGap(448, 448, 448)
                    .addComponent(tabSetup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(tabGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(tabReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(216, Short.MAX_VALUE)))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addGap(207, 207, 207)
                    .addComponent(tabSetup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(216, Short.MAX_VALUE)))
        );
        container.setLayer(tabGrades, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabReports, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabSetup, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menuFile.setText("File");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        menuFile.add(Exit);

        gradebookMenu.add(menuFile);

        setJMenuBar(gradebookMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 880, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTabGrades)
                        .addGap(0, 0, 0)
                        .addComponent(lblTabSetup)
                        .addGap(0, 0, 0)
                        .addComponent(lblTabReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(activeCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(myCourses)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTabGrades, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTabSetup, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTabReport, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myCourses, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(activeCourse, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
      System.exit(0); 
    }//GEN-LAST:event_ExitActionPerformed

    private void lblTabGradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTabGradesMouseClicked
        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOn.png")));
        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOff.png")));
        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOff.png")));
        if (!tabGrades.isVisible())
        {
            tabGrades.setVisible(true);
            tabSetup.setVisible(false);
            tabReports.setVisible(false);
        }
    }//GEN-LAST:event_lblTabGradesMouseClicked

    private void lblTabSetupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTabSetupMouseClicked
        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOff.png")));
        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOn.png")));
        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOff.png")));
        if (!tabSetup.isVisible())
        {
            tabGrades.setVisible(false);
            tabSetup.setVisible(true);
            tabReports.setVisible(false);
        }
    }//GEN-LAST:event_lblTabSetupMouseClicked

    private void lblTabReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTabReportMouseClicked
        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOff.png")));
        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOff.png")));
        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOn.png")));
        if (!tabReports.isVisible())
        {
            tabGrades.setVisible(false);
            tabSetup.setVisible(false);
            tabReports.setVisible(true);
        }
    }//GEN-LAST:event_lblTabReportMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GradebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradebookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradebookGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JLabel activeCourse;
    private javax.swing.JLabel addStudent;
    private javax.swing.JLayeredPane container;
    private javax.swing.JLabel courseName;
    private javax.swing.JList deliverList;
    private javax.swing.JScrollPane deliversScroll;
    private javax.swing.JLabel editCourseIcon;
    private javax.swing.JMenuBar gradebookMenu;
    private javax.swing.JScrollPane gradesScroll;
    private javax.swing.JTable gradesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTabGrades;
    private javax.swing.JLabel lblTabReport;
    private javax.swing.JLabel lblTabSetup;
    private javax.swing.JMenu menuFile;
    private javax.swing.JLabel myCourses;
    private javax.swing.JPanel tabGrades;
    private javax.swing.JPanel tabReports;
    private javax.swing.JPanel tabSetup;
    // End of variables declaration//GEN-END:variables
}