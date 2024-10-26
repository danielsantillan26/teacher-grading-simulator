package graphics;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener{

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
	private JButton pageOneEasterEgg;
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
		setFocusable(true);
		
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
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				page1.resetGraphics();
			}
		});
	}
	
	
	private void setUpCardLayout() {
		Icon addAssignments = new ImageIcon("src/resources/ADD_ASSIGNMENTS.png");
		Icon close = new ImageIcon("src/resources/CLOSE.png");
		Icon easterEgg = new ImageIcon("src/resources/EASTER_EGG.png");
		Icon gradeAssignments = new ImageIcon("src/resources/GRADE_ASSIGNMENTS.png");
		Icon instructions = new ImageIcon("src/resources/INSTRUCTIONS.png");
		Icon instructions2 = new ImageIcon("src/resources/INSTRUCTIONS2.png");
		Icon returnHome = new ImageIcon("src/resources/RETURN.png");
		Icon start = new ImageIcon("src/resources/START.png");
		Icon studentReport = new ImageIcon("src/resources/STUDENT_REPORT.png");
		
		pageOneStart = new JButton(start);
		pageOneStart.setBorder(null);
		pageOneStart.setOpaque(false);
		pageOneStart.setContentAreaFilled(false);		// https://stackoverflow.com/questions/4585867/transparent-jbutton
		pageOneStart.setBorderPainted(false);
		
		pageOneEasterEgg = new JButton(easterEgg);
		pageOneEasterEgg.setBorder(null);
		pageOneEasterEgg.setOpaque(false);
		pageOneEasterEgg.setContentAreaFilled(false);
		pageOneEasterEgg.setBorderPainted(false);
		
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
		
		pageThreeGradeAssignments = new JButton(gradeAssignments);
		pageThreeGradeAssignments.setBorder(null);
		pageThreeGradeAssignments.setOpaque(false);
		pageThreeGradeAssignments.setContentAreaFilled(false);
		pageThreeGradeAssignments.setBorderPainted(false);
		
		pageThreeStudentReport = new JButton(studentReport);
		pageThreeStudentReport.setBorder(null);
		pageThreeStudentReport.setOpaque(false);
		pageThreeStudentReport.setContentAreaFilled(false);
		pageThreeStudentReport.setBorderPainted(false);
		
		pageThreeInstructions = new JButton(instructions2);
		pageThreeInstructions.setBorder(null);
		pageThreeInstructions.setOpaque(false);
		pageThreeInstructions.setContentAreaFilled(false);
		pageThreeInstructions.setBorderPainted(false);
		
		pageThreeClose = new JButton(close);
		pageThreeClose.setBorder(null);
		pageThreeClose.setOpaque(false);
		pageThreeClose.setContentAreaFilled(false);
		pageThreeClose.setBorderPainted(false);
		
		pageFourAddAssignments = new JButton(addAssignments);
		pageFourAddAssignments.setBorder(null);
		pageFourAddAssignments.setOpaque(false);
		pageFourAddAssignments.setContentAreaFilled(false);
		pageFourAddAssignments.setBorderPainted(false);
		
		pageFourStudentReport = new JButton(studentReport);
		pageFourStudentReport.setBorder(null);
		pageFourStudentReport.setOpaque(false);
		pageFourStudentReport.setContentAreaFilled(false);
		pageFourStudentReport.setBorderPainted(false);
		
		pageFourInstructions = new JButton(instructions2);
		pageFourInstructions.setBorder(null);
		pageFourInstructions.setOpaque(false);
		pageFourInstructions.setContentAreaFilled(false);
		pageFourInstructions.setBorderPainted(false);
		
		pageFourClose = new JButton(close);
		pageFourClose.setBorder(null);
		pageFourClose.setOpaque(false);
		pageFourClose.setContentAreaFilled(false);
		pageFourClose.setBorderPainted(false);
		
		pageFiveAddAssignments = new JButton(addAssignments);
		pageFiveAddAssignments.setBorder(null);
		pageFiveAddAssignments.setOpaque(false);
		pageFiveAddAssignments.setContentAreaFilled(false);
		pageFiveAddAssignments.setBorderPainted(false);
		
		pageFiveGradeAssignments = new JButton(gradeAssignments);
		pageFiveGradeAssignments.setBorder(null);
		pageFiveGradeAssignments.setOpaque(false);
		pageFiveGradeAssignments.setContentAreaFilled(false);
		pageFiveGradeAssignments.setBorderPainted(false);
		
		pageFiveInstructions = new JButton(instructions2);
		pageFiveInstructions.setBorder(null);
		pageFiveInstructions.setOpaque(false);
		pageFiveInstructions.setContentAreaFilled(false);
		pageFiveInstructions.setBorderPainted(false);
		
		pageFiveClose = new JButton(close);
		pageFiveClose.setBorder(null);
		pageFiveClose.setOpaque(false);
		pageFiveClose.setContentAreaFilled(false);
		pageFiveClose.setBorderPainted(false);
		
		pageSixClose = new JButton(close);
		pageSixClose.setBorder(null);
		pageSixClose.setOpaque(false);
		pageSixClose.setContentAreaFilled(false);
		pageSixClose.setBorderPainted(false);
		
		pageOneStart.addActionListener(this);
		pageOneEasterEgg.addActionListener(this);
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
		page1.add(pageOneEasterEgg);
		page1.add(pageOneInstructions);
		page2.add(pageTwoReturn);
		page3.addFlowLayoutComponents(pageThreeGradeAssignments, 
				pageThreeStudentReport, pageThreeInstructions, pageThreeClose);
		page4.addFlowLayoutComponents(pageFourAddAssignments,
				pageFourStudentReport, pageFourInstructions, pageFourClose);
		page5.addFlowLayoutComponents(pageFiveAddAssignments, 
				pageFiveGradeAssignments, pageFiveInstructions, pageFiveClose);
		page6.addFlowLayoutComponents(pageSixClose);
		
		container.add(TITLE_SCREEN, page1);
		container.add(INSTRUCTIONS, page2);
		container.add(ADD_ASSIGNMENTS, page3);
		container.add(GRADE_ASSIGNMENTS, page4);
		container.add(STUDENT_REPORT, page5);
		container.add(EASTER_EGG, page6);
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
		} else if (e.getSource() == pageOneEasterEgg) {
			cl.last(container);
		}
		
	}
	
	
}
