package cs2212.team4;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.*;

public class GradebookGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private Gradebook gradebook = new Gradebook();

	private Border errorHighlightBorder = BorderFactory
			.createLineBorder(Color.RED);
	private Border defaultHighlightBorder;

	private DefaultListModel<String> listCourses = new DefaultListModel<String>();
	private DefaultListModel<String> listDelivers = new DefaultListModel<String>();

	UsersTable tableStudents = new UsersTable();
	GradesTable tableGrades = tableStudents.getGradesTable();

	private Font helvetica = new java.awt.Font("Arial", 1, 10);

	Course currCourse;

	public GradebookGUI() {
		int size;

		initComponents();
		getContentPane().setBackground(new Color(20, 150, 250));
		tabGrades.setVisible(true);
		tabSetup.setVisible(false);
		tabDropbox.setVisible(false);

		pnlCourseMenu.setVisible(false);

		pnlAddCourse.setBackground(new Color(20, 150, 250));
		pnlAddDeliver.setBackground(new Color(20, 150, 250));
		pnlAddStudent.setBackground(new Color(20, 150, 250));

		pnlAddCourse.setVisible(false);
		pnlAddDeliver.setVisible(false);
		pnlAddStudent.setVisible(false);

		defaultHighlightBorder = txtCourseName.getBorder();
		try {
			InputStream is = new FileInputStream(new File(
					"/src/main/resources/cs2212/team4/helvetica.ttf"));
			helvetica = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FileNotFoundException e) {
		} catch (FontFormatException e) {
		} catch (IOException e) {
		}

		if (helvetica != null) {
			helvetica = helvetica.deriveFont(0, 16);
			lblActiveCourseTitleInfo.setFont(helvetica);
			helvetica = helvetica.deriveFont(0, 16);
			lblGrades.setFont(helvetica);
			lblSetup.setFont(helvetica);
			lblDropbox.setFont(helvetica);
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
		gradesTable.setModel(tableStudents.getGradesTable());

		deleteDeliver.setVisible(false);
		deleteStudent.setVisible(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);

		txtCourseDesc.setText("Enter a course description...");

		if (gradebook.getPrevCourse() != null) {
			currCourse = gradebook.getPrevCourse();
			courseMenuList.setSelectedIndex(gradebook.findCourse(currCourse));
		}

		updateInfo();

		lblDbxVerify.setVisible(false);
		lblDbxDownload.setVisible(false);
		lblDbxUpload.setVisible(false);
	}

	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		lblGrades = new javax.swing.JLabel();
		lblTabGrades = new javax.swing.JLabel();
		lblSetup = new javax.swing.JLabel();
		lblTabSetup = new javax.swing.JLabel();
		lblDropbox = new javax.swing.JLabel();
		lblTabDropbox = new javax.swing.JLabel();
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
		lblExportStudents = new javax.swing.JLabel();
		lblImportStudents = new javax.swing.JLabel();
		lblGradesErrorLog = new javax.swing.JLabel();
		lblFirstName = new javax.swing.JLabel();
		lblLastName = new javax.swing.JLabel();
		lblNumber = new javax.swing.JLabel();
		lblEmail = new javax.swing.JLabel();
		lblImportGrades = new javax.swing.JLabel();
		lblExportGrades = new javax.swing.JLabel();
		tabSetup = new javax.swing.JPanel();
		lblCourseSetup = new javax.swing.JLabel();
		lblEditCourseTtile = new javax.swing.JLabel();
		txtEditCourseTitle = new javax.swing.JTextField();
		lblEditCourseCode = new javax.swing.JLabel();
		txtEditCourseCode = new javax.swing.JTextField();
		lblEditCourseTerm = new javax.swing.JLabel();
		comboEditCourseTerm = new javax.swing.JComboBox();
		lblEditCourse = new javax.swing.JLabel();
		lblDeleteCourse = new javax.swing.JLabel();
		editDeliverListScroll = new javax.swing.JScrollPane();
		editDeliverList = new javax.swing.JList(listDelivers);
		lblEditDeliverName = new javax.swing.JLabel();
		lblEditDeliverWeight = new javax.swing.JLabel();
		lblEditDeliverType = new javax.swing.JLabel();
		comboEditDeliverType = new javax.swing.JComboBox();
		txtEditDeliverName = new javax.swing.JTextField();
		txtEditDeliverWeight = new javax.swing.JTextField();
		lblEditDeliver = new javax.swing.JLabel();
		lblExportDelivers = new javax.swing.JLabel();
		lblImportDelivers = new javax.swing.JLabel();
		lblCourseDeliverables = new javax.swing.JLabel();
		lblSetupErrorLog = new javax.swing.JLabel();
		courseDescScroll = new javax.swing.JScrollPane();
		txtCourseDesc = new javax.swing.JTextPane();
		lblEditAddDeliver = new javax.swing.JLabel();
		lblEditDeleteDeliver = new javax.swing.JLabel();
		tabDropbox = new javax.swing.JPanel();
		lblDbxAuthLink = new javax.swing.JLabel();
		txtDbxCode = new javax.swing.JTextField();
		lblDbxGenerate = new javax.swing.JLabel();
		lblDbxUpload = new javax.swing.JLabel();
		lblDbxDownload = new javax.swing.JLabel();
		lblDbxSubmit = new javax.swing.JLabel();
		lblDbxErrorLog = new javax.swing.JLabel();
		lblDbxVerify = new javax.swing.JLabel();
		lyrActiveCourse = new javax.swing.JLayeredPane();
		lblActiveCourseTitleInfo = new javax.swing.JLabel();
		lblActiveCourseInfo = new javax.swing.JLabel();
		lblActiveCourse = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Gradebook Application");
		setBackground(new java.awt.Color(51, 105, 232));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
		getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblGrades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblGrades.setText("Grades");
		lblGrades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblGrades.setPreferredSize(new java.awt.Dimension(125, 40));
		getContentPane().add(
				lblGrades,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1,
						-1));

		lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOn.png"))); // NOI18N
		lblTabGrades
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblTabGrades.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblTabGradesMouseClicked(evt);
			}
		});
		getContentPane().add(
				lblTabGrades,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1,
						-1));

		lblSetup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSetup.setText("Setup");
		lblSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblSetup.setPreferredSize(new java.awt.Dimension(125, 40));
		getContentPane().add(
				lblSetup,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 60, 125,
						40));

		lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png"))); // NOI18N
		lblTabSetup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblTabSetup.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblTabSetupMouseClicked(evt);
			}
		});
		getContentPane().add(
				lblTabSetup,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 60, -1,
						-1));

		lblDropbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDropbox.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/dropbox.png"))); // NOI18N
		lblDropbox.setText("Dropbox");
		lblDropbox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblDropbox.setPreferredSize(new java.awt.Dimension(125, 40));
		lblDropbox.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDropboxMouseClicked(evt);
			}
		});
		getContentPane().add(
				lblDropbox,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 125,
						40));

		lblTabDropbox.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/tabOff.png"))); // NOI18N
		lblTabDropbox
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblTabDropbox.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblTabDropboxMouseClicked(evt);
			}
		});
		getContentPane().add(
				lblTabDropbox,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1,
						-1));

		lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/miniOff.png"))); // NOI18N
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
		getContentPane().add(
				lblMini,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1,
						-1));

		lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/exitOff.png"))); // NOI18N
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
		getContentPane().add(
				lblExit,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(1074, 0, -1,
						-1));

		myCourses.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/myCourses.png"))); // NOI18N
		myCourses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		myCourses.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				myCoursesMouseClicked(evt);
			}
		});
		getContentPane().add(
				myCourses,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, -1,
						-1));

		pnlCourseMenu.setBackground(new java.awt.Color(255, 255, 255));
		pnlCourseMenu.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));

		courses.setBorder(null);

		courseMenuList.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(255, 255, 255)));
		courseMenuList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		courseMenuList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						courseMenuListValueChanged(evt);
					}
				});
		courses.setViewportView(courseMenuList);

		addCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		addCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/addCourse.png"))); // NOI18N
		addCourse.setText("Add Course");
		addCourse.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
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

		javax.swing.GroupLayout pnlCourseMenuLayout = new javax.swing.GroupLayout(
				pnlCourseMenu);
		pnlCourseMenu.setLayout(pnlCourseMenuLayout);
		pnlCourseMenuLayout
				.setHorizontalGroup(pnlCourseMenuLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlCourseMenuLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												addCourse,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												228, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								pnlCourseMenuLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(
												courses,
												javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												248, Short.MAX_VALUE)));
		pnlCourseMenuLayout
				.setVerticalGroup(pnlCourseMenuLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								pnlCourseMenuLayout
										.createSequentialGroup()
										.addContainerGap(268, Short.MAX_VALUE)
										.addComponent(
												addCourse,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10))
						.addGroup(
								pnlCourseMenuLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												pnlCourseMenuLayout
														.createSequentialGroup()
														.addComponent(
																courses,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																251,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 57,
																Short.MAX_VALUE))));

		getContentPane().add(
				pnlCourseMenu,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100,
						250, 310));

		pnlAddCourse.setBackground(new java.awt.Color(255, 255, 255));
		pnlAddCourse.setPreferredSize(new java.awt.Dimension(350, 250));

		pnlAddCourseContainer.setBackground(new java.awt.Color(255, 255, 255));
		pnlAddCourseContainer
				.setPreferredSize(new java.awt.Dimension(340, 225));

		lblAddCourseTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblAddCourseTitle
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

		comboCourseTerm.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "", "A", "B", "E", "F", "G", "R", "S", "T", "W",
						"X", "Y", "Z" }));
		comboCourseTerm.setPreferredSize(new java.awt.Dimension(80, 30));

		lblCourseAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

		lblAddCourse.setBackground(new java.awt.Color(255, 255, 255));
		lblAddCourse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblAddCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblAddCourse.setText("Add");
		lblAddCourse
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

		lblCancelCourseAddition
				.setBackground(new java.awt.Color(255, 255, 255));
		lblCancelCourseAddition.setFont(new java.awt.Font("Times New Roman", 1,
				14)); // NOI18N
		lblCancelCourseAddition
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCancelCourseAddition.setText("Cancel");
		lblCancelCourseAddition.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblCancelCourseAddition.setOpaque(true);
		lblCancelCourseAddition
				.addMouseListener(new java.awt.event.MouseAdapter() {
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

		javax.swing.GroupLayout pnlAddCourseContainerLayout = new javax.swing.GroupLayout(
				pnlAddCourseContainer);
		pnlAddCourseContainer.setLayout(pnlAddCourseContainerLayout);
		pnlAddCourseContainerLayout
				.setHorizontalGroup(pnlAddCourseContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddCourseContainerLayout
										.createSequentialGroup()
										.addComponent(
												lblAddCourse,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												165,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												lblCancelCourseAddition,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												175, Short.MAX_VALUE))
						.addGroup(
								pnlAddCourseContainerLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnlAddCourseContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lblAddCourseTitle,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																lblCourseAddErrorLog,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																pnlAddCourseContainerLayout
																		.createSequentialGroup()
																		.addGroup(
																				pnlAddCourseContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								lblCourseName,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								1,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblCourseCode,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								1,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblCourseTerm,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								120,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				pnlAddCourseContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtCourseCode)
																						.addComponent(
																								txtCourseName,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGroup(
																								pnlAddCourseContainerLayout
																										.createSequentialGroup()
																										.addComponent(
																												comboCourseTerm,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												50,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(0,
																												0,
																												Short.MAX_VALUE)))))
										.addContainerGap()));
		pnlAddCourseContainerLayout
				.setVerticalGroup(pnlAddCourseContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddCourseContainerLayout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(
												lblAddCourseTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addGroup(
												pnlAddCourseContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtCourseName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCourseName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(5, 5, 5)
										.addGroup(
												pnlAddCourseContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtCourseCode,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCourseCode,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(5, 5, 5)
										.addGroup(
												pnlAddCourseContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lblCourseTerm,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																pnlAddCourseContainerLayout
																		.createSequentialGroup()
																		.addGap(1,
																				1,
																				1)
																		.addComponent(
																				comboCourseTerm,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
												20, Short.MAX_VALUE)
										.addComponent(
												lblCourseAddErrorLog,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												27,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnlAddCourseContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblAddCourse,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCancelCourseAddition,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)));

		javax.swing.GroupLayout pnlAddCourseLayout = new javax.swing.GroupLayout(
				pnlAddCourse);
		pnlAddCourse.setLayout(pnlAddCourseLayout);
		pnlAddCourseLayout.setHorizontalGroup(pnlAddCourseLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddCourseLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddCourseContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(5, 5, 5)));
		pnlAddCourseLayout.setVerticalGroup(pnlAddCourseLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddCourseLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddCourseContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										240, Short.MAX_VALUE).addGap(5, 5, 5)));

		getContentPane().add(
				pnlAddCourse,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1,
						-1));

		pnlAddDeliver.setBackground(new java.awt.Color(255, 255, 255));
		pnlAddDeliver.setDoubleBuffered(false);
		pnlAddDeliver.setPreferredSize(new java.awt.Dimension(350, 250));
		pnlAddDeliver.setVerifyInputWhenFocusTarget(false);

		pnlAddDeliverContainer.setBackground(new java.awt.Color(255, 255, 255));

		lblAddDeliverTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblAddDeliverTitle
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
		lblDeliverWeight
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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

		comboDeliverType.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Assignment", "Exam", "Other" }));

		lblDeliverAddErrorLog.setForeground(new java.awt.Color(255, 0, 0));

		lblAddDeliver.setBackground(new java.awt.Color(255, 255, 255));
		lblAddDeliver.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblAddDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblAddDeliver.setText("Add");
		lblAddDeliver
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

		lblCancelDeliverAddition
				.setBackground(new java.awt.Color(255, 255, 255));
		lblCancelDeliverAddition.setFont(new java.awt.Font("Times New Roman",
				1, 14)); // NOI18N
		lblCancelDeliverAddition
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCancelDeliverAddition.setText("Cancel");
		lblCancelDeliverAddition.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblCancelDeliverAddition.setOpaque(true);
		lblCancelDeliverAddition
				.addMouseListener(new java.awt.event.MouseAdapter() {
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

		javax.swing.GroupLayout pnlAddDeliverContainerLayout = new javax.swing.GroupLayout(
				pnlAddDeliverContainer);
		pnlAddDeliverContainer.setLayout(pnlAddDeliverContainerLayout);
		pnlAddDeliverContainerLayout
				.setHorizontalGroup(pnlAddDeliverContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddDeliverContainerLayout
										.createSequentialGroup()
										.addComponent(
												lblAddDeliver,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												165,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												lblCancelDeliverAddition,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								pnlAddDeliverContainerLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnlAddDeliverContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																pnlAddDeliverContainerLayout
																		.createSequentialGroup()
																		.addGroup(
																				pnlAddDeliverContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								lblDeliverWeight,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblDeliverType)
																						.addComponent(
																								lblDeliverName,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(20,
																				20,
																				20)
																		.addGroup(
																				pnlAddDeliverContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtDeliverName,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								180,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtDeliverWeight)
																						.addComponent(
																								comboDeliverType,
																								0,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
														.addComponent(
																lblAddDeliverTitle,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																lblDeliverAddErrorLog,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		pnlAddDeliverContainerLayout
				.setVerticalGroup(pnlAddDeliverContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddDeliverContainerLayout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(
												lblAddDeliverTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addGroup(
												pnlAddDeliverContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtDeliverName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDeliverName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(10, 10, 10)
										.addGroup(
												pnlAddDeliverContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																txtDeliverWeight,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																28,
																Short.MAX_VALUE)
														.addComponent(
																lblDeliverWeight,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												pnlAddDeliverContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																lblDeliverType,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE)
														.addComponent(
																comboDeliverType))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
												12, Short.MAX_VALUE)
										.addComponent(
												lblDeliverAddErrorLog,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												27,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnlAddDeliverContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblAddDeliver,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCancelDeliverAddition,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)));

		javax.swing.GroupLayout pnlAddDeliverLayout = new javax.swing.GroupLayout(
				pnlAddDeliver);
		pnlAddDeliver.setLayout(pnlAddDeliverLayout);
		pnlAddDeliverLayout.setHorizontalGroup(pnlAddDeliverLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddDeliverLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddDeliverContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(5, 5, 5)));
		pnlAddDeliverLayout.setVerticalGroup(pnlAddDeliverLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddDeliverLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddDeliverContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(5, 5, 5)));

		getContentPane().add(
				pnlAddDeliver,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1,
						-1));

		pnlAddStudent.setPreferredSize(new java.awt.Dimension(350, 250));

		pnlAddStudentContainer.setBackground(new java.awt.Color(255, 255, 255));
		pnlAddStudentContainer
				.setPreferredSize(new java.awt.Dimension(340, 225));

		lblAddStudentTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblAddStudentTitle
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblAddStudentTitle.setText("Add a New Student");

		lblStudentNameFirst
				.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblStudentNameFirst
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
		lblStudentNameLast
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
		lblStudentNumber
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
		lblStudentEmail
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
		lblAddStudent
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

		lblCancelStudentAddition
				.setBackground(new java.awt.Color(255, 255, 255));
		lblCancelStudentAddition.setFont(new java.awt.Font("Times New Roman",
				1, 14)); // NOI18N
		lblCancelStudentAddition
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblCancelStudentAddition.setText("Cancel");
		lblCancelStudentAddition.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblCancelStudentAddition.setOpaque(true);
		lblCancelStudentAddition
				.addMouseListener(new java.awt.event.MouseAdapter() {
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

		javax.swing.GroupLayout pnlAddStudentContainerLayout = new javax.swing.GroupLayout(
				pnlAddStudentContainer);
		pnlAddStudentContainer.setLayout(pnlAddStudentContainerLayout);
		pnlAddStudentContainerLayout
				.setHorizontalGroup(pnlAddStudentContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddStudentContainerLayout
										.createSequentialGroup()
										.addComponent(
												lblAddStudent,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												165,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												lblCancelStudentAddition,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								pnlAddStudentContainerLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lblAddStudentTitle,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																pnlAddStudentContainerLayout
																		.createSequentialGroup()
																		.addGroup(
																				pnlAddStudentContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								lblStudentEmail,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblStudentNumber,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblStudentNameFirst,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblStudentNameLast,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(10,
																				10,
																				10)
																		.addGroup(
																				pnlAddStudentContainerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								txtStudentEmail,
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								txtStudentNameLast)
																						.addComponent(
																								txtStudentNameFirst,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								160,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtStudentNumber)))
														.addComponent(
																lblStudentAddErrorLog,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		pnlAddStudentContainerLayout
				.setVerticalGroup(pnlAddStudentContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								pnlAddStudentContainerLayout
										.createSequentialGroup()
										.addGap(5, 5, 5)
										.addComponent(
												lblAddStudentTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												35,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(5, 5, 5)
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtStudentNameFirst,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblStudentNameFirst,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(5, 5, 5)
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																txtStudentNameLast,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblStudentNameLast,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(5, 5, 5)
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblStudentNumber,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtStudentNumber,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblStudentEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtStudentEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(2, 2, 2)
										.addComponent(
												lblStudentAddErrorLog,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												20,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												pnlAddStudentContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblAddStudent,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblCancelStudentAddition,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 0, 0)));

		javax.swing.GroupLayout pnlAddStudentLayout = new javax.swing.GroupLayout(
				pnlAddStudent);
		pnlAddStudent.setLayout(pnlAddStudentLayout);
		pnlAddStudentLayout.setHorizontalGroup(pnlAddStudentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddStudentLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddStudentContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(5, 5, 5)));
		pnlAddStudentLayout.setVerticalGroup(pnlAddStudentLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						pnlAddStudentLayout
								.createSequentialGroup()
								.addGap(5, 5, 5)
								.addComponent(pnlAddStudentContainer,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										240, Short.MAX_VALUE).addGap(5, 5, 5)));

		getContentPane().add(
				pnlAddStudent,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 175, -1,
						-1));

		container.setBackground(new java.awt.Color(255, 255, 255));
		container.setPreferredSize(new java.awt.Dimension(1080, 500));

		tabGrades.setBackground(new java.awt.Color(255, 255, 255));
		tabGrades.setPreferredSize(new java.awt.Dimension(1080, 480));

		deliverList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		deliverList.setPreferredSize(new java.awt.Dimension(35, 80));
		deliverList.setVisibleRowCount(10);
		deliverList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						deliverListValueChanged(evt);
					}
				});
		deliversScroll.setViewportView(deliverList);

		courseName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		courseName.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/course.png"))); // NOI18N
		courseName.setText("Select a course");
		courseName.setPreferredSize(new java.awt.Dimension(200, 24));

		editCourseIcon
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		editCourseIcon.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/cs2212/team4/settings.png"))); // NOI18N
		editCourseIcon.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		editCourseIcon.setPreferredSize(new java.awt.Dimension(40, 40));
		editCourseIcon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				editCourseIconMouseClicked(evt);
			}
		});

		addDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		addDeliver.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/addDeliver.png"))); // NOI18N
		addDeliver.setText("Add Deliverable");
		addDeliver.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
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
		addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/addStudent.png"))); // NOI18N
		addStudent.setText("Add Student");
		addStudent.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		addStudent.setPreferredSize(new java.awt.Dimension(130, 30));
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

		pnlTables.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		pnlTables.setPreferredSize(new java.awt.Dimension(820, 350));

		studentScroll.setBackground(new java.awt.Color(255, 255, 255));
		studentScroll.setBorder(null);

		studentTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] {
						"First Name", "Last Name", "Number", "Email" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		studentTable
				.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		studentTable.setGridColor(new java.awt.Color(255, 255, 255));
		studentTable.setOpaque(false);
		studentTable
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { null,
						null, null, null }));
		gradesTable.setToolTipText("");
		gradesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
   		gradesTable.setGridColor(new java.awt.Color(255, 255, 255));
		gradesTable.setOpaque(false);
		gradesTable
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		gradesTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				gradesTableMouseClicked(evt);
			}
		});
		gradesScroll.setViewportView(gradesTable);

		javax.swing.GroupLayout pnlTablesLayout = new javax.swing.GroupLayout(
				pnlTables);
		pnlTables.setLayout(pnlTablesLayout);
		pnlTablesLayout.setHorizontalGroup(pnlTablesLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				pnlTablesLayout
						.createSequentialGroup()
						.addGap(0, 0, 0)
						.addComponent(studentScroll,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0)
						.addComponent(gradesScroll,
								javax.swing.GroupLayout.DEFAULT_SIZE, 366,
								Short.MAX_VALUE)));
		pnlTablesLayout.setVerticalGroup(pnlTablesLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(studentScroll,
						javax.swing.GroupLayout.PREFERRED_SIZE, 0,
						Short.MAX_VALUE)
				.addComponent(gradesScroll,
						javax.swing.GroupLayout.DEFAULT_SIZE, 348,
						Short.MAX_VALUE));

		deleteDeliver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		deleteDeliver.setText("Delete Deliverable");
		deleteDeliver.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		deleteDeliver
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
		deleteStudent.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		deleteStudent
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deleteStudent.setPreferredSize(new java.awt.Dimension(130, 30));
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

		lblExportStudents
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblExportStudents.setText("Export Students");
		lblExportStudents.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblExportStudents.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblExportStudents.setPreferredSize(new java.awt.Dimension(130, 30));
		lblExportStudents.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblExportStudentsMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblExportStudentsMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblExportStudentsMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblExportStudentsMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblExportStudentsMouseReleased(evt);
			}
		});

		lblImportStudents
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblImportStudents.setText("Import Students");
		lblImportStudents.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblImportStudents.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblImportStudents.setPreferredSize(new java.awt.Dimension(130, 30));
		lblImportStudents.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblImportStudentsMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblImportStudentsMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblImportStudentsMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblImportStudentsMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblImportStudentsMouseReleased(evt);
			}
		});

		lblGradesErrorLog.setForeground(new java.awt.Color(255, 0, 0));
		lblGradesErrorLog.setPreferredSize(new java.awt.Dimension(1080, 15));

		lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblFirstName.setText("First Name");
		lblFirstName.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblFirstName
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblFirstName.setPreferredSize(new java.awt.Dimension(80, 30));
		lblFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblFirstNameMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblFirstNameMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblFirstNameMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblFirstNameMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblFirstNameMouseReleased(evt);
			}
		});

		lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLastName.setText("Last Name");
		lblLastName.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblLastName.setPreferredSize(new java.awt.Dimension(80, 30));
		lblLastName.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblLastNameMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblLastNameMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblLastNameMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblLastNameMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblLastNameMouseReleased(evt);
			}
		});

		lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblNumber.setText("Number");
		lblNumber.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblNumber.setPreferredSize(new java.awt.Dimension(80, 30));
		lblNumber.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblNumberMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblNumberMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblNumberMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblNumberMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblNumberMouseReleased(evt);
			}
		});

		lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblEmail.setText("Email");
		lblEmail.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblEmail.setPreferredSize(new java.awt.Dimension(80, 30));
		lblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblEmailMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblEmailMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblEmailMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblEmailMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblEmailMouseReleased(evt);
			}
		});

		lblImportGrades
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblImportGrades.setText("Import Grades");
		lblImportGrades.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblImportGrades.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblImportGrades.setPreferredSize(new java.awt.Dimension(135, 30));
		lblImportGrades.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblImportGradesMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblImportGradesMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblImportGradesMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblImportGradesMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblImportGradesMouseReleased(evt);
			}
		});

		lblExportGrades
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblExportGrades.setText("Export Grades");
		lblExportGrades.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblExportGrades.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblExportGrades.setPreferredSize(new java.awt.Dimension(135, 30));
		lblExportGrades.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblExportGradesMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblExportGradesMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblExportGradesMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblExportGradesMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblExportGradesMouseReleased(evt);
			}
		});

		javax.swing.GroupLayout tabGradesLayout = new javax.swing.GroupLayout(
				tabGrades);
		tabGrades.setLayout(tabGradesLayout);
		tabGradesLayout
				.setHorizontalGroup(tabGradesLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								tabGradesLayout
										.createSequentialGroup()
										.addGroup(
												tabGradesLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																tabGradesLayout
																		.createSequentialGroup()
																		.addGap(10,
																				10,
																				10)
																		.addGroup(
																				tabGradesLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								tabGradesLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												addDeliver,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												deliversScroll,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												230,
																												Short.MAX_VALUE))
																						.addGroup(
																								tabGradesLayout
																										.createSequentialGroup()
																										.addComponent(
																												courseName,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												180,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												editCourseIcon,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								deleteDeliver,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								230,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(10,
																				10,
																				10)
																		.addGroup(
																				tabGradesLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								pnlTables,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								tabGradesLayout
																										.createSequentialGroup()
																										.addComponent(
																												addStudent,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(6,
																												6,
																												6)
																										.addComponent(
																												deleteStudent,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												lblExportStudents,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(6,
																												6,
																												6)
																										.addComponent(
																												lblImportStudents,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(6,
																												6,
																												6)
																										.addComponent(
																												lblExportGrades,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(6,
																												6,
																												6)
																										.addComponent(
																												lblImportGrades,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								tabGradesLayout
																										.createSequentialGroup()
																										.addComponent(
																												lblFirstName,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												lblLastName,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												lblEmail,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												lblNumber,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																tabGradesLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				lblGradesErrorLog,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		tabGradesLayout
				.setVerticalGroup(tabGradesLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								tabGradesLayout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addGroup(
												tabGradesLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																editCourseIcon,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																tabGradesLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				tabGradesLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								lblImportGrades,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblExportGrades,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				tabGradesLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								addStudent,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								deleteStudent,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblImportStudents,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblExportStudents,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																courseName,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												tabGradesLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																deliversScroll,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																350,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																pnlTables,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(5, 5, 5)
										.addGroup(
												tabGradesLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																addDeliver,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblFirstName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblLastName,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNumber,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblEmail,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(5, 5, 5)
										.addComponent(
												deleteDeliver,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)
										.addComponent(
												lblGradesErrorLog,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0)));

		tabSetup.setBackground(new java.awt.Color(255, 255, 255));
		tabSetup.setPreferredSize(new java.awt.Dimension(1080, 480));

		lblCourseSetup.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		lblCourseSetup.setText("Course Setup:");
		lblCourseSetup.setPreferredSize(new java.awt.Dimension(330, 30));

		lblEditCourseTtile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditCourseTtile
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditCourseTtile.setText("Course Title:");
		lblEditCourseTtile.setPreferredSize(new java.awt.Dimension(120, 30));

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

		lblEditCourseCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditCourseCode
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditCourseCode.setText("Course Code:");
		lblEditCourseCode.setPreferredSize(new java.awt.Dimension(120, 30));

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

		lblEditCourseTerm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditCourseTerm
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditCourseTerm.setText("Course Term:");
		lblEditCourseTerm.setPreferredSize(new java.awt.Dimension(120, 30));

		comboEditCourseTerm.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "", "A", "B", "E", "F", "G", "R", "S", "T", "W",
						"X", "Y", "Z" }));
		comboEditCourseTerm.setPreferredSize(new java.awt.Dimension(80, 30));

		lblEditCourse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblEditCourse.setText("Submit Changes");
		lblEditCourse.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblEditCourse
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblEditCourse.setPreferredSize(new java.awt.Dimension(200, 30));
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

		lblDeleteCourse
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDeleteCourse.setText("Delete Course");
		lblDeleteCourse.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(204, 204, 204)));
		lblDeleteCourse.setPreferredSize(new java.awt.Dimension(165, 30));
		lblDeleteCourse.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDeleteCourseMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDeleteCourseMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDeleteCourseMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblDeleteCourseMousePressed(evt);
			}
		});

		editDeliverListScroll.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));

		editDeliverList
				.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		editDeliverList
				.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
					public void valueChanged(
							javax.swing.event.ListSelectionEvent evt) {
						editDeliverListValueChanged(evt);
					}
				});
		editDeliverListScroll.setViewportView(editDeliverList);

		lblEditDeliverName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditDeliverName
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditDeliverName.setText("Deliverable Name:");
		lblEditDeliverName.setPreferredSize(new java.awt.Dimension(120, 30));

		lblEditDeliverWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditDeliverWeight
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditDeliverWeight.setText("Deliverable Weight:");
		lblEditDeliverWeight.setPreferredSize(new java.awt.Dimension(120, 30));

		lblEditDeliverType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		lblEditDeliverType
				.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lblEditDeliverType.setText("Deliverable Type:");
		lblEditDeliverType.setPreferredSize(new java.awt.Dimension(120, 30));

		comboEditDeliverType.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Assignment", "Exam", "Other" }));
		comboEditDeliverType.setPreferredSize(new java.awt.Dimension(80, 30));

		txtEditDeliverName.setForeground(new java.awt.Color(204, 204, 204));
		txtEditDeliverName.setText("Please select a deliverable");
		txtEditDeliverName.setPreferredSize(new java.awt.Dimension(120, 30));
		txtEditDeliverName.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtEditDeliverNameFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtEditDeliverNameFocusLost(evt);
			}
		});

		txtEditDeliverWeight.setForeground(new java.awt.Color(204, 204, 204));
		txtEditDeliverWeight.setText("Please select a deliverable");
		txtEditDeliverWeight.setPreferredSize(new java.awt.Dimension(120, 30));
		txtEditDeliverWeight
				.addFocusListener(new java.awt.event.FocusAdapter() {
					public void focusGained(java.awt.event.FocusEvent evt) {
						txtEditDeliverWeightFocusGained(evt);
					}

					public void focusLost(java.awt.event.FocusEvent evt) {
						txtEditDeliverWeightFocusLost(evt);
					}
				});

		lblEditDeliver
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblEditDeliver.setText("Submit Changes");
		lblEditDeliver.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblEditDeliver.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblEditDeliver.setPreferredSize(new java.awt.Dimension(330, 30));
		lblEditDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblEditDeliverMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblEditDeliverMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblEditDeliverMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblEditDeliverMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblEditDeliverMouseReleased(evt);
			}
		});

		lblExportDelivers
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblExportDelivers.setText("Export Deliverables");
		lblExportDelivers.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblExportDelivers.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblExportDelivers.setPreferredSize(new java.awt.Dimension(150, 30));
		lblExportDelivers.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblExportDeliversMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblExportDeliversMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblExportDeliversMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblExportDeliversMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblExportDeliversMouseReleased(evt);
			}
		});

		lblImportDelivers
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblImportDelivers.setText("Import Deliverables");
		lblImportDelivers.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblImportDelivers.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblImportDelivers.setPreferredSize(new java.awt.Dimension(150, 30));
		lblImportDelivers.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblImportDeliversMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblImportDeliversMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblImportDeliversMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblImportDeliversMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblImportDeliversMouseReleased(evt);
			}
		});

		lblCourseDeliverables.setFont(new java.awt.Font("Times New Roman", 0,
				14)); // NOI18N
		lblCourseDeliverables.setText("Course Deliverables:");
		lblCourseDeliverables.setPreferredSize(new java.awt.Dimension(200, 30));

		lblSetupErrorLog.setForeground(new java.awt.Color(255, 0, 0));
		lblSetupErrorLog.setPreferredSize(new java.awt.Dimension(34, 20));

		txtCourseDesc.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		txtCourseDesc.setForeground(java.awt.Color.lightGray);
		txtCourseDesc.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtCourtxtCourseDesceDescFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtCourtxtCourseDesceDescFocusLost(evt);
			}
		});
		courseDescScroll.setViewportView(txtCourseDesc);

		lblEditAddDeliver
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblEditAddDeliver.setText("Add Deliverable");
		lblEditAddDeliver.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblEditAddDeliver.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblEditAddDeliver.setPreferredSize(new java.awt.Dimension(160, 30));
		lblEditAddDeliver.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblEditAddDeliverMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblEditAddDeliverMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblEditAddDeliverMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblEditAddDeliverMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblEditAddDeliverMouseReleased(evt);
			}
		});

		lblEditDeleteDeliver
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblEditDeleteDeliver.setText("Delete Deliverable");
		lblEditDeleteDeliver.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblEditDeleteDeliver.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblEditDeleteDeliver.setPreferredSize(new java.awt.Dimension(160, 30));
		lblEditDeleteDeliver
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						lblEditDeleteDeliverMouseClicked(evt);
					}

					public void mouseEntered(java.awt.event.MouseEvent evt) {
						lblEditDeleteDeliverMouseEntered(evt);
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						lblEditDeleteDeliverMouseExited(evt);
					}

					public void mousePressed(java.awt.event.MouseEvent evt) {
						lblEditDeleteDeliverMousePressed(evt);
					}

					public void mouseReleased(java.awt.event.MouseEvent evt) {
						lblEditDeleteDeliverMouseReleased(evt);
					}
				});

		javax.swing.GroupLayout tabSetupLayout = new javax.swing.GroupLayout(
				tabSetup);
		tabSetup.setLayout(tabSetupLayout);
		tabSetupLayout
				.setHorizontalGroup(tabSetupLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								tabSetupLayout
										.createSequentialGroup()
										.addGroup(
												tabSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																tabSetupLayout
																		.createSequentialGroup()
																		.addGap(20,
																				20,
																				20)
																		.addComponent(
																				lblSetupErrorLog,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																tabSetupLayout
																		.createSequentialGroup()
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								tabSetupLayout
																										.createSequentialGroup()
																										.addGap(20,
																												20,
																												20)
																										.addComponent(
																												lblCourseSetup,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								tabSetupLayout
																										.createSequentialGroup()
																										.addContainerGap()
																										.addComponent(
																												courseDescScroll,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												502,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(20,
																				20,
																				20)
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								tabSetupLayout
																										.createSequentialGroup()
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																tabSetupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblEditDeliverName,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				txtEditDeliverName,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				200,
																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																tabSetupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblEditDeliverWeight,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				txtEditDeliverWeight,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				200,
																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																														.addComponent(
																																lblDeleteCourse,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																lblEditCourse,
																																javax.swing.GroupLayout.Alignment.LEADING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																tabSetupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblEditCourseTerm,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addGap(10,
																																				10,
																																				10)
																																		.addComponent(
																																				comboEditCourseTerm,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				50,
																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																														.addGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																tabSetupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblEditDeliverType,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				comboEditDeliverType,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				200,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)))
																										.addGap(0,
																												0,
																												0))
																						.addGroup(
																								tabSetupLayout
																										.createSequentialGroup()
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																lblEditCourseCode,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																120,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblEditCourseTtile,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(10,
																												10,
																												10)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																txtEditCourseCode,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																200,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtEditCourseTitle,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																200,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								tabSetupLayout
																										.createSequentialGroup()
																										.addGap(0,
																												0,
																												Short.MAX_VALUE)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																lblEditDeliver,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addGroup(
																																tabSetupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblEditAddDeliver,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)
																																		.addGap(10,
																																				10,
																																				10)
																																		.addComponent(
																																				lblEditDeleteDeliver,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)))))
																		.addGap(10,
																				10,
																				10)
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								lblCourseDeliverables,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblImportDelivers,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblExportDelivers,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								editDeliverListScroll,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								0,
																								Short.MAX_VALUE))))
										.addGap(10, 10, 10)));
		tabSetupLayout
				.setVerticalGroup(tabSetupLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								tabSetupLayout
										.createSequentialGroup()
										.addGap(10, 10, 10)
										.addGroup(
												tabSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																tabSetupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCourseDeliverables,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				28,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(5,
																				5,
																				5))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																tabSetupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCourseSetup,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(13,
																				13,
																				13)))
										.addGroup(
												tabSetupLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																tabSetupLayout
																		.createSequentialGroup()
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								editDeliverListScroll)
																						.addGroup(
																								tabSetupLayout
																										.createSequentialGroup()
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditCourseTtile,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtEditCourseTitle,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(5,
																												5,
																												5)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditCourseCode,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtEditCourseCode,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(5,
																												5,
																												5)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditCourseTerm,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																comboEditCourseTerm,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												lblEditCourse,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(5,
																												5,
																												5)
																										.addComponent(
																												lblDeleteCourse,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(40,
																												40,
																												40)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditDeliverName,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtEditDeliverName,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(5,
																												5,
																												5)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditDeliverWeight,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txtEditDeliverWeight,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(5,
																												5,
																												5)
																										.addGroup(
																												tabSetupLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																lblEditDeliverType,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																comboEditDeliverType,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))))
																		.addGap(5,
																				5,
																				5)
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								lblImportDelivers,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblEditDeliver,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(5,
																				5,
																				5)
																		.addGroup(
																				tabSetupLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								lblExportDelivers,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblEditAddDeliver,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblEditDeleteDeliver,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																courseDescScroll,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																392,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(10, 10, 10)
										.addComponent(
												lblSetupErrorLog,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		tabDropbox.setBackground(new java.awt.Color(255, 255, 255));
		tabDropbox.setPreferredSize(new java.awt.Dimension(1080, 480));

		lblDbxAuthLink
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxAuthLink.setText("Generate a new link");
		lblDbxAuthLink.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblDbxAuthLink.setPreferredSize(new java.awt.Dimension(1000, 30));
		lblDbxAuthLink.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDbxAuthLinkMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDbxAuthLinkMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDbxAuthLinkMouseExited(evt);
			}
		});

		txtDbxCode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtDbxCode.setText("Please enter the code...");
		txtDbxCode.setPreferredSize(new java.awt.Dimension(1000, 30));
		txtDbxCode.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtDbxCodeFocusGained(evt);
			}
		});

		lblDbxGenerate
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxGenerate.setText("Generate");
		lblDbxGenerate.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblDbxGenerate.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblDbxGenerate.setPreferredSize(new java.awt.Dimension(495, 30));
		lblDbxGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDbxGenerateMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDbxGenerateMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDbxGenerateMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblDbxGenerateMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblDbxGenerateMouseReleased(evt);
			}
		});

		lblDbxUpload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxUpload.setText("Upload");
		lblDbxUpload.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblDbxUpload
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblDbxUpload.setPreferredSize(new java.awt.Dimension(495, 30));
		lblDbxUpload.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDbxUploadMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDbxUploadMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDbxUploadMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblDbxUploadMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblDbxUploadMouseReleased(evt);
			}
		});

		lblDbxDownload
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxDownload.setText("Download");
		lblDbxDownload.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblDbxDownload.setCursor(new java.awt.Cursor(
				java.awt.Cursor.HAND_CURSOR));
		lblDbxDownload.setPreferredSize(new java.awt.Dimension(495, 30));
		lblDbxDownload.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDbxDownloadMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDbxDownloadMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDbxDownloadMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblDbxDownloadMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblDbxDownloadMouseReleased(evt);
			}
		});

		lblDbxSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxSubmit.setText("Submit");
		lblDbxSubmit.setBorder(javax.swing.BorderFactory
				.createLineBorder(java.awt.Color.lightGray));
		lblDbxSubmit
				.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lblDbxSubmit.setPreferredSize(new java.awt.Dimension(495, 30));
		lblDbxSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblDbxSubmitMouseClicked(evt);
			}

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				lblDbxSubmitMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblDbxSubmitMouseExited(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				lblDbxSubmitMousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				lblDbxSubmitMouseReleased(evt);
			}
		});

		lblDbxErrorLog.setForeground(java.awt.Color.lightGray);
		lblDbxErrorLog.setText("Disconnected");

		lblDbxVerify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblDbxVerify.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/cs2212/team4/verify.png"))); // NOI18N
		lblDbxVerify.setPreferredSize(new java.awt.Dimension(1000, 20));

		javax.swing.GroupLayout tabDropboxLayout = new javax.swing.GroupLayout(
				tabDropbox);
		tabDropbox.setLayout(tabDropboxLayout);
		tabDropboxLayout
				.setHorizontalGroup(tabDropboxLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								tabDropboxLayout
										.createSequentialGroup()
										.addGap(40, 40, 40)
										.addGroup(
												tabDropboxLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																tabDropboxLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				lblDbxAuthLink,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				txtDbxCode,
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																tabDropboxLayout
																		.createSequentialGroup()
																		.addGroup(
																				tabDropboxLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								lblDbxUpload,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblDbxGenerate,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(10,
																				10,
																				10)
																		.addGroup(
																				tabDropboxLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								lblDbxSubmit,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblDbxDownload,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addGap(40, 40, 40))
						.addGroup(
								tabDropboxLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												lblDbxErrorLog,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								tabDropboxLayout
										.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(
												lblDbxVerify,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(40, 40, 40)));
		tabDropboxLayout
				.setVerticalGroup(tabDropboxLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								tabDropboxLayout
										.createSequentialGroup()
										.addGap(80, 80, 80)
										.addComponent(
												lblDbxVerify,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												128, Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												lblDbxAuthLink,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addComponent(
												txtDbxCode,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20)
										.addGroup(
												tabDropboxLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblDbxGenerate,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDbxSubmit,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(10, 10, 10)
										.addGroup(
												tabDropboxLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lblDbxUpload,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblDbxDownload,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												73, Short.MAX_VALUE)
										.addComponent(lblDbxErrorLog)
										.addContainerGap()));

		javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(
				container);
		container.setLayout(containerLayout);
		containerLayout
				.setHorizontalGroup(containerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 1090, Short.MAX_VALUE)
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabSetup,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 10,
																Short.MAX_VALUE)))
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabGrades,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap()))
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabDropbox,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap())));
		containerLayout
				.setVerticalGroup(containerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 491, Short.MAX_VALUE)
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabSetup,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 11,
																Short.MAX_VALUE)))
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabGrades,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(0, 0,
																Short.MAX_VALUE)))
						.addGroup(
								containerLayout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												containerLayout
														.createSequentialGroup()
														.addComponent(
																tabDropbox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap())));
		container.setLayer(tabGrades, javax.swing.JLayeredPane.DEFAULT_LAYER);
		container.setLayer(tabSetup, javax.swing.JLayeredPane.DEFAULT_LAYER);
		container.setLayer(tabDropbox, javax.swing.JLayeredPane.DEFAULT_LAYER);

		getContentPane().add(
				container,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1,
						490));

		lyrActiveCourse
				.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		lblActiveCourseTitleInfo.setFont(helvetica);
		lblActiveCourseTitleInfo.setText("Select a course");
		lyrActiveCourse.add(lblActiveCourseTitleInfo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 160,
						40));

		lblActiveCourseInfo.setForeground(new java.awt.Color(204, 204, 204));
		lyrActiveCourse.add(lblActiveCourseInfo,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 150,
						20));

		lblActiveCourse.setIcon(new javax.swing.ImageIcon(getClass()
				.getResource("/cs2212/team4/activeCourseTab.png"))); // NOI18N
		lyrActiveCourse.add(lblActiveCourse,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1,
						-1));

		getContentPane().add(
				lyrActiveCourse,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 650,
						-1));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	Dropbox dbx;
	boolean generated = false;

	private void lblTabDropboxMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabDropboxMouseClicked

	}// GEN-LAST:event_lblTabDropboxMouseClicked

	private void lblDropboxMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDropboxMouseClicked
		tabSwitch(2);
	}// GEN-LAST:event_lblDropboxMouseClicked

	private void lblDbxGenerateMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxGenerateMouseClicked
		dbx = new Dropbox();
		lblDbxAuthLink.setText(dbx.getAuthorizeUrl());
		generated = true;
	}// GEN-LAST:event_lblDbxGenerateMouseClicked

	private void lblDbxUploadMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxUploadMouseClicked
		if (!dbx.upload()) {
			lblDbxErrorLog.setForeground(Color.red);
			lblDbxErrorLog.setText("Error, upload failed.");
		} else {
			lblDbxErrorLog.setForeground(Color.green);
			lblDbxErrorLog.setText("Success, upload was successful.");
		}
	}// GEN-LAST:event_lblDbxUploadMouseClicked

	private void lblDbxDownloadMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxDownloadMouseClicked
		if (!dbx.download()) {
			lblDbxErrorLog.setForeground(Color.red);
			lblDbxErrorLog.setText("Error, download failed.");
		} else {
			lblDbxErrorLog.setForeground(Color.green);
			lblDbxErrorLog.setText("Success, download was successful.");
		}
	}// GEN-LAST:event_lblDbxDownloadMouseClicked

	private void lblDbxAuthLinkMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxAuthLinkMouseEntered
		if (generated) {
			lblDbxAuthLink.setForeground(Color.blue);
			Font font = lblDbxAuthLink.getFont();
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			lblDbxAuthLink.setFont(font.deriveFont(attributes));
		}
	}// GEN-LAST:event_lblDbxAuthLinkMouseEntered

	private void lblDbxAuthLinkMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxAuthLinkMouseExited
		lblDbxAuthLink.setForeground(Color.black);
		Font font = lblDbxAuthLink.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
		lblDbxAuthLink.setFont(font.deriveFont(attributes));
	}// GEN-LAST:event_lblDbxAuthLinkMouseExited

	private void lblDbxAuthLinkMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxAuthLinkMouseClicked
		if (generated) {
			try {
				java.awt.Desktop.getDesktop().browse(
						java.net.URI.create(dbx.getAuthorizeUrl()));
			} catch (java.io.IOException e) {
			}
		}
	}// GEN-LAST:event_lblDbxAuthLinkMouseClicked

	private void lblDbxSubmitMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxSubmitMouseClicked
		if (generated) {
			if (!dbx.authenticate(txtDbxCode.getText())) {
				lblDbxErrorLog.setForeground(Color.red);
				lblDbxErrorLog.setText("Invalid Code.");
			} else {
				lblDbxErrorLog.setForeground(Color.green);
				lblDbxErrorLog.setText("Connected.");

				lblDbxAuthLink.setVisible(false);
				txtDbxCode.setVisible(false);
				lblDbxGenerate.setVisible(false);
				lblDbxSubmit.setVisible(false);

				lblDbxVerify.setVisible(true);
				lblDbxDownload.setVisible(true);
				lblDbxUpload.setVisible(true);
			}
		} else {
			lblDbxErrorLog.setForeground(Color.red);
			lblDbxErrorLog
					.setText("Error, please generate a link, and insert the code provided by the Dropbox webpage.");
		}
	}// GEN-LAST:event_lblDbxSubmitMouseClicked

	private void txtDbxCodeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtDbxCodeFocusGained
		txtDbxCode.select(0, txtDbxCode.getText().length());
	}// GEN-LAST:event_txtDbxCodeFocusGained

	private void lblDbxGenerateMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxGenerateMouseEntered
		lblDbxGenerate.setBorder(BorderFactory.createLineBorder(new Color(20,
				150, 250)));
	}// GEN-LAST:event_lblDbxGenerateMouseEntered

	private void lblDbxGenerateMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxGenerateMouseExited
		lblDbxGenerate.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxGenerateMouseExited

	private void lblDbxGenerateMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxGenerateMousePressed
		lblDbxGenerate.setBorder(BorderFactory.createBevelBorder(0, new Color(
				20, 150, 250), new Color(20, 150, 250),
				new Color(20, 150, 250), new Color(20, 150, 250)));
	}// GEN-LAST:event_lblDbxGenerateMousePressed

	private void lblDbxGenerateMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxGenerateMouseReleased
		lblDbxGenerate.setBorder(BorderFactory.createLineBorder(new Color(20,
				150, 250)));
	}// GEN-LAST:event_lblDbxGenerateMouseReleased

	private void lblDbxSubmitMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxSubmitMouseEntered
		lblDbxSubmit.setBorder(BorderFactory.createLineBorder(new Color(20,
				150, 250)));
	}// GEN-LAST:event_lblDbxSubmitMouseEntered

	private void lblDbxSubmitMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxSubmitMouseExited
		lblDbxSubmit.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxSubmitMouseExited

	private void lblDbxSubmitMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxSubmitMousePressed
		lblDbxSubmit.setBorder(BorderFactory.createBevelBorder(0, new Color(20,
				150, 250), new Color(20, 150, 250), new Color(20, 150, 250),
				new Color(20, 150, 250)));
	}// GEN-LAST:event_lblDbxSubmitMousePressed

	private void lblDbxSubmitMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxSubmitMouseReleased
		lblDbxSubmit.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxSubmitMouseReleased

	private void lblDbxUploadMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxUploadMouseEntered
		lblDbxUpload.setBorder(BorderFactory.createLineBorder(new Color(20,
				150, 250)));
	}// GEN-LAST:event_lblDbxUploadMouseEntered

	private void lblDbxUploadMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxUploadMouseExited
		lblDbxUpload.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxUploadMouseExited

	private void lblDbxUploadMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxUploadMousePressed
		lblDbxUpload.setBorder(BorderFactory.createBevelBorder(0, new Color(20,
				150, 250), new Color(20, 150, 250), new Color(20, 150, 250),
				new Color(20, 150, 250)));
	}// GEN-LAST:event_lblDbxUploadMousePressed

	private void lblDbxUploadMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxUploadMouseReleased
		lblDbxUpload.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxUploadMouseReleased

	private void lblDbxDownloadMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxDownloadMouseEntered
		lblDbxDownload.setBorder(BorderFactory.createLineBorder(new Color(20,
				150, 250)));
	}// GEN-LAST:event_lblDbxDownloadMouseEntered

	private void lblDbxDownloadMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxDownloadMouseExited
		lblDbxDownload.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxDownloadMouseExited

	private void lblDbxDownloadMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxDownloadMousePressed
		lblDbxDownload.setBorder(BorderFactory.createBevelBorder(0, new Color(
				20, 150, 250), new Color(20, 150, 250),
				new Color(20, 150, 250), new Color(20, 150, 250)));
	}// GEN-LAST:event_lblDbxDownloadMousePressed

	private void lblDbxDownloadMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDbxDownloadMouseReleased
		lblDbxDownload.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDbxDownloadMouseReleased

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * Start: CUSTOM CODE
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * Start: Grades Tab
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Deliverable Side bar
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	private void editCourseIconMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_editCourseIconMouseClicked
		tabSwitch(1);
	}// GEN-LAST:event_editCourseIconMouseClicked

	private void addDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseClicked
		hideMenu();
		if (currCourse != null) {
			restPnlCourse();
			restPnlDeliver();
			restPnlStudent();
			pnlAddDeliver.setVisible(true);
		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_addDeliverMouseClicked

	private void addDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseEntered
		if (currCourse != null)
			addDeliver.setBorder(BorderFactory.createLineBorder(new Color(51,
					255, 51)));
		else
			addDeliver.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_addDeliverMouseEntered

	private void addDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMouseExited
		addDeliver.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
	}// GEN-LAST:event_addDeliverMouseExited

	private void addDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addDeliverMousePressed
		if (currCourse != null)
			addDeliver.setBorder(BorderFactory.createBevelBorder(1, new Color(
					51, 255, 51), new Color(51, 255, 51),
					new Color(51, 255, 51), new Color(51, 255, 51)));
		else
			addDeliver.setBorder(BorderFactory.createBevelBorder(1, new Color(
					204, 204, 204), new Color(204, 204, 204), new Color(204,
					204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_addDeliverMousePressed

	private void deleteDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseClicked
		if (currCourse != null) {
			if (deliverList.getSelectedIndex() != -1) {
				String temp = listDelivers.getElementAt(deliverList
						.getSelectedIndex());
				currCourse.removeDeliverable(findDeliver(temp));
				updateInfo();
			} else
				lblGradesErrorLog.setText("Please select a deliverable");
		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_deleteDeliverMouseClicked

	private void deleteDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseEntered
		if (currCourse != null)
			deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(
					255, 51, 51)));
		else
			deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_deleteDeliverMouseEntered

	private void deleteDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMouseExited
		deleteDeliver.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_deleteDeliverMouseExited

	private void deleteDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteDeliverMousePressed
		if (currCourse != null)
			deleteDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(255, 51, 51), new Color(255, 51, 51), new Color(
							255, 51, 51), new Color(255, 51, 51)));
		else
			deleteDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_deleteDeliverMousePressed

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Deliverable Side bar
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Tables
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	int firstName = 1, lastName = 1, number = 1, email = 1;

	private void deliverListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_deliverListValueChanged
		deleteDeliver.setVisible(true);
	}// GEN-LAST:event_deliverListValueChanged

	private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_studentTableMouseClicked
		hideMenu();
		if (currCourse != null) {
			if (currCourse.getStudent(studentTable.getSelectedRow()) != null)
				deleteStudent.setVisible(true);
		} else
			deleteStudent.setVisible(false);
		int i = studentTable.getSelectedRow();
		gradesTable.setRowSelectionInterval(i, i);
	}// GEN-LAST:event_studentTableMouseClicked

	private void gradesTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_gradesTableMouseClicked
		hideMenu();
		if (currCourse != null) {
			if (currCourse.getStudent(gradesTable.getSelectedRow()) != null)
				deleteStudent.setVisible(true);
		} else
			deleteStudent.setVisible(false);
		int i = gradesTable.getSelectedRow();
		studentTable.setRowSelectionInterval(i, i);
	}// GEN-LAST:event_gradesTableMouseClicked

	private void lblFirstNameMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblFirstNameMouseClicked
		if (currCourse != null) {
			if (firstName == 1)
				firstName = 0;
			else
				firstName = 1;
			updateTables();
		}
	}// GEN-LAST:event_lblFirstNameMouseClicked

	private void lblFirstNameMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblFirstNameMouseEntered
		if (currCourse != null)
			if (firstName == 1) {
				lblFirstName.setBorder(BorderFactory
						.createLineBorder(new Color(20, 150, 250)));
				lblFirstName.setText("Hide");
			} else
				lblFirstName.setText("Show");
		else
			lblFirstName.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblFirstNameMouseEntered

	private void lblFirstNameMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblFirstNameMouseExited
		if (firstName != 1)
			lblFirstName.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
		lblFirstName.setText("First Name");
	}// GEN-LAST:event_lblFirstNameMouseExited

	private void lblFirstNameMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblFirstNameMousePressed
		if (currCourse != null)
			lblFirstName.setBorder(BorderFactory.createBevelBorder(0,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else
			lblFirstName.setBorder(BorderFactory.createBevelBorder(0,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));

	}// GEN-LAST:event_lblFirstNameMousePressed

	private void lblFirstNameMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblFirstNameMouseReleased
		if (currCourse != null)
			lblFirstName.setBorder(BorderFactory.createLineBorder(new Color(20,
					150, 250)));
		else
			lblFirstName.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblFirstNameMouseReleased

	private void lblLastNameMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblLastNameMouseClicked
		if (currCourse != null) {
			if (lastName == 1)
				lastName = 0;
			else
				lastName = 1;
			updateTables();
		}
	}// GEN-LAST:event_lblLastNameMouseClicked

	private void lblLastNameMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblLastNameMouseEntered
		if (currCourse != null)
			if (lastName == 1) {
				lblLastName.setBorder(BorderFactory.createLineBorder(new Color(
						20, 150, 250)));
				lblLastName.setText("Hide");
			} else
				lblLastName.setText("Show");
		else
			lblLastName.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblLastNameMouseEntered

	private void lblLastNameMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblLastNameMouseExited
		if (lastName != 1)
			lblLastName.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
		lblLastName.setText("Last Name");
	}// GEN-LAST:event_lblLastNameMouseExited

	private void lblLastNameMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblLastNameMousePressed
		if (currCourse != null)
			lblLastName.setBorder(BorderFactory.createBevelBorder(0, new Color(
					20, 150, 250), new Color(20, 150, 250), new Color(20, 150,
					250), new Color(20, 150, 250)));
		else
			lblLastName.setBorder(BorderFactory.createBevelBorder(0, new Color(
					204, 204, 204), new Color(204, 204, 204), new Color(204,
					204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_lblLastNameMousePressed

	private void lblLastNameMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblLastNameMouseReleased
		if (currCourse != null)
			lblLastName.setBorder(BorderFactory.createLineBorder(new Color(20,
					150, 250)));
		else
			lblLastName.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblLastNameMouseReleased

	private void lblNumberMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblNumberMouseClicked
		if (currCourse != null) {
			if (number == 1)
				number = 0;
			else
				number = 1;
			updateTables();
		}
	}// GEN-LAST:event_lblNumberMouseClicked

	private void lblNumberMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblNumberMouseEntered
		if (currCourse != null)
			if (number == 1) {
				lblNumber.setBorder(BorderFactory.createLineBorder(new Color(
						20, 150, 250)));
				lblNumber.setText("Hide");
			} else
				lblNumber.setText("Show");
		else
			lblNumber.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblNumberMouseEntered

	private void lblNumberMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblNumberMouseExited
		if (number != 1)
			lblNumber.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
		lblNumber.setText("Number");
	}// GEN-LAST:event_lblNumberMouseExited

	private void lblNumberMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblNumberMousePressed
		if (currCourse != null)
			lblNumber.setBorder(BorderFactory.createBevelBorder(0, new Color(
					20, 150, 250), new Color(20, 150, 250), new Color(20, 150,
					250), new Color(20, 150, 250)));
		else
			lblNumber.setBorder(BorderFactory.createBevelBorder(0, new Color(
					204, 204, 204), new Color(204, 204, 204), new Color(204,
					204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_lblNumberMousePressed

	private void lblNumberMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblNumberMouseReleased
		if (currCourse != null)
			lblNumber.setBorder(BorderFactory.createLineBorder(new Color(20,
					150, 250)));
		else
			lblNumber.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblNumberMouseReleased

	private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEmailMouseClicked
		if (currCourse != null) {
			if (email == 1)
				email = 0;
			else
				email = 1;
			updateTables();
		}
	}// GEN-LAST:event_lblEmailMouseClicked

	private void lblEmailMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEmailMouseEntered
		if (currCourse != null)
			if (email == 1) {
				lblEmail.setBorder(BorderFactory.createLineBorder(new Color(20,
						150, 250)));
				lblEmail.setText("Hide");
			} else
				lblEmail.setText("Show");
		else
			lblEmail.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblEmailMouseEntered

	private void lblEmailMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEmailMouseExited
		if (email != 1)
			lblEmail.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
		lblEmail.setText("Email");
	}// GEN-LAST:event_lblEmailMouseExited

	private void lblEmailMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEmailMousePressed
		if (currCourse != null)
			lblEmail.setBorder(BorderFactory.createBevelBorder(0, new Color(20,
					150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else
			lblEmail.setBorder(BorderFactory.createBevelBorder(0, new Color(
					204, 204, 204), new Color(204, 204, 204), new Color(204,
					204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEmailMousePressed

	private void lblEmailMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEmailMouseReleased
		if (currCourse != null)
			lblEmail.setBorder(BorderFactory.createLineBorder(new Color(20,
					150, 250)));
		else
			lblEmail.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_lblEmailMouseReleased

	private void addStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseClicked
		hideMenu();
		if (currCourse != null) {
			restPnlCourse();
			restPnlDeliver();
			restPnlStudent();
			pnlAddStudent.setVisible(true);
		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_addStudentMouseClicked

	private void addStudentMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseEntered
		if (currCourse != null)
			addStudent.setBorder(BorderFactory.createLineBorder(new Color(51,
					255, 51)));
		else
			addStudent.setBorder(BorderFactory.createLineBorder(new Color(204,
					204, 204)));
	}// GEN-LAST:event_addStudentMouseEntered

	private void addStudentMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMouseExited
		addStudent.setBorder(BorderFactory.createLineBorder(new Color(204, 204,
				204)));
	}// GEN-LAST:event_addStudentMouseExited

	private void addStudentMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addStudentMousePressed
		if (currCourse != null)
			addStudent.setBorder(BorderFactory.createBevelBorder(1, new Color(
					51, 255, 51), new Color(51, 255, 51),
					new Color(51, 255, 51), new Color(51, 255, 51)));
		else
			addStudent.setBorder(BorderFactory.createBevelBorder(1, new Color(
					204, 204, 204), new Color(204, 204, 204), new Color(204,
					204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_addStudentMousePressed

	private void deleteStudentMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseClicked
		if (currCourse != null) {
			currCourse.removeStudent(studentTable.getSelectedRow());
			updateInfo();
		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_deleteStudentMouseClicked

	private void deleteStudentMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseEntered
		if (currCourse != null)
			deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(
					255, 51, 51)));
		else
			deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_deleteStudentMouseEntered

	private void deleteStudentMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMouseExited
		deleteStudent.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_deleteStudentMouseExited

	private void deleteStudentMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteStudentMousePressed
		if (currCourse != null)
			deleteStudent.setBorder(BorderFactory.createBevelBorder(1,
					new Color(255, 51, 51), new Color(255, 51, 51), new Color(
							255, 51, 51), new Color(255, 51, 51)));
		else
			deleteStudent.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_deleteStudentMousePressed

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Tables
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Imports/Exports
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	private void lblImportGradesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportGradesMouseClicked
		if (currCourse != null) {
			final JFileChooser importGrades = new JFileChooser();
			int returnVal = importGrades.showOpenDialog(this);
			if (returnVal == 0) {
				if (!currCourse.importGrades(importGrades.getSelectedFile()))
					lblGradesErrorLog
							.setText("An error occured while importing the data, the file selected seems to be corrupt");
				else
					updateInfo();
			} else
				lblGradesErrorLog.setText("No file selected.");
		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_lblImportGradesMouseClicked

	private void lblImportGradesMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportGradesMouseEntered
		if (currCourse != null)
			lblImportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					20, 150, 250)));
		else
			lblImportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblImportGradesMouseEntered

	private void lblImportGradesMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportGradesMouseExited
		lblImportGrades.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblImportGradesMouseExited

	private void lblImportGradesMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportGradesMousePressed
		if (currCourse != null)
			lblImportGrades.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else {
			lblImportGrades.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
		}
	}// GEN-LAST:event_lblImportGradesMousePressed

	private void lblImportGradesMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportGradesMouseReleased
		if (currCourse != null)
			lblImportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					20, 150, 250)));
		else
			lblImportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblImportGradesMouseReleased

	private void lblExportGradesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportGradesMouseClicked
		if (currCourse != null) {
			final JFileChooser exportGrades = new JFileChooser();
			exportGrades.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = exportGrades.showSaveDialog(this);

			if (returnVal == 0) {
				File file = new File(exportGrades.getSelectedFile(),
						currCourse.getTitle() + currCourse.getCode()
								+ currCourse.getTerm() + "Grades.csv");
				if (!currCourse.exportGrades(file))
					lblGradesErrorLog
							.setText("An error occured while exporting the data.");
				else
					updateInfo();
			} else
				lblGradesErrorLog.setText("Please select a valid directory.");
		} else
			lblGradesErrorLog.setText("Please select a course");

	}// GEN-LAST:event_lblExportGradesMouseClicked

	private void lblExportGradesMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportGradesMouseEntered
		if (currCourse != null)
			lblExportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					20, 150, 250)));
		else
			lblExportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblExportGradesMouseEntered

	private void lblExportGradesMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportGradesMouseExited
		lblExportGrades.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblExportGradesMouseExited

	private void lblExportGradesMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportGradesMousePressed
		if (currCourse != null)
			lblExportGrades.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else
			lblExportGrades.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));

	}// GEN-LAST:event_lblExportGradesMousePressed

	private void lblExportGradesMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportGradesMouseReleased
		if (currCourse != null)
			lblExportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					20, 150, 250)));
		else
			lblExportGrades.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
	}// GEN-LAST:event_lblExportGradesMouseReleased

	private void lblImportStudentsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportStudentsMouseClicked
		if (currCourse != null) {
			final JFileChooser importStudents = new JFileChooser();
			int returnVal = importStudents.showOpenDialog(this);
			if (returnVal == 0) {
				if (!currCourse.importStudents((importStudents
						.getSelectedFile())))
					lblGradesErrorLog
							.setText("An error occured while importing the data, the file selected seems to be corrupt");
				else
					updateInfo();
			} else
				lblGradesErrorLog.setText("Please select a valid directory.");

		} else
			lblGradesErrorLog.setText("Please select a course");
	}// GEN-LAST:event_lblImportStudentsMouseClicked

	private void lblImportStudentsMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportStudentsMouseEntered
		if (currCourse != null)
			lblImportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblImportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblImportStudentsMouseEntered

	private void lblImportStudentsMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportStudentsMouseExited
		lblImportStudents.setBorder(BorderFactory.createLineBorder(new Color(
				204, 204, 204)));
	}// GEN-LAST:event_lblImportStudentsMouseExited

	private void lblImportStudentsMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportStudentsMousePressed
		if (currCourse != null)
			lblImportStudents.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else {
			lblImportStudents.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
			// lblEditCourseErrorLog.setText("Please select a course");
		}
	}// GEN-LAST:event_lblImportStudentsMousePressed

	private void lblImportStudentsMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportStudentsMouseReleased
		if (currCourse != null)
			lblImportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblImportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblImportStudentsMouseReleased

	private void lblExportStudentsMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportStudentsMouseClicked
		if (currCourse != null) {
			final JFileChooser exportStudents = new JFileChooser();
			exportStudents.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = exportStudents.showSaveDialog(this);

			if (returnVal == 0) {
				File file = new File(exportStudents.getSelectedFile(),
						currCourse.getTitle() + currCourse.getCode()
								+ currCourse.getTerm() + "Students.csv");
				if (!currCourse.exportStudents(file))
					lblGradesErrorLog
							.setText("An error occured while importing the data.");
				else
					updateInfo();
			}
		} else
			lblGradesErrorLog.setText("Please select a course");

	}// GEN-LAST:event_lblExportStudentsMouseClicked

	private void lblExportStudentsMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportStudentsMouseEntered
		if (currCourse != null)
			lblExportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblExportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblExportStudentsMouseEntered

	private void lblExportStudentsMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportStudentsMouseExited
		lblExportStudents.setBorder(BorderFactory.createLineBorder(new Color(
				204, 204, 204)));
	}// GEN-LAST:event_lblExportStudentsMouseExited

	private void lblExportStudentsMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportStudentsMousePressed
		if (currCourse != null)
			lblExportStudents.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else {
			lblExportStudents.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
		}
	}// GEN-LAST:event_lblExportStudentsMousePressed

	private void lblExportStudentsMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportStudentsMouseReleased
		if (currCourse != null)
			lblExportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblExportStudents.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblExportStudentsMouseReleased

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Imports/Exports
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * End: Grades Tab
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * Start: Setup Tab
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Course Config
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	int boolCourse = 2;
	Color colorCourse = Color.lightGray;

	private void txtCourtxtCourseDesceDescFocusLost(
			java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourtxtCourseDesceDescFocusLost
		if (!txtCourseDesc.getText().equals("Enter a course description..."))
			currCourse.setDescription(txtCourseDesc.getText());
		else
			txtCourseDesc.setForeground(Color.lightGray);
	}// GEN-LAST:event_txtCourtxtCourseDesceDescFocusLost

	private void txtCourtxtCourseDesceDescFocusGained(
			java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCourtxtCourseDesceDescFocusGained
		if (txtCourseDesc.getText().equals("Enter a course description...")) {
			txtCourseDesc.select(0, txtCourseDesc.getText().length());
			txtCourseDesc.setForeground(Color.black);
		}
	}// GEN-LAST:event_txtCourtxtCourseDesceDescFocusGained

	private void txtEditCourseTitleFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditCourseTitleFocusGained
		txtEditCourseTitle.setForeground(Color.black);
		txtEditCourseTitle.select(0, txtEditCourseTitle.getText().length());
	}// GEN-LAST:event_txtEditCourseTitleFocusGained

	private void txtEditCourseTitleFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditCourseTitleFocusLost
		if (currCourse != null
				&& txtEditCourseTitle.getText().equals(currCourse.getTitle())
				|| txtEditCourseTitle.getText()
						.equals("Please select a course")) {
			txtEditCourseTitle.setForeground(Color.lightGray);
		}
	}// GEN-LAST:event_txtEditCourseTitleFocusLost

	private void txtEditCourseCodeFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditCourseCodeFocusGained
		txtEditCourseCode.setForeground(Color.black);
		txtEditCourseCode.select(0, txtEditCourseCode.getText().length());
	}// GEN-LAST:event_txtEditCourseCodeFocusGained

	private void txtEditCourseCodeFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditCourseCodeFocusLost
		if (currCourse != null
				&& txtEditCourseCode.getText().equals(currCourse.getCode())
				|| txtEditCourseCode.getText().equals("Please select a course")) {
			txtEditCourseCode.setForeground(Color.lightGray);
		}
	}// GEN-LAST:event_txtEditCourseCodeFocusLost

	private void lblEditCourseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditCourseMouseClicked
		if (currCourse != null) {
			if (boolCourse == 1) {
				currCourse.setTitle(txtEditCourseTitle.getText());
				currCourse.setCode(txtEditCourseCode.getText());
				currCourse.setTerm((String) comboEditCourseTerm
						.getSelectedItem());
				updateInfo();
			} else if (boolCourse == 0)
				lblSetupErrorLog.setText("The course"
						+ txtEditCourseTitle.getText() + ", "
						+ txtEditCourseCode.getText()
						+ (String) comboEditCourseTerm.getSelectedItem()
						+ " already exists!");
		} else {
			lblSetupErrorLog.setText("Please select a course");
		}
	}// GEN-LAST:event_lblEditCourseMouseClicked

	private void lblEditCourseMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditCourseMouseEntered
		if (currCourse != null
				&& (!currCourse.getTitle().equals(txtEditCourseTitle.getText())
						|| !currCourse.getCode().equals(
								txtEditCourseCode.getText()) || !currCourse
						.getTerm()
						.equals(comboEditCourseTerm.getSelectedItem()))) {
			int i = gradebook.findCourse(new Course(txtEditCourseTitle
					.getText(), (String) comboEditCourseTerm.getSelectedItem(),
					txtEditCourseCode.getText()));
			if (i == -1) {
				lblEditCourse.setBorder(BorderFactory
						.createLineBorder(new Color(51, 255, 51)));
				boolCourse = 1;
			} else {
				lblEditCourse.setBorder(BorderFactory
						.createLineBorder(new Color(255, 51, 51)));
				boolCourse = 0;
			}
		} else {
			lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
			boolCourse = 2;
		}
	}// GEN-LAST:event_lblEditCourseMouseEntered

	private void lblEditCourseMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditCourseMouseExited
		lblEditCourse.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblEditCourseMouseExited

	private void lblEditCourseMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditCourseMousePressed
		if (boolCourse == 0)
			colorCourse = new Color(255, 51, 51);
		else if (boolCourse == 1)
			colorCourse = new Color(51, 255, 51);
		else
			colorCourse = new Color(204, 204, 204);
		lblEditCourse.setBorder(BorderFactory.createBevelBorder(1, colorCourse,
				colorCourse, colorCourse, colorCourse));
	}// GEN-LAST:event_lblEditCourseMousePressed

	private void lblEditCourseMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditCourseMouseReleased
		if (boolCourse == 0)
			colorCourse = new Color(255, 51, 51);
		else if (boolCourse == 1)
			colorCourse = new Color(51, 255, 51);
		else
			colorCourse = new Color(204, 204, 204);
		lblEditCourse.setBorder(BorderFactory.createLineBorder(colorCourse));
	}// GEN-LAST:event_lblEditCourseMouseReleased

	boolean delete = false;

	private void lblDeleteCourseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDeleteCourseMouseClicked
		if (currCourse != null) {
			gradebook.removeCourse(gradebook.getCourse(courseMenuList
					.getSelectedIndex()));
			listCourses.remove(courseMenuList.getSelectedIndex());
			currCourse = gradebook.getPrevCourse();
			if (currCourse != null && gradebook.findCourse(currCourse) != -1)
				courseMenuList.setSelectedIndex(gradebook
						.findCourse(currCourse));
			else
				currCourse = null;
			updateInfo();
		} else
			lblSetupErrorLog.setText("Please select a course");

	}// GEN-LAST:event_lblDeleteCourseMouseClicked

	private void lblDeleteCourseMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDeleteCourseMouseEntered
		if (currCourse != null) {
			lblDeleteCourse.setBorder(BorderFactory.createLineBorder(new Color(
					255, 51, 51)));
		} else {
			lblDeleteCourse.setBorder(BorderFactory.createLineBorder(new Color(
					204, 204, 204)));
		}
	}// GEN-LAST:event_lblDeleteCourseMouseEntered

	private void lblDeleteCourseMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDeleteCourseMouseExited
		lblDeleteCourse.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblDeleteCourseMouseExited

	private void lblDeleteCourseMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblDeleteCourseMousePressed
		if (currCourse != null) {
			lblDeleteCourse.setBorder(BorderFactory.createBevelBorder(1,
					new Color(255, 51, 51), new Color(255, 51, 51), new Color(
							255, 51, 51), new Color(255, 51, 51)));
		} else {
			lblDeleteCourse.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
		}
	}// GEN-LAST:event_lblDeleteCourseMousePressed

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Course Config
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Deliverable Config
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	int boolDeliver = 2;
	Color colorDeliver = Color.lightGray;
	Deliverable currDeliver = null;

	private void editDeliverListValueChanged(
			javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_editDeliverListValueChanged
		hideMenu();
		if (currCourse != null) {
			if (editDeliverList.getSelectedIndex() != -1) {

				String temp = listDelivers.getElementAt(editDeliverList
						.getSelectedIndex());

				currDeliver = currCourse.getDeliverable(findDeliver(temp));

				if (currDeliver != null) {
					txtEditDeliverName.setText(currDeliver.getName());
					txtEditDeliverWeight.setText(currDeliver.getWeight() + "");
					comboEditDeliverType.setSelectedItem(currDeliver.getType());
				}
			} else {
				txtEditDeliverName.setText("Please select a deliverable");
				txtEditDeliverWeight.setText("Please select a deliverable");
				comboEditDeliverType.setSelectedIndex(0);
			}
		}
	}// GEN-LAST:event_editDeliverListValueChanged

	private void txtEditDeliverNameFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditDeliverNameFocusGained
		txtEditDeliverName.setForeground(Color.black);
		txtEditDeliverName.select(0, txtEditDeliverName.getText().length());
	}// GEN-LAST:event_txtEditDeliverNameFocusGained

	private void txtEditDeliverNameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditDeliverNameFocusLost
		if (currDeliver != null
				&& txtEditDeliverName.getText().equals(currDeliver.getName())
				|| txtEditDeliverName.getText().equals(
						"Please select a deliverable")) {
			txtEditDeliverName.setForeground(Color.lightGray);
		}
	}// GEN-LAST:event_txtEditDeliverNameFocusLost

	private void txtEditDeliverWeightFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditDeliverWeightFocusGained
		txtEditDeliverWeight.setForeground(Color.black);
		txtEditDeliverWeight.select(0, txtEditDeliverWeight.getText().length());
	}// GEN-LAST:event_txtEditDeliverWeightFocusGained

	private void txtEditDeliverWeightFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtEditDeliverWeightFocusLost
		if (currDeliver != null
				&& txtEditDeliverWeight.getText().equals(
						currDeliver.getWeight())
				|| txtEditDeliverWeight.getText().equals(
						"Please select a deliverable")) {
			txtEditDeliverWeight.setForeground(Color.lightGray);
		}
	}// GEN-LAST:event_txtEditDeliverWeightFocusLost

	private void lblEditDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeliverMouseClicked
		if (currDeliver != null) {
			if (!weightException) {
				if (boolDeliver == 1) {
					currDeliver.setName(txtEditDeliverName.getText());
					currDeliver.setWeight(weight);
					currDeliver.setType((String) comboEditDeliverType
							.getSelectedItem());
					updateInfo();
					currDeliver = null;
				} else if (boolCourse == 0)
					lblSetupErrorLog.setText("The deliverable"
							+ txtEditDeliverName.getText() + ", " + weight
							+ (String) comboEditDeliverType.getSelectedItem()
							+ " already exists!");
			} else {
				lblSetupErrorLog.setText("Please enter a valid weight.");
				txtEditDeliverWeight.setBorder(errorHighlightBorder);
			}
		} else
			lblSetupErrorLog.setText("Please select a deliverable");

	}// GEN-LAST:event_lblEditDeliverMouseClicked

	double weight = -1;
	boolean weightException = false;

	private void lblEditDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeliverMouseEntered
		try {
			weight = Double.parseDouble(txtEditDeliverWeight.getText());

			if (lblSetupErrorLog.getText().equals(
					"Please enter a valid weight."))
				lblSetupErrorLog.setText("");
			weightException = false;
			txtDeliverWeight.setBorder(defaultHighlightBorder);
			if (currDeliver != null
					&& (!currDeliver.getName().equals(
							txtEditDeliverName.getText())
							|| currDeliver.getWeight() != weight || !currDeliver
							.getType().equals(
									comboEditDeliverType.getSelectedItem()))) {
				int i = currCourse.findDeliverable(new Deliverable(
						txtEditDeliverName.getText(),
						(String) comboEditDeliverType.getSelectedItem(),
						weight, 0));
				if (i == -1) {
					lblEditDeliver.setBorder(BorderFactory
							.createLineBorder(new Color(51, 255, 51)));
					boolDeliver = 1;
				} else {
					lblEditDeliver.setBorder(BorderFactory
							.createLineBorder(new Color(255, 51, 51)));
					boolDeliver = 0;
				}
			} else {
				lblEditDeliver.setBorder(BorderFactory
						.createLineBorder(new Color(204, 204, 204)));
				boolDeliver = 2;
			}
		} catch (NumberFormatException e) {
			weightException = true;
		}
	}// GEN-LAST:event_lblEditDeliverMouseEntered

	private void lblEditDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeliverMouseExited
		lblEditDeliver.setBorder(BorderFactory.createLineBorder(new Color(204,
				204, 204)));
	}// GEN-LAST:event_lblEditDeliverMouseExited

	private void lblEditDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeliverMousePressed
		if (boolDeliver == 0)
			colorDeliver = new Color(255, 51, 51);
		else if (boolDeliver == 1)
			colorDeliver = new Color(51, 255, 51);
		else
			colorCourse = new Color(204, 204, 204);
		lblEditDeliver.setBorder(BorderFactory.createBevelBorder(1,
				colorDeliver, colorDeliver, colorDeliver, colorDeliver));
	}// GEN-LAST:event_lblEditDeliverMousePressed

	private void lblEditDeliverMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeliverMouseReleased
		if (boolDeliver == 0)
			colorDeliver = new Color(255, 51, 51);
		else if (boolDeliver == 1)
			colorDeliver = new Color(51, 255, 51);
		else
			colorDeliver = new Color(204, 204, 204);
		lblEditDeliver.setBorder(BorderFactory.createLineBorder(colorDeliver));
	}// GEN-LAST:event_lblEditDeliverMouseReleased

	private void lblImportDeliversMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportDeliversMouseClicked
		if (currCourse != null) {
			final JFileChooser importDeliver = new JFileChooser();
			int returnVal = importDeliver.showOpenDialog(this);

			if (returnVal == 0) {
				if (!currCourse.importDeliverables(importDeliver
						.getSelectedFile())) {
					lblSetupErrorLog.setText("Fail to import, corrupt file.");
				} else
					updateInfo();
			}
		} else
			lblSetupErrorLog.setText("Please select a course.");
	}// GEN-LAST:event_lblImportDeliversMouseClicked

	private void lblImportDeliversMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportDeliversMouseEntered
		if (currCourse != null)
			lblImportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblImportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblImportDeliversMouseEntered

	private void lblImportDeliversMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportDeliversMouseExited
		lblImportDelivers.setBorder(BorderFactory.createLineBorder(new Color(
				204, 204, 204)));
	}// GEN-LAST:event_lblImportDeliversMouseExited

	private void lblImportDeliversMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportDeliversMousePressed
		if (currCourse != null)
			lblImportDelivers.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else
			lblImportDelivers.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));

	}// GEN-LAST:event_lblImportDeliversMousePressed

	private void lblImportDeliversMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblImportDeliversMouseReleased
		if (currCourse != null)
			lblImportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblImportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblImportDeliversMouseReleased

	private void lblExportDeliversMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportDeliversMouseClicked
		if (currCourse != null) {
			final JFileChooser exportDeliver = new JFileChooser();
			exportDeliver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = exportDeliver.showSaveDialog(this);

			if (returnVal == 0) {
				File file = new File(exportDeliver.getSelectedFile(),
						currCourse.getCode() + currCourse.getTerm()
								+ "Deliverables.csv");
				if (!currCourse.exportDeliverables(file))
					lblSetupErrorLog.setText("Fail to export.");
				updateInfo();
			}
		} else
			lblSetupErrorLog.setText("Please selcet a course.");
	}// GEN-LAST:event_lblExportDeliversMouseClicked

	private void lblExportDeliversMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportDeliversMouseEntered
		if (currCourse != null)
			lblExportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblExportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblExportDeliversMouseEntered

	private void lblExportDeliversMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportDeliversMouseExited
		lblExportDelivers.setBorder(BorderFactory.createLineBorder(new Color(
				204, 204, 204)));
	}// GEN-LAST:event_lblExportDeliversMouseExited

	private void lblExportDeliversMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportDeliversMousePressed
		if (currCourse != null)
			lblExportDelivers.setBorder(BorderFactory.createBevelBorder(1,
					new Color(20, 150, 250), new Color(20, 150, 250),
					new Color(20, 150, 250), new Color(20, 150, 250)));
		else
			lblExportDelivers.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));

	}// GEN-LAST:event_lblExportDeliversMousePressed

	private void lblExportDeliversMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblExportDeliversMouseReleased
		if (currCourse != null)
			lblExportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(20, 150, 250)));
		else
			lblExportDelivers.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblExportDeliversMouseReleased

	private void lblEditAddDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditAddDeliverMouseClicked
		hideMenu();
		if (currCourse != null) {
			restPnlCourse();
			restPnlDeliver();
			restPnlStudent();
			pnlAddDeliver.setVisible(true);
		} else {
			lblSetupErrorLog.setText("Please select a course");
		}
	}// GEN-LAST:event_lblEditAddDeliverMouseClicked

	private void lblEditAddDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditAddDeliverMouseEntered
		if (currCourse != null)
			lblEditAddDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(51, 255, 51)));
		else
			lblEditAddDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditAddDeliverMouseEntered

	private void lblEditAddDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditAddDeliverMouseExited
		lblEditAddDeliver.setBorder(BorderFactory.createLineBorder(new Color(
				204, 204, 204)));
	}// GEN-LAST:event_lblEditAddDeliverMouseExited

	private void lblEditAddDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditAddDeliverMousePressed
		if (currCourse != null)
			lblEditAddDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(51, 255, 51), new Color(51, 255, 51), new Color(
							51, 255, 51), new Color(51, 255, 51)));
		else
			lblEditAddDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditAddDeliverMousePressed

	private void lblEditAddDeliverMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditAddDeliverMouseReleased
		if (currCourse != null)
			lblEditAddDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(51, 255, 51)));
		else
			lblEditAddDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditAddDeliverMouseReleased

	private void lblEditDeleteDeliverMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeleteDeliverMouseClicked
		if (currCourse != null) {
			if (editDeliverList.getSelectedIndex() != -1) {
				String temp = listDelivers.getElementAt(editDeliverList
						.getSelectedIndex());
				currCourse.removeDeliverable(findDeliver(temp));
				updateInfo();
			} else
				lblSetupErrorLog.setText("Please select a deliverable");
		} else
			lblSetupErrorLog.setText("Please select a course");
	}// GEN-LAST:event_lblEditDeleteDeliverMouseClicked

	private void lblEditDeleteDeliverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeleteDeliverMouseEntered
		if (currCourse != null && editDeliverList.getSelectedIndex() != -1)
			lblEditDeleteDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(255, 51, 51)));
		else
			lblEditDeleteDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditDeleteDeliverMouseEntered

	private void lblEditDeleteDeliverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeleteDeliverMouseExited
		lblEditDeleteDeliver.setBorder(BorderFactory
				.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditDeleteDeliverMouseExited

	private void lblEditDeleteDeliverMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeleteDeliverMousePressed
		if (currCourse != null && editDeliverList.getSelectedIndex() != -1)
			lblEditDeleteDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(255, 51, 51), new Color(255, 51, 51), new Color(
							255, 51, 51), new Color(255, 51, 51)));
		else
			lblEditDeleteDeliver.setBorder(BorderFactory.createBevelBorder(1,
					new Color(204, 204, 204), new Color(204, 204, 204),
					new Color(204, 204, 204), new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditDeleteDeliverMousePressed

	private void lblEditDeleteDeliverMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblEditDeleteDeliverMouseReleased
		if (currCourse != null && editDeliverList.getSelectedIndex() != -1)
			lblEditDeleteDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(255, 51, 51)));
		else
			lblEditDeleteDeliver.setBorder(BorderFactory
					.createLineBorder(new Color(204, 204, 204)));
	}// GEN-LAST:event_lblEditDeleteDeliverMouseReleased

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Deliverable Config
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * End: Setup Tab
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * Start: Extras
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Tabs
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	private void lblTabGradesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabGradesMouseClicked
		tabSwitch(0);
	}// GEN-LAST:event_lblTabGradesMouseClicked

	private void lblTabSetupMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblTabSetupMouseClicked
		tabSwitch(1);
	}// GEN-LAST:event_lblTabSetupMouseClicked

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Tabs
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Drag
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	Point inWinCoords;

	private void formMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseDragged
		hideMenu();
		Point currCoords = evt.getLocationOnScreen();
		setLocation(currCoords.x - inWinCoords.x, currCoords.y - inWinCoords.y);
	}// GEN-LAST:event_formMouseDragged

	private void formMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMousePressed
		inWinCoords = evt.getPoint();
	}// GEN-LAST:event_formMousePressed

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Drag
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Minimize
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Minimize
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Exit
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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
		gradebook.setPrevCourse(currCourse);
		gradebook.store();
		System.exit(0);
	}// GEN-LAST:event_lblExitMouseClicked

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Exit
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: My Courses Menu
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */
	int check = 0;

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
		if (courseMenuList.getSelectedIndex() != -1) {
			if (!courseMenuList.getSelectedValue().equals("No Courses")
					&& check == 0) {
				check++;
				gradebook.setPrevCourse(currCourse);
				currCourse = gradebook.getCourse(courseMenuList
						.getSelectedIndex());
				updateInfo();
			} else
				check = 0;
		}
	}// GEN-LAST:event_courseMenuListValueChanged

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: My Courses Menu
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Add New Course Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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
				restPnlCourse();

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

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Add New Course Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Add New Deliverable Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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
					updateTables();
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
					restPnlDeliver();

					info = name + ", " + type + ", "
							+ Double.parseDouble(weight);
					listDelivers.addElement(info);
				}
			}
		}
	}// GEN-LAST:event_lblAddDeliverMouseClicked

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Add New Deliverable Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Add New Student Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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
					restPnlStudent();
					updateInfo();
				}
			}
		}
	}// GEN-LAST:event_lblAddStudentMouseClicked

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Add New Student Panel
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * Start: Helper Methods
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	private void tabSwitch(int i) {
		hideMenu();
		if (i == 0) {
			lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOn.png")));
			lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			lblTabDropbox.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			tabGrades.setVisible(true);
			tabSetup.setVisible(false);
			tabDropbox.setVisible(false);
		} else if (i == 1) {
			lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOn.png")));
			lblTabDropbox.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			tabGrades.setVisible(false);
			tabSetup.setVisible(true);
			tabDropbox.setVisible(false);
		} else {
			lblTabGrades.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			lblTabSetup.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOff.png")));
			lblTabDropbox.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/cs2212/team4/tabOn.png")));
			tabGrades.setVisible(false);
			tabSetup.setVisible(false);
			tabDropbox.setVisible(true);
		}
	}

	private String elimSpaces(String str) {
		int i = 0;
		for (; i < str.length(); i++)
			if (str.charAt(i) != ' ')
				break;
		if (i == str.length())
			return null;
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

		if (currCourse != null) {

			/** GRADES TAB */
			lblActiveCourseTitleInfo.setText(currCourse.getTitle());
			lblActiveCourseInfo.setText(currCourse.getCode()
					+ currCourse.getTerm());
			courseName.setText(currCourse.getTitle());

			updateTables();

			listDelivers.clear();
			for (int i = 0; i < currCourse.getDeliverableListSize(); i++) {
				deliver = currCourse.getDeliverable(i);
				if (deliver != null)
					listDelivers.addElement(deliver.getName() + ", "
							+ deliver.getType() + ", " + deliver.getWeight());
			}

			if (firstName == 1)
				lblFirstName.setBorder(BorderFactory
						.createLineBorder(new Color(20, 150, 250)));
			if (lastName == 1)
				lblLastName.setBorder(BorderFactory.createLineBorder(new Color(
						20, 150, 250)));
			if (number == 1)
				lblNumber.setBorder(BorderFactory.createLineBorder(new Color(
						20, 150, 250)));
			if (email == 1)
				lblEmail.setBorder(BorderFactory.createLineBorder(new Color(20,
						150, 250)));

			deleteDeliver.setVisible(false);
			deleteStudent.setVisible(false);
			lblGradesErrorLog.setText("");

			lblCourseSetup.setText("Course Setup: " + currCourse.getTitle()
					+ ", " + currCourse.getCode() + currCourse.getTerm());

			if (currCourse.getDescription().equals(""))
				txtCourseDesc.setText("Enter a course description...");
			else
				txtCourseDesc.setText(currCourse.getDescription());

			txtEditCourseTitle.setText(currCourse.getTitle());
			txtEditCourseCode.setText(currCourse.getCode());
			comboEditCourseTerm.setSelectedItem(currCourse.getTerm());

			lblSetupErrorLog.setText("");
		} else {
			lblActiveCourseTitleInfo.setText("Select a course");
			lblActiveCourseInfo.setText("");
			courseName.setText("select course");

			listDelivers.clear();
			updateTables();

			lblGradesErrorLog.setText("");

			lblCourseSetup.setText("Course Setup: ");

			txtCourseDesc.setText("Enter a course description...");
			txtEditCourseTitle.setText("Please select a course");
			txtEditCourseCode.setText("Please select a course");
			comboEditCourseTerm.setSelectedItem(0);

			lblSetupErrorLog.setText("");
		}
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

	private void updateTables() {

		if (currCourse != null) {
			makeTables(firstName, lastName, email, number);
			studentTable.setModel(tableStudents);
			gradesTable.setModel(tableGrades);
			initTables();
		} else {
			currCourse = new Course("", "", "");
			makeTables(firstName, lastName, email, number);
			studentTable.setModel(tableStudents);
			gradesTable.setModel(tableGrades);
			initTables();
			currCourse = null;
		}
	}

	private void makeTables(int first, int last, int email, int num) {
		tableStudents = new UsersTable(currCourse, first, last, email, num);
		tableStudents.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				updateTables();
			}
		});
		tableStudents.getGradesTable().addTableModelListener(
				new TableModelListener() {
					@Override
					public void tableChanged(TableModelEvent e) {
						updateTables();
					}
				});
		tableGrades = tableStudents.getGradesTable();
	}

	private void initTables() {
		// Create a fixed-size table (adjusting to view settings/number of
		// columns)
		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		if (gradesTable.getColumnCount() + studentTable.getColumnCount() < 11)
			gradesTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		else
			gradesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentTable.setPreferredScrollableViewportSize(studentTable
				.getPreferredSize());
		gradesTable.setPreferredScrollableViewportSize(gradesTable
				.getPreferredSize());

		BoundedRangeModel model = gradesScroll.getVerticalScrollBar()
				.getModel();
		studentScroll.getVerticalScrollBar().setPreferredSize(
				new Dimension(0, 0));
		studentScroll.getVerticalScrollBar().setModel(model);
		gradesScroll.getVerticalScrollBar().setPreferredSize(
				new Dimension(15, 5));
		gradesScroll.setWheelScrollingEnabled(true);

        studentTable.setSelectionModel(gradesTable.getSelectionModel());
        studentTable.setRowSorter(gradesTable.getRowSorter());
	}

	private Integer findDeliver(String deliver) {
		String name = "", type = "", w = "";
		Double weight;
		int i = 0;
		while (deliver.charAt(i) != ',') {
			name += deliver.charAt(i);
			i++;
		}
		i += 2;
		while (deliver.charAt(i) != ',') {
			type += deliver.charAt(i);
			i++;
		}
		i += 2;
		while (i < deliver.length()) {
			w += deliver.charAt(i);
			i++;
		}
		weight = Double.parseDouble(w);
		return currCourse
				.findDeliverable(new Deliverable(name, type, weight, 0));
	}

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * 
	 * End: Helper Methods
	 * 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 */

	/****************************************************************************************************
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 * End: Extras
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
	 **************************************************************************************************** 
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
	private javax.swing.JComboBox comboEditDeliverType;
	private javax.swing.JLayeredPane container;
	private javax.swing.JScrollPane courseDescScroll;
	private javax.swing.JList courseMenuList;
	private javax.swing.JLabel courseName;
	private javax.swing.JScrollPane courses;
	private javax.swing.JLabel deleteDeliver;
	private javax.swing.JLabel deleteStudent;
	private javax.swing.JList deliverList;
	private javax.swing.JScrollPane deliversScroll;
	private javax.swing.JLabel editCourseIcon;
	private javax.swing.JList editDeliverList;
	private javax.swing.JScrollPane editDeliverListScroll;
	private javax.swing.JScrollPane gradesScroll;
	private javax.swing.JTable gradesTable;
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
	private javax.swing.JLabel lblCourseDeliverables;
	private javax.swing.JLabel lblCourseName;
	private javax.swing.JLabel lblCourseSetup;
	private javax.swing.JLabel lblCourseTerm;
	private javax.swing.JLabel lblDbxAuthLink;
	private javax.swing.JLabel lblDbxDownload;
	private javax.swing.JLabel lblDbxErrorLog;
	private javax.swing.JLabel lblDbxGenerate;
	private javax.swing.JLabel lblDbxSubmit;
	private javax.swing.JLabel lblDbxUpload;
	private javax.swing.JLabel lblDbxVerify;
	private javax.swing.JLabel lblDeleteCourse;
	private javax.swing.JLabel lblDeliverAddErrorLog;
	private javax.swing.JLabel lblDeliverName;
	private javax.swing.JLabel lblDeliverType;
	private javax.swing.JLabel lblDeliverWeight;
	private javax.swing.JLabel lblDropbox;
	private javax.swing.JLabel lblEditAddDeliver;
	private javax.swing.JLabel lblEditCourse;
	private javax.swing.JLabel lblEditCourseCode;
	private javax.swing.JLabel lblEditCourseTerm;
	private javax.swing.JLabel lblEditCourseTtile;
	private javax.swing.JLabel lblEditDeleteDeliver;
	private javax.swing.JLabel lblEditDeliver;
	private javax.swing.JLabel lblEditDeliverName;
	private javax.swing.JLabel lblEditDeliverType;
	private javax.swing.JLabel lblEditDeliverWeight;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblExit;
	private javax.swing.JLabel lblExportDelivers;
	private javax.swing.JLabel lblExportGrades;
	private javax.swing.JLabel lblExportStudents;
	private javax.swing.JLabel lblFirstName;
	private javax.swing.JLabel lblGrades;
	private javax.swing.JLabel lblGradesErrorLog;
	private javax.swing.JLabel lblImportDelivers;
	private javax.swing.JLabel lblImportGrades;
	private javax.swing.JLabel lblImportStudents;
	private javax.swing.JLabel lblLastName;
	private javax.swing.JLabel lblMini;
	private javax.swing.JLabel lblNumber;
	private javax.swing.JLabel lblSetup;
	private javax.swing.JLabel lblSetupErrorLog;
	private javax.swing.JLabel lblStudentAddErrorLog;
	private javax.swing.JLabel lblStudentEmail;
	private javax.swing.JLabel lblStudentNameFirst;
	private javax.swing.JLabel lblStudentNameLast;
	private javax.swing.JLabel lblStudentNumber;
	private javax.swing.JLabel lblTabDropbox;
	private javax.swing.JLabel lblTabGrades;
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
	private javax.swing.JPanel tabDropbox;
	private javax.swing.JPanel tabGrades;
	private javax.swing.JPanel tabSetup;
	private javax.swing.JTextField txtCourseCode;
	private javax.swing.JTextPane txtCourseDesc;
	private javax.swing.JTextField txtCourseName;
	private javax.swing.JTextField txtDbxCode;
	private javax.swing.JTextField txtDeliverName;
	private javax.swing.JTextField txtDeliverWeight;
	private javax.swing.JTextField txtEditCourseCode;
	private javax.swing.JTextField txtEditCourseTitle;
	private javax.swing.JTextField txtEditDeliverName;
	private javax.swing.JTextField txtEditDeliverWeight;
	private javax.swing.JTextField txtStudentEmail;
	private javax.swing.JTextField txtStudentNameFirst;
	private javax.swing.JTextField txtStudentNameLast;
	private javax.swing.JTextField txtStudentNumber;
	// End of variables declaration//GEN-END:variables
}
