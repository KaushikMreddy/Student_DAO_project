package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {

	// Method to read lines from a file and return them as a list of strings
	public static List<String> readLines(String filePath) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	// Method to write a list of strings to a text file
	public static void writeLists(String filePath, List<Student> students) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.newLine();
			for (Student student : students) {
				writer.write(student.toString());
				writer.newLine();
			}
			writer.newLine();
			writer.newLine();

			System.out.println("\n Text file created successfully\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int convertToInteger(String s) {
		return Integer.parseInt(s);
	}

	// Method to add student to Array List
	public static void addStudentToList(List<Student> list, Student s) {
		list.add(s);

	}

	// Method to view students in roster
	public static void viewStudentsFromList(List<Student> list) {
		for (Student s : list) {
			System.out.println(s);
		}
	}

}
