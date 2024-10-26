package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The TitleScreen class creates the graphics for the title card of the Teacher
 * Grading System.
 * 
 * @author Daniel Santillan
 */
public class TitleScreen extends JPanel {
	
	/**
	 * FIELDS
	 */
	private static final long serialVersionUID = 1L;  // Version
	private int logoXTeacher;						  // X-coord for "teacher"
	private int logoXGrading;						  // X-coord for "grading"	
	private int logoXSimulator;						  // X-coord for "simulator"
	private int logoXSymbol;						  // X-coord for the symbol
	
	
	/**
	 * The TitleScreen constructor equates default values to the x-coordinates
	 * for each piece of the Teacher Grading System's logo.
	 */
	public TitleScreen() {
		logoXTeacher = 0;
		logoXGrading = 0;
		logoXSimulator = 0;
		logoXSymbol = 1500;
	}
	
	
	/**
	 * The paintComponent method prepares all the graphics necessary for the
	 * title card. The method prepares the background colors and the logo.
	 * The method also changes the values of the fields until they reach a
	 * certain point (using conditionals and repaint()) to make the logo "move
	 * into place" when the user opens the program.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(GraphicsConstants.backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.headerColor);
		g2d.fillRect(0, 0, getWidth(), 50);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Helvetica Bold", Font.BOLD, 120));
		g2d.drawString("Teacher", logoXTeacher, getHeight()/2 - 125);
		g2d.drawString("Grading", logoXGrading, getHeight()/2);
		g2d.drawString("Simulator", logoXSimulator, getHeight()/2 + 125);
		
		Color symbolColor = new Color(0, 59, 155);
		g2d.setColor(symbolColor);
		g2d.fillOval(logoXSymbol, getHeight()/2 - 200, 250, 250);
		g2d.setColor(GraphicsConstants.backgroundColor);
		g2d.fillOval(logoXSymbol + 75, getHeight()/2 - 175, 150, 150);
		g2d.setColor(symbolColor);
		g2d.fillOval(logoXSymbol + 80, getHeight()/2 - 150, 25, 25);
		g2d.fillOval(logoXSymbol + 150, getHeight()/2 - 155, 80, 80);
		
		
		if (logoXTeacher < getWidth()/2 - 450) {
			logoXTeacher++;
		}
		
		if (logoXGrading < getWidth()/2 - 400) {
			logoXGrading++;
		}
		
		if (logoXSimulator < getWidth()/2 - 350) {
			logoXSimulator++;
		}
		
		if (logoXSymbol > getWidth()/2 + 75) {
			logoXSymbol--;
		}
		
		if (logoXSimulator == getWidth()/2 - 350 && logoXSymbol == getWidth()/2
				+ 75) {
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Helvetica Bold", Font.BOLD, 50));
			g2d.drawString("By DS Technologies, 2024", getWidth()/2 - 200, 
					getHeight() - 100);
		}
		
		repaint();
	}
	
	
	/**
	 * The resetGraphics method resets the x-cooordinates to their default
	 * values. This method is called when the card layout switches back to the
	 * title screen from the instructions page.
	 */
	public void resetGraphics() {
		logoXTeacher = 0;
		logoXGrading = 0;
		logoXSimulator = 0;
		logoXSymbol = 1500;
	}


	/**
	 * This is the toString method for this class. It prints out the various
	 * fields from this class.
	 */
	@Override
	public String toString() {
		return "TitleScreen [logoXTeacher=" + logoXTeacher + ", logoXGrading=" +
				logoXGrading + ", logoXSimulator=" + logoXSimulator + 
				", logoXSymbol=" + logoXSymbol + "]";
	}
	
	
	
}
