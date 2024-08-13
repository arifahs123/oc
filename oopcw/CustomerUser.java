package oopcw;

public class CustomerUser extends User{
	//fields - all mentioned in User
	
	//constructors
	public CustomerUser(int userID, String username) {
		super(userID, username, UserType.customer);
	}
	
	//getters
	
	//setters
	
	//public methods
	
	//main method
	public static void main(String[] args) {
		CustomerUser c = new CustomerUser(3300, "user100");
	}
}
