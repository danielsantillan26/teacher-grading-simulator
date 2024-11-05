package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import student.StudentInformation;

/**
 * The AddAssignments class creates the JPanel for the Add Assignments page of
 * the Teacher Grading Simulator. It adds all the labels and buttons necessary
 * for this section, as well as a JTable that stores user-inputted data and a
 * JComboBox that categorizes the user-inputted data.
 * 
 * @author Daniel Santillan
 */
public class AddAssignments extends JPanel {

	// Version
	private static final long serialVersionUID = 1L;

	// Components that must be accessed by multiple methods
	private JPanel northPanel;
	private JTable table;
	private JComboBox<String> comboBoxSelectSystem;


	/**
	 * The AddAssignments constructor sets up the layout of the JPanel and adds
	 * the components of the section by calling specific methods.
	 */
	public AddAssignments() {
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
	 * The prepareNorthPanel method creates the JPanel that is set in the Add 
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
	 * Add Assignment section's center area. This includes the JTable used to
	 * collect assignment names and point/weight values and the JComboBox that
	 * users implement to select the grading system.
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

		JLabel labelSelectSystem = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("SELECT_SYSTEM.png")));

		comboBoxSelectSystem = new JComboBox<String>();
		comboBoxSelectSystem.addItem("Points System");
		comboBoxSelectSystem.addItem("Unweighted Percents");
		comboBoxSelectSystem.addItem("Weighted Percents");

		String[] columnNames = {"Assignment", "Points/Weight"};
		Object[][] data = {{"Add Assignment Name", "Add Points/Weight"},
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
		centerPanel.add(labelSelectSystem, "wrap");
		centerPanel.add(comboBoxSelectSystem, "wrap, left");

		add(centerPanel, BorderLayout.CENTER);

	}


	/**
	 * The prepareSouthPanel method creates the JPanel that is set in the
	 * Add Assignment section's south border. This includes the JButtons used
	 * to collect and reset assignment data.
	 * 
	 * @param fl		the FlowLayout manager for this panel
	 */
	private void prepareSouthPanel(FlowLayout fl) {
		JPanel southPanel = new JPanel(fl);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);
		southPanel.setPreferredSize(new Dimension(getWidth(), 50));

		JButton btnCollectData = new JButton(new ImageIcon(getClass().getClassLoader().getResource("COLLECT_DATA.png")));
		btnCollectData.setBorder(null);
		btnCollectData.setOpaque(false);
		btnCollectData.setContentAreaFilled(false);
		btnCollectData.setBorderPainted(false);

		JButton btnResetData = new JButton(new ImageIcon(getClass().getClassLoader().getResource("RESET_DATA.png")));
		btnResetData.setBorder(null);
		btnResetData.setOpaque(false);
		btnResetData.setContentAreaFilled(false);
		btnResetData.setBorderPainted(false);

		ActionListener al = new ActionListener() {

			/**
			 * The actionPerformed method takes in an ActionEvent. The method 
			 * determines which button the action came from and performs 
			 * specific actions based on that observation.
			 * 
			 * In this case, the method updates assignments using an external 
			 * method if the collect data button is hit and resets the JTable if
			 * the reset data button is hit.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCollectData) {
					StudentInformation.updateAssignments(table, (String)comboBoxSelectSystem.getSelectedItem());
				} else if (e.getSource() == btnResetData) {
					table.setValueAt("Add Assignment Name", 0, 0);
					table.setValueAt("Add Points/Weight", 0, 1);

					for (int i = 1; i < table.getRowCount(); i++) {
						table.setValueAt("", i, 0);
						table.setValueAt("", i, 1);
					}
				}
			}
		};
		
		btnCollectData.addActionListener(al);
		btnResetData.addActionListener(al);

		southPanel.add(btnCollectData);
		southPanel.add(btnResetData);

		add(southPanel, BorderLayout.SOUTH);
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "AddAssignments [northPanel=" + northPanel + ", table=" + table + ", comboBoxSelectSystem="
				+ comboBoxSelectSystem + "]";
	}

}
