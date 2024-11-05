package run;

import graphics.Frame;
import student.StudentInformation;

/**
 * The Run class runs the Teacher Grading Simulator. It creates an object of the
 * frame that holds all the graphics required for the system and runs it.
 * 
 * @author Daniel Santillan
 */
public class Run {

	/**
	 * The main method instantiates the Frame object and runs it. It also prints
	 * the toString method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		System.out.println(new Run());
		
		StudentInformation.instantiateVariables();
	}
	
	
	/**
	 * This is the toString method for this class. It prints a message ensuring 
	 * that the class is running.
	 */
	@Override
	public String toString() {
		
		return "Run toString:\nClass is running!";
	}
	
}
