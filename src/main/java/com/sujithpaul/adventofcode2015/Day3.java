package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;

public class Day3 {

	private int currentXCoordinate = 0;
	private int currentYCoordinate = 0;
	private Map<String, Integer> giftHouses = new HashMap<String, Integer>();

	public static String buildCoordinates(int x, int y){
		return String.valueOf(x) + ":" + String.valueOf(y);
	}
	
	public void insertNextHouse(char ch) {
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
		
		if (giftHouses.containsKey(coordinates)) {
			giftHouses.put(coordinates, giftHouses.get(coordinates) + 1);
		} else {
			giftHouses.put(coordinates, 1);
		}
	}

	public static void main(String[] args) {
		Day3 obj = new Day3();
		obj.giftHouses.put(buildCoordinates(0, 0), 1);
		obj.insertNextHouse('>');
		obj.insertNextHouse('<');
		obj.insertNextHouse('^');
		obj.insertNextHouse('v');
		System.out.println(obj.giftHouses.size());
		System.out.println(obj.giftHouses.toString());
	}

}
