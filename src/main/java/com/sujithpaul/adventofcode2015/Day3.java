package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;

public class Day3 {

	private int currentXCoordinate = 0;
	private int currentYCoordinate = 0;
	private Map<String, Integer> giftHouses;

	public Day3(String instructions) {
		giftHouses = new HashMap<String, Integer>();
		giftHouses.put(buildCoordinates(0, 0), 1);
		instructions //
			.chars() //
			.forEach(direction -> insertNextHouse((char)direction));
	}
	
	private static String buildCoordinates(int x, int y){
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
	
	public String toString() {
		return giftHouses.toString();
	}

	public static void main(String[] args) {
		String instructions = "><^v"; //TODO
		
		Day3 obj = new Day3(instructions);		
		System.out.println(obj.getNumberOfHousesVisited());
		System.out.println(obj.toString());
		
	}

}
