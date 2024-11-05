package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import student.StudentInformation;

/**
 * The StudentReport class creates the JPanel for the Student Report page of the
 * Teacher Grading Simulator. It adds the labels and buttons necessary for this
 * section, as well as the JComboBox that lets users select the student to form
 * a report for.
 * 
 * @author Daniel Santillan
 */
public class StudentReport extends JPanel {

	// Version
	private static final long serialVersionUID = 1L;

	// Components that must be accessed by multiple methods
	private JPanel northPanel;
	private JLabel labelResult;
	private JComboBox<String> comboBoxSelectStudents;


	/**
	 * The StudentReport constructor sets up the layout of the JPanel and adds
	 * the components of the section by calling specific methods.
	 */
	public StudentReport() {
		setLayout(new BorderLayout());
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		
		prepareNorthPanel(fl);
		prepareCenterPanel();
		prepareSouthPanel(fl);

	}


	/**
	 * The paintComponent method paints the background of the section.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(GraphicsConstants.COLOR_BACKGROUND);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.COLOR_HEADER);
		g2d.fillRect(0, 0, getWidth(), 50);
	}


	/**
	 * The prepareNorthPanel method creates the JPanel that is set in the 
	 * Student Report section's north border. This includes the buttons that let 
	 * users to switch between sections.
	 * 
	 * @param fl	the FlowLayout manager for this panel
	 */
	public void prepareNorthPanel(FlowLayout fl) {
		northPanel = new JPanel(fl);
		northPanel.setBackground(GraphicsConstants.COLOR_HEADER);
		add(northPanel, BorderLayout.NORTH);
	}


	/**
	 * The addFlowLayoutComponents method adds the buttons from the Frame class
	 * into the north panel. These buttons are used to switch between sections
	 * while in the Teacher Grading Simulator.
	 */
	public void addFlowLayoutComponents(JButton a, JButton b, JButton c, JButton d) {
		northPanel.add(a);
		northPanel.add(b);
		northPanel.add(c);
		northPanel.add(d);
	}


	/**
	 * The prepareCenterPanel method creates the JPanel that is set in the 
	 * Student Report section's center area. This includes the JComboBox that
	 * lets users select a student to grade, plus a JLabel that determines
	 * whether or not the file was successfully created.
	 */
	public void prepareCenterPanel() {
		JPanel centerPanel = new JPanel();

		centerPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);

		JLabel labelSelectStudent = new JLabel(GraphicsConstants.ICON_SELECT_STUDENT);

		comboBoxSelectStudents = new JComboBox<String>();
		comboBoxSelectStudents.addItem("Select Student");
		comboBoxSelectStudents.setPreferredSize(new Dimension(300, 30));
		
		labelResult = new JLabel();
		
		centerPanel.add(labelSelectStudent);
		centerPanel.add(comboBoxSelectStudents);
		centerPanel.add(labelResult);

		add(centerPanel, BorderLayout.CENTER);
	}


	/**
	 * The prepareSouthPanel method creates the JPanel that is set in the
	 * Student Report section's south border. This includes the buttons to
	 * retrieve student data and generate the student report.
	 * 
	 * @param fl
	 */
	public void prepareSouthPanel(FlowLayout fl) {
		JPanel southPanel = new JPanel(fl);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);

		JButton btnRetrieveData = new JButton(GraphicsConstants.ICON_RETRIEVE_DATA);
		btnRetrieveData.setBorder(null);
		btnRetrieveData.setOpaque(false);
		btnRetrieveData.setContentAreaFilled(false);
		btnRetrieveData.setBorderPainted(false);

		JButton btnGenerateReport = new JButton(GraphicsConstants.ICON_GENERATE_REPORT);
		btnGenerateReport.setBorder(null);
		btnGenerateReport.setOpaque(false);
		btnGenerateReport.setContentAreaFilled(false);
		btnGenerateReport.setBorderPainted(false);

		ActionListener al = new ActionListener() {
			
			/**
			 * The actionPerformed method takes in an ActionEvent. The method 
			 * determines which button the action came from and performs 
			 * specific actions based on that observation.
			 * 
			 * In this case, the method updates students on the JComboBox if the
			 * retrieve data button is hit and tries generating a student report 
			 * if the generate report button is hit.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRetrieveData) {
					List<String> studentNames = StudentInformation.getStudentNames();

					if (comboBoxSelectStudents.getItemAt(0) != null) {
						comboBoxSelectStudents.removeAllItems();
					}

					for (int i = 0; i < studentNames.size(); i++) {
						comboBoxSelectStudents.addItem(studentNames.get(i));
					}

				} else if (e.getSource() == btnGenerateReport) {

					try {
						if (StudentInformation.generateStudentReport(comboBoxSelectStudents.getSelectedIndex())) {
							labelResult.setIcon(GraphicsConstants.ICON_FILE_CREATED);
							setVisible(false);
							setVisible(true);
						} else {
							labelResult.setIcon(GraphicsConstants.ICON_FAILED_TO_COMPILE);
							setVisible(false);
							setVisible(true);
						}
					} catch (Exception a) { }
				}
			}
		};
		
		btnRetrieveData.addActionListener(al);
		btnGenerateReport.addActionListener(al);
		
		southPanel.add(btnRetrieveData);
		southPanel.add(btnGenerateReport);

		add(southPanel, BorderLayout.SOUTH);
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "StudentReport [northPanel=" + northPanel + ", labelResult=" + labelResult + ", comboBoxSelectStudents="
				+ comboBoxSelectStudents + "]";
	}

}
