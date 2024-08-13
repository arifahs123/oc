package oopcw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
	// the fields section
	private List<Customer> customers; //access modifier, type of field, name of field
	
	//constructors
	public Shop(List<Customer> customers) {
		this.customers = customers;
	}
	//getters
	
	//setters
	
	//public methods
	
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> shopCustomers = new ArrayList<>();
		
		List<String> c1Items = new ArrayList<>(Arrays.asList("apple", "peach", "potato", "banana"));
		Customer c1 = new Customer("Alex", c1Items);
		shopCustomers.add(c1);
		
		List<String> c2Items = new ArrayList<>(Arrays.asList("potato", "kiwi", "orange"));
		Customer c2 = new Customer("John", c2Items);
		shopCustomers.add(c2);
		
		List<String> c3Items = new ArrayList<>(Arrays.asList("apple", "kiwi", "peach"));
		Customer c3 = new Customer("Sarah", c3Items);
		shopCustomers.add(c3);
		
		Map<String, List<String>> itemCustomers = new HashMap<>();
		//potato, {john, alex} 
		//apple, {alex, sarah}
		//kiwi, {john, sarah}
		//peach, {alex, sarah}
		//banana, {alex}
		//orange, {john}
		Shop tesco = new Shop(shopCustomers);
		
		for (Customer customer : shopCustomers) {
			for (String item : customer.getItems()) { //looks through every item in the items list
				//search if item exists in the hashmap keys
				if (itemCustomers.keySet().contains(item)) { //but it doesn't contain anything initially so it goes to else
				//if items is in hashmap keys, customer name should be added to the value of that key
					List<String> customerOfCurrentItem = itemCustomers.get(item); //gets the list of customers under the current item
					customerOfCurrentItem.add(customer.getName()); //adds current customer
					itemCustomers.put(item, customerOfCurrentItem); //key and value (key unique value not unique)
				} else {
					List<String> customerOfCurrentItem = new ArrayList<>(); //empty adds 1st customer (Alex) to an arraylist
					customerOfCurrentItem.add(customer.getName());
					itemCustomers.put(item, customerOfCurrentItem);
				}
			}
		}

for (String item : itemCustomers.keySet()) {
	System.out.print(item + " {");
	//for (List<String> customers : itemCustomers.get(item)) {
	List<String> nameOwnerOfCurrentCustomer = itemCustomers.get(item); 
	//for (String customer : itemCustomers.get(item)) {
	for (int i = 0; i < nameOwnerOfCurrentCustomer.size(); i++)	{
		
		if (i < nameOwnerOfCurrentCustomer.size() - 1) {
			System.out.print(nameOwnerOfCurrentCustomer.get(i));
			System.out.print( ", ");
		}
		if (i == nameOwnerOfCurrentCustomer.size() - 1) {
			System.out.print(nameOwnerOfCurrentCustomer.get(i));
		}
	}
		
	System.out.print("}");
	System.out.println();
		//System.out.print(customer);
		//System.out.print(", ");
	//System.out.print(item + ", ");	
	/*List<String> customers = itemCustomers.get(item);
	System.out.println(String.join(",", customers));*/
	
	}
}
		

	}


