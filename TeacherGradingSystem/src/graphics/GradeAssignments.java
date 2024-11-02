package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import student.StudentConstants;

public class GradeAssignments extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private FlowLayout fl;
	private BorderLayout bl;
	private MigLayout ml;
	private JPanel northPanel, centerPanel;
	
	private JButton btnCollectData;
	private JComboBox<String> comboBoxSelectAssignment;
	
	
	public GradeAssignments() {
		bl = new BorderLayout();
		setLayout(bl);
		
		prepareNorthPanel();
		prepareCenterPanel();
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
	
	
	private void prepareCenterPanel() {
		centerPanel = new JPanel(ml);
		
		
	}
	
	
	public void addFlowLayoutComponents(JButton a, JButton b, JButton c, JButton d) {
		northPanel.add(a);
		northPanel.add(b);
		northPanel.add(c);
		northPanel.add(d);
	}

}
