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


public class StudentReport extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FlowLayout fl, fl2;
	private BorderLayout bl;
	private JPanel northPanel, centerPanel, southPanel;

	private JLabel labelResult;
	private JButton btnRetrieveData, btnGenerateReport;
	private JComboBox<String> comboBoxSelectStudents;


	public StudentReport() {
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


	public void prepareNorthPanel() {
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


	public void prepareCenterPanel() {
		centerPanel = new JPanel();

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


	public void prepareSouthPanel() {
		fl2 = new FlowLayout();
		fl2.setAlignment(FlowLayout.CENTER);
		southPanel = new JPanel(fl2);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);

		btnRetrieveData = new JButton(GraphicsConstants.ICON_RETRIEVE_DATA);
		btnRetrieveData.addActionListener(this);
		btnRetrieveData.setBorder(null);
		btnRetrieveData.setOpaque(false);
		btnRetrieveData.setContentAreaFilled(false);
		btnRetrieveData.setBorderPainted(false);

		btnGenerateReport = new JButton(GraphicsConstants.ICON_GENERATE_REPORT);
		btnGenerateReport.addActionListener(this);
		btnGenerateReport.setBorder(null);
		btnGenerateReport.setOpaque(false);
		btnGenerateReport.setContentAreaFilled(false);
		btnGenerateReport.setBorderPainted(false);

		southPanel.add(btnRetrieveData);
		southPanel.add(btnGenerateReport);

		add(southPanel, BorderLayout.SOUTH);
	}


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
					labelResult.setIcon(GraphicsConstants.FILE_CREATED);
					setVisible(false);
					setVisible(true);
				} else {
					labelResult.setIcon(GraphicsConstants.FAILED_TO_COMPILE);
					setVisible(false);
					setVisible(true);

				}
			} catch (Exception a) {
				
			}

		}

	}

}
