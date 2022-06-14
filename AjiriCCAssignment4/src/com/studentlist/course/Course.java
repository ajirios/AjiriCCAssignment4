package com.studentlist.course;

import com.studentlist.student.Student;

public class Course 

{
	private String courseTitle;
	private Student[] students;

	public Course(int maximumClassSize, String courseTitle) 
	
	{
		this.courseTitle = courseTitle;
		this.students = new Student[maximumClassSize];
	}

	public String getCourseTitle() 
	
	{
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) 
	
	{
		this.courseTitle = courseTitle;
	}

	public Student[] getStudents() 
	
	{
		return students;
	}

	public void setStudent(int count, Student student) 
	
	{
		this.students[count] = student;
	}

}
