package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddAssignments extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private FlowLayout fl;
	private BorderLayout bl;
	private JPanel flPanel;
	
	
	public AddAssignments() {
		bl = new BorderLayout();
		setLayout(bl);
		
		fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		flPanel = new JPanel();
		flPanel.setBackground(GraphicsConstants.headerColor);
		flPanel.setLayout(fl);	
		add(flPanel, BorderLayout.NORTH);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(GraphicsConstants.backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.headerColor);
		g2d.fillRect(0, 0, getWidth(), 50);
	}
	
	
	public void addFlowLayoutComponents(JButton a, JButton b, JButton c, JButton d) {
		flPanel.add(a);
		flPanel.add(b);
		flPanel.add(c);
		flPanel.add(d);
	}

}
