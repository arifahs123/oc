package oopcw;

public class EBook extends Book {
	//fields
	private double pages;
	private EBookFormat format;	
	
	//constructors
	//changed pages to a double
	public EBook(long isbn, String title, Language language, Genre genre, double retailPrice, int quantityInStock, double pages, EBookFormat format) {
		super(isbn, title, language, genre, retailPrice, quantityInStock);
		this.pages = pages;
		this.format = format;
	}
	//getters 
	public double getPages() {
		return pages;
	}
	
	public EBookFormat getFormat() {
		return format;
	}
	//setters
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void getFormat(EBookFormat format) {
		this.format = format;
	}
	
	//public methods
	
	//main method
	public static void main() {
		//EBook ebookName = new EBook (19238203, "The Wind in the Willows", Language.FRENCH, Genre.BIOGRAPHY, 29.45, 2, 830, EBookFormat.PDF);
	}
}

