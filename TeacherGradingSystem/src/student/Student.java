package student;

import java.util.ArrayList;

/**
 * The Student class represents a student in the database of the Teacher Grading
 * Simulator. The object contains a student's name and their grades.
 */
public class Student {
	
	// Version
	public static final long serialVersionUID = 1L;
	
	// Name and list of grades
	private String name;
	private ArrayList<Double> grades;
	
	
	/**
	 * The Student constructor sets the name of the student and instantiates
	 * the list of grades. All grades are set at -1, indicating the assignment
	 * has not been graded yet.
	 * 
	 * @param name		student name
	 */
	public Student(String name) {
		this.name = name;
		grades = new ArrayList<Double>();
		for (int i = 0; i < 200; i++) {
			grades.add(-1.0);
		}
	}
	
	
	/**
	 * The resetGrades method resets all grades to -1, indicating the assignment
	 * has not been graded. This method is called when the list of assignments
	 * (in StudentInformation.java) is changed.
	 */
	public void resetGrades() {
		int i = 0;
		while (i < grades.size()) {
			grades.set(i, -1.0);
			i++;
		}
	}
	
	
	/**
	 * The setGradeAt method sets a grade at a specific part of the grades list.
	 * 
	 * @param index		the index of the assignment to be graded
	 * @param grade		the grade to be given
	 */
	public void setGradeAt(int index, double grade) {
		grades.set(index, grade);
	}
	
	
	/**
	 * The getName method returns the student's name.
	 * 
	 * @return		student name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * The getGrades method returns the list of the student's grades.
	 * 
	 * @return		student's list of grades
	 */
	public ArrayList<Double> getGrades() {
		return grades;
	}


	/**
	 * This is the toString method for this class. It prints the fields.
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", grades=" + grades + "]";
	}
	
}
