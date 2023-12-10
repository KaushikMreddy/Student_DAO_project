package edu.neu.csye6200;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class SaveToCSV implements StudentDAO {

	final String inputFilePath = "src/main/java/resources/studentRosterInput.csv";
	final String outputFilePath = "src/main/java/resources/studentRosterOutput.csv";

	static List<Student> studentRosterCSV = new ArrayList<>();

	@Override
	public void getStudentDetails() {
		
		List<String> tempStudentList = new ArrayList<String>();
		tempStudentList = Utility.readLines(inputFilePath);
		
		for (String line : tempStudentList) {
			String[] row = line.split(","); 
											
			Student student = new Student(Utility.convertToInteger(row[0]), row[1], row[2], row[3]);

			Utility.addStudentToList(studentRosterCSV, student);
		}

	}

	@Override
	public void saveStudentDetails() {

		// Write data to the CSV file
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFilePath))) {
			// Write the headers
			String[] headers = { "ID", "Name", "Program", "Email" };
			csvWriter.writeNext(headers);

			// Write data from the ArrayList
			for (Student student : studentRosterCSV) {
				String[] studentData = { String.valueOf(student.getStudentId()), student.getStudentName(),
						student.getStudentCourse(), student.getStudentEmail() };
				csvWriter.writeNext(studentData);
			}

			System.out.println("\n CSV file created successfully - Search for studentRosterOutput.csv \n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void demo() {

		SaveToCSV saveCsv = new SaveToCSV();
		saveCsv.getStudentDetails();

		System.out.println("---------Reading Student Details from CSV File-------");
		Utility.viewStudentsFromList(studentRosterCSV);

		// Lets add another student to the Roster to differentiate between read and write
		Utility.addStudentToList(studentRosterCSV, new Student(6, "CSVTestStudent", "CSVTestCourse", "CSVTestEmail"));

		saveCsv.saveStudentDetails();
	}

}
