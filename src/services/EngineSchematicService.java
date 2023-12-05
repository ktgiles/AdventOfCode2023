package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

//ok this doesn't work at all but you can see what I was going for 
//I feel like there are 298479283 better ways to do this and I'm not sure it's worth my time to debug this solution 
//I think this a prime example of "I need a decent lead dev to help me think about things programmatically" 
//because boy is this just not it 

public class EngineSchematicService {
//we may need to find a way for things to not be counted twice (if they are connected to more than 1 symbol

	private EngineSchematicService () {}
	
	//this method is also too long and I also hate it
	public static void getPartNumberSum(String schematic) {
		int lineNumber = 0;
		int sum = 0;
		List<String> lineSplit = lineSplit(schematic);
		List<char[]> charSplit = charSplit(lineSplit);
		for (char[] line : charSplit) { //for every line 
			int charIndex = 0;
			for (char c : line) {		//for every char 
				if (isSymbol(c)) { //if symbol
						// for every symbol we need to check above line, same line, below line
					if (lineNumber > 0 && lineNumber < lineSplit.size() -1) { //not first line, not last line			
//						char[] line = charSplit.get(lineNumber - 1); //get above line
						for (int l = lineNumber - 1; l < lineNumber + 2; l++) { //for above, same, and below : 
							if (charIndex == 0) { //if  first char in char[]
								sum += sumFirstChar(charSplit.get(l), charIndex);
							} else if (charIndex == (charSplit.get(l).length - 1)){
								sum += sumLastChar(charSplit.get(l), charIndex);
							} else {
								sum += sumChar(charSplit.get(l), charIndex); 
							}
						}//end for 3 lines loop
					//end if lineNumber > 0 loop 
					} else if (lineNumber == 0) { //first line, only process line and below
						for (int l = lineNumber; l < lineNumber + 2; l++) { //for same, and below : 
							if (charIndex == 0) { //if  first char in char[]
								sum += sumFirstChar(charSplit.get(l), charIndex);
							} else if (charIndex == (charSplit.get(l).length - 1)){
								sum += sumLastChar(charSplit.get(l), charIndex);
							} else {
								sum += sumChar(charSplit.get(l), charIndex); 
							}
						}//end for 2 lines loop
					} else {//last line, only process line and above
						for (int l = lineNumber - 1; l < lineNumber + 1; l++) { //for same, and below : 
							if (charIndex == 0) { //if  first char in char[]
								sum += sumFirstChar(charSplit.get(l), charIndex);
							} else if (charIndex == (charSplit.get(l).length - 1)){
								sum += sumLastChar(charSplit.get(l), charIndex);
							} else {
								sum += sumChar(charSplit.get(l), charIndex); 
							}
						}//end for 2 lines loop
					}				
				}//end if char is symbol loop
				charIndex++;
			} //end for every char loop
			lineNumber++;
		}//end for every line loop 
		System.out.println(sum);
	}
	
	private static int sumFirstChar(char[] line, int charIndex) {
		int sum = 0;
		if (isNumber(line[charIndex + 1]) ) {
			if (isNumber(line[charIndex])) {
				if (isNumber(line[charIndex + 2])) {
					//save 0, +1, +2
					sum += compileChars(ArrayUtils.subarray(line, charIndex, charIndex + 2));
				} else {
					//save 0, +1
					sum += compileChars(ArrayUtils.subarray(line, charIndex, charIndex + 1));
				}
			} else {
				if (isNumber(line[charIndex + 3])) {
					//save +1, +2, +3
					sum += compileChars(ArrayUtils.subarray(line, charIndex + 1, charIndex + 3));
				} else {
					//save +1, +2
					sum += compileChars(ArrayUtils.subarray(line, charIndex + 1, charIndex + 2));

				}
			}
		}
		return sum;
	}

	private static int sumLastChar (char[] line, int charIndex) {
		int sum = 0;
		if(isNumber(line[charIndex - 1]) &&  (isNumber(line[charIndex -2]))) {
				if (isNumber(line[charIndex - 3])) {
					//save -3, -2, -1
					sum += compileChars(ArrayUtils.subarray(line, charIndex - 3, charIndex - 1));
				} else {
					if (isNumber(line[charIndex])) {
						//save -2, -1, 0
						sum += compileChars(ArrayUtils.subarray(line, charIndex - 2, charIndex));
					} else {
						//save -2, -1
						sum += compileChars(ArrayUtils.subarray(line, charIndex - 2, charIndex - 1));
					}
				}
		}
		return sum;
	}
	
	//this method is too long and I hate it
	private static int sumChar (char[] line, int charIndex) {
		int sum = 0;
		if(isNumber(line[charIndex - 1])) {
			if (isNumber(line[charIndex -2])) {
				if (isNumber(line[charIndex - 3])) {
					//save -3, -2, -1
					sum += compileChars(ArrayUtils.subarray(line, charIndex - 3, charIndex - 1));
				} else {
					if (isNumber(line[charIndex])) {
						//save -2, -1, 0
						sum += compileChars(ArrayUtils.subarray(line, charIndex - 2, charIndex));
					} else {
						//save -2, -1
						sum += compileChars(ArrayUtils.subarray(line, charIndex - 2, charIndex - 1));
					}
				}
			} else {
				if (isNumber(line[charIndex + 1])) {
					//save -1, 0, +1 
					sum += compileChars(ArrayUtils.subarray(line, charIndex - 1, charIndex + 1));

				} else {
					//save -1, 0
					sum += compileChars(ArrayUtils.subarray(line, charIndex - 1, charIndex));
				}
			}
			
		} else if (isNumber(line[charIndex + 1]) ) {
			if (isNumber(line[charIndex])) {
				if (isNumber(line[charIndex + 2])) {
					//save 0, +1, +2
					sum += compileChars(ArrayUtils.subarray(line, charIndex, charIndex + 2));
				} else {
					//save 0, +1
					sum += compileChars(ArrayUtils.subarray(line, charIndex, charIndex + 1));
				}
			} else {
				if (isNumber(line[charIndex + 3])) {
					//save +1, +2, +3
					sum += compileChars(ArrayUtils.subarray(line, charIndex + 1, charIndex + 3));
				} else {
					//save +1, +2
					sum += compileChars(ArrayUtils.subarray(line, charIndex + 1, charIndex + 2));
				}
			}
		}
		// return sum of saved numbers
		return sum;
	}
	
	private static int compileChars(char[] c) {
		String s = new String(c);
		return Integer.parseInt(s);
	}
	
	private static List<String> lineSplit(String input) {
		return Arrays.asList(input.split("\\R"));
	}
	
	private static List<char[]> charSplit(List<String> lines) {
		List<char[]> charSplit = new ArrayList<>();
		for (String line : lines) {
			charSplit.add(line.toCharArray());
		}
		return charSplit;
	}
	
	private static boolean isSymbol(char c) {
		return String.valueOf(c).matches("[^A-Za-z0-9.]");
	}
	
	private static boolean isNumber(int c) {
		return String.valueOf(c).matches("\\d");
	}

	
}
