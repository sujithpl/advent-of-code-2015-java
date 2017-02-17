package com.sujithpaul.adventofcode2015;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day7 {

	private static Map<String, String> circuit = new HashMap<>();

	private static void initCircuit() {
		circuit.clear();
		InputProcessor.readFile("files/day7-input.txt") //
				.map(str -> str.split(" -> ")) //
				.forEach(str -> setValue(str[1], str[0]));
	}

	protected static void setValue(String key, String instruction) {
		circuit.put(key, instruction);
	}

	private static int getValue(String arg) {
		int value = 0;
		if (arg.matches("\\d+")) {
			value = Integer.valueOf(arg);
		} else {
			value = processWiringInstruction(circuit.get(arg));
			circuit.put(arg, String.valueOf(value));
		}
		return value;
	}

	/*
	 * Converts 32 bit integer in two's complement notation to the equivalent 16
	 * bit short
	 */
	public static int getIntValue(String key) {
		return 0xffff & getValue(key);
	}

	static Function<String, Integer> notOperation = s -> (~getValue(s));

	static BiFunction<String, String, Integer> andOperation = (arg1, arg2) -> (getValue(arg1) & getValue(arg2));

	static BiFunction<String, String, Integer> orOperation = (arg1, arg2) -> (getValue(arg1) | getValue(arg2));

	static BiFunction<String, String, Integer> lShiftOperation = (arg1, arg2) -> (getValue(arg1) << getValue(arg2));

	static BiFunction<String, String, Integer> rShiftOperation = (arg1, arg2) -> (getValue(arg1) >> getValue(arg2));

	private static final Pattern singleArgumentInstructionPattern = Pattern.compile("(.+) (.+)");

	private static final Pattern doubleArgumentInstructionPattern = Pattern.compile("(.+) (.+) (.+)");

	public static int processWiringInstruction(String instruction) {
		Matcher matcher = doubleArgumentInstructionPattern.matcher(instruction);
		Matcher matcher1 = singleArgumentInstructionPattern.matcher(instruction);
		int result = 0;
		if (matcher.find()) {
			String arg1 = matcher.group(1);
			String operation = matcher.group(2);
			String arg2 = matcher.group(3);
			switch (operation) {
			case "AND":
				result = andOperation.apply(arg1, arg2);
				break;
			case "OR":
				result = orOperation.apply(arg1, arg2);
				break;
			case "LSHIFT":
				result = lShiftOperation.apply(arg1, arg2);
				break;
			case "RSHIFT":
				result = rShiftOperation.apply(arg1, arg2);
				break;
			default:
				break;
			}
		} else if (matcher1.find()) {
			String operation = matcher1.group(1);
			String arg1 = matcher1.group(2);
			if (operation.equals("NOT")) {
				result = notOperation.apply(arg1);
			}
		} else {
			String arg1 = instruction;
			result = getValue(arg1);
		}
		return result;
	}

	public static void main(String[] args) {
		initCircuit();
		int solution = getIntValue("a");
		System.out.println("Value of wire a (part 1): " + solution);
		initCircuit();
		circuit.put("b", String.valueOf(solution));
		System.out.println("Value of wire a (part 2): " + getIntValue("a"));
	}
}
