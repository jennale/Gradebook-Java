package cs2212.team4;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;

public class GradebookGUI extends javax.swing.JFrame {
    
    private Gradebook gradebook = new Gradebook();
    Border errorHighlightBorder = BorderFactory.createLineBorder(Color.RED);
    Border defaultHighlightBorder;
    DefaultListModel listCourses= new DefaultListModel();
    
    Course currCourse;
    
    public GradebookGUI() {
        int size;
        
        initComponents();
        getContentPane().setBackground(new Color(51,105,232));
        tabGrades.setVisible(true);
        tabSetup.setVisible(false);
        tabReports.setVisible(false);
        
        pnlCourseMenu.setVisible(false);
        
        pnlAddCourse.setBackground(this.getBackground());
        pnlAddDeliver.setBackground(this.getBackground());
        pnlAddStudent.setBackground(this.getBackground());
        
        pnlAddCourse.setVisible(false);
        pnlAddDeliver.setVisible(false);
        pnlAddStudent.setVisible(false);
        
        defaultHighlightBorder = txtCourseName.getBorder();
        
        Course crs;
        if ((size=gradebook.getCourseListSize())>0)for (int i=0; i<size; i++)
        {
            crs=gradebook.getCourse(i);
            listCourses.addElement(crs.getTitle()+", "+crs.getCode()+crs.getTerm());
        }
        else listCourses.addElement("No Courses");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTabGrades = new javax.swing.JLabel();
        lblTabSetup = new javax.swing.JLabel();
        lblTabReport = new javax.swing.JLabel();
        lblMini = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        myCourses = new javax.swing.JLabel();
        pnlCourseMenu = new javax.swing.JPanel();
        courses = new javax.swing.JScrollPane();
        courseMenuList = new javax.swing.JList(listCourses);
        addCourse = new javax.swing.JLabel();
        pnlAddDeliver = new javax.swing.JPanel();
        pnlAddCourse = new javax.swing.JPanel();
        pnlAddCourseContainer = new javax.swing.JPanel();
        lblCourseTerm = new javax.swing.JLabel();
        lblCourseCode = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        lblCourseName = new javax.swing.JLabel();
        lblAddCourseTitle = new javax.swing.JLabel();
        lblCancelCourseAddition = new javax.swing.JLabel();
        lblAddCourse = new javax.swing.JLabel();
        lblCourseAddErrorLog = new javax.swing.JLabel();
        txtCourseCode = new javax.swing.JTextField();
        comboCourseTerm = new javax.swing.JComboBox();
        pnlAddStudent = new javax.swing.JPanel();
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
        tabSetup = new javax.swing.JPanel();
        tabReports = new javax.swing.JPanel();
        lyrActiveCourse = new javax.swing.JLayeredPane();
        lblActiveCourseTitleInfo = new javax.swing.JLabel();
        lblActiveCourseInfo = new javax.swing.JLabel();
        lblActiveCourse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gradebook Application");
        setBackground(new java.awt.Color(51, 105, 232));
        setLocationByPlatform(true);
        setName("Gradebook"); // NOI18N
        setUndecorated(true);
        setOpacity(0.99F);
        setPreferredSize(new java.awt.Dimension(900, 530));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/gradesTabOn.png"))); // NOI18N
        lblTabGrades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTabGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabGradesMouseClicked(evt);
            }
        });
        getContentPane().add(lblTabGrades, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/setupTabOff.png"))); // NOI18N
        lblTabSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTabSetup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabSetupMouseClicked(evt);
            }
        });
        getContentPane().add(lblTabSetup, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 60, -1, -1));

        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/reportingTabOff.png"))); // NOI18N
        lblTabReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTabReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabReportMouseClicked(evt);
            }
        });
        getContentPane().add(lblTabReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/miniOff.png"))); // NOI18N
        lblMini.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMiniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMiniMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMiniMousePressed(evt);
            }
        });
        getContentPane().add(lblMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(848, 0, -1, -1));

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/exitOff.png"))); // NOI18N
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });
        getContentPane().add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(874, 0, -1, -1));

        myCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/myCourses.png"))); // NOI18N
        myCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myCoursesMouseClicked(evt);
            }
        });
        getContentPane().add(myCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, -1));

        pnlCourseMenu.setBackground(new java.awt.Color(255, 255, 255));

        courseMenuList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        courseMenuList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseMenuList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                courseMenuListValueChanged(evt);
            }
        });
        courses.setViewportView(courseMenuList);

        addCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addCourse.png"))); // NOI18N
        addCourse.setText("Add Course");
        addCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourse.setPreferredSize(new java.awt.Dimension(40, 40));
        addCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCourseMenuLayout = new javax.swing.GroupLayout(pnlCourseMenu);
        pnlCourseMenu.setLayout(pnlCourseMenuLayout);
        pnlCourseMenuLayout.setHorizontalGroup(
            pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(courses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );
        pnlCourseMenuLayout.setVerticalGroup(
            pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCourseMenuLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
            .addGroup(pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCourseMenuLayout.createSequentialGroup()
                    .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 49, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlCourseMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 210, 280));

        pnlAddDeliver.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddDeliver.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout pnlAddDeliverLayout = new javax.swing.GroupLayout(pnlAddDeliver);
        pnlAddDeliver.setLayout(pnlAddDeliverLayout);
        pnlAddDeliverLayout.setHorizontalGroup(
            pnlAddDeliverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        pnlAddDeliverLayout.setVerticalGroup(
            pnlAddDeliverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        getContentPane().add(pnlAddDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 160, -1, -1));

        pnlAddCourse.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddCourse.setPreferredSize(new java.awt.Dimension(350, 250));

        pnlAddCourseContainer.setBackground(new java.awt.Color(255, 255, 255));

        lblCourseTerm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseTerm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseTerm.setText("Course Term:");
        lblCourseTerm.setToolTipText("");

        lblCourseCode.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseCode.setText("Course Code:");
        lblCourseCode.setToolTipText("");

        txtCourseName.setForeground(new java.awt.Color(204, 204, 204));
        txtCourseName.setText("ex. Computer Engineering");
        txtCourseName.setPreferredSize(new java.awt.Dimension(150, 30));
        txtCourseName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCourseNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCourseNameFocusLost(evt);
            }
        });

        lblCourseName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseName.setText("Course Name:");
        lblCourseName.setToolTipText("");

        lblAddCourseTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAddCourseTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddCourseTitle.setText("Add a New Course");

        lblCancelCourseAddition.setBackground(new java.awt.Color(255, 255, 255));
        lblCancelCourseAddition.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCancelCourseAddition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelCourseAddition.setText("Cancel");
        lblCancelCourseAddition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelCourseAddition.setOpaque(true);
        lblCancelCourseAddition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelCourseAdditionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelCourseAdditionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelCourseAdditionMouseExited(evt);
            }
        });
        lblCancelCourseAddition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblCancelCourseAdditionFocusGained(evt);
            }
        });

        lblAddCourse.setBackground(new java.awt.Color(255, 255, 255));
        lblAddCourse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblAddCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddCourse.setText("Add");
        lblAddCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddCourse.setOpaque(true);
        lblAddCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddCourseMouseExited(evt);
            }
        });

        lblCourseAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

        txtCourseCode.setForeground(new java.awt.Color(204, 204, 204));
        txtCourseCode.setText("ex. CS2212");
        txtCourseCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCourseCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCourseCodeFocusLost(evt);
            }
        });

        comboCourseTerm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "E", "F", "G", "Q", "R", "S", "T", "W", "X", "Y", "Z" }));

        javax.swing.GroupLayout pnlAddCourseContainerLayout = new javax.swing.GroupLayout(pnlAddCourseContainer);
        pnlAddCourseContainer.setLayout(pnlAddCourseContainerLayout);
        pnlAddCourseContainerLayout.setHorizontalGroup(
            pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                .addComponent(lblAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCancelCourseAddition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                        .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCourseTerm))
                            .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtCourseCode)
                            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                                .addComponent(comboCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddCourseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCourseAddErrorLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlAddCourseContainerLayout.setVerticalGroup(
            pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAddCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCourseCode, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblCourseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCourseTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(comboCourseTerm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCourseAddErrorLog, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCancelCourseAddition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlAddCourseLayout = new javax.swing.GroupLayout(pnlAddCourse);
        pnlAddCourse.setLayout(pnlAddCourseLayout);
        pnlAddCourseLayout.setHorizontalGroup(
            pnlAddCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCourseLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddCourseContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        pnlAddCourseLayout.setVerticalGroup(
            pnlAddCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCourseLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddCourseContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlAddCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 160, -1, -1));

        pnlAddStudent.setPreferredSize(new java.awt.Dimension(350, 250));

        javax.swing.GroupLayout pnlAddStudentLayout = new javax.swing.GroupLayout(pnlAddStudent);
        pnlAddStudent.setLayout(pnlAddStudentLayout);
        pnlAddStudentLayout.setHorizontalGroup(
            pnlAddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        pnlAddStudentLayout.setVerticalGroup(
            pnlAddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        getContentPane().add(pnlAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 160, -1, -1));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setOpaque(true);
        container.setPreferredSize(new java.awt.Dimension(880, 450));

        tabGrades.setBackground(new java.awt.Color(255, 255, 255));

        gradesScroll.setPreferredSize(new java.awt.Dimension(450, 400));

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
        courseName.setPreferredSize(new java.awt.Dimension(200, 24));

        editCourseIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editCourseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/settings.png"))); // NOI18N
        editCourseIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editCourseIcon.setPreferredSize(new java.awt.Dimension(16, 40));

        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addStudent.png"))); // NOI18N
        addStudent.setText("Add Student");
        addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudent.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addDeliver.png"))); // NOI18N
        jLabel1.setText("Add Deliverable");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(95, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(95, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout tabGradesLayout = new javax.swing.GroupLayout(tabGrades);
        tabGrades.setLayout(tabGradesLayout);
        tabGradesLayout.setHorizontalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGradesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCourseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deliversScroll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(gradesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabGradesLayout.setVerticalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editCourseIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(courseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(deliversScroll)
                        .addGap(10, 10, 10)
                        .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gradesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout tabSetupLayout = new javax.swing.GroupLayout(tabSetup);
        tabSetup.setLayout(tabSetupLayout);
        tabSetupLayout.setHorizontalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        tabSetupLayout.setVerticalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tabReportsLayout = new javax.swing.GroupLayout(tabReports);
        tabReports.setLayout(tabReportsLayout);
        tabReportsLayout.setHorizontalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        tabReportsLayout.setVerticalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabGrades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabSetup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabReports, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabSetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        container.setLayer(tabGrades, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabSetup, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabReports, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 420));

        lyrActiveCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblActiveCourseTitleInfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblActiveCourseTitleInfo.setText("No Course Selected");
        lyrActiveCourse.add(lblActiveCourseTitleInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 54, 140, 20));

        lblActiveCourseInfo.setForeground(new java.awt.Color(204, 204, 204));
        lyrActiveCourse.add(lblActiveCourseInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 70, 120, 20));

        lblActiveCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/activeCourseTab.png"))); // NOI18N
        lblActiveCourse.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lyrActiveCourse.add(lblActiveCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        getContentPane().add(lyrActiveCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 460, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        java.awt.Point currCoords = evt.getLocationOnScreen();
        setLocation(currCoords.x-inCoords.x, currCoords.y-inCoords.y);
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked
    java.awt.Point inCoords;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        inCoords = evt.getLocationOnScreen();
    }//GEN-LAST:event_formMousePressed

    private void lblMiniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMousePressed
        
    }//GEN-LAST:event_lblMiniMousePressed

    private void lblMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseEntered
        lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/miniOn.png")));
    }//GEN-LAST:event_lblMiniMouseEntered

    private void lblMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseExited
        lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/miniOff.png")));
    }//GEN-LAST:event_lblMiniMouseExited

    private void lblMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseClicked
        setState(this.ICONIFIED);
    }//GEN-LAST:event_lblMiniMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/exitOn.png")));
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/exitOff.png")));
    }//GEN-LAST:event_lblExitMouseExited

    private void myCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myCoursesMouseClicked
        if (!pnlCourseMenu.isVisible())pnlCourseMenu.setVisible(true);
        else pnlCourseMenu.setVisible(false);
    }//GEN-LAST:event_myCoursesMouseClicked

    private void lblAddCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddCourseMouseEntered
        lblAddCourse.setBackground(Color.green);
    }//GEN-LAST:event_lblAddCourseMouseEntered

    private void lblAddCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddCourseMouseExited
        lblAddCourse.setBackground(Color.white);
    }//GEN-LAST:event_lblAddCourseMouseExited

    private void lblCancelCourseAdditionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelCourseAdditionMouseEntered
        lblCancelCourseAddition.setBackground(Color.red);
    }//GEN-LAST:event_lblCancelCourseAdditionMouseEntered

    private void lblCancelCourseAdditionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelCourseAdditionMouseExited
        lblCancelCourseAddition.setBackground(Color.white);
    }//GEN-LAST:event_lblCancelCourseAdditionMouseExited

    private void txtCourseNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCourseNameFocusGained
        txtCourseName.setText("");
        txtCourseName.setForeground(Color.black);
    }//GEN-LAST:event_txtCourseNameFocusGained

    private void txtCourseNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCourseNameFocusLost
        if (txtCourseName.getText().equals(""))
        {
            txtCourseName.setText("ex. Computer Engineering");
            txtCourseName.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtCourseNameFocusLost

    private void lblCancelCourseAdditionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelCourseAdditionMouseClicked
        txtCourseName.setText("ex. Computer Engineering");
        txtCourseName.setForeground(new Color(204, 204, 204));
        txtCourseCode.setText("ex. CS2212");
        txtCourseCode.setForeground(new Color(204, 204, 204));
        comboCourseTerm.setSelectedIndex(0);
        txtCourseName.setBorder(defaultHighlightBorder);
        txtCourseCode.setBorder(defaultHighlightBorder);
        lblCourseAddErrorLog.setText("");
        pnlAddCourse.setVisible(false);
    }//GEN-LAST:event_lblCancelCourseAdditionMouseClicked

    private void addCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCourseMouseClicked
        pnlAddCourse.setVisible(true);
        pnlCourseMenu.setVisible(false);
    }//GEN-LAST:event_addCourseMouseClicked

    private void lblAddCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddCourseMouseClicked
        String name, code, getName, getCode, info, term;
        
        txtCourseName.setBorder(defaultHighlightBorder);
        txtCourseCode.setBorder(defaultHighlightBorder);
        lblCourseAddErrorLog.setText("");
        
        getName=txtCourseName.getText();
        if (getName.equals("ex. Computer Engineering"))getName="";
        getCode=txtCourseCode.getText();
        if (getCode.equals("ex. CS2212"))getCode="";
        
        term = (String)comboCourseTerm.getSelectedItem();
        
        if(getName.equals("")||(name=elimSpaces(getName))==null)
        {
            lblCourseAddErrorLog.setText("Please enter a course name.");
            txtCourseName.setBorder(errorHighlightBorder);
        }
        else if(getCode.equals("")||(code=elimSpaces(getCode))==null)
        {
            lblCourseAddErrorLog.setText("Please enter a course code.");
            txtCourseCode.setBorder(errorHighlightBorder);
        }
        else
        {
            if(!gradebook.addCourse(name, term, code))
                lblCourseAddErrorLog.setText("Course Already exists!");
            else 
            {
                txtCourseName.setText("ex. Computer Engineering");
                txtCourseName.setForeground(new Color(204, 204, 204));
                txtCourseCode.setText("ex. CS2212");
                txtCourseCode.setForeground(new Color(204, 204, 204));
                comboCourseTerm.setSelectedIndex(0);
                pnlAddCourse.setVisible(false);
                info=name+", "+code+term;
                if (listCourses.size()==1&&listCourses.get(0).equals("No Courses"))
                listCourses.set(0, info);
                else listCourses.addElement(info);
                currCourse=new Course(name, term, code);
                updateCourseInfo();
            }
        }
    }//GEN-LAST:event_lblAddCourseMouseClicked

    private void txtCourseCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCourseCodeFocusGained
        txtCourseCode.setText("");
        txtCourseCode.setForeground(Color.black);
    }//GEN-LAST:event_txtCourseCodeFocusGained

    private void txtCourseCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCourseCodeFocusLost
        if (txtCourseCode.getText().equals(""))
        {
            txtCourseCode.setText("ex. CS2212");
            txtCourseCode.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtCourseCodeFocusLost

    private void courseMenuListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_courseMenuListValueChanged
        if (!courseMenuList.getSelectedValue().equals("No Courses"))
        {
            currCourse=gradebook.getCourse(courseMenuList.getSelectedIndex());
            updateCourseInfo();
        }
    }//GEN-LAST:event_courseMenuListValueChanged

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
    
    private String elimSpaces(String str)
    {
        int i=0;
        for ( ; i<str.length()-1;i++)
            if (str.charAt(i)!=' ')break;
        if (str.length()>1&&i+1==str.length())return null;
        return str.substring(i);
    }
    
    private void updateCourseInfo()
    {
        lblActiveCourseTitleInfo.setText(currCourse.getTitle());
        lblActiveCourseInfo.setText(currCourse.getCode()+currCourse.getTerm());
        courseName.setText(currCourse.getTitle());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCourse;
    private javax.swing.JLabel addStudent;
    private javax.swing.JComboBox comboCourseTerm;
    private javax.swing.JLayeredPane container;
    private javax.swing.JList courseMenuList;
    private javax.swing.JLabel courseName;
    private javax.swing.JScrollPane courses;
    private javax.swing.JList deliverList;
    private javax.swing.JScrollPane deliversScroll;
    private javax.swing.JLabel editCourseIcon;
    private javax.swing.JScrollPane gradesScroll;
    private javax.swing.JTable gradesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblActiveCourse;
    private javax.swing.JLabel lblActiveCourseInfo;
    private javax.swing.JLabel lblActiveCourseTitleInfo;
    private javax.swing.JLabel lblAddCourse;
    private javax.swing.JLabel lblAddCourseTitle;
    private javax.swing.JLabel lblCancelCourseAddition;
    private javax.swing.JLabel lblCourseAddErrorLog;
    private javax.swing.JLabel lblCourseCode;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblCourseTerm;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMini;
    private javax.swing.JLabel lblTabGrades;
    private javax.swing.JLabel lblTabReport;
    private javax.swing.JLabel lblTabSetup;
    private javax.swing.JLayeredPane lyrActiveCourse;
    private javax.swing.JLabel myCourses;
    private javax.swing.JPanel pnlAddCourse;
    private javax.swing.JPanel pnlAddCourseContainer;
    private javax.swing.JPanel pnlAddDeliver;
    private javax.swing.JPanel pnlAddStudent;
    private javax.swing.JPanel pnlCourseMenu;
    private javax.swing.JPanel tabGrades;
    private javax.swing.JPanel tabReports;
    private javax.swing.JPanel tabSetup;
    private javax.swing.JTextField txtCourseCode;
    private javax.swing.JTextField txtCourseName;
    // End of variables declaration//GEN-END:variables
}