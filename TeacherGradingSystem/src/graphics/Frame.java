package graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO: Delete Later
 * 
 * OVERVIEW:
 * Page 1 - start up
 * Page 2 - instructions
 * Page 3 - add assignments
 * Page 4 - grade assignments
 * Page 5 - release student report (export as file)
 * Page 6 - Easter Egg (rick roll video)
 * 
 * 
 */
public class Frame extends JFrame implements ActionListener {
	
	// FIELDS
	private static final long serialVersionUID = 1L;	// Version
	private CardLayout cl;								// CardLayout
	private Container container;						// Container
	
	// JBUTTONS
	private JButton buttonPageOneStartUp;				// Page 1 Startup
	private JButton buttonPageOneInstructions;			// Page 1 Instructions
	private JButton buttonPageTwoAddAssignments;		// Page 2 Assignments
	private JButton buttonPageTwoGradeAssignments;		// Page 2 Grader
	private JButton buttonPageTwoReport;				// Page 2 Student Report
	private JButton buttonPageTwoClose;					// Page 2 Close
	private JButton buttonPageThreeGradeAssignments;	// Page 3 Grader
	private JButton buttonPageThreeReport;				// Page 3 Student Report
	private JButton buttonPageThreeInstructions;		// Page 3 Instructions
	private JButton buttonPageThreeClose;				// Page 3 Close
	private JButton buttonPageFourAddAssignments;		// Page 4 Assignments
	private JButton buttonPageFourReport;				// Page 4 Student Report
	private JButton buttonPageFourInstructions;			// Page 4 Instructions
	private JButton buttonPageFourClose;				// Page 4 Close;
	private JButton buttonPageFiveAddAssignments;		// Page 5 Assignments
	private JButton buttonPageFiveGradeAssignments;		// Page 5 Grader
	private JButton buttonPageFiveInstructions;			// Page 5 Instructions
	private JButton buttonPageFiveClose;				// Page 5 Close;
	private JButton buttonPageSixClose;					// Page 6 Close;
	
	// PAGES
	private PageAMenu page1;							// Page 1 panel
	private PageBInstructions page2;					// Page 2 panel
	private PageCAddAssignments page3;					// Page 3 panel
	private PageDGradeAssignments page4;				// Page 4 panel
	private PageEStudentReport page5;					// Page 5 panel
	private PageFEasterEgg page6;						// Page 6 panel
	
	// STRING CARD NAMES
	private static final String START_UP = "a";			// For page 1
	private static final String INSTRUCTIONS = "b";		// For page 2
	private static final String ADD_ASGNMNT = "c";		// For page 3
	private static final String GRADE_ASGNMNT = "d";	// For page 4
	private static final String STDNT_REPORT = "e";		// For page 5
	private static final String EASTER_EGG = "f";		// For page 6
	
	
	/**
	 * TODO: Fill out JavaDocs
	 * @param name
	 */
	public Frame(String name) {
		setTitle(name);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width, size.height);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cl = new CardLayout();
		container = getContentPane();
		container.setLayout(cl);
		
		setUpButtons();
	}
	
	
	private void setUpButtons() {
		buttonPageOneStartUp = new JButton("START");
		buttonPageOneInstructions = new JButton("INSTRUCTIONS");
		buttonPageTwoAddAssignments = new JButton("ADD ASSIGNMENTS");
		buttonPageTwoGradeAssignments = new JButton("GRADE ASSIGNMENTS");
		buttonPageTwoReport = new JButton("STUDENT REPORT");
		buttonPageTwoClose = new JButton("CLOSE");
		buttonPageThreeGradeAssignments = new JButton("GRADE ASSIGNMENTS");
		buttonPageThreeReport = new JButton("STUDENT REPORT");
		buttonPageThreeInstructions = new JButton("INSTRUCTIONS");
		buttonPageThreeClose = new JButton("CLOSE");
		buttonPageFourAddAssignments = new JButton("ADD ASSIGNMENTS");
		buttonPageFourReport = new JButton("STUDENT REPORT");
		buttonPageFourInstructions = new JButton("INSTRUCTIONS");
		buttonPageFourClose = new JButton("CLOSE");
		buttonPageFiveAddAssignments = new JButton("ADD ASSIGNMENTS");
		buttonPageFiveGradeAssignments = new JButton("GRADE ASSIGNMENTS");
		buttonPageFiveInstructions = new JButton("INSTRUCTIONS");
		buttonPageFiveClose = new JButton("CLOSE");
		buttonPageSixClose = new JButton("CLOSE");
		
		buttonPageOneStartUp.addActionListener(this);
		buttonPageOneInstructions.addActionListener(this);
		buttonPageTwoAddAssignments.addActionListener(this);
		buttonPageTwoGradeAssignments.addActionListener(this);
		buttonPageTwoReport.addActionListener(this);
		buttonPageTwoClose.addActionListener(this);
		buttonPageThreeGradeAssignments.addActionListener(this);
		buttonPageThreeReport.addActionListener(this);
		buttonPageThreeInstructions.addActionListener(this);
		buttonPageThreeClose.addActionListener(this);
		buttonPageFourAddAssignments.addActionListener(this);
		buttonPageFourReport.addActionListener(this);
		buttonPageFourInstructions.addActionListener(this);
		buttonPageFourClose.addActionListener(this);
		buttonPageFiveAddAssignments.addActionListener(this);
		buttonPageFiveGradeAssignments.addActionListener(this);
		buttonPageFiveInstructions.addActionListener(this);
		buttonPageFiveClose.addActionListener(this);
		buttonPageSixClose.addActionListener(this);
		
		page1.add(buttonPageOneStartUp);
		page1.add(buttonPageOneInstructions);
		page2.add(buttonPageTwoAddAssignments);
		page2.add(buttonPageTwoGradeAssignments);
		page2.add(buttonPageTwoReport);
		page2.add(buttonPageTwoClose);
		page3.add(buttonPageThreeGradeAssignments);
		page3.add(buttonPageThreeReport);
		page3.add(buttonPageThreeInstructions);
		page3.add(buttonPageThreeClose);
		page4.add(buttonPageFourAddAssignments);
		page4.add(buttonPageFourReport);
		page4.add(buttonPageFourInstructions);
		page4.add(buttonPageFourClose);
		page5.add(buttonPageFiveAddAssignments);
		page5.add(buttonPageFiveGradeAssignments);
		page5.add(buttonPageFiveInstructions);
		page5.add(buttonPageFiveClose);
		page6.add(buttonPageSixClose);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
