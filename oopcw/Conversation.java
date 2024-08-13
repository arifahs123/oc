package oopcw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversation {
	
	//fields
	private Scanner input;
	
	public Conversation() {} //constructors and class same name always
	public Conversation(Scanner inputScanner) {
		input = inputScanner;
	}
	
	//public methods
	public Student makeConversation() {
		Student currentStudent = new Student();
		System.out.println("Hi, what is your name?");
//input.nextLine(); returns a string that has not been stored anywhere so can't be used
		String name = input.nextLine(); //stores the string in variable name so operations can be performed
		System.out.println("Hi "+name);
		currentStudent.setName(name);
		
		System.out.println("And what is your student ID?");
		//System.out.println(input.nextLine());
		int id = input.nextInt();
		//System.out.println(id);
		currentStudent.setId(id);
		
		System.out.println("And what is your occupation?");
		String occupation = input.nextLine();
		occupation = input.nextLine();
		
		currentStudent.setJob(occupation);
		
		System.out.println("And what university do you attend?");
		String university = input.nextLine();
		currentStudent.setUni(university);
		
		System.out.println("List of your grades, separated by comma:");
		String listOfGrades = input.nextLine();
		String[] individualGrades = listOfGrades.split(",");
		double[] grades = new double[individualGrades.length];
		for (int i = 0; i < individualGrades.length; i++) {
			grades[i] = Double.parseDouble(individualGrades[i]); //parseDouble() receives a string and returns the double value of the string
		}
		currentStudent.setGrades(grades);
		
		return currentStudent;
	}
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("How many students are in the class?");
		
		
		//System.out.println(new File(".").getAbsoluteFile().getAbsolutePath());
		//String studentFilePath = new File(".").getAbsoluteFile().getAbsolutePath();
	    File inputFile = new File("students.txt"); //file class is imported (players.txt checks the current directory)
		//Scanner numScanner = new Scanner(System.in); //will read from System.in(console)
		//this Scanner will read from the file 
		Scanner numScanner =  null;
		try {
			numScanner = new Scanner(inputFile);
			//System.out.println("??");
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return;
		}
		int numStudents = numScanner.nextInt(); 
		numScanner.nextLine();
		System.out.println(numStudents);
		List<Student> studentsOfClass = new ArrayList<Student>();
		//Scanner sc = new Scanner(System.in); //create a scanner object
		//Scanner sc = new Scanner(inputFile); 
		Conversation myConversation = new Conversation(numScanner);
		
		for(int i = 0; i < numStudents; i++) {
			Student currentStudent =  myConversation.makeConversation();
			studentsOfClass.add(currentStudent);
		}
		System.out.println("Here are all the students of the class: ");
		for (Student x : studentsOfClass) {
			String currentStudentCV = x.makecv();
			System.out.println(currentStudentCV);
		}
		
	}

}
