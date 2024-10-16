package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The MenuGraphics class draws the graphics for the menu page of the Teacher
 * Grading System. The graphics also involves some motion.
 * 
 * @author Daniel Santillan
 */
public class PageAMenu extends JPanel {

	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;	// Version
	
	
	/*
	 * The paintComponent method paints the graphics for the title screen.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Constants.BG_PURPLE);
		g2d.fillRect(0, 0, getWidth(), getHeight());

	}
	
}
