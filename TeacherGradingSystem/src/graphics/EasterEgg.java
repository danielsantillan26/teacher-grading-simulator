package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The EasterEgg class is a joke of a class. It is here to serve as an easter
 * egg that one can access on the Teacher Grading Simulator by pressing a random
 * spot on the title screen that does not look like a button.
 * 
 * @author Daniel Santillan
 */
public class EasterEgg extends JPanel {
	
	// Version
	private static final long serialVersionUID = 1L;
	
	// Components that must be accessed in multiple methods.
	private JPanel northPanel;
	
	
	/**
	 * The EasterEgg constructor sets up the Easter Egg section of the program.
	 * It adds the easter egg itself to the center of the panel.
	 */
	public EasterEgg() {
		setLayout(new BorderLayout());
		
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		northPanel = new JPanel(fl);
		northPanel.setBackground(GraphicsConstants.COLOR_HEADER);	
		add(northPanel, BorderLayout.NORTH);
		
		
		JLabel easterEggHolder = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("THE_EASTER_EGG.png")));
		add(easterEggHolder, BorderLayout.CENTER);
		easterEggHolder.setOpaque(false);
		easterEggHolder.setBorder(null);
		
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
	 * The addFlowLayoutComponents method takes in a JButton, which is placed
	 * on top of the section. The JButton comes from the Frame class, which has
	 * all the buttons needed to switch between cards/close the program.
	 * 
	 * @param a		the button to be added (close operation)
	 */
	public void addFlowLayoutComponents(JButton a) {
		northPanel.add(a);
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "EasterEgg [northPanel=" + northPanel + "]";
	}

}
