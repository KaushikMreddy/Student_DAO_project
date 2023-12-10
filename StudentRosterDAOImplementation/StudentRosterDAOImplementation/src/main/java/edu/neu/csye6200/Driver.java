package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		SaveToCSV.demo();
		SaveToJSON.demo();
		SaveToHTML.demo();
	}

}

//Sample Console Output
//
//---------Reading Student Details from CSV File-------
//sId: 1 | sName: Michael | sCourse: SES | sEmail: michael@neu.edu
//sId: 2 | sName: Sophia | sCourse: SES | sEmail: sophia@neu.edu
//sId: 3 | sName: William | sCourse: ECE | sEmail: william@neu.edu
//sId: 4 | sName: Grace | sCourse: CCIS | sEmail: grace@neu.edu
//sId: 5 | sName: Lucas | sCourse: COS | sEmail: lucas@neu.edu
//
//CSV file created successfully - Search for studentRosterOutput.csv 
//
//
//---------Reading Student Details from JSON File-------
//sId: 1 | sName: Jack | sCourse: SES | sEmail: jack@neu.edu
//sId: 2 | sName: Alice | sCourse: SES | sEmail: alice@neu.edu
//sId: 3 | sName: Bob | sCourse: ECE | sEmail: bob@neu.edu
//sId: 4 | sName: Emily | sCourse: CCIS | sEmail: emily@neu.edu
//sId: 5 | sName: David | sCourse: COS | sEmail: david@neu.edu
//sId: 6 | sName: Saman | sCourse: MBA | sEmail: samantha@new.edu
//sId: 7 | sName: Nathan | sCourse: IS | sEmail: nathan@new.edu
//
//JSON file created successfully - Search for studentRosterOutput.json 
//
//
//---------Reading Student Details from HTML File-------
//sId: 1 | sName: John | sCourse: SES | sEmail: john@neu.edu
//sId: 2 | sName: Emma | sCourse: SES | sEmail: emma@neu.edu
//sId: 3 | sName: Charlie | sCourse: ECE | sEmail: charlie@neu.edu
//sId: 4 | sName: Olivia | sCourse: CCIS | sEmail: olivia@neu.edu
//sId: 5 | sName: Liam | sCourse: COS | sEmail: liam@neu.edu
//sId: 6 | sName: Ava | sCourse: MBA | sEmail: ava@new.edu
//sId: 7 | sName: Noah | sCourse: IS | sEmail: noah@new.edu
//
//HTML file created successfully - search for studentRosterOutput.html
