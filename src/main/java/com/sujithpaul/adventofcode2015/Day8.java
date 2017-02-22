package com.sujithpaul.adventofcode2015;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day8 {

	public static void main(String[] args) {
		int numberOfTextChars = InputProcessor.readFile("files/day8-input.txt") //
				.mapToInt(s -> s.length()) //
				.sum();
		System.out.println(numberOfTextChars);
		int numberOfInMemoryChars = InputProcessor.readFile("files/day8-input.txt") //
				.map(s -> s.replaceAll("^\"", "")) //
				.map(s -> s.replaceAll("\"$", "")) //
				.map(s -> s.replaceAll("\\\\", "@")) //
				.map(s -> s.replaceAll("@\\\"", "!")) //
				.map(s -> s.replaceAll("@@", "#")) //
				.map(s -> s.replaceAll("@x..", "%")) //
				.mapToInt(s -> s.length()) //
				.sum();
		System.out.println(numberOfInMemoryChars);
		System.out.println("Diff: " + (numberOfTextChars - numberOfInMemoryChars));
	}

}
