package cs2212.team4;

public class GradebookGUI extends javax.swing.JFrame {
    
    private Gradebook gradebook = new Gradebook();
    
    public GradebookGUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradebookTab = new javax.swing.JTabbedPane();
        tabGrades = new javax.swing.JPanel();
        gradesScroll = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        deliversScroll = new javax.swing.JScrollPane();
        deliverList = new javax.swing.JList();
        butEditCourse = new javax.swing.JButton();
        butAddDeliver = new javax.swing.JButton();
        butAddStudent = new javax.swing.JButton();
        tabSetup = new javax.swing.JPanel();
        tabReports = new javax.swing.JPanel();
        gradebookMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gradebook Application");
        setName("Gradebook"); // NOI18N
        setResizable(false);

        gradebookTab.setBackground(new java.awt.Color(255, 255, 255));
        gradebookTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tabGrades.setBackground(new java.awt.Color(255, 255, 255));

        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        gradesScroll.setViewportView(gradesTable);

        deliverList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        deliversScroll.setViewportView(deliverList);

        butEditCourse.setText("Edit Course");
        butEditCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditCourseActionPerformed(evt);
            }
        });

        butAddDeliver.setText("Add Deliverable");

        butAddStudent.setText("Add Student");
        butAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabGradesLayout = new javax.swing.GroupLayout(tabGrades);
        tabGrades.setLayout(tabGradesLayout);
        tabGradesLayout.setHorizontalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGradesLayout.createSequentialGroup()
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butEditCourse)
                            .addComponent(butAddDeliver)
                            .addComponent(butAddStudent))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deliversScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(gradesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabGradesLayout.setVerticalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGradesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addComponent(butEditCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deliversScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butAddDeliver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butAddStudent)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(gradesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        gradebookTab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOn.png")), tabGrades); // NOI18N

        tabSetup.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabSetupLayout = new javax.swing.GroupLayout(tabSetup);
        tabSetup.setLayout(tabSetupLayout);
        tabSetupLayout.setHorizontalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        tabSetupLayout.setVerticalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        gradebookTab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOn.png")), tabSetup); // NOI18N

        tabReports.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabReportsLayout = new javax.swing.GroupLayout(tabReports);
        tabReports.setLayout(tabReportsLayout);
        tabReportsLayout.setHorizontalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        tabReportsLayout.setVerticalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        gradebookTab.addTab("", new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOn.png")), tabReports); // NOI18N

        menuFile.setText("File");
        gradebookMenu.add(menuFile);

        setJMenuBar(gradebookMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(gradebookTab, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(gradebookTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        gradebookTab.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butAddStudentActionPerformed

    private void butEditCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butEditCourseActionPerformed

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
    private javax.swing.JButton butAddDeliver;
    private javax.swing.JButton butAddStudent;
    private javax.swing.JButton butEditCourse;
    private javax.swing.JList deliverList;
    private javax.swing.JScrollPane deliversScroll;
    private javax.swing.JMenuBar gradebookMenu;
    private javax.swing.JTabbedPane gradebookTab;
    private javax.swing.JScrollPane gradesScroll;
    private javax.swing.JTable gradesTable;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel tabGrades;
    private javax.swing.JPanel tabReports;
    private javax.swing.JPanel tabSetup;
    // End of variables declaration//GEN-END:variables
}
