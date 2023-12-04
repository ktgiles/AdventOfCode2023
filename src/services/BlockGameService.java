package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlockGameService {
	
	private BlockGameService() {}
	
	public static void process(String values) {
		List<List<String>> split = lineSplit(values); // {Game Number, first result, second result, third result, etc}
		//I think I need another method here to take the List of Lists and make it something parseable like a 2d array or map/stream/something? 
		List<String> validGames = checkForCondition(split);
		System.out.println(split);
	}
	
	private static List<List<String>> lineSplit(String values) {	
		List<List<String>> listOfLists = new ArrayList<List<String>>(); 
		List<String> lineSplit =  Arrays.asList(values.split("\\R"));
		
		for (String s : lineSplit) {
			List<String> temp = new ArrayList<>();
			temp.add(s.substring(s.indexOf(":") - 1, s.indexOf(":"))); //first String in List is the game number 
			s = s.substring(s.indexOf(":") + 1);
			s = s.replaceAll(",", ""); //get rid of commas, so the only commas are separating lists (more readable console output for debugging) 
			for (String sub : s.split(";")) {
				temp.add(sub);
			}
			listOfLists.add(temp);
		}
		return listOfLists;
	}

	private static List<String> checkForCondition(List<List<String>> split) {
		List<String> validGames = new ArrayList<>();
		
		for (List<String> game : split) {
			//return only the game number for only the games where condition isn't violated
		}
		return null;
	}
}
