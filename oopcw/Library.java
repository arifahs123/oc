package oopcw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//to do: create a function called readUsers, which will read users from the file 
// and fill library users static variable
//call library users from file and then initialise library users 
//st.replaceAll("\\s+","")
public class Library {
	
	//fields
	//defined a list of the User and Book classes
	public static List<User> libraryUsers= readUsers("C:\\Users\\arifa\\eclipse-workspace\\oopcw\\oopcw\\useraccount1.txt");
	public static List<Book> libraryBooks= readBooks("C:\\Users\\arifa\\eclipse-workspace\\oopcw\\oopcw\\stock1.txt");
	public static int x = 5;
	//constructors
	public Library() {
		
	}
	
	//getters
	//setters
	//public methods
	//public static methods
	
	//gets the filepath containing the books, reads every line as a book and return the list of books
	public static List<Book> readBooks(String filepath){ //the input is the filepath
		//Book x = new Book()
		List<Book> books = new ArrayList<Book>(); //empty list of books
		File inputFile = new File(filepath); 
		Scanner fileScanner;
		try { //attempts to read the stock file
			fileScanner = new Scanner(inputFile);
		
			while (fileScanner.hasNextLine()) { //iterating every line of the stock file
				String line = fileScanner.nextLine();
				String[] properties = line.split(",");
				Book currentBook = null;
				String currentISBN = properties[0];
				long dISBN = Long.parseLong(currentISBN);
				String currentBookType = properties[1];
				String currentTitle = properties[2];
				String currentLang = properties[3].trim();
				Language dLang = Language.valueOf(currentLang);
				String currentGenre = properties[4].trim().replace(" ", "_"); //saved the comp sci enum as computer_science instead 
				Genre dGenre = Genre.valueOf(currentGenre);
				String currentPrice = properties[5];
				double dPrice = Double.valueOf(currentPrice); //parseInt etc and valueOf are interchangeable
				String currentStock = properties[6].trim();
				int dStock = Integer.parseInt(currentStock);
				String currentLength = properties[7].trim();
				//int dLength = Integer.parseInt(currentLength); //what we had before
				double dLength = Double.parseDouble(currentLength); //my attempt
				String currentFormat = properties[8];
				switch(currentBookType) {
				  case "audiobook":
					AudioBookFormat aFormat = AudioBookFormat.valueOf(currentFormat);
				    currentBook = new AudioBook(dISBN, currentTitle, dLang, dGenre, dPrice, dStock, dLength, aFormat);
				    break;
				  case "ebook":
				    EBookFormat eFormat = EBookFormat.valueOf(currentFormat);
				    currentBook = new EBook(dISBN, currentTitle, dLang, dGenre, dPrice, dStock, dLength, eFormat);
				    break;
				  default:
				    //System.out.println(line + "will be skipped as the type is not audiobook nor ebook.");
				}
				if (currentBook != null) {
					books.add(currentBook);
					System.out.println(currentBook.getTitle() + "is added.");
				}
				
				//System.out.println(line);
			}
			fileScanner.close();
		} catch (FileNotFoundException e) { //if it fails, it prints the stackTrace saying the file doesnt exist
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books; //the output is the list of books if the file is found, books contains list of books read from file, otherwise books is  empty
	}
	
	
	public static List<User> readUsers(String filepath){
		List<User> users = new ArrayList<User>(); 
		File inputFile = new File(filepath); 
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(inputFile);
			
			while (fileScanner.hasNextLine()) { 
				String line = fileScanner.nextLine();
				String[] credentials = line.split(",");
				User currentUser = null;
				String currentUserId = credentials[0].trim();
				int iUserId = Integer.parseInt(currentUserId);
				String currentUserName = credentials[1].trim();
				String currentUserRole = credentials[2].trim();
				switch(currentUserRole.trim()) { 
					case "admin":
						UserType adminRole = UserType.valueOf(currentUserRole);
						currentUser = new AdminUser(iUserId, currentUserName); 
						break;
					case "customer":
						UserType customerRole = UserType.valueOf(currentUserRole);
						currentUser = new CustomerUser(iUserId, currentUserName);
						break;
				}
				users.add(currentUser);
				//System.out.println(line);
			}
			fileScanner.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	//main method
	
	public static void main(String[] args) {
		
		Library myLib = new Library();
		System.out.println(Library.x);
		for (Book b: Library.libraryBooks) { //
			System.out.println(b.getTitle());
		}
		
	    for (User u: myLib.libraryUsers) {
	        System.out.println(u.getUserId()); //need to make a getter method for the ID
	    }
	}
}
