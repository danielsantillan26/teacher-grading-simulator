package filecreation;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import calculations.GradeCalculations;
import student.Student;
import student.StudentInformation;

/**
 * The FileMaker class helps generate the student report from the Teacher
 * Grading Simulator. The FileMaker class holds the method needed to create
 * the report .txt files.
 * 
 * @author Daniel Santillan
 */
public class FileMaker {
	
	/**
	 * The createStudentReport method takes in a student. The method creates
	 * a file that will hold his/her grading report in a specialized directory
	 * created by the method. The method adds the student's name, the teacher's
	 * grading method, a list of all assignments that were graded (with their
	 * grades, of course), and the average grade. The method returns whether
	 * the file was successfully made or not.
	 * 
	 * @param student	the student who is being inspected in the report
	 * @return			whether the file was successfully made or not
	 */
	@SuppressWarnings("resource")	// Suggested by Eclipse for boolean b
	public static boolean createStudentReport(Student student) {
		boolean b = false;
		
		// Everything must be in a try-catch for file creation.
		try {
			File directory = new File("C:/TeacherGradingSimReports");
			if (!directory.exists()) {
				directory.mkdirs();
			}
			
			File file = new File("C:/TeacherGradingSimReports/" + student.getName() + "_Student_Report.txt");
			file.createNewFile();

			PrintWriter writer = new PrintWriter(file);
			writer.println("Student Name: " + student.getName());
			writer.println("");

			String system = "";
			int systemInt = StudentInformation.getSystem();
			if (systemInt == StudentInformation.POINTS_SYSTEM) {
				system = "Points System";
			} else if (systemInt == StudentInformation.UNWEIGHTED_PERCENT) {
				system = "Unweighted Percents";
			} else if (systemInt == StudentInformation.WEIGHTED_PERCENT) {
				system = "Weighted Percents";
			} else {
				return b;
			}

			writer.println("Assignment Grading System: " + system);
			writer.println("-----------------------------");

			ArrayList<Double> grades = student.getGrades();
			ArrayList<String> assignmentName = StudentInformation.getAssignmentList();
			ArrayList<Double> pointOrWeight = StudentInformation.getAssignmentValues();

			
			// The means of adding assignment grades differ by system.
			switch (systemInt)  {
			case StudentInformation.POINTS_SYSTEM:
				for (int i = 0; i < grades.size(); i++) {
					if (grades.get(i) >= 0) {
						writer.println(assignmentName.get(i)
								+ ": " + grades.get(i) + "/" + pointOrWeight.get(i));
					}
				}
				
				double finalGrade = GradeCalculations.calculateAveragePointsGrade(grades, pointOrWeight);
				
				writer.println("-----------------------------");
				writer.println("Total Grade: " + finalGrade);
				break;

			case StudentInformation.UNWEIGHTED_PERCENT:
				int j = 0;
				while (j < grades.size()) {
					if (grades.get(j) >= 0) {
						writer.println(assignmentName.get(j) + ": "
								+ grades.get(j) + "%");
					}
					j++;
				}
				
				double finalGrade2 = GradeCalculations.calculateAverageUnweightedGrade(grades);
				
				writer.println("-----------------------------");
				writer.println("Total Grade: " + finalGrade2);
				break;

			case StudentInformation.WEIGHTED_PERCENT:
				for (int k = 0; k < grades.size(); k++) {
					if (grades.get(k) >= 0) {
						writer.println(assignmentName.get(k) + ": " +
								grades.get(k) + ", Weight: " + pointOrWeight.get(k));
					}
				}
				
				double finalGrade3 = GradeCalculations.calculateAverageWeightedGrade(grades, pointOrWeight);
				
				writer.println("-----------------------------");
				writer.println("Total Grade: " + finalGrade3);
				break;
			}
			
			writer.close();

			return true;
		} catch (Exception e) {
			return b;
		}

	}

	
	/**
	 * This is the toString method for this class.
	 */
	@Override
	public String toString() {
		return "FileMaker []";
	}

}
