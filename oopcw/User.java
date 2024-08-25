package oopcw;

//import oopcoursework.UserType;

public class User {

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
	
	public String getUsername() {
		return username;
	}
	
	//setters
	
	//public method
	public void viewAllBooks() {
		for (Book b: Library.libraryBooks) {
			System.out.println(b.getTitle() + b.getISBN() + b.getRetailPrice());
		}
	}
	
	//main method
}
