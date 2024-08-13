package oopcw;

//import oopcoursework.AudioBookFormat;

public class AudioBook extends Book{
	//fields
		private double length;
		private AudioBookFormat format;	
		
		//constructors
		//changed length to a double
		public AudioBook(long isbn, String title, Language language, Genre genre, double retailPrice, int quantityInStock, double length, AudioBookFormat format) {
			super(isbn, title, language, genre, retailPrice, quantityInStock);
			this.length = length;
			this.format = format;
		}
		//getters 
		public double getLength() {
			return length;
		}
		
		public AudioBookFormat getFormat() {
			return format;
		}
		//setters
		public void setLength(int length) {
			this.length = length;
		}
		
		public void setFormat(AudioBookFormat format) {
			this.format = format;
		}
		
		//public methods
		
		//main method
		public static void main() {
			//AudioBook audiobookName = new AudioBook (19238203, "The Wind in the Willows", Language.FRENCH, Genre.BIOGRAPHY, 29.45, 2, 2334, AudioBookFormat.WMA);
		}
	}

