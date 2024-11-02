package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Instructions extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public Instructions() {

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
