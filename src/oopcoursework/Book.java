package oopcoursework;


public class Book { 
	
	//fields
	private long isbn;
	private String title;
	private Language language;
	private Genre genre;
	private double retailPrice;
	private int quantityInStock;
	
	//constructors
	public Book(long isbn, String title, Language language, Genre genre, double retailPrice, int quantityInStock) {
		this.isbn = isbn;
		this.title = title;
		this.language = language;
		this.genre = genre;
		this.retailPrice = retailPrice;
		this.quantityInStock = quantityInStock;
	}
	
	//getters
	
	//setters
	
	//public methods
	
	//main method
	public static void main() {
		Book bookName = new Book(19238203, "The Wind in the Willows", Language.FRENCH, Genre.BIOGRAPHY, 29.45, 2);
	}
}
