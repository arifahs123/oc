package oopcw;

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
	public long getISBN() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public double getRetailPrice() {
		return retailPrice;
	}
	
	public int getQuantityInStock() {
	    return quantityInStock;
	}
	
	//setters
	public void setISBN(long isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLanguage(Language language) {
	    this.language = language;
	}

	public void setGenre(Genre genre) {
	    this.genre = genre;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public void setStockQuantity(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	@Override
	public String toString() {
	    return String.format("ISBN: %d, Title: %s, Language: %s, Genre: %s, Price: %.2f, Stock: %d",
	        isbn, title, language, genre, retailPrice, quantityInStock);
	}
	
}
