package oopcw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Student extends Person{
	
	//here are fields - properties that are private to the class
	//fields are always private. getter and setter methods can be used to access them from a different class
	private double[] grades; //double[] list of doubles
	public static int numberOfRequiredExams = 10;
	private LocalDateTime examTime;
	//here are the constructors
	
	public Student() {} //default constructor
	public Student(int id, String name, String uni, String job, LocalDate birthdate, LocalDateTime examTime, double[] grades) { //arguments in bracket
		super(id, name, uni, job, birthdate); //calls on the parent constructor (Person, in this case)
		this.grades = grades;
		this.examTime = examTime;
		
		
	}
	

	//here are static methods for class Student
	public static void reduceNumberOfRequiredExams() {
		numberOfRequiredExams --;
		//non static fields cannot be accessed inside a static method
		//university = "Java Uni";
	}
	//here are public methods of the class Student
	
	@Override
	public String makecv() {
		numberOfRequiredExams --;
		//String studentcv = "Hi, my name is " + studentName + ". I am studying in " + university + ". I work as a " + occupation + ". My average score is " + studentavg;
		double studentavg = 0;
		try {
			for(int i = 0; i < grades.length; i++) {
				studentavg += grades[i];
			}
			studentavg /= grades.length;
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		String studentcv = "Hi, my name is " + getName() +
				". My birth date is " + birthdate + 
				". I am studying in " + getUni() + 
				". I work as a " + getJob() + 
				". My average score is " + studentavg +
				". My exam date will be on " + examTime;
		//println does not return, it just prints a value, but student cv is a string & returns instead of prints
		//System.out.println("Hi, my name is " + studentName + ". I am studying in " + university + ". I work as a " + occupation + ".");
		return studentcv; //return must always be last thing to execute
	}
	
	//a function can receive multiple variables but only return one single variable 
	
	//here are setter methods ; set private fields
	
	
	
	public void setGrades(double[] newGrades) { //always receive a value/arguments and return nothing
		// TODO Auto-generated method stub
		this.grades = newGrades;
	}
	//here are getter methods ; gets the private fields
	
	
	//here is the main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		double[] x_studentGrades = {45.6,56.7};
		//Date x_student_birthdate = new Date ();
		LocalDateTime studentExamTime = LocalDateTime.of(2024, 10, 10, 15, 30);
		LocalDate myDate = LocalDate.of(2014, 2, 14);
		Student x_student = new Student(1234, "Sarah", "University of Nottingham", "Teacher", myDate, studentExamTime, x_studentGrades);
		Person y_student = (Person) x_student;
		String cvy_student = y_student.makecv();
		System.out.println(cvy_student);
		x_student.setName("Max");
		System.out.println(x_student.getId());
		LocalDate myDate2 = LocalDate.of(2014, 3, 24);
		Student studentTwo = new Student(8000, "Arifah", "Random University", "Student", myDate2, studentExamTime, new double[]{67.8,78.9});
		Student studentThree = new Student(); //default constructor
		//print cv of student 2
		String cvstudentTwo = studentTwo.makecv(); //receives cv of student two 
		boolean instanceOfStudent = studentTwo instanceof Person;
		System.out.println("studentTwo is instance of Person:" + instanceOfStudent);
		System.out.println(cvstudentTwo);
		//my attempt
		//String cvstudentTwo = super. ??
		//print cv of x student
		String cvx_student = x_student.makecv();
		System.out.println(cvx_student);
		//print cv of student 3
		String cvstudentThree = studentThree.makecv();
		System.out.println(cvstudentThree);
		LocalDate myDate3 = LocalDate.of(2014, 4, 04);
		Student studentFour = new Student(1835, "Jack", "University of Nottingham", "Teacher", myDate3, studentExamTime, x_studentGrades);
		String cvStudentFour = studentFour.makecv();
		System.out.println(cvStudentFour);
		//static methods and fields are accessible at the class level.
		//non static methods and fields are only accessible at the instance level.
		
		
	}
	

}
