package graphics;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	
	private JButton btnPageOneStart;
	private JButton btnPageOneInstructions;
	private JButton btnPageOneEasterEgg;
	private JButton btnPageTwoReturn;
	private JButton btnPageThreeGradeAssignments;
	private JButton btnPageThreeStudentReport;
	private JButton btnPageThreeInstructions;
	private JButton btnPageThreeClose;
	private JButton btnPageFourAddAssignments;
	private JButton btnPageFourStudentReport;
	private JButton btnPageFourInstructions;
	private JButton btnPageFourClose;
	private JButton btnPageFiveAddAssignments;
	private JButton btnPageFiveGradeAssignments;
	private JButton btnPageFiveInstructions;
	private JButton btnPageFiveClose;
	private JButton btnPageSixClose;
	
	
	public Frame() {
		setTitle("Teacher Grading System");
		Dimension x = Toolkit.getDefaultToolkit().getScreenSize();
		int length = x.width;
		int width = x.height;
		setSize(length, width);
		setExtendedState(JFrame. MAXIMIZED_BOTH);
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
		btnPageOneStart = new JButton(GraphicsConstants.ICON_START);
		btnPageOneStart.setBorder(null);
		btnPageOneStart.setOpaque(false);
		btnPageOneStart.setContentAreaFilled(false);		// https://stackoverflow.com/questions/4585867/transparent-jbutton
		btnPageOneStart.setBorderPainted(false);
		
		btnPageOneEasterEgg = new JButton(GraphicsConstants.ICON_EASTER_EGG);
		btnPageOneEasterEgg.setBorder(null);
		btnPageOneEasterEgg.setOpaque(false);
		btnPageOneEasterEgg.setContentAreaFilled(false);
		btnPageOneEasterEgg.setBorderPainted(false);
		
		btnPageOneInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS);
		btnPageOneInstructions.setBorder(null);
		btnPageOneInstructions.setOpaque(false);
		btnPageOneInstructions.setContentAreaFilled(false);
		btnPageOneInstructions.setBorderPainted(false);
		
		btnPageTwoReturn = new JButton(GraphicsConstants.ICON_RETURN_HOME);
		btnPageTwoReturn.setBorder(null);
		btnPageTwoReturn.setOpaque(false);
		btnPageTwoReturn.setContentAreaFilled(false);
		btnPageTwoReturn.setBorderPainted(false);
		
		btnPageThreeGradeAssignments = new JButton(GraphicsConstants.ICON_GRADE_ASSIGNMENTS);
		btnPageThreeGradeAssignments.setBorder(null);
		btnPageThreeGradeAssignments.setOpaque(false);
		btnPageThreeGradeAssignments.setContentAreaFilled(false);
		btnPageThreeGradeAssignments.setBorderPainted(false);
		
		btnPageThreeStudentReport = new JButton(GraphicsConstants.ICON_STUDENT_REPORT);
		btnPageThreeStudentReport.setBorder(null);
		btnPageThreeStudentReport.setOpaque(false);
		btnPageThreeStudentReport.setContentAreaFilled(false);
		btnPageThreeStudentReport.setBorderPainted(false);
		
		btnPageThreeInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageThreeInstructions.setBorder(null);
		btnPageThreeInstructions.setOpaque(false);
		btnPageThreeInstructions.setContentAreaFilled(false);
		btnPageThreeInstructions.setBorderPainted(false);
		
		btnPageThreeClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageThreeClose.setBorder(null);
		btnPageThreeClose.setOpaque(false);
		btnPageThreeClose.setContentAreaFilled(false);
		btnPageThreeClose.setBorderPainted(false);
		
		btnPageFourAddAssignments = new JButton(GraphicsConstants.ICON_ADD_ASSIGNMENTS);
		btnPageFourAddAssignments.setBorder(null);
		btnPageFourAddAssignments.setOpaque(false);
		btnPageFourAddAssignments.setContentAreaFilled(false);
		btnPageFourAddAssignments.setBorderPainted(false);
		
		btnPageFourStudentReport = new JButton(GraphicsConstants.ICON_STUDENT_REPORT);
		btnPageFourStudentReport.setBorder(null);
		btnPageFourStudentReport.setOpaque(false);
		btnPageFourStudentReport.setContentAreaFilled(false);
		btnPageFourStudentReport.setBorderPainted(false);
		
		btnPageFourInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageFourInstructions.setBorder(null);
		btnPageFourInstructions.setOpaque(false);
		btnPageFourInstructions.setContentAreaFilled(false);
		btnPageFourInstructions.setBorderPainted(false);
		
		btnPageFourClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageFourClose.setBorder(null);
		btnPageFourClose.setOpaque(false);
		btnPageFourClose.setContentAreaFilled(false);
		btnPageFourClose.setBorderPainted(false);
		
		btnPageFiveAddAssignments = new JButton(GraphicsConstants.ICON_ADD_ASSIGNMENTS);
		btnPageFiveAddAssignments.setBorder(null);
		btnPageFiveAddAssignments.setOpaque(false);
		btnPageFiveAddAssignments.setContentAreaFilled(false);
		btnPageFiveAddAssignments.setBorderPainted(false);
		
		btnPageFiveGradeAssignments = new JButton(GraphicsConstants.ICON_GRADE_ASSIGNMENTS);
		btnPageFiveGradeAssignments.setBorder(null);
		btnPageFiveGradeAssignments.setOpaque(false);
		btnPageFiveGradeAssignments.setContentAreaFilled(false);
		btnPageFiveGradeAssignments.setBorderPainted(false);
		
		btnPageFiveInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageFiveInstructions.setBorder(null);
		btnPageFiveInstructions.setOpaque(false);
		btnPageFiveInstructions.setContentAreaFilled(false);
		btnPageFiveInstructions.setBorderPainted(false);
		
		btnPageFiveClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageFiveClose.setBorder(null);
		btnPageFiveClose.setOpaque(false);
		btnPageFiveClose.setContentAreaFilled(false);
		btnPageFiveClose.setBorderPainted(false);
		
		btnPageSixClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageSixClose.setBorder(null);
		btnPageSixClose.setOpaque(false);
		btnPageSixClose.setContentAreaFilled(false);
		btnPageSixClose.setBorderPainted(false);
		
		btnPageOneStart.addActionListener(this);
		btnPageOneEasterEgg.addActionListener(this);
		btnPageOneInstructions.addActionListener(this);
		btnPageTwoReturn.addActionListener(this);
		btnPageThreeGradeAssignments.addActionListener(this);
		btnPageThreeStudentReport.addActionListener(this);
		btnPageThreeInstructions.addActionListener(this);
		btnPageThreeClose.addActionListener(this);
		btnPageFourAddAssignments.addActionListener(this);
		btnPageFourStudentReport.addActionListener(this);
		btnPageFourInstructions.addActionListener(this);
		btnPageFourClose.addActionListener(this);
		btnPageFiveAddAssignments.addActionListener(this);
		btnPageFiveGradeAssignments.addActionListener(this);
		btnPageFiveInstructions.addActionListener(this);
		btnPageFiveClose.addActionListener(this);
		btnPageSixClose.addActionListener(this);
		
		page1.add(btnPageOneStart);
		page1.add(btnPageOneEasterEgg);
		page1.add(btnPageOneInstructions);
		page2.add(btnPageTwoReturn);
		page3.addFlowLayoutComponents(btnPageThreeGradeAssignments, 
				btnPageThreeStudentReport, btnPageThreeInstructions, btnPageThreeClose);
		page4.addFlowLayoutComponents(btnPageFourAddAssignments,
				btnPageFourStudentReport, btnPageFourInstructions, btnPageFourClose);
		page5.addFlowLayoutComponents(btnPageFiveAddAssignments, 
				btnPageFiveGradeAssignments, btnPageFiveInstructions, btnPageFiveClose);
		page6.addFlowLayoutComponents(btnPageSixClose);
		
		container.add(TITLE_SCREEN, page1);
		container.add(INSTRUCTIONS, page2);
		container.add(ADD_ASSIGNMENTS, page3);
		container.add(GRADE_ASSIGNMENTS, page4);
		container.add(STUDENT_REPORT, page5);
		container.add(EASTER_EGG, page6);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPageOneStart || e.getSource() == 
				btnPageFourAddAssignments || e.getSource() ==
				btnPageFiveAddAssignments) {
			cl.first(container);
			cl.next(container);
			cl.next(container);
		} else if (e.getSource() == btnPageOneInstructions || e.getSource() ==
				btnPageThreeInstructions || e.getSource() == btnPageFourInstructions
				|| e.getSource() == btnPageFiveInstructions) {
			cl.first(container);
			cl.next(container);
		} else if (e.getSource() == btnPageThreeGradeAssignments || e.getSource()
				== btnPageFiveGradeAssignments) {
			cl.last(container);
			cl.previous(container);
			cl.previous(container);
		} else if (e.getSource() == btnPageThreeStudentReport || e.getSource() ==
				btnPageFourStudentReport) {
			cl.last(container);
			cl.previous(container);
		} else if (e.getSource() == btnPageTwoReturn) {
			cl.first(container);
			page1.resetGraphics();
		} else if (e.getSource() == btnPageThreeClose || e.getSource() ==
				btnPageFourClose || e.getSource() == btnPageFiveClose || e.getSource()
				== btnPageSixClose) {
			System.exit(0);
		} else if (e.getSource() == btnPageOneEasterEgg) {
			cl.last(container);
		}
		
	}
	
	
}
