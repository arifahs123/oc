package oopcw;

import java.util.List;

public class CustomerUser extends User{
	//fields - all mentioned in User
	
	//constructors
	public CustomerUser(int userID, String username) {
		super(userID, username, UserType.customer);
	}
	
	//getters
	
	//setters
	
	//public methods
	public List<Book> customerViewBooks(){
        //get list of books from library
        //sort the books in ascending order of price
        //return the sorted books
		return null;
    }
	
	//main method
	//public static void main(String[] args) {
		//CustomerUser c = new CustomerUser(3300, "user100");
	//}
}
