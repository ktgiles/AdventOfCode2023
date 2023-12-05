package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BlockGameService {
	
	private BlockGameService() {}
	
	public static void process(String values) {
		List<String> split = gameSplit(values); // omit game number, place each game into list entry
		List<Integer> validGames = new ArrayList<>(); //this will hold valid games only
		Integer gameNumber = 1;		
		for (String s : split ) {
			if (gameIsValid(s)) {
				validGames.add(gameNumber);
			}
			gameNumber++;
		}
		int sum = sumValidGames(validGames);
		System.out.println(sum);
		
	}
	
	private static List<String> gameSplit(String values) {	
		List<String> lineSplit =  Arrays.asList(values.split("\\R")); // each game entry is now a String
		List<String> resultsOnly = new ArrayList<>();
		
		for (String s : lineSplit) {
			s = s.substring(s.indexOf(":") + 1);
			resultsOnly.add(s);	
		}
		return resultsOnly;
	}

	
	private static int sumValidGames(List<Integer> games) {
		int sum = 0;
		for (Integer gameNumber : games) {
			sum += gameNumber;
		}
		return sum;
	}
	
	//this may be dumb? (5:07)
	//I'm really starting to think this is dumb (5:36)
	//if it's stupid but it works it's not stupid (6:14) 
	//IT WORKED IT'S FINE (6:58)
	//this should really be broken into a mapping method and then a validation method but I'm dying here 
	private static boolean gameIsValid(String game) {
		//format of game entry : 
		 //5 red, 1 green; 6 red, 3 blue; 9 red; 1 blue, 1 green, 4 red; 1 green, 2 blue; 2 blue, 1 red
		Map<String, List<String>> map = new HashMap<>(); //this will hold key = color, List<String> = all quantities of that color
		
		for (String s : pullSplit(game)) { //for each pull of the game
			String[] splitforMap = s.trim().split(" "); //splitForMap[0] is Number and splitForMap[1] is color
			if (map.containsKey(splitforMap[1])) {
				map.get(splitforMap[1]).add(splitforMap[0]);
			}
			else {
				List<String> list = new ArrayList<>();
				list.add(splitforMap[0]);
				map.put(splitforMap[1], list);
			}
		}
		//now map holds color, list of all pull counts for that color 	
		//max pulls :  12 red cubes, 13 green cubes, and 14 blue cubes
	
		Iterator<Map.Entry<String, List<String>>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, List<String>> set = itr.next();
			switch (set.getKey()) {
			case "red" :
				for (String count: set.getValue()) {
					if (Integer.valueOf(count) > 12) {
						return false;
					}
				}
				break;
			case "green" : 
				for (String count: set.getValue()) {
					if (Integer.valueOf(count) > 13) {
						return false;
					}
				}
				break;
			case "blue" :
				for (String count: set.getValue()) {
					if (Integer.valueOf(count) > 14) {
						return false;
					}
				}	
				break;
			}
		}
		return true;
	}
	
	private static String[] pullSplit(String game) { 
		String g = game.replaceAll(";", ","); //so we can split on the comma
		return g.split(","); //now each String holds "X color" ie "5 red"  (aka one "pull") 	
	}

}
