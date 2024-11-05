package calculations;

import java.util.ArrayList;
import java.util.List;


/**
 * The GradeCalculations class performs grade calculations for the Teacher
 * Grading Simulator. The class takes in grades and weights/point values to
 * make a final, or average, grade.
 * 
 * @author Daniel Santillan
 */
public class GradeCalculations {

	/**
	 * The calculateAverageUnweightedGrade method takes in a list of percent
	 * grades and returns the average value. This method is used to calculate
	 * the average grade under an unweighted percent grading system.
	 * 
	 * @param grades		the list of grades
	 * @return				the average grade
	 */
	public static double calculateAverageUnweightedGrade(List<Double> grades) {
		double gradeSum = 0.0;
		double totalAssignments = 0.0;

		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) >= 0) {
				gradeSum += grades.get(i);
				totalAssignments++;
			}
		}

		return gradeSum/totalAssignments;
	}


	/**
	 * The calculateAveragePointsGrade method takes in a list of point values
	 * the student earned per assignment and divides it by the total number of
	 * points available. This method is used to calculate the average grade 
	 * under a points grading system.
	 * 
	 * @param grades			the list of grades
	 * @param pointValues		the list of maximum point values per assignment
	 * @return					the average grade
	 */
	public static double calculateAveragePointsGrade(List<Double> grades, List<Double> pointValues) {
		double pointsSum = 0.0;
		double totalPoints = 0.0;

		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) >= 0) {
				pointsSum += grades.get(i);
				totalPoints += pointValues.get(i);
			}
		}

		return pointsSum/totalPoints;
	}


	/**
	 * The calculateAverageWeightedGrade method 
	 * 
	 * @param grades
	 * @param weightValues
	 * @return
	 */
	public static double calculateAverageWeightedGrade(List<Double>grades, ArrayList<Double> weightValues) {
		weightValues = fixWeights(weightValues);
		double totalGrade = 0;

		for (int i = 0; i < grades.size(); i++) {
			totalGrade += (grades.get(i) * weightValues.get(i));
		}

		return totalGrade;
	}


	private static ArrayList<Double> fixWeights(ArrayList<Double> weights) {
		ArrayList<Double> individualWeights = new ArrayList<Double>();

		for (int i = 0; i < weights.size(); i++) {
			if (individualWeights.indexOf(weights.get(i)) == -1) {
				individualWeights.add(weights.get(i));
			}
		}

		for (double j : individualWeights) {
			int occurrence = 0;
			for (int k = 0; k < weights.size(); k++) {
				if (weights.get(k) == j) {
					occurrence++;
				}
			}

			for (int l = 0; l < weights.size(); l++) {
				if (weights.get(l) == j) {
					weights.set(l, weights.get(l)/occurrence);
				}
			}
		}

		return weights;
	}

}
