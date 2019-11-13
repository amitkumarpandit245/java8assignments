package com.cts.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {
	private static List<Player> players=new ArrayList<>(Arrays.asList(
			new Player("Dhoni",200,10010,99,new Country(1,"India")),
			new Player("Virat",201,10011,129,new Country(1,"India")),
			new Player("Sachin",202,10012,123,new Country(1,"India")),
			new Player("Yuvraj",203,10013,124,new Country(1,"India")),
			new Player("Ponting",200,10010,121,new Country(2,"Australia")),
			new Player("Mcrath",198,10011,122,new Country(2,"Australia")),
			new Player("Akhtar",202,1000,123,new Country(3,"Pakistan")),
			new Player("Sami",199,10013,124,new Country(3,"Pakistan"))
			));
	public static void displayPlayers(){
		players.stream().map(Player::getPlayerName).forEach(System.out::println);
	}
	public static void displayPlayersForCountry(String country){
		players.stream().filter(c-> c.getCountry().getCountryName().equalsIgnoreCase(country) && c.getHighestScore()>100).map(Player::getPlayerName).forEach(System.out::println);;
	}
	public static LinkedList<String> getPlayerNames(){
		LinkedList<String> result=players.stream().filter(f -> f.getRuns()>5000).sorted((n1,n2)->n2.getPlayerName().compareToIgnoreCase(n1.getPlayerName())).map(Player::getPlayerName).collect(Collectors.toCollection(LinkedList::new));
		System.out.println(result);
		return result;
	}
	public static Double getAverageRunsByCountry(String country){
		Double result=players.stream().filter(c-> c.getCountry().getCountryName().equalsIgnoreCase(country)).collect(Collectors.averagingDouble(Player::getRuns));
		System.out.println("Average of "+country+" is "+result);
		return result;
	}
	public static List<String> getPlayerNamesSorted(){
		List<String> result=players.stream().sorted((c1,c2)->c1.getCountry().getCountryName().compareToIgnoreCase(c2.getCountry().getCountryName())
				).sorted((m1,m2)->m2.getMatchesPlayed()-m1.getMatchesPlayed()).map(Player::getPlayerName).collect(Collectors.toList());
		System.out.println(result);
		return result;
	}
	public static Map<String, String> getPlayerCountry(){
		Map<String,String> result=players.stream().filter(f-> f.getMatchesPlayed()>200).collect(Collectors.toMap(Player::getPlayerName, v->v.getCountry().getCountryName()));
		System.out.println(result);
		return result;
	}
	public static Player getMaxRunsPlayer(){
		Optional<Player> p=players.stream().sorted((p1,p2)->p2.getHighestScore()-p1.getHighestScore()).findFirst();
		Player player=p.get();
		System.out.println(player);
		return player;
	}
	public static Player findPlayer(String name, String country){
		Optional<Player> pl=players.stream().filter(p-> p.getCountry().getCountryName().equalsIgnoreCase(country) && p.getPlayerName().equalsIgnoreCase(name)).findAny();
		Player player=pl.get();
		System.out.println(player);
		return player;
	}
	public static boolean checkHighScorerByCountry(String country){
		long result=players.stream().filter(f-> f.getCountry().getCountryName().equalsIgnoreCase(country) && f.getRuns()>10000).count();
		if(result>0){
			System.out.println(result +": Result matches your criteria");
			return true;
		}
		else{
			System.out.println("No Player matxches the condition");
			return false;	
		}

	}
	public static void main(String[] args) {
		System.out.println("***********************Name Of All Players*****************");
		displayPlayers();
		System.out.println("****************Players with Highest score more than 100 from given Country*****************");
		displayPlayersForCountry("India");
		System.out.println("****************Players with more than 5000 runs in descending order of name****************");
		getPlayerNames();
		System.out.println("****************Average Runs from a particular Country***************");
		getAverageRunsByCountry("India");
		System.out.println("***************Get Sorted Players Name**************************");
		getPlayerNamesSorted();
		System.out.println("***************Players who have played more than 200 matches**************************");
		getPlayerCountry();
		System.out.println("************* Maximum Score**************");
		getMaxRunsPlayer();
		System.out.println("************* Player from a particular country*************");
		findPlayer("sachin","India");
		System.out.println("************* Player from a particular country scoring more than 10000*************");
		checkHighScorerByCountry("Australia");
	}
}
