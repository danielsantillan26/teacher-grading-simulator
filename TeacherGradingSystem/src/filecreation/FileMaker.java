package filecreation;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import calculations.GradeCalculations;
import student.Student;
import student.StudentInformation;


public class FileMaker {
	
	public static boolean createStudentReport(Student student) {
		boolean b = false;

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
			if (systemInt == 0) {
				system = "Points System";
			} else if (systemInt == 1) {
				system = "Unweighted Percents";
			} else if (systemInt == 2) {
				system = "Weighted Percents";
			} else {
				return b;
			}

			writer.println("Assignment Grading System: " + system);
			writer.println("-----------------------------");

			ArrayList<Double> grades = student.getGrades();
			List<String> assignmentName = StudentInformation.getAssignmentList();
			ArrayList<Double> pointOrWeight = StudentInformation.getAssignmentValues();

			switch (systemInt)  {
			case 0:
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

			case 1:
				for (int j = 0; j < grades.size(); j++) {
					if (grades.get(j) >= 0) {
						writer.println(assignmentName.get(j) + ": "
								+ grades.get(j) + "%");
					}
				}
				
				double finalGrade2 = GradeCalculations.calculateAverageUnweightedGrade(grades);
				
				writer.println("-----------------------------");
				writer.println("Total Grade: " + finalGrade2);
				break;

			case 2:
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


}
