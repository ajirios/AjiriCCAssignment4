package com.studentlist.application;

import com.studentlist.student.StudentService;

public class StudentApplication 

{

	public static void main(String[] args) 
	
	{
		final String FILE = "student-master-list.csv";
		StudentService studentService = new StudentService();
		
		studentService.parseFileIntoThree(FILE);
		
		System.out.println("Parsing completed successfully. Please refresh application folder to see CSV files.");
	}

}
