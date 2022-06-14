package com.studentlist.student;

public class Student 

{
	private int studentID;
	private String studentName;
	private String courseTitle;
	private int studentGrade;
	
	public Student(int studentID, String studentName, String courseTitle, int studentGrade)
	
	{
		this.studentID = studentID;
		this.studentName = studentName;
		this.courseTitle = courseTitle;
		this.studentGrade = studentGrade;
	}

	public int getStudentID() 
	
	{
		return studentID;
	}

	public void setStudentID(int studentID) 
	
	{
		this.studentID = studentID;
	}

	public String getStudentName() 
	
	{
		return studentName;
	}

	public void setStudentName(String studentName) 
	
	{
		this.studentName = studentName;
	}

	public String getCourseTitle() 
	
	{
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) 
	
	{
		this.courseTitle = courseTitle;
	}

	public int getStudentGrade() 
	
	{
		return studentGrade;
	}

	public void setStudentGrade(int studentGrade) 
	
	{
		this.studentGrade = studentGrade;
	}

}
