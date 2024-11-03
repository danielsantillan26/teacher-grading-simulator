package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import student.StudentInformation;



public class AddAssignments extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private FlowLayout fl, fl2;
	private BorderLayout bl;
	private MigLayout ml;
	private JPanel northPanel, centerPanel, southPanel;
	
	private JButton btnCollectData, btnResetData;
	private JLabel labelSelectSystem;
	private JTable table;
	private JScrollPane spTable;
	private JComboBox<String> comboBoxSelectSystem;
	
	
	/**
	 * 
	 */
	public AddAssignments() {
		bl = new BorderLayout();
		fl = new FlowLayout();
		fl2 = new FlowLayout();
		ml = new MigLayout();
		
		setLayout(bl);
		
		prepareNorthPanel();
		prepareCenterPanel();
		prepareSouthPanel();
	}
	
	
	/**
	 * 
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
	 * 
	 */
	private void prepareNorthPanel() {
		fl.setAlignment(FlowLayout.CENTER);
		
		northPanel = new JPanel(fl);
		northPanel.setBackground(GraphicsConstants.COLOR_HEADER);	
		
		add(northPanel, BorderLayout.NORTH);
	}
	
	
	/**
	 * 
	 */
	public void addFlowLayoutComponents(JButton a, JButton b, JButton c, JButton d) {
		northPanel.add(a);
		northPanel.add(b);
		northPanel.add(c);
		northPanel.add(d);
	}
	
	
	/**
	 * 
	 */
	private void prepareCenterPanel() {
		centerPanel = new JPanel(ml);
		centerPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);
		
		labelSelectSystem = new JLabel(GraphicsConstants.ICON_SELECT_SYSTEM);
		
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
		spTable = new JScrollPane(table);
		spTable.setPreferredSize(new Dimension(1400, 800));
		
		centerPanel.add(spTable, "span 2 4");
		centerPanel.add(labelSelectSystem, "wrap");
		centerPanel.add(comboBoxSelectSystem, "wrap, left");
		
		add(centerPanel, BorderLayout.CENTER);

	}
	
	
	/**
	 * 
	 */
	private void prepareSouthPanel() {
		fl2.setAlignment(FlowLayout.CENTER);
		
		southPanel = new JPanel(fl2);
		southPanel.setBackground(GraphicsConstants.COLOR_BACKGROUND);
		southPanel.setPreferredSize(new Dimension(getWidth(), 50));
		
		btnCollectData = new JButton(GraphicsConstants.ICON_COLLECT_DATA);
		btnCollectData.addActionListener(this);
		btnCollectData.setBorder(null);
		btnCollectData.setOpaque(false);
		btnCollectData.setContentAreaFilled(false);
		btnCollectData.setBorderPainted(false);
		
		btnResetData = new JButton(GraphicsConstants.ICON_RESET_DATA);
		btnResetData.addActionListener(this);
		btnResetData.setBorder(null);
		btnResetData.setOpaque(false);
		btnResetData.setContentAreaFilled(false);
		btnResetData.setBorderPainted(false);
		
		southPanel.add(btnCollectData);
		southPanel.add(btnResetData);
		
		add(southPanel, BorderLayout.SOUTH);
	}


	/**
	 * 
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

}
