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


public class GradeAssignments extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FlowLayout fl, fl2;
	private BorderLayout bl;
	private MigLayout ml;
	private JPanel northPanel, centerPanel, southPanel;

	private JButton btnRetrieveData, btnSaveData, btnLoadStudentData;
	private JComboBox<String> comboBoxSelectAssignment;
	private JLabel labelSelectAssignment;
	private JTable table;
	private JScrollPane spTable;


	public GradeAssignments() {
		bl = new BorderLayout();
		setLayout(bl);

		prepareNorthPanel();
		prepareCenterPanel();
		prepareSouthPanel();
	}


	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(GraphicsConstants.COLOR_BACKGROUND);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.COLOR_HEADER);
		g2d.fillRect(0, 0, getWidth(), 50);
	}


	private void prepareNorthPanel() {
		fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		northPanel = new JPanel(fl);
		northPanel.setBackground(GraphicsConstants.COLOR_HEADER);
		add(northPanel, BorderLayout.NORTH);
	}


	public void addFlowLayoutComponents(JButton a, JButton b, JButton c, JButton d) {
		northPanel.add(a);
		northPanel.add(b);
		northPanel.add(c);
		northPanel.add(d);
	}


	private void prepareCenterPanel() {
		ml = new MigLayout();
		centerPanel = new JPanel(ml);
		centerPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);

		labelSelectAssignment = new JLabel(GraphicsConstants.ICON_SELECT_ASSIGNMENT);
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
		spTable = new JScrollPane(table);
		spTable.setPreferredSize(new Dimension(1400, 800));

		centerPanel.add(spTable, "span 2 4");
		centerPanel.add(labelSelectAssignment, "wrap");
		centerPanel.add(comboBoxSelectAssignment, "wrap");

		add(centerPanel, BorderLayout.CENTER);

	}


	private void prepareSouthPanel() {
		fl2 = new FlowLayout();
		fl2.setAlignment(FlowLayout.CENTER);

		southPanel = new JPanel(fl);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);
		southPanel.setPreferredSize(new Dimension(getWidth(), 50));

		btnLoadStudentData = new JButton(GraphicsConstants.ICON_LOAD_STUDENT_DATA);
		btnLoadStudentData.addActionListener(this);
		btnLoadStudentData.setBorder(null);
		btnLoadStudentData.setOpaque(false);
		btnLoadStudentData.setContentAreaFilled(false);
		btnLoadStudentData.setBorderPainted(false);

		btnRetrieveData = new JButton(GraphicsConstants.ICON_RETRIEVE_DATA);
		btnRetrieveData.addActionListener(this);
		btnRetrieveData.setBorder(null);
		btnRetrieveData.setOpaque(false);
		btnRetrieveData.setContentAreaFilled(false);
		btnRetrieveData.setBorderPainted(false);

		btnSaveData = new JButton(GraphicsConstants.ICON_SAVE_DATA);
		btnSaveData.addActionListener(this);
		btnSaveData.setBorder(null);
		btnSaveData.setOpaque(false);
		btnSaveData.setContentAreaFilled(false);
		btnSaveData.setBorderPainted(false);

		southPanel.add(btnLoadStudentData);
		southPanel.add(btnRetrieveData);
		southPanel.add(btnSaveData);

		add(southPanel, BorderLayout.SOUTH);

	}


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

			for (int k = 0; k < assignments.size(); k++) {
				comboBoxSelectAssignment.addItem(assignments.get(k));
			}

		} else if (e.getSource() == btnSaveData) {
			StudentInformation.updateStudents(table, comboBoxSelectAssignment.getSelectedIndex());
		}
	}

}
