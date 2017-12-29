package com.sujithpaul.adventofcode2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {

	public static String getSequenceAfterRepetitions(String inString, int numRepetitions) {
		for (int i = 0; i < numRepetitions; i++) {
			inString = getNextSequence(inString);
		}
		return inString;
	}

	private static String getNextSequence(String inputString) {
		StringBuilder newString = new StringBuilder();
		Pattern pattern = Pattern.compile("(\\d)\\1*");
		Matcher matcher = pattern.matcher(inputString);
		while (matcher.find()) {
			newString.append(matcher.group().length());
			newString.append(matcher.group().charAt(0));
		}
		return newString.toString();
	}

	// First attempt - Imperative approach without using Regex
	//
	// private static String getNextSequence(String inputString) {
	// StringBuilder newString = new StringBuilder();
	// char currentChar = inputString.charAt(0);
	// int currentCharCount = 0;
	// for (int i = 0; i < inputString.length(); i++) {
	// if (inputString.charAt(i) != currentChar) {
	// newString.append(currentCharCount);
	// newString.append(currentChar);
	// currentChar = inputString.charAt(i);
	// currentCharCount = 1;
	// } else {
	// currentCharCount++;
	// }
	// }
	// newString.append(currentCharCount);
	// newString.append(currentChar);
	// return newString.toString();
	// }

	public static void main(String[] args) {
		String sequenceString = "1113122113";
		System.out.println("Length of sequence after 40 repetitions (Part 1): "
				+ getSequenceAfterRepetitions(sequenceString, 40).length());
		System.out.println("Length of sequence after 50 repetitions (Part 2): "
				+ getSequenceAfterRepetitions(sequenceString, 50).length());
	}

}
