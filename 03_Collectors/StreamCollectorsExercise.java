import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {
	 static List<Player> players=Arrays.asList(
				new Player("Amit",2,4,130,"India"),
				new Player("Bipul",5001,4,7,"USA"),
				new Player("Guhan",2,4,7,"Singapore"),
				new Player("Vishwendra",5080,1280,7,"Germany"),
				new Player("Gopal",5090,1290,7,"Germany")
				);
	public static void getPlayersByCountry(){
		Map<String,List<String>> res=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.mapping(Player::getPlayerName, Collectors.toList())));
		res.forEach((k,v)->System.out.println(k+" "+v));
	}
	public static Map<String,List<String>> getPlayerNamesByCountry(){
		Map<String,List<String>> res=players.stream().filter(p->p.getMatchesPlayed()>100).collect(Collectors.groupingBy(Player::getCountry,Collectors.mapping(Player::getPlayerName, Collectors.toList())));
		return res;
	}
	public static LinkedHashMap<String,Long> getTotalPlayersByCountry(){
		
		Map<String, Long> res=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.counting()));
		LinkedHashMap<String,Long> result=new LinkedHashMap<>(res);
		return result;
	}
	public static Map<String,Integer> getTotalRunsByCountry(){
		Map<String, Integer> res=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.summingInt(Player::getRuns)));
		return res;
	}
	public static Map<String, Optional<Player>>  getMaxScoreByCountry(){
		Map<String, Optional<Player>> res=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.maxBy(Comparator.comparing(Player::getRuns))));
		return res;
	}
	public static Map<String,String> getPlayerNamesStringByCountry(){
		Map<String,String> res=players.stream().collect(Collectors.groupingBy(Player::getCountry,Collectors.mapping(Player::getPlayerName, Collectors.joining(", "))));
		return res;
	}
	public static void main(String[] args) 
	{
		//StreamCollectorsExercise.getPlayersByCountry();
		StreamCollectorsExercise.getPlayerNamesStringByCountry();
	}
	

}
