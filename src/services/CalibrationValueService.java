package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalibrationValueService {
	
	private CalibrationValueService() {}
	
	public static Map <String, String> conversion = new HashMap<String, String>()
	{
		{
			put("one", "one1one");
			put("two", "two2two");
			put("three", "three3three");
			put("four", "four4four");
			put("five", "five5five");
			put("six", "six6six");
			put("seven", "seven7seven");
			put("eight", "eight8eight");
			put("nine", "nine9nine");
		}
	};
	//credit to r/fquiver for this solution 
	//my attempt identical but I used "1one, 2two" etc - I didn't think to surround the new digit with it's former string
	
	/*
	I feel like this solution is a really good example of "if it's stupid but it works it's not stupid" 
	If I had time I'd replace with something like : 
	break line array :
	9 o n e i g h t 

	for each character : 
	if digit, keep as digit move on 
	if o, look ahead two more spaces and if that makes a "one", replace that o with 1 (if not, leave it alone and move on) 
	9 1 n e i g h t 
	if t, look ahead two more spaces and if that makes a "two", replace t with 2 (if not, leave it alone and move on)
	etc, etc, etc, 
	for future revisiting, the correct output is : 54916  // 54728
	 */
		
	public static void calibrate(String input) {
		List<String> split = lineSplit(input);
		List<String> numbers = yeetLetters(split);
		List<String> processing = process(numbers);
		int sum = sum(processing);
		System.out.println(sum);

	}
	
	public static void recalibrate(String input) {
		List<String> split = lineSplit(input);
		List<String> converted = convertDigits(split);
		List<String> numbers = yeetLetters(converted);
		List<String> processing = process(numbers);
		int sum = sum(processing);
		System.out.println(sum);
	}

	private static List<String> convertDigits(List<String> split) {
		List<String> converted = new ArrayList<>();
		
		for (String s : split) {
			for (Map.Entry<String, String> entry : conversion.entrySet()) {
				s = s.replaceAll(entry.getKey(), entry.getValue() + entry.getKey());
			}
			converted.add(s);
		}
		return converted;
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
