package graphics;

import java.awt.BorderLayout;
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

/**
 * The Frame class holds the base of the GUI structure for the Teacher Grading
 * Simulator. It holds the card layout used to move between pages of the
 * program. The class also holds the buttons required to move between pages and
 * creates instances of the pages themselves to place into the GUI container.
 * 
 * @author Daniel Santillan
 */
public class Frame extends JFrame {

	// Version
	private static final long serialVersionUID = 1L;
	
	// CardLayout and container for the card layout
	private CardLayout cl;
	private Container container;
	
	// JPanels for the container
	private TitleScreen page1;
	private Instructions page2;
	private AddAssignments page3;
	private GradeAssignments page4;
	private StudentReport page5;
	private EasterEgg page6;

	
	/**
	 * The Frame constructor sets up the various qualities of the JFrame for the
	 * program. It also instantiates the card layout and the JPanel. The Frame
	 * constructor also refreshes the graphics from TitleScreen.java if the 
	 * frame was resized.
	 */
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
	
	
	/**
	 * The setUpCardLayout method creates all the buttons necessary to swap
	 * between pages of the program. The buttons are ImageIcons from the
	 * GraphicsConstants class. It also adds all the JPanels (the pages of the
	 * program) to the container that holds the CardLayout.
	 */
	private void setUpCardLayout() {
		JButton btnPageOneStart = new JButton(GraphicsConstants.ICON_START);
		btnPageOneStart.setBorder(null);
		btnPageOneStart.setOpaque(false);
		btnPageOneStart.setContentAreaFilled(false);	
		btnPageOneStart.setBorderPainted(false);
		
		JButton btnPageOneEasterEgg = new JButton(GraphicsConstants.ICON_EASTER_EGG);
		btnPageOneEasterEgg.setBorder(null);
		btnPageOneEasterEgg.setOpaque(false);
		btnPageOneEasterEgg.setContentAreaFilled(false);
		btnPageOneEasterEgg.setBorderPainted(false);
		
		JButton btnPageOneInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS);
		btnPageOneInstructions.setBorder(null);
		btnPageOneInstructions.setOpaque(false);
		btnPageOneInstructions.setContentAreaFilled(false);
		btnPageOneInstructions.setBorderPainted(false);
		
		JButton btnPageTwoReturn = new JButton(GraphicsConstants.ICON_RETURN_HOME);
		btnPageTwoReturn.setBorder(null);
		btnPageTwoReturn.setOpaque(false);
		btnPageTwoReturn.setContentAreaFilled(false);
		btnPageTwoReturn.setBorderPainted(false);
		
		JButton btnPageThreeGradeAssignments = new JButton(GraphicsConstants.ICON_GRADE_ASSIGNMENTS);
		btnPageThreeGradeAssignments.setBorder(null);
		btnPageThreeGradeAssignments.setOpaque(false);
		btnPageThreeGradeAssignments.setContentAreaFilled(false);
		btnPageThreeGradeAssignments.setBorderPainted(false);
		
		JButton btnPageThreeStudentReport = new JButton(GraphicsConstants.ICON_STUDENT_REPORT);
		btnPageThreeStudentReport.setBorder(null);
		btnPageThreeStudentReport.setOpaque(false);
		btnPageThreeStudentReport.setContentAreaFilled(false);
		btnPageThreeStudentReport.setBorderPainted(false);
		
		JButton btnPageThreeInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageThreeInstructions.setBorder(null);
		btnPageThreeInstructions.setOpaque(false);
		btnPageThreeInstructions.setContentAreaFilled(false);
		btnPageThreeInstructions.setBorderPainted(false);
		
		JButton btnPageThreeClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageThreeClose.setBorder(null);
		btnPageThreeClose.setOpaque(false);
		btnPageThreeClose.setContentAreaFilled(false);
		btnPageThreeClose.setBorderPainted(false);
		
		JButton btnPageFourAddAssignments = new JButton(GraphicsConstants.ICON_ADD_ASSIGNMENTS);
		btnPageFourAddAssignments.setBorder(null);
		btnPageFourAddAssignments.setOpaque(false);
		btnPageFourAddAssignments.setContentAreaFilled(false);
		btnPageFourAddAssignments.setBorderPainted(false);
		
		JButton btnPageFourStudentReport = new JButton(GraphicsConstants.ICON_STUDENT_REPORT);
		btnPageFourStudentReport.setBorder(null);
		btnPageFourStudentReport.setOpaque(false);
		btnPageFourStudentReport.setContentAreaFilled(false);
		btnPageFourStudentReport.setBorderPainted(false);
		
