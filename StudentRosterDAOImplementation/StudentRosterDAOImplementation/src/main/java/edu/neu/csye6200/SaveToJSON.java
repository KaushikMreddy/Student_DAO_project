package edu.neu.csye6200;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveToJSON implements StudentDAO {

	final String inputJsonPath = "src/main/java/resources/studentRosterInput.json";
	final String outputJsonPath = "src/main/java/resources/studentRosterOutput.json";

	static List<Student> studentRosterJSON = new ArrayList<>();

	@Override
	public void getStudentDetails() {

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			// Read JSON file and convert to a List of Student objects
			List<Student> tempstudentList = objectMapper.readValue(new File(inputJsonPath), new TypeReference<List<Student>>() {});

			for (Student student : tempstudentList) {

				Student s = new Student(student.getStudentId(), student.getStudentName(), student.getStudentCourse(),
						student.getStudentEmail());
				Utility.addStudentToList(studentRosterJSON, s);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveStudentDetails() {

		// Write data to the JSON file
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.writeValue(new File(outputJsonPath), studentRosterJSON);

			System.out.println("\n JSON file created successfully - Search for studentRosterOutput.json \n\n");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void demo() {
		SaveToJSON saveJSON = new SaveToJSON();

		saveJSON.getStudentDetails();

		System.out.println("---------Reading Student Details from JSON File-------");
		Utility.viewStudentsFromList(studentRosterJSON);

		// Adding a new student to the roster - this is to differentiate between json file read and write
		Utility.addStudentToList(studentRosterJSON,
				new Student(8, "JSONTestStudent", "JSONTestCourse", "JSONTestEmail"));

		saveJSON.saveStudentDetails();

	}

}
