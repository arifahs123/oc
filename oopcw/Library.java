package oopcw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//to do: create a function called readUsers, which will read users from the file 
// and fill library users static variable
//call library users from file and then initialise library users 
//st.replaceAll("\\s+","")
public class Library {
	
	                                                                                                              
	public static List<User> libraryUsers= readUsers("UserAccounts.txt");    
	public static List<Book> libraryBooks= readBooks("Stock.txt");          
	
	
	
	
	//fields
	//defined a list of the User and Book classes
	
	
	//getters
	//setters
	//public methods
	//public static methods
	
	//gets the file path containing the books, reads every line as a book and return the list of books
	public static List<Book> readBooks(String filepath){ //the input is the file path
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
				String currentBookType = properties[1].trim();
				String currentTitle = properties[2].trim();
				String currentLang = properties[3].trim();
				Language dLang = Language.valueOf(currentLang);
				String currentGenre = properties[4].trim().replace(" ", "_"); //saved the comp sci Enum as computer_science instead 
				Genre dGenre = Genre.valueOf(currentGenre);
				String currentPrice = properties[5].trim();
				double dPrice = Double.valueOf(currentPrice); //parseInt etc and valueOf are interchangeable
				String currentStock = properties[6].trim();
				int dStock = Integer.parseInt(currentStock);
				String currentLength = properties[7].trim();
				//int dLength = Integer.parseInt(currentLength); //what we had before
				double dLength = Double.parseDouble(currentLength); //my attempt
				String currentFormat = properties[8].trim();


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
				}
				
				//System.out.println(line);
			}
			fileScanner.close();
		} catch (FileNotFoundException e) { //if it fails, it prints the stackTrace saying the file doesnt exist
			System.out.println("File not found!");
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
				//String currentUserId = credentials[0].trim();
				//int iUserId = Integer.parseInt(currentUserId);
				//String currentUserName = credentials[1].trim();
				//String currentUserRole = credentials[2].trim();
				int iUserId = Integer.parseInt(credentials[0].trim());
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
	
	 public static List<Book> getBooksByQuantity() {
	        List<Book> sortedBooks = new ArrayList<>(libraryBooks);
	        Collections.sort(sortedBooks, Comparator.comparingInt(Book::getQuantityInStock));
	        return sortedBooks;
	 }
	 
	 public static List<Book> getBooksByPrice() {
	        List<Book> sortedBooks = new ArrayList<>(libraryBooks);
	        Collections.sort(sortedBooks, Comparator.comparingDouble(Book::getRetailPrice));
	        return sortedBooks;
	    }
	
	 public static void appendBookToFile(Book book, String filepath) {
        try {
            File file = new File(filepath);
            FileWriter fw = new FileWriter(file, true); 
            fw.write("\n" + bookToFileLine(book) + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }

    private static String bookToFileLine(Book book) {
        return String.format("%d, %s, %s, %s, %s, %.2f, %d, %.1f, %s",
            book.getISBN(),
            (book instanceof EBook) ? "ebook" : "audiobook",
            book.getTitle(),
            book.getLanguage(),
            book.getGenre(),
            book.getRetailPrice(),
            book.getQuantityInStock(),
            (book instanceof EBook) ? ((EBook) book).getPages() : ((AudioBook) book).getLength(),
            (book instanceof EBook) ? ((EBook) book).getFormat() : ((AudioBook) book).getFormat()
        );
    }
	 
	//main method
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to My Bookshop.");
        //System.out.println("Current working directory: " + System.getProperty("user.dir"));
        
        while(true) {
        	System.out.println("What is your username? ('X' to quit): ");
        	String input = scanner.nextLine().trim();
        	
        	if (input.equalsIgnoreCase("X")) {
                break;
        	}
        	 User currentUser = null;
             for (User user : libraryUsers) {
                 if (user.getUsername().equals(input)) {
                     currentUser = user;
                     break;
                 }
             }  
             if (currentUser == null) {
                System.out.println("User not found. Please try again.");
                continue;
            }
             System.out.println("Welcome, " + currentUser.getUsername() + "!");
             
             while (true) {
                if (currentUser instanceof AdminUser) {
                	System.out.println("Admin Menu");
                    System.out.println("\n1. View all books\n2. Add a new book\n3. Log out.");
                    System.out.print("Choose an option by its' number: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                  
                    switch (choice) {
                    //admin user views books
                        case 1:
                            List<Book> sortedBooks = getBooksByQuantity();
                            for (Book book : sortedBooks) {
                                System.out.println(book);
                            }
                            System.out.println("Press enter to continue.");
                            scanner.nextLine();
                            break;
                    //admin user adds a book to the bookshop library    
                        case 2:    
                        	 ((AdminUser) currentUser).addBook();
                             break;   
                    //log out
                        case 3:
                        	currentUser = null;
                        	System.out.println("Goodbye!");
                        	break;
                    //none of the 3 options
                        default:
                        	System.out.println("Option not valid. Try again?");
                    }
                }
                else if (currentUser instanceof CustomerUser) {
                	System.out.println("Customer Menu");
                    System.out.println("\n1. View all books\n2. Logout");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    switch (choice) {
                //customer user view of the books
                    case 1:
                        List<Book> sortedBooks = getBooksByPrice();
                        for (Book book : sortedBooks) {
                            System.out.println(book);
                        }
                        System.out.println("Press enter to continue.");
                        scanner.nextLine();
                        break;
                //leave the system        
                    case 2:
                        currentUser = null;
                        System.out.println("Come again soon!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                    }
                }
                if (currentUser == null) {
                    break;
                }
                
             }
         }
        System.out.println("Thank you for using the Library System. Goodbye!");
        scanner.close();
    }
}

