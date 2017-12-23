package com.sujithpaul.adventofcode2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;
import com.sujithpaul.adventofcode2015.utilities.ListHelper;

public class Day9 {

	protected static Map<String, HashMap<String, Integer>> interCityMap = new HashMap<String, HashMap<String, Integer>>();

	private static void addCitiesToMap(String city1, String city2, int distance) {
		if (!interCityMap.containsKey(city1)) {
			interCityMap.put(city1, new HashMap<>());
		}
		interCityMap.get(city1).put(city2, distance);
	}

	public static int getShortestRouteLength() {
		return getAllPossibleRouteLengths().stream().min(Integer::compare).get();
	}

	public static int getLongestRouteLength() {
		return getAllPossibleRouteLengths().stream().max(Integer::compare).get();
	}

	private static List<Integer> getAllPossibleRouteLengths() {
		List<String> cities = new ArrayList<String>(interCityMap.keySet());
		List<List<?>> allRoutesThroughTheCities = ListHelper.getAllPermutations(cities);
		List<Integer> allRouteLengths = getRouteLengths(allRoutesThroughTheCities);
		return allRouteLengths;
	}

	private static List<Integer> getRouteLengths(List<List<?>> allRoutes) {
		List<Integer> result = new ArrayList<>();
		for (List<?> aRoute : allRoutes) {
			int routeLength = 0;
			for (int i = 0; i < aRoute.size() - 1; i++) {
				routeLength += getDistanceBetweenCities(aRoute.get(i).toString(), aRoute.get(i + 1).toString());
			}
			result.add(routeLength);
		}
		return result;
	}

	private static int getDistanceBetweenCities(String city1, String city2) {
		return (int) interCityMap.get(city1).get(city2);
	}

	public static void main(String[] args) {

		InputProcessor.readFile("files/day9-input.txt") //
				.map(str -> str.split(" ")) //
				.forEach((str) -> {
					addCitiesToMap(str[0], str[2], Integer.parseInt(str[4]));
					addCitiesToMap(str[2], str[0], Integer.parseInt(str[4]));
				});

		System.out.println("Shortest Route Length (Part 1) is " + getShortestRouteLength());
		System.out.println("Longest Route Length (Part 2) is " + getLongestRouteLength());
	}

}