		JButton btnPageFourInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageFourInstructions.setBorder(null);
		btnPageFourInstructions.setOpaque(false);
		btnPageFourInstructions.setContentAreaFilled(false);
		btnPageFourInstructions.setBorderPainted(false);
		
		JButton btnPageFourClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageFourClose.setBorder(null);
		btnPageFourClose.setOpaque(false);
		btnPageFourClose.setContentAreaFilled(false);
		btnPageFourClose.setBorderPainted(false);
		
		JButton btnPageFiveAddAssignments = new JButton(GraphicsConstants.ICON_ADD_ASSIGNMENTS);
		btnPageFiveAddAssignments.setBorder(null);
		btnPageFiveAddAssignments.setOpaque(false);
		btnPageFiveAddAssignments.setContentAreaFilled(false);
		btnPageFiveAddAssignments.setBorderPainted(false);
		
		JButton btnPageFiveGradeAssignments = new JButton(GraphicsConstants.ICON_GRADE_ASSIGNMENTS);
		btnPageFiveGradeAssignments.setBorder(null);
		btnPageFiveGradeAssignments.setOpaque(false);
		btnPageFiveGradeAssignments.setContentAreaFilled(false);
		btnPageFiveGradeAssignments.setBorderPainted(false);
		
		JButton btnPageFiveInstructions = new JButton(GraphicsConstants.ICON_INSTRUCTIONS2);
		btnPageFiveInstructions.setBorder(null);
		btnPageFiveInstructions.setOpaque(false);
		btnPageFiveInstructions.setContentAreaFilled(false);
		btnPageFiveInstructions.setBorderPainted(false);
		
		JButton btnPageFiveClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageFiveClose.setBorder(null);
		btnPageFiveClose.setOpaque(false);
		btnPageFiveClose.setContentAreaFilled(false);
		btnPageFiveClose.setBorderPainted(false);
		
		JButton btnPageSixClose = new JButton(GraphicsConstants.ICON_CLOSE);
		btnPageSixClose.setBorder(null);
		btnPageSixClose.setOpaque(false);
		btnPageSixClose.setContentAreaFilled(false);
		btnPageSixClose.setBorderPainted(false);
		
		ActionListener al = new ActionListener() {
			
			/**
			 * The actionPerformed method, embedded in the creation of the
			 * ActionListener object, handles the actions performed by each
			 * button in the Frame class. Specifically, it moves users to a new
			 * page of the Teacher Grading Simulator depending on which button
			 * was selected.
			 */
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
			
		};
		
		btnPageOneStart.addActionListener(al);
		btnPageOneEasterEgg.addActionListener(al);
		btnPageOneInstructions.addActionListener(al);
		btnPageTwoReturn.addActionListener(al);
		btnPageThreeGradeAssignments.addActionListener(al);
		btnPageThreeStudentReport.addActionListener(al);
		btnPageThreeInstructions.addActionListener(al);
		btnPageThreeClose.addActionListener(al);
		btnPageFourAddAssignments.addActionListener(al);
		btnPageFourStudentReport.addActionListener(al);
		btnPageFourInstructions.addActionListener(al);
		btnPageFourClose.addActionListener(al);
		btnPageFiveAddAssignments.addActionListener(al);
		btnPageFiveGradeAssignments.addActionListener(al);
		btnPageFiveInstructions.addActionListener(al);
		btnPageFiveClose.addActionListener(al);
		btnPageSixClose.addActionListener(al);
		
		
		page1.add(btnPageOneStart);
		page1.add(btnPageOneEasterEgg);
		page1.add(btnPageOneInstructions);
		page2.add(btnPageTwoReturn, BorderLayout.NORTH);
		page2.addInstructions();
		page3.addFlowLayoutComponents(btnPageThreeGradeAssignments, 
				btnPageThreeStudentReport, btnPageThreeInstructions, btnPageThreeClose);
		page4.addFlowLayoutComponents(btnPageFourAddAssignments,
				btnPageFourStudentReport, btnPageFourInstructions, btnPageFourClose);
		page5.addFlowLayoutComponents(btnPageFiveAddAssignments, 
				btnPageFiveGradeAssignments, btnPageFiveInstructions, btnPageFiveClose);
		page6.addFlowLayoutComponents(btnPageSixClose);
		
		container.add(page1);
		container.add(page2);
		container.add(page3);
		container.add(page4);
		container.add(page5);
		container.add(page6);
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "Frame [cl=" + cl + ", container=" + container + ", page1=" + page1 + ", page2=" + page2 + ", page3="
				+ page3 + ", page4=" + page4 + ", page5=" + page5 + ", page6=" + page6 + "]";
	}
	
}
