package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Instructions class creates the JPanel for the Instructions page of the
 * Teacher Grading Simulator. It adds a JLabel (in the form of an image) that
 * lists all the instructions necessary to properly run the simulator.
 * 
 * @author Daniel Santillan
 */
public class Instructions extends JPanel {
	
	// Version
	private static final long serialVersionUID = 1L;
	
	/**
	*  The Instructions constructor sets the layout of the JPanel. Since the
	*  default layout of a JPanel is FlowLayout, the layout must be set.
	*/
	public Instructions() {
		setLayout(new BorderLayout());
	}
	
	
	/**
	 * The addInstructions method adds the instructions to the JPanel. It is a
	 * separate public method called by the Frame class to ensure that the
	 * buttons on the North section of the panel are added before the
	 * instructions themselves (placing this block of code in the constructor
	 * makes the panel look wrong).
	 */
	public void addInstructions() {
		JLabel labelInstructions = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("INSTRUCTIONS_FULL.png")));
		labelInstructions.setBounds(new Rectangle(50, 100, getWidth() - 50, getHeight() - 50));
		add(labelInstructions, BorderLayout.CENTER);
	}
	
	
	/**
	 * The paintComponent method paints the background of the section.
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
	 * This is the toString method for this class.
	 */
	@Override
	public String toString() {
		return "Instructions []";
	}	
	
}
