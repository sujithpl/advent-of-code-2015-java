package com.sujithpaul.adventofcode2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;
import com.sujithpaul.adventofcode2015.utilities.ListHelper;

public class Day9 {

	private static Map<String, HashMap<String, Integer>> interCityMap = new HashMap<String, HashMap<String, Integer>>();

	private static void addCitiesToMap(String city1, String city2, int distance) {
		if (!interCityMap.containsKey(city1)) {
			interCityMap.put(city1, new HashMap<>());
		}
		interCityMap.get(city1).put(city2, distance);
	}

	private static int getDistanceBetweenCities(String city1, String city2) {
		return (int) interCityMap.get(city1).get(city2);
	}

	static BiFunction<String, String, Integer> k = (city1, city2) -> interCityMap.get(city1).get(city2);

	public static void main(String[] args) {
		InputProcessor.readFile("files/day9-input.txt") //
				.map(str -> str.split(" ")) //
				.forEach((str) -> {
					addCitiesToMap(str[0], str[2], Integer.parseInt(str[4]));
					addCitiesToMap(str[2], str[0], Integer.parseInt(str[4]));
				});
		List<String> cities = new ArrayList<String>(interCityMap.keySet());
		List<List<?>> pathThroughCities = ListHelper.getAllPermutations(cities);
		int minDist = Integer.MAX_VALUE;
		int maxDist = Integer.MIN_VALUE;
		for (List<?> aPath : pathThroughCities) {
			int dist = 0;
			for (int i = 0; i < aPath.size() - 1; i++) {
				dist += getDistanceBetweenCities(aPath.get(i).toString(), aPath.get(i + 1).toString());
			}
			if (dist < minDist)
				minDist = dist;
			if (dist > maxDist)
				maxDist = dist;
		}
		System.out.println(minDist);
		System.out.println(maxDist);
	}

}
