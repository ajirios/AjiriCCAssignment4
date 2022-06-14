package com.studentlist.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import com.studentlist.course.Course;

public class StudentService 

{
	private Student[] students;
	private Course[] courses;
	
	public void parseFileIntoThree(String fileName)
	
	{
		this.students = null;
		BufferedReader bufferedReader = null;
		int studentsLength = computeStudentsLength(fileName);
		
		
		if (studentsLength > 0)
			
		{
			this.students = new Student[studentsLength];
			
			
			
			try 
			
			{
				bufferedReader = new BufferedReader(new FileReader(fileName));
				String line = null;
				String[] parser = null;
				int count = 0;
				
				bufferedReader.readLine();
				
				
				while (((line = bufferedReader.readLine()) != null) && (count < studentsLength))
					
				{
					parser = line.trim().split(",");
					this.students[count] = new Student(Integer.parseInt(parser[0]), parser[1], parser[2], Integer.parseInt(parser[3]));
					count++;
				}
				
			} 
			
			catch (FileNotFoundException e) 
			
			{
				e.printStackTrace();
			} 
			
			catch (IOException e) 
			
			{
				e.printStackTrace();
			}
			
			finally
			
			{
				if (bufferedReader != null)
				{
					try 
					
					{
						bufferedReader.close();
					} 
					
					catch (IOException e) 
					
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		buildThreeCourseArrays();
	}
	
	private void buildThreeCourseArrays()
	
	{
		this.courses = new Course[3]; 		//problem specifically says 3 courses are available
		this.courses[0] = new Course(this.students.length, "COMPSCI");
		this.courses[1] = new Course(this.students.length, "APMTH");
		this.courses[2] = new Course(this.students.length, "STAT");
		
		//for each of these courses, let's populate assigned students
		for (int count = 0; count < this.students.length; count++)
			
		{
			if (this.students[count].getCourseTitle().startsWith("COMPSCI"))
				
			{
				this.courses[0].setStudent(count, new Student(this.students[count].getStudentID(), this.students[count].getStudentName(), this.students[count].getCourseTitle(), this.students[count].getStudentGrade()));
			}
			
			else if (this.students[count].getCourseTitle().startsWith("APMTH"))
				
			{
				this.courses[1].setStudent(count, new Student(this.students[count].getStudentID(), this.students[count].getStudentName(), this.students[count].getCourseTitle(), this.students[count].getStudentGrade()));
			}
			
			else if (this.students[count].getCourseTitle().startsWith("STAT"))
				
			{
				this.courses[2].setStudent(count, new Student(this.students[count].getStudentID(), this.students[count].getStudentName(), this.students[count].getCourseTitle(), this.students[count].getStudentGrade()));
			}
			
		}
		
		
		
		//sort the course arrays
		for (int count = 0; count < this.courses.length; count++)
			
		{
			Arrays.sort(this.courses[count].getStudents(), new Comparator<Student>() {
				
				@Override
				public int compare(Student student1, Student student2) 
				
				{
					if (student1 == null && student2 == null)
					{
						return 0;
					}
					else if (student1 == null && student2 != null)
					{
						return 1;
					}
					else if (student1 != null && student2 == null)
					{
						return -1;
					}
					else
					{
						return student2.getStudentGrade() - student1.getStudentGrade();
					}
					
				}
				
			});
		}
		
		
		//write to files
		writeCoursesToFiles();
		
	}
	
	private void writeCoursesToFiles()
	
	{
		BufferedWriter bufferedWriter = null;
		int courseCount = 0;
		String courseFileName = null;
		
		for (courseCount = 0; courseCount < this.courses.length; courseCount++)
		{
			
			courseFileName = "course" + (courseCount + 1) + ".csv";
			
			
			try 
			
			{
				bufferedWriter = new BufferedWriter(new FileWriter(courseFileName));
				
				bufferedWriter.write("Student ID,Student Name,Course,Grade\n");
				
				
				for (int i = 0; i < this.students.length; i++)
				{
					if (this.courses[courseCount].getStudents()[i] != null)
					{
						bufferedWriter.write(String.valueOf(this.courses[courseCount].getStudents()[i].getStudentID()) + "," + this.courses[courseCount].getStudents()[i].getStudentName() + "," + this.courses[courseCount].getStudents()[i].getCourseTitle() + "," + this.courses[courseCount].getStudents()[i].getStudentGrade() + "\n");
					}
				}
			} 
			
			catch (IOException e) 
			
			{
				e.printStackTrace();
			}
			
			finally
			
			{
				if (bufferedWriter != null)
					
				{
					try 
					
					{
						bufferedWriter.close();
					} 
					
					catch (IOException e) 
					
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private int computeStudentsLength(String fileName)
	
	{
		int length = 0;
		BufferedReader bufferedReader = null;
		
		try 
		
		{
			bufferedReader = new BufferedReader(new FileReader(fileName));
			
			bufferedReader.readLine();
			
			
			while (bufferedReader.readLine() != null)
				
			{
				length++;
				
			}
			
		} 
		
		catch (FileNotFoundException e) 
		
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		
		{
			e.printStackTrace();
		}
		
		finally
		
		{
			try 
			
			{
				bufferedReader.close();
			} 
			
			catch (IOException e) 
			
			{
				e.printStackTrace();
			}
		}
		
		return length;
	}

}
