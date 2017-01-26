package com.sujithpaul.adventofcode2015;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day5 {

	public static Predicate<String> containsAtLeastThreeVowels = (str) -> {
		Pattern pattern = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");
		Matcher matcher = pattern.matcher(str);
		return (matcher.find());
	};

	public static Predicate<String> containsDoubleLetters = (str) -> {
		Pattern pattern = Pattern.compile("(.)\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	};

	public static Predicate<String> doesNotContainAbCdPqXy = (str) -> {
		Pattern pattern = Pattern.compile("(ab|cd|pq|xy)");
		Matcher matcher = pattern.matcher(str);
		return !(matcher.find());
	};

	public static void main(String[] args) {
		long numOfNiceStrings = InputProcessor.readFile("files/day5-input.txt") //
				.filter(containsAtLeastThreeVowels) //
				.filter(containsDoubleLetters) //
				.filter(doesNotContainAbCdPqXy) //
				.count();
		System.out.println("Number of nice strings according to part 1 rules: " + numOfNiceStrings);
	}

}
