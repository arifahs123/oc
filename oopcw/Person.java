package oopcw;

import java.time.LocalDate;
import java.util.Date;

public class Person {

	//here are the fields
	protected LocalDate birthdate;
	private int id;
	private String name; 
	private String university;
	private String occupation;
	
	
	//here are the constructors
	public Person() {}
	public Person(int id, String name, String university, String occupation, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.university = university;
		this.occupation = occupation;
		this.birthdate = birthdate;
	}
	
	//here are static methods
	
	//here are public methods
	public String makecv() {
		String personcv = "Hi, my name is " + name + ". My birth date is " + birthdate + ". I am studying in " + getUni() + ". I work as a " + getJob() + ".";
		//id, name, university, job and birthdate are all defined in this class so the setter/getter is not necessarily needed
		return personcv;
	}
	
	//getter methods
	public String getName() { //no need for arguments, getter methods receive no arguments but return a specific variable therefore never void
		return this.name;
	}
	public int getId() { //no need for arguments, getter methods receive no arguments but return a specific variable therefore never void
		return this.id;
	}
	public String getUni() { //no need for arguments, getter methods receive no arguments but return a specific variable therefore never void
		return this.university;
	}
	public String getJob() { //no need for arguments, getter methods receive no arguments but return a specific variable therefore never void
		return this.occupation;
	}
	
	//setter methods
	public void setId(int newId) {
		this.id = newId;
	}
	public void setName(String newName) { //always receive a value/arguments and return nothing
		// TODO Auto-generated method stub
		this.name = newName;
	}
	public void setUni(String newUni) { //always receive a value/arguments and return nothing
		// TODO Auto-generated method stub
		this.university = newUni;
	}
	
	public void setJob(String newJob) { //always receive a value/arguments and return nothing
		// TODO Auto-generated method stub
		this.occupation = newJob;
	} 
	
	//the main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
