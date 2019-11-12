import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utility {
	
	public static List<LocalTime> getBusSchedule(String start, Duration frequency){
		String[] ar=start.split(":");
		long add=frequency.toHours();
		LocalTime startTime=LocalTime.of(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));
		LocalTime EndTime=LocalTime.of(00,00);
		long dur=Duration.between(EndTime,startTime).toHours();
		return IntStream.iterate(0, i->i+(int)add).mapToObj(i -> startTime.plusHours(i))
				.limit(dur/add).collect(Collectors.toList());
	}
	public static void main(String[] args) {
		System.out.println("*************Get Schedule*************");
		System.out.println(getBusSchedule("13:59", Duration.ofHours(2)));
	}

}
