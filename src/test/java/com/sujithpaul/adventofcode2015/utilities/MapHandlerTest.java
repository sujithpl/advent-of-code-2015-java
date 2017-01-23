package com.sujithpaul.adventofcode2015.utilities;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapHandlerTest {

	@Test
	public void testCombineMap() {
		Map<String, Integer> mapA = new HashMap<String, Integer>();
		mapA.put("key 1", 1);
		mapA.put("key 2", -1);
		
		Map<String, Integer> mapB = new HashMap<String, Integer>();
		mapB.put("key 3", 1000);
		
		Map<?, ?> mapAB = MapHandler.combineMap(mapA, mapB);
		
		assertEquals(3, mapAB.size());
		assertEquals(1, mapAB.get("key 1"));
		assertEquals(-1, mapAB.get("key 2"));
		assertEquals(1000, mapAB.get("key 3"));
	}

}
