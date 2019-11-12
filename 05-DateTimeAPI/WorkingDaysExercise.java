import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class WorkingDaysExercise {
	public static List<String> getNextMonthsWorkingDays(){
		long days=LocalDate.now().plusMonths(1).lengthOfMonth();
		List<LocalDate> list=IntStream.iterate(0, i->i+1).mapToObj(i->(LocalDate.now().plusMonths(1).withDayOfMonth(1)).plusDays(i)).limit(days)
				.filter(d->!d.getDayOfWeek().equals(d.getDayOfWeek().SATURDAY)).filter(d-> !d.getDayOfWeek().equals(d.getDayOfWeek().SUNDAY))
				.collect(Collectors.toList());
	
		List<String> result=new ArrayList<>();
		for (LocalDate localDate : list) {
			String fdate=localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			result.add(fdate);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println("**************************Get Next Month Working days*****************");
		System.out.println(getNextMonthsWorkingDays());
	}
	
}
