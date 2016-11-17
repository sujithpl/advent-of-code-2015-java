package com.sujithpaul.adventofcode2015;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {

	private String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	public int finalFloorPosition(String str) {
		return str.chars().filter(ch -> ch == '(' || ch == ')').map(ch -> ch == '(' ? 1 : -1).sum();
	}

	public int basementEntryPoint(String str) {
		int floor = 0;
		int step = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				floor++;
			else if (str.charAt(i) == ')')
				floor--;
			if (floor == -1) {
				step = i + 1;
				break;
			}
		}
		return step;
	}

	public static void main(String[] args) {
		Day1 obj = new Day1();
		String floorInstructions = obj.getFile("files/day1-input.txt");
		System.out.println("Final floor position is " + obj.finalFloorPosition(floorInstructions));
		System.out.println("First time entering basement at step " + obj.basementEntryPoint(floorInstructions));
	}
}
