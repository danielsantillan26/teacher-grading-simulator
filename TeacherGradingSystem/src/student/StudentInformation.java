package student;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class StudentInformation {
	private static ArrayList<String> assignments;
	private static ArrayList<Double> systemValues;
	private static int system;
	private static ArrayList<Student> students;
	
	
	public static void instantiateVariables() {
		assignments = new ArrayList<String>();
		systemValues = new ArrayList<Double>();
		students = new ArrayList<Student>();
	}
	
	
	public static void updateAssignments(JTable table, String systemChoice) {
		if (systemChoice.equals("Points System")) {
			system = 0;
		} else if (systemChoice.equals("Unweighted Percents")) {
			system = 1;
		} else if (systemChoice.equals("Weighted Percents")) {
			system = 2;
		}
		
		for (int i = 0; i < assignments.size(); i++) {
			assignments.set(i, null);
		}
		
		for (int i = 0; i < table.getRowCount(); i++) {
			String x = (String) table.getValueAt(i, 0);
			String y = (String)table.getValueAt(i, 1);
			if (!(x.isBlank())) {
				if (system != 1) {
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
		
		for (int j = 0; j < students.size(); j++) {
			students.get(j).resetGrades();
		}
		
		for (int k = 0; k < assignments.size(); k++) {
			if (assignments.get(k) == null || assignments.get(k).isBlank()) {
				assignments.remove(k);
				k--;
			}
		}
	}
	
	
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
	
	
	public static List<String> getAssignmentList() {
		return assignments;
	}
	
	
	public static List<String> getStudentNames() {
		ArrayList<String> studentNames = new ArrayList<String>();
		for (int i = 0; i < students.size(); i++) {
			studentNames.add(students.get(i).getName());
		}
		
		return studentNames;
	}
	
	
	
	
}
