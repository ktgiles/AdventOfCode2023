package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalibrationValueService {
	
	private CalibrationValueService() {}

	public static void calibrate(String input) {
		List<String> split = lineSplit(input);
		List<String> numbers = yeetLetters(split);
		List<String> processing = process(numbers);
		int sum = sum(processing);
		System.out.println(sum);

	}

	private static List<String> lineSplit(String input) {
		return Arrays.asList(input.split("\\R"));
	}
	
	private static List<String> yeetLetters (List<String> split) {
		
		List<String> numbers = new ArrayList<>();
		
		for (String s : split) {
			s = s.replaceAll("[^\\d.]", "");
			numbers.add(s);
		}
		return numbers;
	}
	
	private static List<String> process(List<String> numbers) {
		List<String> processing = new ArrayList<>();
		for (String s : numbers) {
			String temp = s.substring(0,1);
			temp = temp + s.substring(s.length() - 1, s.length());
			processing.add(temp);
		}
		return processing;
	}
	
	private static int sum(List<String> processing) {
		int sum = 0; 
		for (String p : processing) {
			sum += Integer.valueOf(p);
		}
		return sum;
	}
}
