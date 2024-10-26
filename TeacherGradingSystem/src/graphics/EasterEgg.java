package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EasterEgg extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private BorderLayout bl;
	private FlowLayout fl;
	private JPanel flPanel;
	
	
	public EasterEgg() {
		bl = new BorderLayout();
		setLayout(bl);
		
		fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		flPanel = new JPanel();
		flPanel.setBackground(GraphicsConstants.headerColor);
		flPanel.setLayout(fl);	
		add(flPanel, BorderLayout.NORTH);
		
		Icon theEasterEgg = new ImageIcon("src/resources/THE_EASTER_EGG.png");
		JLabel easterEggHolder = new JLabel(theEasterEgg);
		add(easterEggHolder, BorderLayout.CENTER);
		easterEggHolder.setOpaque(false);
		easterEggHolder.setBorder(null);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(GraphicsConstants.backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(GraphicsConstants.headerColor);
		g2d.fillRect(0, 0, getWidth(), 50);
	}
	
	
	public void addFlowLayoutComponents(JButton a) {
		flPanel.add(a);
	}
	

}
