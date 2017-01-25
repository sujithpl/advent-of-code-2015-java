package com.sujithpaul.adventofcode2015;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {

	public static Predicate<String> containsDoubleLetters = (str) -> {
		Pattern pattern = Pattern.compile("(.)\\1");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	};

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("(.)\\1");
		Matcher matcher = pattern.matcher("haabcdehjkafeex");
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
		}
	}

}
