package student;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class StudentConstants {

	private static ArrayList<String> assignments;
	private static ArrayList<Double> systemValues;
	private static int system;
	
	public static void updateAssignments(JTable table, Object proposedSystem) {
		assignments = new ArrayList<String>();
		systemValues = new ArrayList<Double>();
		
		if (proposedSystem.equals("Points System")) {
			system = 0;
		} else if (proposedSystem.equals("Unweighted Percents")) {
			system = 1;
		} else if (proposedSystem.equals("Weighted Percents")) {
			system = 2;
		}
		
		for (int i = 0; i < table.getRowCount(); i++) {
			if (!(table.getValueAt(i, 0).equals("")) && !(table.getValueAt(i, 1).equals(""))) {
				
				try {
					if (system != 1) {
						systemValues.add(Double.parseDouble((String) table.getValueAt(i, 1)));
					}
					assignments.add((String) table.getValueAt(i, 0));
					
				} catch (Exception e) {
					continue;
				}
			}
		}
		
	}
	
	
	public static List getAssignments() {
		return assignments;
	}
	
}
