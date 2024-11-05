package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instructions extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public Instructions() {
		setLayout(new BorderLayout());
	}
	
	
	public void addInstructions() {
		JLabel labelInstructions = new JLabel(GraphicsConstants.ICON_INSTRUCTIONS_FULL);
		labelInstructions.setBounds(new Rectangle(50, 100, getWidth() - 50, getHeight() - 50));
		add(labelInstructions, BorderLayout.CENTER);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(GraphicsConstants.COLOR_BACKGROUND);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.COLOR_HEADER);
		g2d.fillRect(0, 0, getWidth(), 50);
	}
	
}
