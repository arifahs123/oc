package oopcw;

import java.util.List;

public class Customer {
	//fields
	private String name;
	private List<String> items;
	
	//constructors
	public Customer(String name, List<String> items) {		
		this.name = name;
		this.items = items;
	}
	
	//getters
	public List<String> getItems(){
		return items;
	}
	
	public String getName() {
		return name;
	}
	
	//setters
	
	//public methods
	
	//main method
}
