package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScratchCardService {
	
	private ScratchCardService() {}
	
	public static void getWinners(String scratchCards) {
		Integer points = 0;
		List<String> cards = lineSplit(scratchCards);
		for (String card : cards) {
			Integer cardPoints = 0;
			boolean first = true; 
			List<String> matches = getMatches(card);
			for (String win : matches) {
				if (!win.isBlank() || !win.isEmpty() ) {
					if (first) {
						cardPoints = 1;
						first = false;
					} else {
						cardPoints = cardPoints * 2;
					}
				} 
			}
			points += cardPoints;		
		}
		System.out.println(points);
	}
	
	//alright, this is a mess
	//I don't think things are resetting properly between rounds of recursion hellscape 
	//also it's recursion hellscape
	//again, I think the concepts here would work if I had unlimited time to fuck about with it but 
	//I don't (: 
	//maybe next year? 
	//I'm leaving in all the sysouts and the unused variables because they are for local debugging and I may pick this up again after Christmas
	//if you're reading this because I shared my git on my resume, I know it takes a dump on best practices but I'm trying here
	public static void getCardCount(String scratchCards) {
		int sum = 0;
		Integer cardNumber = 1; 
		Map<Integer, Integer> map = new HashMap<>(); //key card number, value duplicate count
		for (int i = 1; i < 101; i ++) {
			map.put(i, 1);
		}
		List<String> cards = lineSplit(scratchCards); 
		for (String card : cards) {
			List<String> matches = getMatches(card); //matches can contain empty/space only strings and that's a problem
			int size = matches.size();
			int cardCount = map.get(cardNumber);
				for (int m = 1; m < map.get(cardNumber) + 1; m++) { //this recursion is a mess and that's a problem
					System.out.println("starting processing card : " + cardNumber);
					System.out.println("which has : " + map.get(cardNumber) + " duplicates");
					int nextCardNumber = cardNumber + 1;
					for (int k = 1; k < matches.size() + 1; k++) { //loop as many times as there are matches
						map.merge(nextCardNumber, 1, Integer::sum);
						nextCardNumber++;
					}
				}
				System.out.println("finished processing card : " + cardNumber);
				System.out.println("map count is " +  map.size());
			cardNumber++;
		}
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			sum += entry.getValue();	
		}
		System.out.println(sum);
	}
	
	public static List<String> getMatches(String card) {
		card = card.substring(9).trim(); //get rid of card number, semicolon, leading whitespace
		String[] cardSplit = card.split("\\|");
		List<String> winners = Arrays.asList(cardSplit[0].split(" "));
		List<String> scratches = Arrays.asList(cardSplit[1].split(" "));
		List<String> matches = new ArrayList<>(scratches);
		matches.retainAll(winners);
		return matches;
		
	}
	
	private static List<String> lineSplit(String input) {
		return Arrays.asList(input.split("\\R"));
	}

}
