package oopcw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	 public static void main(String[] args)
	 {
	  //array experiments
	  List<String> fruitList = new ArrayList<>(); //keeps order (index access) and multiple same value elements
	  fruitList.add("apple");
	  fruitList.add("orange");
	  fruitList.add("peach");
	  fruitList.add("kiwi");
	  fruitList.add("apple");
	  fruitList.add("apple");
	  fruitList.add("apple");
	  for (int i = 0; i < fruitList.size(); i++) {
		  System.out.println(fruitList.get(i));
	  }
	  System.out.println("--------------");
	  //set experiments
	  Set<String> fruitsSet = new HashSet<>(); //no duplicates only unique elements, no index access either
	  fruitsSet.add("apple");
	  fruitsSet.add("orange");
	  fruitsSet.add("peach");
	  fruitsSet.add("kiwi");
	  fruitsSet.add("apple");
	  fruitsSet.add("apple");
	  fruitsSet.add("apple");
	  for (String fruit : fruitsSet) {
		  System.out.println(fruit);
	  }
	//map experiments
	  System.out.println("--------------");
	  Map<Integer,String> colourMap = new HashMap<>();
	  colourMap.put(1, "blue");
	  //colourMap.put(1, "purple"); //keys are sets so they cannot hold duplicates
	  colourMap.put(4, "yellow"); //values are lists so the can have duplicates
	  colourMap.put(2, "red");
	  colourMap.put(3, "yellow");
	  colourMap.put(55, "orange");
	  colourMap.put(5, "orange");
	  for (Integer key : colourMap.keySet()) { // to loop through all the keys in the map
		  String keyValue = colourMap.get(key);
		  System.out.println(keyValue);
	  }
		 
	 }
	 
}

