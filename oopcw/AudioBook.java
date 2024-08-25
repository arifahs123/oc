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
		/*
		@Override
    	public String toString(){
        	return super.toString() + ", Length: " + length + " hours, Format: " + format;
    	}
		 */
	}

