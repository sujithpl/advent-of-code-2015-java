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

	public static Predicate<String> containsRepeatingLetters = (str) -> {
		Pattern pattern = Pattern.compile("(.)\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	};

	public static Predicate<String> doesNotContainAbCdPqXy = (str) -> {
		Pattern pattern = Pattern.compile("(ab|cd|pq|xy)");
		Matcher matcher = pattern.matcher(str);
		return !(matcher.find());
	};

	public static Predicate<String> niceStringPart1Rules = (str) -> {
		return containsAtLeastThreeVowels.test(str) && containsRepeatingLetters.test(str) && doesNotContainAbCdPqXy.test(str);
	};

	public static Predicate<String> containsRepeatingPairOfLetters = (str) -> {
		Pattern pattern = Pattern.compile("((.)(.)).*\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	};

	public static Predicate<String> containsRepeatingLettersWithAnotherInBetween = (str) -> {
		Pattern pattern = Pattern.compile("(.).\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	};

	public static Predicate<String> niceStringPart2Rules = (str) -> {
		return containsRepeatingPairOfLetters.test(str) && containsRepeatingLettersWithAnotherInBetween.test(str);
	};

	public static void main(String[] args) {
		long numOfNiceStrings = InputProcessor.readFile("files/day5-input.txt") //
				.filter(niceStringPart1Rules) //
				.count();
		System.out.println("Number of nice strings according to part 1 rules: " + numOfNiceStrings);
		
		long numOfActualNiceStrings = InputProcessor.readFile("files/day5-input.txt") //
				.filter(niceStringPart2Rules) //
				.count();
		System.out.println("Number of nice strings according to part 2 rules: " + numOfActualNiceStrings);
		
	}

}
