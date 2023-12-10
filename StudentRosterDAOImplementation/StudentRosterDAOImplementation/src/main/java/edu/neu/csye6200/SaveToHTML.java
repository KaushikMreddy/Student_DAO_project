package edu.neu.csye6200;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SaveToHTML implements StudentDAO {

	final String inputHTMLPath = "src/main/java/resources/studentRosterInput.html";
	final String outputHTMLPath = "src/main/java/resources/studentRosterOutput.html";

	static List<Student> studentRosterHTML = new ArrayList<>();

	public static String readHtmlFile(File file) throws IOException {
		// Read HTML content from the file
		return FileUtils.readFileToString(file, "UTF-8");
	}

	@Override
	public void getStudentDetails() {

		File htmlFile = new File(inputHTMLPath);
		String htmlContent;
		try {
			htmlContent = readHtmlFile(htmlFile);

			// Parse HTML content using Jsoup
			Document document = Jsoup.parse(htmlContent);

			// Select the table rows
			Elements rows = document.select("table tr");

			// Skip the header row
			for (int i = 1; i < rows.size(); i++) {
				Element row = rows.get(i);

				// Extract data from each column
				Elements columns = row.select("td");
				int id = Utility.convertToInteger(columns.get(0).text());
				String name = columns.get(1).text();
				String program = columns.get(2).text();
				String email = columns.get(3).text();

				// Create Student object and add to the list
				Student s = new Student(id, name, program, email);
				Utility.addStudentToList(studentRosterHTML, s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveStudentDetails() {

		// Write data to the HTML file
		try (PrintWriter writer = new PrintWriter(new FileWriter(outputHTMLPath))) {
			// Write HTML header
			writer.println("<html><body><table>");

			// Write table headers
			writer.println("<tr><th>ID</th><th>Name</th><th>Program</th><th>Email</th></tr>");

			// Write data from the ArrayList
			for (Student student : studentRosterHTML) {
				writer.println(
						"<tr><td>" + student.getStudentId() + "</td><td>" + student.getStudentName() + "</td><td>"
								+ student.getStudentCourse() + "</td><td>" + student.getStudentEmail() + "</td></tr>");
			}

			// Write HTML footer
			writer.println("</table></body></html>");

			System.out.println("\n HTML file created successfully - search for studentRosterOutput.html");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void demo() {

		SaveToHTML saveHtml = new SaveToHTML();

		System.out.println("---------Reading Student Details from HTML File-------");
		saveHtml.getStudentDetails();

		Utility.viewStudentsFromList(studentRosterHTML);

		// Lets add another student to the Roster to differentiate between read and write
		Utility.addStudentToList(studentRosterHTML,
				new Student(8, "HTMLTestStudent", "HTMLTestCourse", "HTMLTestEmail"));

		saveHtml.saveStudentDetails();

	}

}
