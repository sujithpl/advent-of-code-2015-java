package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	/*
	 * Converts 32 bit integer in two's complement notation to the equivalent 16
	 * bit short
	 */
	public static int getIntValue(String key) {
		return 0xffff & circuit.get(key);
	}

	static Function<String, Integer> notOperation = s -> (~getValue(s));

	static BiFunction<String, String, Integer> andOperation = (arg1, arg2) -> (getValue(arg1) & getValue(arg2));

	static BiFunction<String, String, Integer> orOperation = (arg1, arg2) -> (getValue(arg1) | getValue(arg2));

	static BiFunction<String, String, Integer> lShiftOperation = (arg1, arg2) -> (getValue(arg1) << getValue(arg2));

	static BiFunction<String, String, Integer> rShiftOperation = (arg1, arg2) -> (getValue(arg1) << getValue(arg2));

	private static final Pattern assignmentInstructionPattern = Pattern.compile("(.+) -> (.+)");

	private static final Pattern singleArgumentInstructionPattern = Pattern.compile("(.+) (.+) -> (.+)");

	private static final Pattern doubleArgumentInstructionPattern = Pattern.compile("(.+) (.+) (.+) -> (.+)");

	public static void processWiringInstruction(String instruction) {
		Matcher matcher = doubleArgumentInstructionPattern.matcher(instruction);
		if (matcher.find()) {
			String arg1 = matcher.group(1);
			String operation = matcher.group(2);
			String arg2 = matcher.group(3);
			String arg3 = matcher.group(4);
			switch (operation) {
			case "AND":
				setValue(arg3, andOperation.apply(arg1, arg2));
				break;
			case "OR":
				setValue(arg3, orOperation.apply(arg1, arg2));
				break;
			case "LSHIFT":
				setValue(arg3, lShiftOperation.apply(arg1, arg2));
				break;
			case "RSHIFT":
				setValue(arg3, rShiftOperation.apply(arg1, arg2));
				break;
			default:
				break;
			}
			return;
		}

		Matcher matcher1 = singleArgumentInstructionPattern.matcher(instruction);
		if (matcher1.find()) {
			String operation = matcher.group(1);
			String arg1 = matcher.group(2);
			String arg2 = matcher.group(3);
			if (operation.equals("NOT")) {
				setValue(arg2, notOperation.apply(arg1));
			}
			return;
		}

		Matcher matcher2 = assignmentInstructionPattern.matcher(instruction);
		if (matcher2.find()) {
			String arg1 = matcher.group(1);
			String arg2 = matcher.group(2);
			setValue(arg2, getValue(arg1));
			return;
		}
	}

	public static void main(String[] args) {
		// Day7 obj = new Day7();
		Day7.setValue("ab", 3);
		Day7.setValue("de", 5);
		System.out.println(Day7.getValue("ab"));
		System.out.println(Day7.getValue("23"));
		System.out.println(0xffff & notOperation.apply("ab"));
		System.out.println(0xffff & andOperation.apply("ab", "de"));

	}

}
