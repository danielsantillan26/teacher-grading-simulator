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
	public static final Icon ICON_ADD_ASSIGNMENTS = new ImageIcon("src/resources/ADD_ASSIGNMENTS.png");
	public static final Icon ICON_CLOSE = new ImageIcon("src/resources/CLOSE.png");
	public static final Icon ICON_COLLECT_DATA = new ImageIcon("src/resources/COLLECT_DATA.png");
	public static final Icon ICON_EASTER_EGG = new ImageIcon("src/resources/EASTER_EGG.png");
	public static final Icon ICON_FAILED_TO_COMPILE = new ImageIcon("src/resources/FAILED_TO_COMPILE.png");
	public static final Icon ICON_FILE_CREATED = new ImageIcon("src/resources/FILE_CREATED.png");
	public static final Icon ICON_GENERATE_REPORT = new ImageIcon("src/resources/GENERATE_REPORT.png");
	public static final Icon ICON_GRADE_ASSIGNMENTS = new ImageIcon("src/resources/GRADE_ASSIGNMENTS.png");
	public static final Icon ICON_INSTRUCTIONS = new ImageIcon("src/resources/INSTRUCTIONS.png");
	public static final Icon ICON_INSTRUCTIONS2 = new ImageIcon("src/resources/INSTRUCTIONS2.png");
	public static final Icon ICON_INSTRUCTIONS_FULL = new ImageIcon("src/resources/INSTRUCTIONS_FULL.png");
	public static final Icon ICON_LOAD_STUDENT_DATA = new ImageIcon("src/resources/LOAD_STUDENT_DATA.png");
	public static final Icon ICON_RESET_DATA = new ImageIcon("src/resources/RESET_DATA.png");
	public static final Icon ICON_RETRIEVE_DATA = new ImageIcon("src/resources/RETRIEVE_DATA.png");
	public static final Icon ICON_RETURN_HOME = new ImageIcon("src/resources/RETURN.png");
	public static final Icon ICON_SAVE_DATA = new ImageIcon("src/resources/SAVE_DATA.png");
	public static final Icon ICON_SELECT_ASSIGNMENT = new ImageIcon("src/resources/SELECT_ASSIGNMENT.png");
	public static final Icon ICON_SELECT_STUDENT = new ImageIcon("src/resources/SELECT_STUDENT.png");
	public static final Icon ICON_SELECT_SYSTEM = new ImageIcon("src/resources/SELECT_SYSTEM.png");
	public static final Icon ICON_START = new ImageIcon("src/resources/START.png");
	public static final Icon ICON_STUDENT_REPORT = new ImageIcon("src/resources/STUDENT_REPORT.png");
	public static final Icon ICON_THE_EASTER_EGG = new ImageIcon("src/resources/THE_EASTER_EGG.png");
	
	
	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "GraphicsConstants []";
	}
	
}
