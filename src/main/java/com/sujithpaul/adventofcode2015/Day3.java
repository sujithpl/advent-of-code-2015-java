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

		Day3 allSanta = new Day3(instructions);
		System.out.println("Number of Houses with at least one gift (All Santa): " + allSanta.getNumberOfHousesVisited());

		String[] splitInstructions = InputProcessor.splitStringByAlternatingChars(instructions);
		Day3 onlySanta = new Day3(splitInstructions[0]);
		Day3 onlyRoboSanta = new Day3(splitInstructions[1]);

		System.out.println("Number of Houses with at least one gift (Santa only): " + onlySanta.getNumberOfHousesVisited());
		System.out.println(
				"Number of Houses with at least one gift (Robo-Santa only): " + onlyRoboSanta.getNumberOfHousesVisited());

		Map<String, Integer> combinedGiftHouses = onlySanta.getGiftHouses();
		combinedGiftHouses.putAll(onlyRoboSanta.getGiftHouses());
		System.out
				.println("Number of Houses with at least one gift (Santa + Robo-Santa): " + combinedGiftHouses.size());

	}

}
