import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeExercise {
	static List<Tablet> tablets=new ArrayList<>(Arrays.asList(
			new Tablet("Dizine","abc",LocalDate.of(2019, 04, 23),LocalDate.of(2019, 11, 21)),
			new Tablet("Bikosule","def",LocalDate.of(2019, 02, 23),LocalDate.of(2019, 05, 20)),
			new Tablet("Pantids","ghi",LocalDate.of(2019, 04, 23),LocalDate.of(2019, 05, 23)),
			new Tablet("Vicks","jkl",LocalDate.of(2019, 03, 23),LocalDate.of(2020, 12, 24))
			));
	public static List<String> getExpiringTables(int months){
		List<String> result=tablets.stream().filter(f -> f.getExpiryDate().isBefore(LocalDate.now().plusMonths(months))).map(Tablet::getTablet_name).collect(Collectors.toList());
		return result;
	}
	public static List<String> getExpiringTabletsSorted(){
		
		List<String> result=tablets.stream().sorted((a,b)-> a.getExpiryDate().compareTo(b.getExpiryDate())).map(Tablet::getTablet_name).collect(Collectors.toList());
		return result;
	}
	public static Map<String, String>getTabletExpiryPeriod(){
		Map<String, String> result=tablets.stream().collect(
				Collectors.toMap(Tablet::getTablet_name, v -> (Period.between(v.getManufactureDate(),v.getExpiryDate())).getYears()
				+" year/s "+(Period.between(v.getManufactureDate(),v.getExpiryDate())).getMonths()
				+" month/s "+(Period.between(v.getManufactureDate(),v.getExpiryDate())).getDays()+" day/s "));
		
		return result;
	}
	public static List<String> getTablets(Tablet t){
		List<String> tablet=new ArrayList<>();
		tablet.add(t.getTablet_name());
		return tablet;
	}
	public static Map<String,List<String>> getSameYearExpiry(){
		Map<String, List<String>> result=tablets
				.stream()
				.filter(f ->(f.getManufactureDate().getYear())==(LocalDate.now().getYear()))
				.filter(s -> s.getExpiryDate().isBefore(LocalDate.now()))
				.collect(Collectors.toMap(Tablet::getManufacturer, DateTimeExercise::getTablets));
		return result;
	}
	public static void main(String[] args) {
		System.out.println("***************************Get Expiring Tablets********************");
		System.out.println(getExpiringTables(2));
		System.out.println("***************************Get Sorted Expiring Tablets based on Expiry Date*********************");
		System.out.println(getExpiringTabletsSorted());
		System.out.println("***************************Get Tablet Expiry Period********************");
		System.out.println(getTabletExpiryPeriod());
		System.out.println("***************************Same Year Expiry*********************");
		System.out.println(getSameYearExpiry());
	}

}
