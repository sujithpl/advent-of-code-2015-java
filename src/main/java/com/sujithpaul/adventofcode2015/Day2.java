package com.sujithpaul.adventofcode2015;

import java.util.Arrays;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day2 {

	public static int areaOfWrappingPaper(int[] sides) {
		int area1 = sides[0] * sides[1];
		int area2 = sides[1] * sides[2];
		int area3 = sides[2] * sides[0];
		int minArea = Math.min(area1, Math.min(area2, area3));
		return minArea + 2 * (area1 + area2 + area3);
	}

	public static int lengthOfRibbon(int[] sides) {
		Arrays.sort(sides);
		int wrapLength = 2 * (sides[0] + sides[1]);
		int bowLength = sides[0] * sides[1] * sides[2];
		return wrapLength + bowLength;
	}

	public static void main(String[] args) {
		int sqftOfWrappingPaper = InputProcessor.readFile("day2-input.txt").map(s -> s.split("x"))
				.map(InputProcessor::convertStringsArrayToIntsArray).map(Day2::areaOfWrappingPaper)
				.mapToInt(Integer::intValue).sum();
		System.out.println("Total square feet of wrapping paper: " + sqftOfWrappingPaper);
		int feetOfRibbon = InputProcessor.readFile("day2-input.txt").map(s -> s.split("x"))
				.map(InputProcessor::convertStringsArrayToIntsArray).map(Day2::lengthOfRibbon)
				.mapToInt(Integer::intValue).sum();
		System.out.println("Total feet of wrapping paper: " + feetOfRibbon);
	}

}
