package graphics;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	
	private CardLayout cl;
	private Container container;
	
	private TitleScreen page1;
	private Instructions page2;
	private AddAssignments page3;
	private GradeAssignments page4;
	private StudentReport page5;
	private EasterEgg page6;
	
	private static final String TITLE_SCREEN = "1";
	private static final String INSTRUCTIONS = "2";
	private static final String ADD_ASSIGNMENTS = "3";
	private static final String GRADE_ASSIGNMENTS = "4";
	private static final String STUDENT_REPORT = "5";
	private static final String EASTER_EGG = "6";
	
	private JButton pageOneStart;
	private JButton pageOneInstructions;
	private JButton pageTwoReturn;
	private JButton pageThreeGradeAssignments;
	private JButton pageThreeStudentReport;
	private JButton pageThreeInstructions;
	private JButton pageThreeClose;
	private JButton pageFourAddAssignments;
	private JButton pageFourStudentReport;
	private JButton pageFourInstructions;
	private JButton pageFourClose;
	private JButton pageFiveAddAssignments;
	private JButton pageFiveGradeAssignments;
	private JButton pageFiveInstructions;
	private JButton pageFiveClose;
	private JButton pageSixClose;
	
	
	public Frame() {
		setTitle("Teacher Grading System");
		Dimension x = Toolkit.getDefaultToolkit().getScreenSize();
		int length = x.width;
		int width = x.height;
		setSize(length, width);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);	
		
		cl = new CardLayout();
		container = getContentPane();
		container.setLayout(cl);
		
		page1 = new TitleScreen();
		page2 = new Instructions();
		page3 = new AddAssignments();
		page4 = new GradeAssignments();
		page5 = new StudentReport();
		page6 = new EasterEgg();
		
		setUpCardLayout();
	}
	
	
	private void setUpCardLayout() {
		Icon start = new ImageIcon("src/resources/START.png");
		Icon instructions = new ImageIcon("src/resources/INSTRUCTIONS.png");
		Icon returnHome = new ImageIcon("src/resources/RETURN.png");
		
		pageOneStart = new JButton(start);
		pageOneStart.setBorder(null);
		pageOneStart.setOpaque(false);
		pageOneStart.setContentAreaFilled(false);		// https://stackoverflow.com/questions/4585867/transparent-jbutton
		pageOneStart.setBorderPainted(false);
		
		pageOneInstructions = new JButton(instructions);
		pageOneInstructions.setBorder(null);
		pageOneInstructions.setOpaque(false);
		pageOneInstructions.setContentAreaFilled(false);
		pageOneInstructions.setBorderPainted(false);
		
		pageTwoReturn = new JButton(returnHome);
		pageTwoReturn.setBorder(null);
		pageTwoReturn.setOpaque(false);
		pageTwoReturn.setContentAreaFilled(false);
		pageTwoReturn.setBorderPainted(false);
		
		pageThreeGradeAssignments = new JButton("GRADE ASSIGNMENTS");
		pageThreeStudentReport = new JButton("STUDENT REPORT");
		pageThreeInstructions = new JButton("INSTRUCTIONS");
		pageThreeClose = new JButton("CLOSE");
		pageFourAddAssignments = new JButton("ADD ASSIGNMENTS");
		pageFourStudentReport = new JButton("STUDENT REPORT");
		pageFourInstructions = new JButton("INSTRUCTIONS");
		pageFourClose = new JButton("CLOSE");
		pageFiveAddAssignments = new JButton("ADD ASSIGNMENTS");
		pageFiveGradeAssignments = new JButton("GRADE ASSIGNMENTS");
		pageFiveInstructions = new JButton("INSTRUCTIONS");
		pageFiveClose = new JButton("CLOSE");
		pageSixClose = new JButton("CLOSE");
		
		pageOneStart.addActionListener(this);
		pageOneInstructions.addActionListener(this);
		pageTwoReturn.addActionListener(this);
		pageThreeGradeAssignments.addActionListener(this);
		pageThreeStudentReport.addActionListener(this);
		pageThreeInstructions.addActionListener(this);
		pageThreeClose.addActionListener(this);
		pageFourAddAssignments.addActionListener(this);
		pageFourStudentReport.addActionListener(this);
		pageFourInstructions.addActionListener(this);
		pageFourClose.addActionListener(this);
		pageFiveAddAssignments.addActionListener(this);
		pageFiveGradeAssignments.addActionListener(this);
		pageFiveInstructions.addActionListener(this);
		pageFiveClose.addActionListener(this);
		pageSixClose.addActionListener(this);
		
		page1.add(pageOneStart);
		page1.add(pageOneInstructions);
		page2.add(pageTwoReturn);
		page3.add(pageThreeGradeAssignments);
		page3.add(pageThreeStudentReport);
		page3.add(pageThreeInstructions);
		page3.add(pageThreeClose);
		page4.add(pageFourAddAssignments);
		page4.add(pageFourStudentReport);
		page4.add(pageFourInstructions);
		page4.add(pageFourClose);
		page5.add(pageFiveAddAssignments);
		page5.add(pageFiveGradeAssignments);
		page5.add(pageFiveInstructions);
		page5.add(pageFiveClose);
		page6.add(pageSixClose);
		
		container.add(TITLE_SCREEN, page1);
		container.add(INSTRUCTIONS, page2);
		container.add(ADD_ASSIGNMENTS, page3);
		container.add(GRADE_ASSIGNMENTS, page4);
		container.add(STUDENT_REPORT, page5);
		container.add(EASTER_EGG, page6);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pageOneStart || e.getSource() == 
				pageFourAddAssignments || e.getSource() ==
				pageFiveAddAssignments) {
			cl.first(container);
			cl.next(container);
			cl.next(container);
		} else if (e.getSource() == pageOneInstructions || e.getSource() ==
				pageThreeInstructions || e.getSource() == pageFourInstructions
				|| e.getSource() == pageFiveInstructions) {
			cl.first(container);
			cl.next(container);
		} else if (e.getSource() == pageThreeGradeAssignments || e.getSource()
				== pageFiveGradeAssignments) {
			cl.last(container);
			cl.previous(container);
			cl.previous(container);
		} else if (e.getSource() == pageThreeStudentReport || e.getSource() ==
				pageFourStudentReport) {
			cl.last(container);
			cl.previous(container);
		} else if (e.getSource() == pageTwoReturn) {
			cl.first(container);
			page1.resetGraphics();
		} else if (e.getSource() == pageThreeClose || e.getSource() ==
				pageFourClose || e.getSource() == pageFiveClose || e.getSource()
				== pageSixClose) {
			System.exit(0);
		}
		
	}
	
	
}
