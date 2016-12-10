package com.sujithpaul.adventofcode2015.utilities;

import java.util.Map;

public class MapHandler {
	public static Map<String, Integer> combineMap(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> combinedMap = map1;
		combinedMap.putAll(map2);
		return combinedMap;
	}

}
