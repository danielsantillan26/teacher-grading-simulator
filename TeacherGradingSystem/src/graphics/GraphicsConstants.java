package graphics;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * The GraphicsConstants class holds several variables that are used throughout
 * the Teacher Grading Simulator.
 * 
 * @author Daniel Santillan
 */
public final class GraphicsConstants {

	// Colors that are used for the GUI on each page
	public static final Color COLOR_BACKGROUND = new Color(181, 209, 255);
	public static final Color COLOR_HEADER = new Color(69, 140, 255);
	
	/**
	 * ImageIcons that are for the JLabels and JButtons in this program
	 * 
	 * I found it easier to hold all of these objects in one place rather than
	 * scatter them all throughout. Each icon is mostly used once, but it is
	 * easier for them to be in one area for simple reference.
	 */
	public static final Icon ICON_ADD_ASSIGNMENTS = new ImageIcon("res/ADD_ASSIGNMENTS.png");
	public static final Icon ICON_CLOSE = new ImageIcon("res/CLOSE.png");
	public static final Icon ICON_COLLECT_DATA = new ImageIcon("res/COLLECT_DATA.png");
	public static final Icon ICON_EASTER_EGG = new ImageIcon("res/EASTER_EGG.png");
	public static final Icon ICON_FAILED_TO_COMPILE = new ImageIcon("res/FAILED_TO_COMPILE.png");
	public static final Icon ICON_FILE_CREATED = new ImageIcon("res/FILE_CREATED.png");
	public static final Icon ICON_GENERATE_REPORT = new ImageIcon("res/GENERATE_REPORT.png");
	public static final Icon ICON_GRADE_ASSIGNMENTS = new ImageIcon("res/GRADE_ASSIGNMENTS.png");
	public static final Icon ICON_INSTRUCTIONS = new ImageIcon("res/INSTRUCTIONS.png");
	public static final Icon ICON_INSTRUCTIONS2 = new ImageIcon("res/INSTRUCTIONS2.png");
	public static final Icon ICON_INSTRUCTIONS_FULL = new ImageIcon("res/INSTRUCTIONS_FULL.png");
	public static final Icon ICON_LOAD_STUDENT_DATA = new ImageIcon("res/LOAD_STUDENT_DATA.png");
	public static final Icon ICON_RESET_DATA = new ImageIcon("res/RESET_DATA.png");
	public static final Icon ICON_RETRIEVE_DATA = new ImageIcon("res/RETRIEVE_DATA.png");
	public static final Icon ICON_RETURN_HOME = new ImageIcon("res/RETURN.png");
	public static final Icon ICON_SAVE_DATA = new ImageIcon("res/SAVE_DATA.png");
	public static final Icon ICON_SELECT_ASSIGNMENT = new ImageIcon("res/SELECT_ASSIGNMENT.png");
	public static final Icon ICON_SELECT_STUDENT = new ImageIcon("res/SELECT_STUDENT.png");
	public static final Icon ICON_SELECT_SYSTEM = new ImageIcon("res/SELECT_SYSTEM.png");
	public static final Icon ICON_START = new ImageIcon("res/START.png");
	public static final Icon ICON_STUDENT_REPORT = new ImageIcon("res/STUDENT_REPORT.png");
	public static final Icon ICON_THE_EASTER_EGG = new ImageIcon("res/THE_EASTER_EGG.png");
	
	
	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "GraphicsConstants []";
	}
	
}
