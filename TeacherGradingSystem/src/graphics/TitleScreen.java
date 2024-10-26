package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TitleScreen extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int logoXTeacher;
	private int logoXGrading;
	private int logoXSimulator;
	private int logoXSymbol;
	
	
	public TitleScreen() {
		logoXTeacher = 0;
		logoXGrading = 0;
		logoXSimulator = 0;
		logoXSymbol = 1500;
	}
	
	
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
	
	
	public void resetGraphics() {
		logoXTeacher = 0;
		logoXGrading = 0;
		logoXSimulator = 0;
		logoXSymbol = 1500;
	}
	
}
