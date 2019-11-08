import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExercise {
	static List<String> countries=new ArrayList<>();
	static Map<String, String> countryCapitals=new HashMap<>();
static{
	countries.add("India");
	countries.add("Srilanka");
	countries.add("Australia");
	countries.add("China");
	countryCapitals.put("India", "New Delhi");
	countryCapitals.put("Srilanka", "Colombo");
}
public static void displayCountries(){
	countries.forEach(p->System.out.print(p+" "));
}
public static void DisplayCountryCapitals(){
	countryCapitals.forEach((a,b)->System.out.print(a+" "+b+"\n"));
}
public static void sortCountriesByName(){
	Collections.sort(countries, (c1,c2)->c2.compareTo(c1));
	countries.forEach(s->System.out.println(s));
}
public static void sortCountriesBylength(){
	Collections.sort(countries,new Comparator<String>()
	{

		@Override
		public int compare(String s1, String s2) {
			int l1=s1.length();
			int l2=s2.length();
			if(l1<l2){
				return -1;
			}
			else if(l1>l2){
				return 1;
			}
			else{
				return s1.compareTo(s2);
			}
		}
	});
	countries.forEach(s->System.out.println(s));
	
}
public static void removeCountry(String name){
	if(name.length()>6 && countries.contains(name)){
		countries.remove(name);
		System.out.println("List of countries after removing "+name+" are");
		countries.forEach(s->System.out.println(s+"  "));
	}
	else{
		System.out.println("The item length is less than 6 or not in the List");
	}

}
	public static void main(String[] args) {
		System.out.println("Result of displayCountries() Method");
		LambdaExercise.displayCountries();
		System.out.println("Result of DisplayCountryCapitals() Method");
		LambdaExercise.DisplayCountryCapitals();
		System.out.println("Result of sortCountriesByName() Method");
		LambdaExercise.sortCountriesByName();
		System.out.println("Result of sortCountriesBylength() Method");
		LambdaExercise.sortCountriesBylength();
		System.out.println("Result of removeCountry(\"Srilanka\") Method");
		LambdaExercise.removeCountry("Srilanka");
	}

}
