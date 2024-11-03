package student;

import java.util.ArrayList;

public class Student {
	
	private String name;
	private ArrayList<Double> grades;
	
	public static final long serialVersionUID = 1L;
	
	
	public Student(String name) {
		this.name = name;
		grades = new ArrayList<Double>();
	}
	
	
	public void resetGrades() {
		int i = 0;
		while (i < grades.size()) {
			grades.set(i, null);
			i++;
		}
	}
	
	
	public void setGradeAt(int index, double grade) {
		grades.set(index, grade);
	}
	
	
	public String getName() {
		return name;
	}

}
