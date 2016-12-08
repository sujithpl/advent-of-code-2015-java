package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day3 {

	private int currentXCoordinate = 0;
	private int currentYCoordinate = 0;
	private Map<String, Integer> giftHouses;

	public Day3(String instructions) {
		giftHouses = new HashMap<String, Integer>();
		giftHouses.put(buildCoordinates(0, 0), 1);
		instructions //
				.chars() //
				.forEach(direction -> insertNextHouse((char) direction));
	}

	private static String buildCoordinates(int x, int y) {
		return String.valueOf(x) + ":" + String.valueOf(y);
	}

	private void insertNextHouse(char ch) {
		switch (ch) {
		case '>':
			currentXCoordinate += 1;
			break;
		case '<':
			currentXCoordinate -= 1;
			break;
		case '^':
			currentYCoordinate += 1;
			break;
		case 'v':
			currentYCoordinate -= 1;
			break;
		}

		String coordinates = buildCoordinates(currentXCoordinate, currentYCoordinate);

		Integer currentGiftCount = giftHouses.containsKey(coordinates) ? giftHouses.get(coordinates) : 0;
		giftHouses.put(coordinates, currentGiftCount + 1);
	}

	public int getNumberOfHousesVisited() {
		return giftHouses.size();
	}

	public Map<String, Integer> getGiftHouses() {
		return giftHouses;
	}

	public static void main(String[] args) {
		String instructions = InputProcessor.readFile("files/day3-input.txt") //
				.collect(Collectors.joining());

		Day3 obj = new Day3(instructions);
		System.out.println("Number of Houses with at least one gift (Santa only): " + obj.getNumberOfHousesVisited());
		// System.out.println(obj.toString());

		int[] c = { 0 };

		String ins = instructions //
				.codePoints()
				// .parallel() // uncomment this line for large strings
				.filter(x -> c[0]++ % 2 == 0)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
//System.out.println(ins);
		Day3 obj1 = new Day3(ins);

		int[] d = { 0 };

		String inst = instructions //
				.codePoints()
				// .parallel() // uncomment this line for large strings
				.filter(x -> d[0]++ % 2 != 0)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
//		System.out.println(inst);


		Day3 obj2 = new Day3(inst);

		System.out.println("Number of Houses with at least one gift (Santa only): " + obj1.getNumberOfHousesVisited());
		System.out.println("Number of Houses with at least one gift (Santa only): " + obj2.getNumberOfHousesVisited());
		obj1.getGiftHouses().putAll(obj2.getGiftHouses());
		System.out.println(obj1.getGiftHouses().size());

	}

}
