package oopcw;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminUser extends User{

	//fields
	
	//constructors
	public AdminUser(int userID, String username) {
		super(userID, username, UserType.admin);
	}
	
	//getters
	
	//setters
	
	//public methods
	
	//view the books by quantity:
    public List<Book> adminViewBooks(){
        //get list of books from library
        //sort the books in ascending order of quantity
        //return the sorted books
    	return null;
    }

	public void addBook() {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new book:");
        long isbn = getLongInput(scanner, "ISBN: ");
        
        System.out.print("Title: ");
        String title = scanner.next();
        scanner.nextLine();
        
        Language language = getValidLanguage(scanner);
        Genre genre = getValidGenre(scanner);
        
        //double retailPrice = getDoubleInput(scanner, "Retail price: ");
        System.out.print("Retail price: ");
        double retailPrice = scanner.nextDouble();
        scanner.nextLine();
        
        //int quantityInStock = getIntInput(scanner, "Quantity in stock: ");
        System.out.print("Quantity in stock: ");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine();
        
        String bookType = getValidBookType(scanner);
        
        Book newBook = null;
        if (bookType.equals("ebook")) {
        	System.out.print("Number of pages: ");
            double pages = scanner.nextDouble();
            scanner.nextLine(); 
            EBookFormat format = getValidEBookFormat(scanner);
            newBook = new EBook(isbn, title, language, genre, retailPrice, quantityInStock, pages, format);
        } else if (bookType.equals("audiobook")) {
        	System.out.print("Length: ");
            double length = scanner.nextDouble();
            scanner.nextLine();
            AudioBookFormat format = getValidAudioBookFormat(scanner);
            newBook = new AudioBook(isbn, title, language, genre, retailPrice, quantityInStock, length, format);
        }
        
        Library.libraryBooks.add(newBook);    
        Library.appendBookToFile(newBook, "Stock.txt");
        System.out.println("Book added successfully!");
        } 
       //else {
          //  System.out.println("Invalid book type. Book not added.");
            //return;
        //}
	
	private Language getValidLanguage(Scanner scanner) {
        while (true) {
            System.out.print("Language: English/French: ");
            String input = scanner.nextLine().trim();
            try {
                return Language.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid language. Please enter either English or French.");
            }
        }
    }

    private Genre getValidGenre(Scanner scanner) {
        while (true) {
            System.out.print("Genre: Business/Computer Science/Biography: ");
            String input = scanner.nextLine().trim().replace(" ", "_");
            try {
                return Genre.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid genre. Please enter Business, Computer Science, or Biography.");
            }
        }
    }

    private String getValidBookType(Scanner scanner) {
        while (true) {
            System.out.print("Book type: ebook/audiobook: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("ebook") || input.equals("audiobook")) {
                return input;
            }
            System.out.println("Invalid book type. Please enter either ebook or audiobook.");
        }
    }

    private EBookFormat getValidEBookFormat(Scanner scanner) {
        while (true) {
            System.out.print("Format: MOBI/AZW3/PDF: ");
            String input = scanner.nextLine().trim();
            try {
                return EBookFormat.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid format. Please enter MOBI, AZW3, or PDF.");
            }
        }
    }

    private AudioBookFormat getValidAudioBookFormat(Scanner scanner) {
        while (true) {
            System.out.print("Format (MP3/WMA/AAC): ");
            String input = scanner.nextLine().trim();
            try {
                return AudioBookFormat.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid format. Please enter MP3, WMA, or AAC.");
            }
        }
    }
    
    private long getLongInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }
    private double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    private int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }
}
	
	//main method

