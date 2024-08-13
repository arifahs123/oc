package oopcw;

public class AdminUser extends User{

	//fields
	
	//constructors
	public AdminUser(int userID, String username) {
		super(userID, username, UserType.admin);
	}
	
	//getters
	
	//setters
	
	//public methods
	@Override
	public void viewAllBooks() {
		
	}
	
	//main method
}
