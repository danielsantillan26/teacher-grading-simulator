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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import student.StudentInformation;

/**
 * The GradeAssignments class creates the JPanel for the Grade Assignments page
 * of the Teacher Grading Simulator. It adds all the labels and buttons 
 * necessary for this section, as well as a JTable that scores user-inputted
 * data and a JComboBox that categorizes the user-inputted data.
 * 
 * @author DanielSantillan
 */
public class GradeAssignments extends JPanel {

	// Version
	private static final long serialVersionUID = 1L;

	// Components that must be accessed by multiple methods
	private JPanel northPanel;
	private JTable table;
	private JComboBox<String> comboBoxSelectAssignment;


	/**
	 * The GradeAssignments constructor sets up the layout of the JPanel and
	 * adds the components of the section by calling specific methods.
	 */
	public GradeAssignments() {
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
	 * The prepareNorthPanel method creates the JPanel that is set in the Grade 
	 * Assignment section's north border. This includes the buttons that allow 
	 * users to switch between sections.
	 * 
	 * @param fl	the FlowLayout manager for this panel
	 */
	private void prepareNorthPanel(FlowLayout fl) {
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
	 * Grade Assignment section's center area. This includes the JTable used to
	 * collect student names and their grades and the JComboBox that users
	 * implement to select the assignment being graded.
	 * 
	 * This panel uses an external layout manager I found on the Internet. It
	 * helped simplify positioning my JTable and JComboBox in this section. The
	 * layout manager is called MigLayout and can be found here:
	 * 
	 * http://www.miglayout.com/, retrieved 1 November 2024, made by
	 * Mikael Grev
	 */
	private void prepareCenterPanel() {
		JPanel centerPanel = new JPanel(new MigLayout());
		centerPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);

		JLabel labelSelectAssignment = new JLabel(GraphicsConstants.ICON_SELECT_ASSIGNMENT);
		comboBoxSelectAssignment = new JComboBox<String>();
		comboBoxSelectAssignment.addItem("Select Assignment");
		comboBoxSelectAssignment.setPreferredSize(new Dimension(300, 30));

		String[] columnNames = {"Student Name", "Grade (Points or Percent)"};
		Object[][] data = {{"Add Student Name", "Add Grade"},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},
				{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""},};
		table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		JScrollPane spTable = new JScrollPane(table);
		spTable.setPreferredSize(new Dimension(1400, 800));

		centerPanel.add(spTable, "span 2 4");
		centerPanel.add(labelSelectAssignment, "wrap");
		centerPanel.add(comboBoxSelectAssignment, "wrap");

		add(centerPanel, BorderLayout.CENTER);

	}


	/**
	 * The prepareSouthPanel method creates the JPanel that is set in the
	 * Grade Assignment section's south border. This includes the JButtons used
	 * to retrieve student data, retrieve assignment data, and collect student
	 * data.
	 * 
	 * @param fl		the FlowLayout manager for this panel
	 */
	private void prepareSouthPanel(FlowLayout fl) {
		JPanel southPanel = new JPanel(fl);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);
		southPanel.setPreferredSize(new Dimension(getWidth(), 50));

		JButton btnLoadStudentData = new JButton(GraphicsConstants.ICON_LOAD_STUDENT_DATA);
		btnLoadStudentData.setBorder(null);
		btnLoadStudentData.setOpaque(false);
		btnLoadStudentData.setContentAreaFilled(false);
		btnLoadStudentData.setBorderPainted(false);

		JButton btnRetrieveData = new JButton(GraphicsConstants.ICON_RETRIEVE_DATA);
		btnRetrieveData.setBorder(null);
		btnRetrieveData.setOpaque(false);
		btnRetrieveData.setContentAreaFilled(false);
		btnRetrieveData.setBorderPainted(false);

		JButton btnSaveData = new JButton(GraphicsConstants.ICON_SAVE_DATA);
		btnSaveData.setBorder(null);
		btnSaveData.setOpaque(false);
		btnSaveData.setContentAreaFilled(false);
		btnSaveData.setBorderPainted(false);
		
		ActionListener al = new ActionListener() {
			
			/**
			 * The actionPerformed method takes in an ActionEvent. The method 
			 * determines which button the action came from and performs 
			 * specific actions based on that observation.
			 * 
			 * In this case, the method loads student data on the JTable when 
			 * the load student data button is hit, adds assignment names to the
			 * JComboBox when the retrieve data button is hit, and collects 
			 * grade data to be added in the student objects when the save data
			 * button is hit.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnLoadStudentData) {
					List<String> names = StudentInformation.getStudentNames();
					for (int i = 0; i < names.size(); i++) {
						table.setValueAt(names.get(i), i, 0);
					}
					
				} else if (e.getSource() == btnRetrieveData) {
					List<String> assignments = StudentInformation.getAssignmentList();
					
					if (comboBoxSelectAssignment.getItemAt(0) != null) {
						comboBoxSelectAssignment.removeAllItems();
					}

					int j = 0;
					while (j < assignments.size()) {
						comboBoxSelectAssignment.addItem(assignments.get(j));
						j++;
					}

				} else if (e.getSource() == btnSaveData) {
					StudentInformation.updateStudents(table, comboBoxSelectAssignment.getSelectedIndex());
				}
			}
		};
		
		btnLoadStudentData.addActionListener(al);
		btnRetrieveData.addActionListener(al);
		btnSaveData.addActionListener(al);

		southPanel.add(btnLoadStudentData);
		southPanel.add(btnRetrieveData);
		southPanel.add(btnSaveData);

		add(southPanel, BorderLayout.SOUTH);

	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "GradeAssignments [northPanel=" + northPanel + ", table=" + table + ", comboBoxSelectAssignment="
				+ comboBoxSelectAssignment + "]";
	}
	
}
