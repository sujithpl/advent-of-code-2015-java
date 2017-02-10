package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Day7 {

	private static Map<String, Integer> circuit = new HashMap<>();

	public static void setValue(String key, int value) {
		circuit.put(key, value);
	}

	public static int getValue(String key) {
		int value = 0;
		if (key.matches("\\d+")) {
			value = Integer.valueOf(key);
		} else {
			value = circuit.get(key);
		}
		return value;
	}

	static Function<String, Integer> notOperation = s -> (~getValue(s));

	static BiFunction<String, String, Integer> andOperation = (arg1, arg2) -> (getValue(arg1) & getValue(arg2));
	
	public static void main(String[] args) {
		Day7 obj = new Day7();
		obj.setValue("ab", 3);
		obj.setValue("de", 5);
		System.out.println(obj.getValue("ab"));
		System.out.println(obj.getValue("23"));
		System.out.println(notOperation.apply("ab"));
		System.out.println(andOperation.apply("ab", "de"));

	}

}
