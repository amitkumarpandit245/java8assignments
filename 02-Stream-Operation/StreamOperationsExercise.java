import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {
	static List<Player> players=Arrays.asList(
			new Player("Amit",2,4,130,"India"),
			new Player("Bipul",5001,4,7,"USA"),
			new Player("Guhan",2,7000,6000,"Singapore"),
			new Player("Vishwendra",5062,8000,7,"Germany"),
			new Player("Gopal",5060,8002,7,"Germany")
			);
	static void displayPlayers(){
		players.stream().forEach(s->System.out.println(s+" "));
	}
	public static void main(String[] args) {
		//StreamOperationsExercise.displayPlayers();
		//StreamOperationsExercise.displayPlayersForCountry("India");
		
		StreamOperationsExercise.getAverageRunsByCountry("Germany");
	}
	public static void displayPlayersForCountry(String country){
		List<Player> students=players.stream().filter(s->s.getHighestScore()>100 && s.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
		students.forEach(s->System.out.println(s));
	}
	public static LinkedList<String> getPlayerNames(){
		//LinkedList<Player> player=players.stream().filter(s->s.getRuns()>5000).sorted((s1,s2)->s2.getPlayerName().compareTo(s1.getPlayerName())).collect(Collectors.toCollection(LinkedList::new));
		LinkedList<String> player=players.stream().filter(s->s.getRuns()>5000).map(Player::getPlayerName).sorted().collect(Collectors.toCollection(LinkedList::new));
		return player;
	}
	public static Map<String,Double> getAverageRunsByCountry(String country){
		Map<String,Double> result=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.averagingDouble(Player::getRuns)));
		result.forEach((k,v)->System.out.println(k+""+v));
		return result;
	}
	public static List<String> getPlayerNamesSorted(){
		List<String> result=players.stream().sorted((a,b)->a.getCountry().compareTo(b.getCountry())).sorted((a,b)->b.getMatchesPlayed()-a.getMatchesPlayed()).collect(Collectors.mapping(Player::getPlayerName, Collectors.toList()));
		result.forEach(System.out::println);
		return result;
	}
	public static Map<String,String> getPlayerCountry(){
		Map<String,String> result=players.stream().filter(p -> p.getMatchesPlayed()>200).collect(Collectors.toMap(Player::getCountry, Player::getCountry));
		return result;
	}
	public static Optional<Player> getMaxRunsPlayer(){
		
		Optional<Player> result=players.stream().sorted((a,b)->b.getHighestScore()-a.getHighestScore()).findFirst();
		return result;
	}
	public static List<Player> findPlayer(String name, String country){
		return players.stream().filter(p -> p.getPlayerName().equalsIgnoreCase(name) && p.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
	}
	public static boolean checkHighScorerByCountry(String country){
		return players.stream().filter(c -> c.getRuns()>1000 && c.getCountry().equalsIgnoreCase(country)).findAny().isPresent();
	}
	
}
