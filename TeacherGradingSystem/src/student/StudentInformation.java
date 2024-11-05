package student;

import java.util.ArrayList;

import javax.swing.JTable;

import filecreation.FileMaker;

/**
 * The StudentInformation class holds values and methods that apply to all
 * students. This includes the list of assignments, the weights/points for each
 * assignment, the grading system used, and the list of students. The methods
 * take in the results from the JTables from the program and make edits to each
 * student/assignment based on the data.
 * 
 * @author Daniel Santillan
 */
public class StudentInformation {

	private static ArrayList<String> assignments;	// List of assignments
	private static ArrayList<Double> systemValues;	// List of points/weights
	private static int system;						// System
	private static ArrayList<Student> students;		// List of students
	
	// Symbolic constants for the grading system (public for external reference)
	public static final int POINTS_SYSTEM = 0;
	public static final int UNWEIGHTED_PERCENT = 1;
	public static final int WEIGHTED_PERCENT = 2;
	
	
	/**
	 * The instantiateVariables method instantiates each list to ensure that
	 * a NullPointerException is not thrown.
	 */
	public static void instantiateVariables() {
		assignments = new ArrayList<String>();
		systemValues = new ArrayList<Double>();
		students = new ArrayList<Student>();
		system = -1;
	}
	
	
	/**
	 * The updateAssignments method takes in a JTable of assignment data and the
	 * desired grading system from the Add Assignments page of the simulator. It
	 * adds the assignment names (and their point/weight value) to the necessary
	 * ArrayLists in this class. These lists will be used to associate grades
	 * with assignments and their values.
	 * 
	 * @param table			the table of assignment data and their points/weight
	 * @param systemChoice	the system choice from the JComboBox
	 */
	public static void updateAssignments(JTable table, String systemChoice) {
		if (systemChoice.equals("Points System")) {
			system = POINTS_SYSTEM;
		} else if (systemChoice.equals("Unweighted Percents")) {
			system = UNWEIGHTED_PERCENT;
		} else if (systemChoice.equals("Weighted Percents")) {
			system = WEIGHTED_PERCENT;
		}
		
		for (int i = 0; i < assignments.size(); i++) {
			assignments.set(i, null);
		}
		
		for (int i = 0; i < table.getRowCount(); i++) {
			String x = (String) table.getValueAt(i, 0);
			String y = (String)table.getValueAt(i, 1);
			if (!(x.isBlank())) {
				if (system != UNWEIGHTED_PERCENT) {
					if (!(y.isBlank())) {
						try {
							systemValues.add(Double.parseDouble(y));
							assignments.add(x);
						} catch (Exception e) {
							continue;
						}
					}
				} else {
					assignments.add((String) table.getValueAt(i, 0));
				}
				
			}
		}
		
		int j = 0;
		while (j < students.size()) {
			students.get(j).resetGrades();
			j++;
		}
		
		for (int k = 0; k < assignments.size(); k++) {
			if (assignments.get(k) == null || assignments.get(k).isBlank()) {
				assignments.remove(k);
				k--;
			}
		}
	}
	
	
	/**
	 * The updateStudents method takes in a JTable of student and grade data
	 * and the index of the assignment to be graded on the JComboBox. The index
	 * from the JComboBox aligns with the index on the assignments list in this
	 * class. The method adds new students if their name is not on the list
	 * of students and gives them grades for the specific assignment.
	 * 
	 * @param table					the table of students and their grades
	 * @param assignmentIndex 		the index of the assignment to be graded
	 */
	public static void updateStudents(JTable table, int assignmentIndex) {
		for (int i = 0; i < table.getRowCount(); i++) {
			String x = (String) table.getValueAt(i, 0);
			String y = (String) table.getValueAt(i, 1);
			
			if (!(x.isBlank())) {
				boolean isNameFree = true;
				for (int j = 0; j < students.size(); j++) {
					if (students.get(j).getName().equals(x)) {
						isNameFree = false;
					}
				}
				
				if (isNameFree) {
					students.add(new Student(x));
				}
				
				if (!(y.isBlank())) {
					try {
						for (int k = 0; k < students.size(); k++) {
							if (students.get(k).getName().equals(x)) {
								students.get(k).setGradeAt(assignmentIndex, Double.parseDouble(y));
							}
						}
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
	}
	
	
	/**
	 * The generateStudentReport method takes in an integer index from the
	 * JComboBox of the Student Report page of the simulator. It finds the
	 * student at the specific index and calls the FileMaker method to generate
	 * a .txt file student report.
	 * 
	 * @param index		the index of the student
	 * @return			whether or not the file was successfully created		
	 */
	public static boolean generateStudentReport(int index) {
		return FileMaker.createStudentReport(students.get(index));
	}
	
	
	/**
	 * The getAssignmentList method returns the list of assignments.
	 * 
	 * @return		the list of assignments
	 */
	public static ArrayList<String> getAssignmentList() {
		return assignments;
	}
	
	
	/**
	 * The getStudentNames method returns the list of student names.
	 * 
	 * @return		the list of student names
	 */
	public static ArrayList<String> getStudentNames() {
		ArrayList<String> studentNames = new ArrayList<String>();
		int i = 0;
		while (i < students.size()) {
			studentNames.add(students.get(i).getName());
			i++;
		}
		
		return studentNames;
	}
	
	
	/**
	 * The getAssignmentValues method returns the list of weights or points
	 * for each assignment.
	 * 
	 * @return		the list of points/weights for each assignment
	 */
	public static ArrayList<Double> getAssignmentValues() {
		return systemValues;
	}
	
	
	/**
	 * The getSystem method returns the system being used to grade.
	 * 
	 * @return		the grading system
	 */
	public static int getSystem() {
		return system;
	}


	/**
	 * This is the toString method for this class.
	 */
	@Override
	public String toString() {
		return "StudentInformation []";
	}
	
}
