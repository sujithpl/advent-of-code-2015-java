package com.sujithpaul.adventofcode2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day12 {

	private static Pattern numberPattern = Pattern.compile("-?\\d+");
	private static Pattern redObjectPattern = Pattern.compile("\\{.*:\"red\".*\\}");

	private static int extractSumOfIntegers(String s) {
		int result = 0;
		Matcher numberMatcher = numberPattern.matcher(s);
		while (numberMatcher.find()) {
			result += Integer.valueOf(numberMatcher.group());
		}
		return result;
	}
	
	private static String removeRedObjects(String s){
		return redObjectPattern.matcher(s).replaceAll("");
	}

	public static void main(String[] args) {
		int part1total = InputProcessor.readFile("files/day12-input.txt").mapToInt(s -> extractSumOfIntegers(s)).sum();
		System.out.println("Part 1 solution: " + part1total);
//		int part2total = InputProcessor.readFile("files/day12-input.txt").map(s->removeRedObjects(s)).mapToInt(s -> extractSumOfIntegers(s)).sum();
//		System.out.println("Part 2 solution: " + part2total);
		System.out.println(removeRedObjects("[1,{\"c\":\"red\",\"b\":2},3]"));
		System.out.println(removeRedObjects("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"));
		System.out.println(removeRedObjects("{\"a\":{\"b\":4},\"c\":-1}"));
	}

}
