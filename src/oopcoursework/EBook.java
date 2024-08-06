package oopcoursework;

public class EBook extends Book {
	//fields
	private int pages;
	private EBookFormat format;	
	
	//constructors
	public EBook(long isbn, String title, Language language, Genre genre, double retailPrice, int quantityInStock, int pages, EBookFormat format) {
		super(isbn, title, language, genre, retailPrice, quantityInStock);
		this.pages = pages;
		this.format = format;
	}
	//getters 
	
	//setters
	
	//public methods
	
	//main method
	public static void main() {
		EBook ebookName = new EBook (19238203, "The Wind in the Willows", Language.FRENCH, Genre.BIOGRAPHY, 29.45, 2, 830, EBookFormat.PDF);
	}
}

