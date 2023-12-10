package edu.neu.csye6200;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	@JsonProperty("studentId")
	private int studentId;

	@JsonProperty("studentName")
	private String studentName;

	@JsonProperty("studentCourse")
	private String studentCourse;

	@JsonProperty("studentEmail")
	private String studentEmail;

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return " sId: " + studentId + " | sName: " + studentName + " | sCourse: " + studentCourse + " | sEmail: "
				+ studentEmail;
	}

	// Needed for JSON to pick up the reference types while reading a JSON File
	public Student() {
	}

	public Student(int studentId, String studentName, String studentCourse, String studentEmail) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.studentEmail = studentEmail;
	}

}
