package oopcw;

//import oopcoursework.UserType;

public class User { //will either have extend classes admin and customer or have roles admin and customer

	//fields	
	private int userID;
	private String username;
	private UserType usertype;
	
	//constructors 
	public User(int userID, String username, UserType usertpye) {
		this.userID = userID;
		this.username = username;
		this.usertype = usertype;
	}
	//getters
	public int getUserId() {
		return userID;
		
	}
	
	//setters
	
	//public method
	public void viewAllBooks() {
		
	}
	
	//main method
}
