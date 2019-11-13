package com.cts.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {
	private static List<String> countries=new ArrayList<>();
	private static Map<String, String> countryCapitals=new HashMap<>();
static {
	countries.add("India");
	countries.add("China");
	countries.add("Sri Lanka");
	countries.add("Bhutan");
	countries.add("Bangladesh");
	countryCapitals.put("India", "New Delhi");
	countryCapitals.put("Sri Lanka", "Colombo");
	countryCapitals.put("China", "Beijing");
	countryCapitals.put("Bhutan", "Thimphu");
	countryCapitals.put("Bangladesh", "Dhaka");
}
public static void displayCountries() {
	countries.forEach(System.out::println);
}
public static void displayCountryCapitals() {
	countryCapitals.forEach((k,v)->System.out.println(k+"  :"+v));
}
public static void sortCountriesByName() {
	countries.sort((c1,c2)->c1.compareToIgnoreCase(c2));
	countries.forEach(System.out::println);
}
public static void sortCountriesBylength() {
	countries.sort((l1,l2)->
	{
	int length=l2.length()-l1.length();
	if(length==0) {
		return l1.compareToIgnoreCase(l2);
	}
	return l2.length()-l1.length();
	}
	);
	countries.forEach(System.out::println);
}
public static void removeCountry(String name) {
	if(name.length()>6 && countries.contains(name)) {
		countries.remove(name);
	}
	else {
	System.out.println("The Element is not Present or length is less than 6");
	}
	countries.forEach(System.out::println);
}
public static void main(String[] args) {
	System.out.println("************Displaying Countries*****************");
	displayCountries();
	System.out.println("************Displaying Countries and Capitals*****************");
	displayCountryCapitals();
	System.out.println("************Sort Countries by Name*****************");
	sortCountriesByName();
	System.out.println("************Sort Countries by Length*****************");
	sortCountriesBylength();
	System.out.println("************Remove Countries if valid Length and name*****************");
	removeCountry("Sri Lanka");
}
}
