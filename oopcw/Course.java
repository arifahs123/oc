package oopcw;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//A Java program to show that references are also passed by value.

class Course {
 
//fields
 private int x; 
 private List<Student> registeredStudent;
 private String courseName;
 
//constructor 
 public Course(int i, String nameOfCourse) { 
	 registeredStudent = new ArrayList();
	 x = i;
	 courseName = nameOfCourse;
	 }
 public Course() { x = 0; }
 //the access modifier of a constructor must always be public
 
 //static methods
 
 //public methods
 private void addStudent(Student courseStudent) {
	// TODO Auto-generated method stub
	try {
		registeredStudent.add(courseStudent);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
 //main method
 public static void main(String[] args)
 {
//creating an instance of class Course
	 Course maths = new Course(4, "Maths");
//creating a new instance of the Student class
	 Student studentOne = new Student(1,"Max","UCL","Student",new double[] {50.0,45.5});
	 Student studentTwo = new Student(2,"John","UCL","Student",new double[] {50.0,45.5});
	 Student studentThree = new Student(3,"Jack","UCL","Student",new double[] {50.0,45.5});
	 studentOne.rename("James");
//adding Student max to the list registeredStudent
	 maths.addStudent(studentOne);
	 maths.addStudent(studentTwo);
	 maths.addStudent(studentThree);
	 List<Student> studentsOfMaths = maths.registeredStudent;
	 for (Student j : studentsOfMaths) {
		 System.out.println(j.getName());
		 System.out.print();
	 }
	 Course chemistry = new Course(7, "Chemistry");
	 System.out.println(args.length);
	 for (String i : args) {
		 System.out.println(i);
	 }
 }

}
