package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * The TitleScreen class creates the JPanel for the title card of the Teacher
 * Grading Simulator. It creates the graphics and animation for the title card.
 * 
 * @author Daniel Santillan
 */
public class TitleScreen extends JPanel {
	
	// Version
	private static final long serialVersionUID = 1L;
	
	// X-coordinates for each part of the animation
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
		
		g2d.setColor(GraphicsConstants.COLOR_BACKGROUND);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.COLOR_HEADER);
		g2d.fillRect(0, 0, getWidth(), 50);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Helvetica Bold", Font.BOLD, 120));
		g2d.drawString("Teacher", logoXTeacher, getHeight()/2 - 125);
		g2d.drawString("Grading", logoXGrading, getHeight()/2);
		g2d.drawString("Simulator", logoXSimulator, getHeight()/2 + 125);
		
		Color symbolColor = new Color(0, 59, 155);
		g2d.setColor(symbolColor);
		g2d.fillOval(logoXSymbol, getHeight()/2 - 200, 250, 250);
		g2d.setColor(GraphicsConstants.COLOR_BACKGROUND);
		g2d.fillOval(logoXSymbol + 75, getHeight()/2 - 175, 150, 150);
		g2d.setColor(symbolColor);
		g2d.fillOval(logoXSymbol + 80, getHeight()/2 - 150, 25, 25);
		g2d.fillOval(logoXSymbol + 150, getHeight()/2 - 155, 80, 80);
		
		
		logoXTeacher = (logoXTeacher < getWidth()/2 - 450) ? logoXTeacher + 1 : logoXTeacher;
		logoXGrading = (logoXGrading < getWidth()/2 - 400) ? logoXGrading + 1 : logoXGrading;
		logoXSimulator = (logoXSimulator < getWidth()/2 - 350) ? logoXSimulator + 1 : logoXSimulator;
		logoXSymbol = (logoXSymbol > getWidth()/2 + 75) ? logoXSymbol - 1 : logoXSymbol;

		
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
	 * title screen from the instructions page or when the frame is resized.
	 */
	public void resetGraphics() {
		logoXTeacher = 0;
		logoXGrading = 0;
		logoXSimulator = 0;
		logoXSymbol = 1500;
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "TitleScreen [logoXTeacher=" + logoXTeacher + ", logoXGrading=" +
				logoXGrading + ", logoXSimulator=" + logoXSimulator + 
				", logoXSymbol=" + logoXSymbol + "]";
	}
	
}
