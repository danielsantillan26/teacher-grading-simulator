package calculations;

import java.util.ArrayList;

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
	public static double calculateAverageUnweightedGrade(ArrayList<Double> grades) {
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
	public static double calculateAveragePointsGrade(ArrayList<Double> grades, ArrayList<Double> pointValues) {
		double pointsSum = 0.0;
		double totalPoints = 0.0;

		int i = 0;
		while (i < grades.size()) {
			if (grades.get(i) >= 0) {
				pointsSum += grades.get(i);
				totalPoints += pointValues.get(i);
			}
			i++;
		}

		return pointsSum/totalPoints * 100;
	}


	/**
	 * The calculateAverageWeightedGrade method takes in a list of percent
	 * grades and a list of weights for each assignment. The method uses the
	 * percent grades and their respective weights to calculate the average
	 * grade. This method is used to calculate the average grade under a
	 * weighted percent grading system.
	 * 
	 * @param grades			the list of grades
	 * @param weightValues		the list of weights
	 * @return					the average grade
	 */
	public static double calculateAverageWeightedGrade(ArrayList<Double>grades, ArrayList<Double> weightValues) {
		weightValues = fixWeights(grades, weightValues);
		double totalGrade = 0;

		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) >= 0) {
				totalGrade += (grades.get(i) * weightValues.get(i));
			}
		}

		return totalGrade;
	}


	/**
	 * The fixWeights method divides each weight in the list of weights 
	 * (for weighted grade calculations) by the number of occurrences of said 
	 * weight in the list. This is to ensure correct calculation of the
	 * weighted grade.
	 * 
	 * @param grades		the list of grades
	 * @param weights		the list of weights
	 * @return				the list of modified weights)
	 */
	private static ArrayList<Double> fixWeights(ArrayList<Double>grades, ArrayList<Double> weights) {
		ArrayList<Double> individualWeights = new ArrayList<Double>();

		for (int i = 0; i < weights.size(); i++) {
			if (individualWeights.indexOf(weights.get(i)) == -1) {
				individualWeights.add(weights.get(i));
			}
		}

		for (double j : individualWeights) {
			int occurrence = 0;
			for (int k = 0; k < weights.size(); k++) {
				if (weights.get(k) == j && grades.get(k) >= 0) {
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


	/**
	 * This is the toString method for this class.
	 */
	@Override
	public String toString() {
		return "GradeCalculations []";
	}

}
