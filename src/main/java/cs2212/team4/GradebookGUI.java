package cs2212.team4;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GradebookGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private Gradebook gradebook = new Gradebook();

	private Border errorHighlightBorder = BorderFactory
			.createLineBorder(Color.RED);
	private Border defaultHighlightBorder;

	private DefaultListModel<String> listCourses = new DefaultListModel<String>();
	private DefaultListModel<String> listDelivers = new DefaultListModel<String>();

	DefaultTableModel tableStudents = new DefaultTableModel();
	DefaultTableModel tableGrades = new DefaultTableModel();

	private Font helvetica = new java.awt.Font("Times New Roman", 1, 14);

	Course currCourse;

	public GradebookGUI() {
		int size;

		initComponents();
		getContentPane().setBackground(new Color(20, 150, 250));
		tabGrades.setVisible(true);
		tabSetup.setVisible(false);
		tabReports.setVisible(false);

		pnlCourseMenu.setVisible(false);

		pnlAddCourse.setBackground(new Color(20, 150, 250));
		pnlAddDeliver.setBackground(new Color(20, 150, 250));
		pnlAddStudent.setBackground(new Color(20, 150, 250));

		pnlAddCourse.setVisible(false);
		pnlAddDeliver.setVisible(false);
		pnlAddStudent.setVisible(false);

		defaultHighlightBorder = txtCourseName.getBorder();
		try {
			InputStream is = new FileInputStream("/cs2212/team4/helvetica.ttf");
			helvetica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FileNotFoundException e) {
		} catch (FontFormatException e) {
		} catch (IOException e) {
		}

		if (helvetica != null) {
			helvetica = helvetica.deriveFont(0, 16);
			lblActiveCourseTitleInfo.setFont(helvetica);
			helvetica = helvetica.deriveFont(0, 20);
			lblGrades.setFont(helvetica);
			lblSetup.setFont(helvetica);
			lblReports.setFont(helvetica);
		}

		Course crs;
		if ((size = gradebook.getCourseListSize()) > 0)
			for (int i = 0; i < size; i++) {
				crs = gradebook.getCourse(i);
				listCourses.addElement(crs.getTitle() + ", " + crs.getCode()
						+ crs.getTerm());
			}
		else
			listCourses.addElement("No Courses");

		studentTable.setModel(tableStudents);
		tableStudents.addColumn("First Name");
		tableStudents.addColumn("Last Name");
		tableStudents.addColumn("Number");
		tableStudents.addColumn("Email");

		gradesTable.setModel(tableGrades);

		addCourse.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
		addDeliver.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
		addStudent.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
		deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
		deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
		deleteDeliver.setVisible(false);
		deleteStudent.setVisible(false);
	}

	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGrades = new javax.swing.JLabel();
        lblTabGrades = new javax.swing.JLabel();
        lblSetup = new javax.swing.JLabel();
        lblTabSetup = new javax.swing.JLabel();
        lblReports = new javax.swing.JLabel();
        lblTabReport = new javax.swing.JLabel();
        lblMini = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        myCourses = new javax.swing.JLabel();
        pnlCourseMenu = new javax.swing.JPanel();
        courses = new javax.swing.JScrollPane();
        courseMenuList = new javax.swing.JList(listCourses);
        addCourse = new javax.swing.JLabel();
        pnlAddCourse = new javax.swing.JPanel();
        pnlAddCourseContainer = new javax.swing.JPanel();
        lblAddCourseTitle = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        lblCourseCode = new javax.swing.JLabel();
        txtCourseCode = new javax.swing.JTextField();
        lblCourseTerm = new javax.swing.JLabel();
        comboCourseTerm = new javax.swing.JComboBox();
        lblCourseAddErrorLog = new javax.swing.JLabel();
        lblAddCourse = new javax.swing.JLabel();
        lblCancelCourseAddition = new javax.swing.JLabel();
        pnlAddDeliver = new javax.swing.JPanel();
        pnlAddDeliverContainer = new javax.swing.JPanel();
        lblAddDeliverTitle = new javax.swing.JLabel();
        lblDeliverName = new javax.swing.JLabel();
        txtDeliverName = new javax.swing.JTextField();
        lblDeliverWeight = new javax.swing.JLabel();
        txtDeliverWeight = new javax.swing.JTextField();
        lblDeliverType = new javax.swing.JLabel();
        comboDeliverType = new javax.swing.JComboBox();
        lblDeliverAddErrorLog = new javax.swing.JLabel();
        lblAddDeliver = new javax.swing.JLabel();
        lblCancelDeliverAddition = new javax.swing.JLabel();
        pnlAddStudent = new javax.swing.JPanel();
        pnlAddStudentContainer = new javax.swing.JPanel();
        lblAddStudentTitle = new javax.swing.JLabel();
        lblStudentNameFirst = new javax.swing.JLabel();
        txtStudentNameFirst = new javax.swing.JTextField();
        lblStudentNameLast = new javax.swing.JLabel();
        txtStudentNameLast = new javax.swing.JTextField();
        lblStudentNumber = new javax.swing.JLabel();
        txtStudentNumber = new javax.swing.JTextField();
        lblStudentEmail = new javax.swing.JLabel();
        txtStudentEmail = new javax.swing.JTextField();
        lblStudentAddErrorLog = new javax.swing.JLabel();
        lblAddStudent = new javax.swing.JLabel();
        lblCancelStudentAddition = new javax.swing.JLabel();
        container = new javax.swing.JLayeredPane();
        tabGrades = new javax.swing.JPanel();
        deliversScroll = new javax.swing.JScrollPane();
        deliverList = new javax.swing.JList(listDelivers);
        courseName = new javax.swing.JLabel();
        editCourseIcon = new javax.swing.JLabel();
        addDeliver = new javax.swing.JLabel();
        addStudent = new javax.swing.JLabel();
        pnlTables = new javax.swing.JPanel();
        studentScroll = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        gradesScroll = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        deleteDeliver = new javax.swing.JLabel();
        deleteStudent = new javax.swing.JLabel();
        tabSetup = new javax.swing.JPanel();
        lblEditCourseTtile = new javax.swing.JLabel();
        lblEditCourseCode = new javax.swing.JLabel();
        lblEditCourseTerm = new javax.swing.JLabel();
        comboEditCourseTerm = new javax.swing.JComboBox();
        txtEditCourseTitle = new javax.swing.JTextField();
        txtEditCourseCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblEditCourseErrorLog = new javax.swing.JLabel();
        lblEditCourse = new javax.swing.JLabel();
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

        lblGrades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGrades.setText("Grades");
        lblGrades.setPreferredSize(new java.awt.Dimension(125, 40));
        getContentPane().add(lblGrades, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/tabOn.png"))); // NOI18N
        lblTabGrades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTabGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabGradesMouseClicked(evt);
            }
        });
        getContentPane().add(lblTabGrades, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblSetup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetup.setText("Setup");
        lblSetup.setPreferredSize(new java.awt.Dimension(125, 40));
        getContentPane().add(lblSetup, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 60, 125, 40));

        lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/tabOff.png"))); // NOI18N
        lblTabSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTabSetup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTabSetupMouseClicked(evt);
            }
        });
        getContentPane().add(lblTabSetup, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 60, -1, -1));

        lblReports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReports.setText("Reports");
        lblReports.setPreferredSize(new java.awt.Dimension(125, 40));
        getContentPane().add(lblReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/tabOff.png"))); // NOI18N
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
        });
        getContentPane().add(lblMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, -1));

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
        getContentPane().add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1074, 0, -1, -1));

        myCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/myCourses.png"))); // NOI18N
        myCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        myCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myCoursesMouseClicked(evt);
            }
        });
        getContentPane().add(myCourses, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, -1, -1));

        pnlCourseMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlCourseMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        courses.setBorder(null);

        courseMenuList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        courseMenuList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseMenuList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                courseMenuListValueChanged(evt);
            }
        });
        courses.setViewportView(courseMenuList);

        addCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addCourse.png"))); // NOI18N
        addCourse.setText("Add Course");
        addCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourse.setPreferredSize(new java.awt.Dimension(110, 30));
        addCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addCourseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addCourseMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlCourseMenuLayout = new javax.swing.GroupLayout(pnlCourseMenu);
        pnlCourseMenu.setLayout(pnlCourseMenuLayout);
        pnlCourseMenuLayout.setHorizontalGroup(
            pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(courses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );
        pnlCourseMenuLayout.setVerticalGroup(
            pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCourseMenuLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(pnlCourseMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCourseMenuLayout.createSequentialGroup()
                    .addComponent(courses, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 57, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlCourseMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 250, 310));

        pnlAddCourse.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddCourse.setPreferredSize(new java.awt.Dimension(350, 250));

        pnlAddCourseContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddCourseContainer.setPreferredSize(new java.awt.Dimension(340, 225));

        lblAddCourseTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAddCourseTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddCourseTitle.setText("Add a New Course");
        lblAddCourseTitle.setPreferredSize(new java.awt.Dimension(150, 22));

        lblCourseName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseName.setText("Course Title:");
        lblCourseName.setToolTipText("");
        lblCourseName.setPreferredSize(new java.awt.Dimension(150, 30));

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

        lblCourseCode.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseCode.setText("Course Code:");
        lblCourseCode.setToolTipText("");
        lblCourseCode.setPreferredSize(new java.awt.Dimension(150, 30));

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

        lblCourseTerm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCourseTerm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCourseTerm.setText("Course Term:");
        lblCourseTerm.setToolTipText("");

        comboCourseTerm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "E", "F", "G", "R", "S", "T", "W", "X", "Y", "Z" }));
        comboCourseTerm.setPreferredSize(new java.awt.Dimension(80, 30));

        lblCourseAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

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

        javax.swing.GroupLayout pnlAddCourseContainerLayout = new javax.swing.GroupLayout(pnlAddCourseContainer);
        pnlAddCourseContainer.setLayout(pnlAddCourseContainerLayout);
        pnlAddCourseContainerLayout.setHorizontalGroup(
            pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                .addComponent(lblAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCancelCourseAddition, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddCourseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCourseAddErrorLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                        .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCourseName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(lblCourseCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(lblCourseTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCourseCode)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                                .addComponent(comboCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(pnlAddCourseContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAddCourseContainerLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
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
                .addComponent(pnlAddCourseContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlAddCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1, -1));

        pnlAddDeliver.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddDeliver.setDoubleBuffered(false);
        pnlAddDeliver.setPreferredSize(new java.awt.Dimension(350, 250));
        pnlAddDeliver.setVerifyInputWhenFocusTarget(false);

        pnlAddDeliverContainer.setBackground(new java.awt.Color(255, 255, 255));

        lblAddDeliverTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAddDeliverTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddDeliverTitle.setText("Add a New Deliverable");

        lblDeliverName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDeliverName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDeliverName.setText("Deliverable Name:");
        lblDeliverName.setToolTipText("");

        txtDeliverName.setForeground(new java.awt.Color(204, 204, 204));
        txtDeliverName.setText("ex. Group Project");
        txtDeliverName.setPreferredSize(new java.awt.Dimension(150, 30));
        txtDeliverName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDeliverNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDeliverNameFocusLost(evt);
            }
        });

        lblDeliverWeight.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDeliverWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDeliverWeight.setText("Deliverable Weight");
        lblDeliverWeight.setToolTipText("");

        txtDeliverWeight.setForeground(new java.awt.Color(204, 204, 204));
        txtDeliverWeight.setText("ex. 0.54");
        txtDeliverWeight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDeliverWeightFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDeliverWeightFocusLost(evt);
            }
        });

        lblDeliverType.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDeliverType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDeliverType.setText("Deliverable Type:");
        lblDeliverType.setToolTipText("");

        comboDeliverType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Other", "Exam", "Assignment" }));

        lblDeliverAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

        lblAddDeliver.setBackground(new java.awt.Color(255, 255, 255));
        lblAddDeliver.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblAddDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddDeliver.setText("Add");
        lblAddDeliver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddDeliver.setOpaque(true);
        lblAddDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddDeliverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddDeliverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddDeliverMouseExited(evt);
            }
        });

        lblCancelDeliverAddition.setBackground(new java.awt.Color(255, 255, 255));
        lblCancelDeliverAddition.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCancelDeliverAddition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelDeliverAddition.setText("Cancel");
        lblCancelDeliverAddition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelDeliverAddition.setOpaque(true);
        lblCancelDeliverAddition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelDeliverAdditionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelDeliverAdditionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelDeliverAdditionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlAddDeliverContainerLayout = new javax.swing.GroupLayout(pnlAddDeliverContainer);
        pnlAddDeliverContainer.setLayout(pnlAddDeliverContainerLayout);
        pnlAddDeliverContainerLayout.setHorizontalGroup(
            pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddDeliverContainerLayout.createSequentialGroup()
                .addComponent(lblAddDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCancelDeliverAddition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlAddDeliverContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddDeliverContainerLayout.createSequentialGroup()
                        .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDeliverWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDeliverType)
                            .addComponent(lblDeliverName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeliverName, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtDeliverWeight)
                            .addGroup(pnlAddDeliverContainerLayout.createSequentialGroup()
                                .addComponent(comboDeliverType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(lblAddDeliverTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDeliverAddErrorLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAddDeliverContainerLayout.setVerticalGroup(
            pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddDeliverContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAddDeliverTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeliverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeliverName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDeliverWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblDeliverWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDeliverType, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(comboDeliverType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                .addComponent(lblDeliverAddErrorLog, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddDeliverContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCancelDeliverAddition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlAddDeliverLayout = new javax.swing.GroupLayout(pnlAddDeliver);
        pnlAddDeliver.setLayout(pnlAddDeliverLayout);
        pnlAddDeliverLayout.setHorizontalGroup(
            pnlAddDeliverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddDeliverLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddDeliverContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        pnlAddDeliverLayout.setVerticalGroup(
            pnlAddDeliverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddDeliverLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddDeliverContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlAddDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1, -1));

        pnlAddStudent.setPreferredSize(new java.awt.Dimension(350, 250));

        pnlAddStudentContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlAddStudentContainer.setPreferredSize(new java.awt.Dimension(340, 225));

        lblAddStudentTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblAddStudentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddStudentTitle.setText("Add a New Student");

        lblStudentNameFirst.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblStudentNameFirst.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStudentNameFirst.setText("Student First Name:");
        lblStudentNameFirst.setToolTipText("");
        lblStudentNameFirst.setPreferredSize(new java.awt.Dimension(150, 30));

        txtStudentNameFirst.setForeground(new java.awt.Color(204, 204, 204));
        txtStudentNameFirst.setText("ex. John");
        txtStudentNameFirst.setPreferredSize(new java.awt.Dimension(150, 30));
        txtStudentNameFirst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStudentNameFirstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentNameFirstFocusLost(evt);
            }
        });

        lblStudentNameLast.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblStudentNameLast.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStudentNameLast.setText("Student Last Name:");
        lblStudentNameLast.setToolTipText("");
        lblStudentNameLast.setPreferredSize(new java.awt.Dimension(150, 30));

        txtStudentNameLast.setForeground(new java.awt.Color(204, 204, 204));
        txtStudentNameLast.setText("ex. Doe");
        txtStudentNameLast.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStudentNameLastFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentNameLastFocusLost(evt);
            }
        });

        lblStudentNumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblStudentNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStudentNumber.setText("Student Number:");
        lblStudentNumber.setToolTipText("");

        txtStudentNumber.setForeground(new java.awt.Color(204, 204, 204));
        txtStudentNumber.setText("ex. 250626000");
        txtStudentNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStudentNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentNumberFocusLost(evt);
            }
        });

        lblStudentEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblStudentEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStudentEmail.setText("Student Email:");
        lblStudentEmail.setToolTipText("");

        txtStudentEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtStudentEmail.setText("ex. john-doe@example.com");
        txtStudentEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStudentEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStudentEmailFocusLost(evt);
            }
        });

        lblStudentAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

        lblAddStudent.setBackground(new java.awt.Color(255, 255, 255));
        lblAddStudent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblAddStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddStudent.setText("Add");
        lblAddStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddStudent.setOpaque(true);
        lblAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddStudentMouseExited(evt);
            }
        });

        lblCancelStudentAddition.setBackground(new java.awt.Color(255, 255, 255));
        lblCancelStudentAddition.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCancelStudentAddition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancelStudentAddition.setText("Cancel");
        lblCancelStudentAddition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancelStudentAddition.setOpaque(true);
        lblCancelStudentAddition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelStudentAdditionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelStudentAdditionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelStudentAdditionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlAddStudentContainerLayout = new javax.swing.GroupLayout(pnlAddStudentContainer);
        pnlAddStudentContainer.setLayout(pnlAddStudentContainerLayout);
        pnlAddStudentContainerLayout.setHorizontalGroup(
            pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddStudentContainerLayout.createSequentialGroup()
                .addComponent(lblAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCancelStudentAddition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlAddStudentContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddStudentTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAddStudentContainerLayout.createSequentialGroup()
                        .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblStudentEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStudentNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStudentNameFirst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStudentNameLast, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStudentEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStudentNameLast)
                            .addComponent(txtStudentNameFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtStudentNumber)))
                    .addComponent(lblStudentAddErrorLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAddStudentContainerLayout.setVerticalGroup(
            pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddStudentContainerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblAddStudentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentNameFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStudentNameFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentNameLast, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStudentNameLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblStudentAddErrorLog, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAddStudentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCancelStudentAddition, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlAddStudentLayout = new javax.swing.GroupLayout(pnlAddStudent);
        pnlAddStudent.setLayout(pnlAddStudentLayout);
        pnlAddStudentLayout.setHorizontalGroup(
            pnlAddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddStudentLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddStudentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        pnlAddStudentLayout.setVerticalGroup(
            pnlAddStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddStudentLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAddStudentContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1, -1));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setOpaque(true);
        container.setPreferredSize(new java.awt.Dimension(1080, 500));

        tabGrades.setBackground(new java.awt.Color(255, 255, 255));
        tabGrades.setPreferredSize(new java.awt.Dimension(1080, 490));

        deliverList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        deliverList.setPreferredSize(new java.awt.Dimension(35, 80));
        deliverList.setVisibleRowCount(10);
        deliverList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                deliverListValueChanged(evt);
            }
        });
        deliversScroll.setViewportView(deliverList);

        courseName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        courseName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/course.png"))); // NOI18N
        courseName.setText("Select a course");
        courseName.setPreferredSize(new java.awt.Dimension(200, 24));

        editCourseIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editCourseIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/settings.png"))); // NOI18N
        editCourseIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editCourseIcon.setPreferredSize(new java.awt.Dimension(40, 40));
        editCourseIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editCourseIconMouseClicked(evt);
            }
        });

        addDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addDeliver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addDeliver.png"))); // NOI18N
        addDeliver.setText("Add Deliverable");
        addDeliver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addDeliver.setMaximumSize(new java.awt.Dimension(95, 40));
        addDeliver.setMinimumSize(new java.awt.Dimension(95, 40));
        addDeliver.setPreferredSize(new java.awt.Dimension(110, 30));
        addDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addDeliverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addDeliverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addDeliverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addDeliverMousePressed(evt);
            }
        });

        addStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/addStudent.png"))); // NOI18N
        addStudent.setText("Add Student");
        addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudent.setPreferredSize(new java.awt.Dimension(110, 30));
        addStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addStudentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addStudentMousePressed(evt);
            }
        });

        pnlTables.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlTables.setPreferredSize(new java.awt.Dimension(825, 440));

        studentScroll.setBackground(new java.awt.Color(255, 255, 255));
        studentScroll.setBorder(null);

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Number", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        studentTable.setGridColor(new java.awt.Color(255, 255, 255));
        studentTable.setOpaque(false);
        studentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        studentScroll.setViewportView(studentTable);

        gradesScroll.setBackground(new java.awt.Color(255, 255, 255));
        gradesScroll.setBorder(null);

        gradesTable.setAutoCreateRowSorter(true);
        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                null, null, null, null
            }
        ));
        gradesTable.setToolTipText("");
        gradesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        gradesTable.setGridColor(new java.awt.Color(255, 255, 255));
        gradesTable.setOpaque(false);
        gradesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gradesScroll.setViewportView(gradesTable);

        javax.swing.GroupLayout pnlTablesLayout = new javax.swing.GroupLayout(pnlTables);
        pnlTables.setLayout(pnlTablesLayout);
        pnlTablesLayout.setHorizontalGroup(
            pnlTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablesLayout.createSequentialGroup()
                .addComponent(studentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(gradesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );
        pnlTablesLayout.setVerticalGroup(
            pnlTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradesScroll)
            .addComponent(studentScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        deleteDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteDeliver.setText("Delete Deliverable");
        deleteDeliver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteDeliver.setPreferredSize(new java.awt.Dimension(110, 30));
        deleteDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteDeliverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteDeliverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteDeliverMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteDeliverMousePressed(evt);
            }
        });

        deleteStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteStudent.setText("Delete Student");
        deleteStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteStudent.setPreferredSize(new java.awt.Dimension(110, 30));
        deleteStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteStudentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteStudentMousePressed(evt);
            }
        });

        javax.swing.GroupLayout tabGradesLayout = new javax.swing.GroupLayout(tabGrades);
        tabGrades.setLayout(tabGradesLayout);
        tabGradesLayout.setHorizontalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabGradesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCourseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addDeliver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteDeliver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(deliversScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabGradesLayout.setVerticalGroup(
            tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabGradesLayout.createSequentialGroup()
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabGradesLayout.createSequentialGroup()
                        .addComponent(deliversScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteDeliver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabGradesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );

        tabSetup.setBackground(new java.awt.Color(255, 255, 255));
        tabSetup.setPreferredSize(new java.awt.Dimension(1080, 500));

        lblEditCourseTtile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEditCourseTtile.setText("Course Title:");
        lblEditCourseTtile.setPreferredSize(new java.awt.Dimension(120, 30));

        lblEditCourseCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEditCourseCode.setText("Course Code:");
        lblEditCourseCode.setPreferredSize(new java.awt.Dimension(120, 30));

        lblEditCourseTerm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEditCourseTerm.setText("Course Term:");
        lblEditCourseTerm.setPreferredSize(new java.awt.Dimension(120, 30));

        comboEditCourseTerm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B", "E", "F", "G", "R", "S", "T", "W", "X", "Y", "Z" }));
        comboEditCourseTerm.setPreferredSize(new java.awt.Dimension(80, 30));

        txtEditCourseTitle.setForeground(new java.awt.Color(204, 204, 204));
        txtEditCourseTitle.setText("Please select a course");
        txtEditCourseTitle.setPreferredSize(new java.awt.Dimension(120, 30));
        txtEditCourseTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEditCourseTitleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEditCourseTitleFocusLost(evt);
            }
        });

        txtEditCourseCode.setForeground(new java.awt.Color(204, 204, 204));
        txtEditCourseCode.setText("Please select a course");
        txtEditCourseCode.setPreferredSize(new java.awt.Dimension(120, 30));
        txtEditCourseCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEditCourseCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEditCourseCodeFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Course Setup:");

        lblEditCourseErrorLog.setForeground(new java.awt.Color(255, 0, 0));
        lblEditCourseErrorLog.setPreferredSize(new java.awt.Dimension(330, 30));

        lblEditCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEditCourse.setText("Submit Changes");
        lblEditCourse.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        lblEditCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditCourse.setPreferredSize(new java.awt.Dimension(330, 30));
        lblEditCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditCourseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEditCourseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblEditCourseMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout tabSetupLayout = new javax.swing.GroupLayout(tabSetup);
        tabSetup.setLayout(tabSetupLayout);
        tabSetupLayout.setHorizontalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblEditCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabSetupLayout.createSequentialGroup()
                        .addComponent(lblEditCourseTtile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEditCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabSetupLayout.createSequentialGroup()
                        .addComponent(lblEditCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEditCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabSetupLayout.createSequentialGroup()
                        .addComponent(lblEditCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comboEditCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEditCourseErrorLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(740, Short.MAX_VALUE))
        );
        tabSetupLayout.setVerticalGroup(
            tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSetupLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditCourseTtile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(tabSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEditCourseTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEditCourseErrorLog, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblEditCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        tabReports.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tabReportsLayout = new javax.swing.GroupLayout(tabReports);
        tabReports.setLayout(tabReportsLayout);
        tabReportsLayout.setHorizontalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        tabReportsLayout.setVerticalGroup(
            tabReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabSetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabReports, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addComponent(tabGrades, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabSetup, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(containerLayout.createSequentialGroup()
                    .addComponent(tabGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        container.setLayer(tabGrades, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabSetup, javax.swing.JLayeredPane.DEFAULT_LAYER);
        container.setLayer(tabReports, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 490));

        lyrActiveCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblActiveCourseTitleInfo.setFont(helvetica);
        lblActiveCourseTitleInfo.setText("Select a course");
        lyrActiveCourse.add(lblActiveCourseTitleInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 160, 40));

        lblActiveCourseInfo.setForeground(new java.awt.Color(204, 204, 204));
        lyrActiveCourse.add(lblActiveCourseInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 150, 20));

        lblActiveCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs2212/team4/activeCourseTab.png"))); // NOI18N
        lyrActiveCourse.add(lblActiveCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        getContentPane().add(lyrActiveCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 660, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int bool=2;
    Color color=Color.lightGray;
    private void txtEditCourseTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditCourseTitleFocusGained
        txtEditCourseTitle.setForeground(Color.black);
        txtEditCourseTitle.select(0, txtEditCourseTitle.getText().length());
    }//GEN-LAST:event_txtEditCourseTitleFocusGained

    private void txtEditCourseTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditCourseTitleFocusLost
        if (currCourse==null)lblEditCourseErrorLog.setText("Please select a course.");
        else if (txtEditCourseTitle.getText().equals(currCourse.getTitle()))
        {
            txtEditCourseTitle.setForeground(Color.lightGray);
            lblEditCourseErrorLog.setText("");
        }
    }//GEN-LAST:event_txtEditCourseTitleFocusLost

    private void txtEditCourseCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditCourseCodeFocusGained
        txtEditCourseCode.setForeground(Color.black);
        txtEditCourseCode.select(0, txtEditCourseCode.getText().length());
    }//GEN-LAST:event_txtEditCourseCodeFocusGained

    private void txtEditCourseCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditCourseCodeFocusLost
        if (currCourse==null)lblEditCourseErrorLog.setText("Please select a course.");
        else if (txtEditCourseCode.getText().equals(currCourse.getCode()))
        {
            txtEditCourseCode.setForeground(Color.lightGray);
            lblEditCourseErrorLog.setText("");
        }     
    }//GEN-LAST:event_txtEditCourseCodeFocusLost

    private void lblEditCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCourseMouseClicked
        if (bool==1)
        {
            currCourse.setTitle(txtEditCourseTitle.getText());
            currCourse.setCode(txtEditCourseCode.getText());
            currCourse.setTerm((String)comboEditCourseTerm.getSelectedItem());   
        }
        updateInfo();
    }//GEN-LAST:event_lblEditCourseMouseClicked

    private void lblEditCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCourseMouseEntered
        if (currCourse!=null&&(!currCourse.getTitle().equals(txtEditCourseTitle.getText())||!currCourse.getCode().equals(txtEditCourseCode.getText())
                ||!currCourse.getTerm().equals(comboEditCourseTerm.getSelectedItem())))
        {
            int i=gradebook.findCourse(new Course(txtEditCourseTitle.getText(), (String)comboEditCourseTerm.getSelectedItem(), txtEditCourseCode.getText()));
            if (i==-1)
            {
                lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(51, 255,51)));
                bool=1;
            }
            else
            {
                lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(255, 51,51)));
                bool=0;
            }
        }
        else
        {
            lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(204, 204,204)));
            bool=2;
        }
    }//GEN-LAST:event_lblEditCourseMouseEntered

    private void lblEditCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCourseMouseExited
        lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(204, 204,204)));
    }//GEN-LAST:event_lblEditCourseMouseExited

    private void lblEditCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCourseMousePressed
        if (bool==0)color=new Color(255,51,51);
        else if (bool==1)color=new Color(51,255,51);
        else color=new Color(204,204,204);
        lblEditCourse.setBorder(BorderFactory.createBevelBorder(1, color, color, color, color));
    }//GEN-LAST:event_lblEditCourseMousePressed

    private void lblEditCourseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditCourseMouseReleased
        color=new Color(204,204,204);
        lblEditCourse.setBorder(BorderFactory.createBevelBorder(1, color, color, color, color));
    }//GEN-LAST:event_lblEditCourseMouseReleased

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Tabs
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	private void lblTabGradesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabGradesMouseClicked
		hideMenu();
		lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOn.png")));
		lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		if (!tabGrades.isVisible()) {
			tabGrades.setVisible(true);
			tabSetup.setVisible(false);
			tabReports.setVisible(false);
		}
	}// GEN-LAST:event_lblTabGradesMouseClicked

	private void lblTabSetupMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabSetupMouseClicked
		hideMenu();
		lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOn.png")));
		lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		if (!tabSetup.isVisible()) {
			tabGrades.setVisible(false);
			tabSetup.setVisible(true);
			tabReports.setVisible(false);
		}
	}// GEN-LAST:event_lblTabSetupMouseClicked

	private void lblTabReportMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabReportMouseClicked
		hideMenu();
		lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOn.png")));
		if (!tabReports.isVisible()) {
			tabGrades.setVisible(false);
			tabSetup.setVisible(false);
			tabReports.setVisible(true);
		}
	}// GEN-LAST:event_lblTabReportMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Tabs
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Drag
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */
	Point inCoords;

	private void formMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseDragged
		hideMenu();
		java.awt.Point currCoords = evt.getLocationOnScreen();
		setLocation(currCoords.x - inCoords.x, currCoords.y - inCoords.y);
	}// GEN-LAST:event_formMouseDragged

	private void formMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMousePressed
		inCoords = evt.getLocationOnScreen();
	}// GEN-LAST:event_formMousePressed

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Drag
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Minimize
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	private void lblMiniMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMiniMouseEntered
		lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/miniOn.png")));
	}// GEN-LAST:event_lblMiniMouseEntered

	private void lblMiniMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMiniMouseExited
		lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/miniOff.png")));
	}// GEN-LAST:event_lblMiniMouseExited

	private void lblMiniMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMiniMouseClicked
		hideMenu();
		setState(Frame.ICONIFIED);
	}// GEN-LAST:event_lblMiniMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Minimize
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Exit
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExitMouseEntered
		lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/exitOn.png")));
	}// GEN-LAST:event_lblExitMouseEntered

	private void lblExitMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExitMouseExited
		lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/exitOff.png")));
	}// GEN-LAST:event_lblExitMouseExited

	private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExitMouseClicked
		gradebook.store();
		System.exit(0);
	}// GEN-LAST:event_lblExitMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Exit
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: My Courses Menu
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */
	private void myCoursesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_myCoursesMouseClicked
		if (!pnlCourseMenu.isVisible())
			pnlCourseMenu.setVisible(true);
		else
			pnlCourseMenu.setVisible(false);
	}// GEN-LAST:event_myCoursesMouseClicked

	private void formMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseClicked
		hideMenu();
	}// GEN-LAST:event_formMouseClicked

	private void addCourseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addCourseMouseClicked
		hideMenu();
		restPnlCourse();
		restPnlDeliver();
		restPnlStudent();
		pnlAddCourse.setVisible(true);
	}// GEN-LAST:event_addCourseMouseClicked

	private void addCourseMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addCourseMouseEntered
		addCourse.setBorder(BorderFactory.createLineBorder(new Color(51, 255,
				51)));
	}// GEN-LAST:event_addCourseMouseEntered

	private void addCourseMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addCourseMouseExited
		addCourse.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
	}// GEN-LAST:event_addCourseMouseExited

	private void addCourseMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addCourseMousePressed
		addCourse.setBorder(BorderFactory.createBevelBorder(1, new Color(51,
				255, 51), new Color(51, 255, 51), new Color(51, 255, 51),
				new Color(51, 255, 51)));
	}// GEN-LAST:event_addCourseMousePressed

	private void courseMenuListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_courseMenuListValueChanged
		hideMenu();
		hideButtons();
		if (!courseMenuList.getSelectedValue().equals("No Courses")) {
			currCourse = gradebook.getCourse(courseMenuList.getSelectedIndex());
			updateInfo();
		}
	}// GEN-LAST:event_courseMenuListValueChanged

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: My Courses Menu
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Deliverable Side bar
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */
	private void editCourseIconMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_editCourseIconMouseClicked
		hideMenu();
		lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOn.png")));
		lblTabReport.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png")));
		if (!tabSetup.isVisible()) {
			tabGrades.setVisible(false);
			tabSetup.setVisible(true);
			tabReports.setVisible(false);
		}
	}// GEN-LAST:event_editCourseIconMouseClicked

	/** Add deliverable button **************************************************************************************/
	private void addDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseClicked
		hideMenu();
		restPnlCourse();
		restPnlDeliver();
		restPnlStudent();
		pnlAddDeliver.setVisible(true);
	}// GEN-LAST:event_addDeliverMouseClicked

	private void addDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseEntered
		addDeliver.setBorder(BorderFactory.createLineBorder(new Color(51, 255,
				51)));
	}// GEN-LAST:event_addDeliverMouseEntered

	private void addDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseExited
		addDeliver.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
	}// GEN-LAST:event_addDeliverMouseExited

	private void addDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMousePressed
		addDeliver.setBorder(BorderFactory.createBevelBorder(1, new Color(51,
				255, 51), new Color(51, 255, 51), new Color(51, 255, 51),
				new Color(51, 255, 51)));
	}// GEN-LAST:event_addDeliverMousePressed

	/** Add student button *****************************************************************************************/
	private void addStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseClicked
		hideMenu();
		restPnlCourse();
		restPnlDeliver();
		restPnlStudent();
		pnlAddStudent.setVisible(true);
	}// GEN-LAST:event_addStudentMouseClicked

	private void addStudentMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseEntered
		addStudent.setBorder(BorderFactory.createLineBorder(new Color(51, 255,
				51)));
	}// GEN-LAST:event_addStudentMouseEntered

	private void addStudentMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseExited
		addStudent.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
	}// GEN-LAST:event_addStudentMouseExited

	private void addStudentMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMousePressed
		addStudent.setBorder(BorderFactory.createBevelBorder(1, new Color(51,
				255, 51), new Color(51, 255, 51), new Color(51, 255, 51),
				new Color(51, 255, 51)));
	}// GEN-LAST:event_addStudentMousePressed

	/** Delete deliverable button **************************************************************************************/
	private void deleteDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseClicked
		String name = "", type = "", w = "", temp = listDelivers
				.getElementAt(deliverList.getSelectedIndex());
		Double weight;
		int i = 0;
		while (temp.charAt(i) != ',') {
			name += temp.charAt(i);
			i++;
		}
		i += 2;
		while (temp.charAt(i) != ',') {
			type += temp.charAt(i);
			i++;
		}
		i += 2;
		while (i < temp.length()) {
			w += temp.charAt(i);
			i++;
		}
		weight = Double.parseDouble(w);
		currCourse.removeDeliverable(currCourse
				.findDeliverable(new Deliverable(name, type, weight, 0)));
		updateInfo();
	}// GEN-LAST:event_deleteDeliverMouseClicked

	private void deleteDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseEntered
		deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(255,
				51, 51)));
	}// GEN-LAST:event_deleteDeliverMouseEntered

	private void deleteDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseExited
		deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_deleteDeliverMouseExited

	private void deleteDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMousePressed
		deleteDeliver.setBorder(BorderFactory.createBevelBorder(1, new Color(
				255, 51, 51), new Color(255, 51, 51), new Color(255, 51, 51),
				new Color(255, 51, 51)));
	}// GEN-LAST:event_deleteDeliverMousePressed

	/** Delete student button ********************************************************************************************/
	private void deleteStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseClicked
		currCourse.removeStudent(studentTable.getSelectedRow());
		updateInfo();
	}// GEN-LAST:event_deleteStudentMouseClicked

	private void deleteStudentMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseEntered
		deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(255,
				51, 51)));
	}// GEN-LAST:event_deleteStudentMouseEntered

	private void deleteStudentMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseExited
		deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_deleteStudentMouseExited

	private void deleteStudentMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMousePressed
		deleteStudent.setBorder(BorderFactory.createBevelBorder(1, new Color(
				255, 51, 51), new Color(255, 51, 51), new Color(255, 51, 51),
				new Color(255, 51, 51)));
	}// GEN-LAST:event_deleteStudentMousePressed

	/** Delete buttons visibility **************************************************************************************/
	private void deliverListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_deliverListValueChanged
		deleteDeliver.setVisible(true);
	}// GEN-LAST:event_deliverListValueChanged

	private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_studentTableMouseClicked
		deleteStudent.setVisible(true);
	}// GEN-LAST:event_studentTableMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Deliverable Side bar
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Add Courses Panel
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	private void txtCourseNameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourseNameFocusGained
		if (txtCourseName.getText().equals("")
				|| txtCourseName.getText().equals("ex. Computer Engineering"))
			txtCourseName.setText("");
		txtCourseName.setForeground(Color.black);
	}// GEN-LAST:event_txtCourseNameFocusGained

	private void txtCourseNameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourseNameFocusLost
		if (txtCourseName.getText().equals("")) {
			txtCourseName.setText("ex. Computer Engineering");
			txtCourseName.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtCourseNameFocusLost

	private void txtCourseCodeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourseCodeFocusGained
		if (txtCourseCode.getText().equals("")
				|| txtCourseCode.getText().equals("ex. CS2212"))
			txtCourseCode.setText("");
		txtCourseCode.setForeground(Color.black);
	}// GEN-LAST:event_txtCourseCodeFocusGained

	private void txtCourseCodeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourseCodeFocusLost
		if (txtCourseCode.getText().equals("")) {
			txtCourseCode.setText("ex. CS2212");
			txtCourseCode.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtCourseCodeFocusLost

	private void lblCancelCourseAdditionMouseEntered(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelCourseAdditionMouseEntered
		lblCancelCourseAddition.setBackground(new Color(255, 51, 51));
	}// GEN-LAST:event_lblCancelCourseAdditionMouseEntered

	private void lblCancelCourseAdditionMouseExited(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelCourseAdditionMouseExited
		lblCancelCourseAddition.setBackground(Color.white);
	}// GEN-LAST:event_lblCancelCourseAdditionMouseExited

	private void lblCancelCourseAdditionMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelCourseAdditionMouseClicked
		restPnlCourse();
	}// GEN-LAST:event_lblCancelCourseAdditionMouseClicked

	private void lblAddCourseMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddCourseMouseEntered
		lblAddCourse.setBackground(new Color(51, 255, 51));
	}// GEN-LAST:event_lblAddCourseMouseEntered

	private void lblAddCourseMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddCourseMouseExited
		lblAddCourse.setBackground(Color.white);
	}// GEN-LAST:event_lblAddCourseMouseExited

	private void lblAddCourseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddCourseMouseClicked
		String name, code, getName, getCode, info, term;

		txtCourseName.setBorder(defaultHighlightBorder);
		txtCourseCode.setBorder(defaultHighlightBorder);
		lblCourseAddErrorLog.setText("");

		getName = txtCourseName.getText();
		if (getName.equals("ex. Computer Engineering"))
			getName = "";

		getCode = txtCourseCode.getText();
		if (getCode.equals("ex. CS2212"))
			getCode = "";

		term = (String) comboCourseTerm.getSelectedItem();

		if (getName.equals("") || (name = elimSpaces(getName)) == null) {
			lblCourseAddErrorLog.setText("Please enter a course name.");
			txtCourseName.setBorder(errorHighlightBorder);
		} else if (getCode.equals("") || (code = elimSpaces(getCode)) == null) {
			lblCourseAddErrorLog.setText("Please enter a course code.");
			txtCourseCode.setBorder(errorHighlightBorder);
		} else {
			if (!gradebook.addCourse(name, term, code))
				lblCourseAddErrorLog.setText("Course Already exists!");
			else {
				txtCourseName.setText("ex. Computer Engineering");
				txtCourseName.setForeground(new Color(204, 204, 204));

				txtCourseCode.setText("ex. CS2212");
				txtCourseCode.setForeground(new Color(204, 204, 204));

				comboCourseTerm.setSelectedIndex(0);

				pnlAddCourse.setVisible(false);

				info = name + ", " + code + term;
				if (listCourses.size() == 1
						&& listCourses.get(0).equals("No Courses"))
					listCourses.set(0, info);
				else
					listCourses.addElement(info);

				currCourse = gradebook.getCourse(listCourses.getSize() - 1);

				courseMenuList.setSelectedIndex(listCourses.getSize() - 1);
			}
		}
	}// GEN-LAST:event_lblAddCourseMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Add Courses Panel
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Add Deliverables Panel
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	private void txtDeliverNameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtDeliverNameFocusGained
		if (txtDeliverName.getText().equals("")
				|| txtDeliverName.getText().equals("ex. Group Project"))
			txtDeliverName.setText("");
		txtDeliverName.setForeground(Color.black);
	}// GEN-LAST:event_txtDeliverNameFocusGained

	private void txtDeliverNameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtDeliverNameFocusLost
		if (txtDeliverName.getText().equals("")) {
			txtDeliverName.setText("ex. Group Project");
			txtDeliverName.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtDeliverNameFocusLost

	private void txtDeliverWeightFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtDeliverWeightFocusGained
		if (txtDeliverWeight.getText().equals("")
				|| txtDeliverWeight.getText().equals("ex. 0.54"))
			txtDeliverWeight.setText("");
		txtDeliverWeight.setForeground(Color.black);
	}// GEN-LAST:event_txtDeliverWeightFocusGained

	private void txtDeliverWeightFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtDeliverWeightFocusLost
		if (txtDeliverWeight.getText().equals("")) {
			txtDeliverWeight.setText("ex. 0.54");
			txtDeliverWeight.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtDeliverWeightFocusLost

	private void lblCancelDeliverAdditionMouseEntered(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelDeliverAdditionMouseEntered
		lblCancelDeliverAddition.setBackground(new Color(255, 51, 51));
	}// GEN-LAST:event_lblCancelDeliverAdditionMouseEntered

	private void lblCancelDeliverAdditionMouseExited(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelDeliverAdditionMouseExited
		lblCancelDeliverAddition.setBackground(Color.white);
	}// GEN-LAST:event_lblCancelDeliverAdditionMouseExited

	private void lblCancelDeliverAdditionMouseClicked(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelDeliverAdditionMouseClicked
		restPnlDeliver();
	}// GEN-LAST:event_lblCancelDeliverAdditionMouseClicked

	private void lblAddDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddDeliverMouseEntered
		lblAddDeliver.setBackground(new Color(51, 255, 51));
	}// GEN-LAST:event_lblAddDeliverMouseEntered

	private void lblAddDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddDeliverMouseExited
		lblAddDeliver.setBackground(Color.white);
	}// GEN-LAST:event_lblAddDeliverMouseExited

	private void lblAddDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddDeliverMouseClicked

		if (currCourse == null)
			lblDeliverAddErrorLog.setText("Please select a course!");
		else {
			String name, weight, getName, getWeight, info, type;
			boolean boolExists = false, boolFormat = true;

			txtDeliverName.setBorder(defaultHighlightBorder);
			txtDeliverWeight.setBorder(defaultHighlightBorder);
			lblDeliverAddErrorLog.setText("");

			getName = txtDeliverName.getText();
			if (getName.equals("ex. Group Project"))
				getName = "";

			getWeight = txtDeliverWeight.getText();
			if (getWeight.equals("ex. 0.54"))
				getWeight = "";

			type = (String) comboDeliverType.getSelectedItem();

			if (getName.equals("") || (name = elimSpaces(getName)) == null) {
				lblDeliverAddErrorLog
						.setText("Please enter a deliverable name.");
				txtDeliverName.setBorder(errorHighlightBorder);
			} else if (getWeight.equals("")
					|| (weight = elimSpaces(getWeight)) == null) {
				lblDeliverAddErrorLog
						.setText("Please enter a deliverable weight.");
				txtDeliverWeight.setBorder(errorHighlightBorder);
			} else {
				try {
					boolExists = currCourse.addDeliverable(name, type,
							Double.parseDouble(weight));
				} catch (NumberFormatException e) {
					txtDeliverWeight.setBorder(errorHighlightBorder);
					boolFormat = false;
				}

				if (!boolFormat)
					lblDeliverAddErrorLog
							.setText("Please enter a valid deliverable weight.");
				else if (!boolExists)
					lblDeliverAddErrorLog.setText("Deliver Already exists!");
				else {
					txtDeliverName.setText("ex. Group Project");
					txtDeliverName.setForeground(new Color(204, 204, 204));
					txtDeliverWeight.setText("ex. 0.54");
					txtDeliverWeight.setForeground(new Color(204, 204, 204));
					comboDeliverType.setSelectedIndex(0);
					txtDeliverName.setBorder(defaultHighlightBorder);
					txtDeliverWeight.setBorder(defaultHighlightBorder);
					lblDeliverAddErrorLog.setText("");
					pnlAddDeliver.setVisible(false);

					info = name + ", " + type + ", "
							+ Double.parseDouble(weight);
					listDelivers.addElement(info);
				}
			}
		}
	}// GEN-LAST:event_lblAddDeliverMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Add Deliverables Panel
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Add Students Panel
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */
	private void txtStudentNameFirstFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNameFirstFocusGained
		if (txtStudentNameFirst.getText().equals("")
				|| txtStudentNameFirst.getText().equals("ex. John"))
			txtStudentNameFirst.setText("");
		txtStudentNameFirst.setForeground(Color.black);
	}// GEN-LAST:event_txtStudentNameFirstFocusGained

	private void txtStudentNameFirstFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNameFirstFocusLost
		if (txtStudentNameFirst.getText().equals("")) {
			txtStudentNameFirst.setText("ex. John");
			txtStudentNameFirst.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtStudentNameFirstFocusLost

	private void txtStudentNameLastFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNameLastFocusGained
		if (txtStudentNameLast.getText().equals("")
				|| txtStudentNameLast.getText().equals("ex. Doe"))
			txtStudentNameLast.setText("");
		txtStudentNameLast.setForeground(Color.black);
	}// GEN-LAST:event_txtStudentNameLastFocusGained

	private void txtStudentNameLastFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNameLastFocusLost
		if (txtStudentNameLast.getText().equals("")) {
			txtStudentNameLast.setText("ex. Doe");
			txtStudentNameLast.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtStudentNameLastFocusLost

	private void txtStudentNumberFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNumberFocusGained
		if (txtStudentNumber.getText().equals("")
				|| txtStudentNumber.getText().equals("ex. 250626000"))
			txtStudentNumber.setText("");
		txtStudentNumber.setForeground(Color.black);
	}// GEN-LAST:event_txtStudentNumberFocusGained

	private void txtStudentNumberFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentNumberFocusLost
		if (txtStudentNumber.getText().equals("")) {
			txtStudentNumber.setText("ex. 250626000");
			txtStudentNumber.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtStudentNumberFocusLost

	private void txtStudentEmailFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentEmailFocusGained
		if (txtStudentEmail.getText().equals("")
				|| txtStudentEmail.getText().equals("ex. john-doe@example.com"))
			txtStudentEmail.setText("");
		txtStudentEmail.setForeground(Color.black);
	}// GEN-LAST:event_txtStudentEmailFocusGained

	private void txtStudentEmailFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtStudentEmailFocusLost
		if (txtStudentEmail.getText().equals("")) {
			txtStudentEmail.setText("ex. john-doe@example.com");
			txtStudentEmail.setForeground(new Color(204, 204, 204));
		}
	}// GEN-LAST:event_txtStudentEmailFocusLost

	private void lblCancelStudentAdditionMouseEntered(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelStudentAdditionMouseEntered
		lblCancelStudentAddition.setBackground(new Color(255, 51, 51));
	}// GEN-LAST:event_lblCancelStudentAdditionMouseEntered

	private void lblCancelStudentAdditionMouseExited(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblCancelStudentAdditionMouseExited
		lblCancelStudentAddition.setBackground(Color.white);
	}// GEN-LAST:event_lblCancelStudentAdditionMouseExited

	private void lblCancelStudentAdditionMouseClicked(
			java.awt.event.MouseEvent evt) {
		restPnlStudent();
	}

	private void lblAddStudentMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddStudentMouseEntered
		lblAddStudent.setBackground(new Color(51, 255, 51));
	}// GEN-LAST:event_lblAddStudentMouseEntered

	private void lblAddStudentMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddStudentMouseExited
		lblAddStudent.setBackground(Color.white);
	}// GEN-LAST:event_lblAddStudentMouseExited

	private void lblAddStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblAddStudentMouseClicked
		if (currCourse == null)
			lblStudentAddErrorLog.setText("Please select a course!");
		else {
			String nameFirst, nameLast, number, email, getNameFirst, getNameLast, getNumber, getEmail;
			boolean boolFormat = false;
			txtStudentNameFirst.setBorder(defaultHighlightBorder);
			txtStudentNameLast.setBorder(defaultHighlightBorder);
			txtStudentNumber.setBorder(defaultHighlightBorder);
			txtStudentEmail.setBorder(defaultHighlightBorder);
			lblStudentAddErrorLog.setText("");

			getNameFirst = txtStudentNameFirst.getText();
			if (getNameFirst.equals("ex. John"))
				getNameFirst = "";

			getNameLast = txtStudentNameLast.getText();
			if (getNameLast.equals("ex. Doe"))
				getNameLast = "";

			getNumber = txtStudentNumber.getText();
			if (getNumber.equals("ex. 250626000"))
				getNumber = "";

			getEmail = txtStudentEmail.getText();
			if (getEmail.equals("ex. john-doe@example.com"))
				getEmail = "";

			try {
				Integer.parseInt(getNumber);
				boolFormat = true;
			} catch (NumberFormatException e) {
				boolFormat = false;
			}

			if (getNameFirst.equals("")
					|| (nameFirst = elimSpaces(getNameFirst)) == null) {
				lblStudentAddErrorLog
						.setText("Please enter a student first name.");
				txtStudentNameFirst.setBorder(errorHighlightBorder);
			} else if (getNameLast.equals("")
					|| (nameLast = elimSpaces(getNameLast)) == null) {
				lblStudentAddErrorLog
						.setText("Please enter a student last name.");
				txtStudentNameLast.setBorder(errorHighlightBorder);
			} else if (getNumber.equals("")
					|| (number = elimSpaces(getNumber)) == null) {
				lblStudentAddErrorLog.setText("Please enter a student number.");
				txtStudentNumber.setBorder(errorHighlightBorder);
			} else if (!boolFormat) {
				lblStudentAddErrorLog
						.setText("Please enter a valid student number.");
				txtStudentNumber.setBorder(errorHighlightBorder);
			} else if (getEmail.equals("")
					|| (email = elimSpaces(getEmail)) == null) {
				lblStudentAddErrorLog.setText("Please enter a student email.");
				txtStudentEmail.setBorder(errorHighlightBorder);
			} else {
				if (!currCourse.addStudent(nameFirst, nameLast, number, email))
					lblStudentAddErrorLog.setText("Student Already exists!");
				else {
					txtStudentNameFirst.setText("ex. John");
					txtStudentNameFirst.setForeground(new Color(204, 204, 204));

					txtStudentNameLast.setText("ex. Doe");
					txtStudentNameLast.setForeground(new Color(204, 204, 204));

					txtStudentNumber.setText("ex. 250626000");
					txtStudentNumber.setForeground(new Color(204, 204, 204));

					txtStudentEmail.setText("ex. john-doe@example.com");
					txtStudentEmail.setForeground(new Color(204, 204, 204));

					txtStudentNameFirst.setBorder(defaultHighlightBorder);
					txtStudentNameLast.setBorder(defaultHighlightBorder);
					txtStudentNumber.setBorder(defaultHighlightBorder);
					txtStudentEmail.setBorder(defaultHighlightBorder);

					lblStudentAddErrorLog.setText("");
					pnlAddStudent.setVisible(false);

					tableStudents.addRow(new String[] { nameFirst, nameLast,
							number, email });
				}
			}
		}
	}// GEN-LAST:event_lblAddStudentMouseClicked

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Add Students Panel
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 * 
	 * Start: Helper Methods
	 * 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */
	private String elimSpaces(String str) {
		int i = 0;
		for (; i < str.length() - 1; i++)
			if (str.charAt(i) != ' ')
				break;
		if (i + 1 == str.length()) {

			return null;
		}
		return str.substring(i);
	}

	private void hideMenu() {
		pnlCourseMenu.setVisible(false);
	}

	private void hideButtons() {
		deleteDeliver.setVisible(false);
		deleteStudent.setVisible(false);
	}

	private void updateInfo() {
		Deliverable deliver;
		Student stud;
                Course crs;

		lblActiveCourseTitleInfo.setText(currCourse.getTitle());
		lblActiveCourseInfo
				.setText(currCourse.getCode() + currCourse.getTerm());
		courseName.setText(currCourse.getTitle());

                crs=gradebook.getCourse(courseMenuList.getSelectedIndex());
                listCourses.set(courseMenuList.getSelectedIndex(), crs.getTitle() + ", " + crs.getCode()+crs.getTerm());
                
                
		for (int i = 0; i < currCourse.getDeliverableListSize(); i++) {
			deliver = currCourse.getDeliverable(i);
			if (deliver != null) {
				listDelivers.addElement(deliver.getName() + ", "
						+ deliver.getType() + ", " + deliver.getWeight());
				tableGrades.addColumn(deliver.getName());
			}
		}
                
                
		tableStudents = new DefaultTableModel();
		studentTable.setModel(tableStudents);
		tableStudents.addColumn("First Name");
		tableStudents.addColumn("Last Name");
		tableStudents.addColumn("Number");
		tableStudents.addColumn("Email");

		tableGrades = new DefaultTableModel();
		gradesTable.setModel(tableGrades);

		for (int i = 0; i < currCourse.getStudentListSize(); i++) {
			stud = currCourse.getStudent(i);
			tableStudents.addRow(new String[] { stud.getNameFirst(),
					stud.getNameLast(), stud.getNumber(), stud.getEmail() });
		}

		deleteDeliver.setVisible(false);
		deleteStudent.setVisible(false);
                
                txtEditCourseTitle.setText(currCourse.getTitle());
                txtEditCourseCode.setText(currCourse.getCode());
                comboEditCourseTerm.setSelectedItem(currCourse.getTerm());
	}

	private void restPnlCourse() {
		txtCourseName.setText("ex. Computer Engineering");
		txtCourseName.setForeground(new Color(204, 204, 204));

		txtCourseCode.setText("ex. CS2212");
		txtCourseCode.setForeground(new Color(204, 204, 204));

		comboCourseTerm.setSelectedIndex(0);

		txtCourseName.setBorder(defaultHighlightBorder);
		txtCourseCode.setBorder(defaultHighlightBorder);

		lblCourseAddErrorLog.setText("");

		pnlAddCourse.setVisible(false);
                
                
	}

	private void restPnlDeliver() {
		txtDeliverName.setText("ex. Group Project");
		txtDeliverName.setForeground(new Color(204, 204, 204));

		txtDeliverWeight.setText("ex. 0.54");
		txtDeliverWeight.setForeground(new Color(204, 204, 204));

		comboDeliverType.setSelectedIndex(0);

		txtDeliverName.setBorder(defaultHighlightBorder);
		txtDeliverWeight.setBorder(defaultHighlightBorder);

		lblDeliverAddErrorLog.setText("");

		pnlAddDeliver.setVisible(false);
	}

	private void restPnlStudent() {
		txtStudentNameFirst.setText("ex. John");
		txtStudentNameFirst.setForeground(new Color(204, 204, 204));

		txtStudentNameLast.setText("ex. Doe");
		txtStudentNameLast.setForeground(new Color(204, 204, 204));

		txtStudentNumber.setText("ex. 250626000");
		txtStudentNumber.setForeground(new Color(204, 204, 204));

		txtStudentEmail.setText("ex. john-doe@example.com");
		txtStudentEmail.setForeground(new Color(204, 204, 204));

		txtStudentNameFirst.setBorder(defaultHighlightBorder);
		txtStudentNameLast.setBorder(defaultHighlightBorder);
		txtStudentNumber.setBorder(defaultHighlightBorder);
		txtStudentEmail.setBorder(defaultHighlightBorder);

		lblStudentAddErrorLog.setText("");
		pnlAddStudent.setVisible(false);
	}

	/*****************************************************************************************************************
	 ***************************************************************************************************************** 
	 * End: Helper Methods
	 ***************************************************************************************************************** 
	 ***************************************************************************************************************** 
	 */

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GradebookGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GradebookGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GradebookGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GradebookGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GradebookGUI().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addCourse;
    private javax.swing.JLabel addDeliver;
    private javax.swing.JLabel addStudent;
    private javax.swing.JComboBox comboCourseTerm;
    private javax.swing.JComboBox comboDeliverType;
    private javax.swing.JComboBox comboEditCourseTerm;
    private javax.swing.JLayeredPane container;
    private javax.swing.JList courseMenuList;
    private javax.swing.JLabel courseName;
    private javax.swing.JScrollPane courses;
    private javax.swing.JLabel deleteDeliver;
    private javax.swing.JLabel deleteStudent;
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
    private javax.swing.JLabel lblAddDeliver;
    private javax.swing.JLabel lblAddDeliverTitle;
    private javax.swing.JLabel lblAddStudent;
    private javax.swing.JLabel lblAddStudentTitle;
    private javax.swing.JLabel lblCancelCourseAddition;
    private javax.swing.JLabel lblCancelDeliverAddition;
    private javax.swing.JLabel lblCancelStudentAddition;
    private javax.swing.JLabel lblCourseAddErrorLog;
    private javax.swing.JLabel lblCourseCode;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblCourseTerm;
    private javax.swing.JLabel lblDeliverAddErrorLog;
    private javax.swing.JLabel lblDeliverName;
    private javax.swing.JLabel lblDeliverType;
    private javax.swing.JLabel lblDeliverWeight;
    private javax.swing.JLabel lblEditCourse;
    private javax.swing.JLabel lblEditCourseCode;
    private javax.swing.JLabel lblEditCourseErrorLog;
    private javax.swing.JLabel lblEditCourseTerm;
    private javax.swing.JLabel lblEditCourseTtile;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGrades;
    private javax.swing.JLabel lblMini;
    private javax.swing.JLabel lblReports;
    private javax.swing.JLabel lblSetup;
    private javax.swing.JLabel lblStudentAddErrorLog;
    private javax.swing.JLabel lblStudentEmail;
    private javax.swing.JLabel lblStudentNameFirst;
    private javax.swing.JLabel lblStudentNameLast;
    private javax.swing.JLabel lblStudentNumber;
    private javax.swing.JLabel lblTabGrades;
    private javax.swing.JLabel lblTabReport;
    private javax.swing.JLabel lblTabSetup;
    private javax.swing.JLayeredPane lyrActiveCourse;
    private javax.swing.JLabel myCourses;
    private javax.swing.JPanel pnlAddCourse;
    private javax.swing.JPanel pnlAddCourseContainer;
    private javax.swing.JPanel pnlAddDeliver;
    private javax.swing.JPanel pnlAddDeliverContainer;
    private javax.swing.JPanel pnlAddStudent;
    private javax.swing.JPanel pnlAddStudentContainer;
    private javax.swing.JPanel pnlCourseMenu;
    private javax.swing.JPanel pnlTables;
    private javax.swing.JScrollPane studentScroll;
    private javax.swing.JTable studentTable;
    private javax.swing.JPanel tabGrades;
    private javax.swing.JPanel tabReports;
    private javax.swing.JPanel tabSetup;
    private javax.swing.JTextField txtCourseCode;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtDeliverName;
    private javax.swing.JTextField txtDeliverWeight;
    private javax.swing.JTextField txtEditCourseCode;
    private javax.swing.JTextField txtEditCourseTitle;
    private javax.swing.JTextField txtStudentEmail;
    private javax.swing.JTextField txtStudentNameFirst;
    private javax.swing.JTextField txtStudentNameLast;
    private javax.swing.JTextField txtStudentNumber;
    // End of variables declaration//GEN-END:variables
}
