package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.*;
import static com.sujithpaul.adventofcode2015.Day9.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

public class Day9Test {

	@BeforeClass
	public static void setUp() {
		interCityMap = new HashMap<String, HashMap<String,Integer>>();
		interCityMap.put("London", new HashMap<>());
		interCityMap.get("London").put("Dublin", 464);
		interCityMap.get("London").put("Belfast", 518);
		interCityMap.put("Dublin", new HashMap<>());
		interCityMap.get("Dublin").put("London", 464);
		interCityMap.get("Dublin").put("Belfast", 141);
		interCityMap.put("Belfast", new HashMap<>());
		interCityMap.get("Belfast").put("London", 518);
		interCityMap.get("Belfast").put("Dublin", 141);
	}

	@Test
	public void testGetShortestRouteLength() {
		assertEquals(605, getShortestRouteLength());
	}

	@Test
	public void testGetLongestRouteLength() {
		assertEquals(982, getLongestRouteLength());
	}

}
