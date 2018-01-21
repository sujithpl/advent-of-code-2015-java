package com.sujithpaul.adventofcode2015;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day12 {

	private static Pattern numberPattern = Pattern.compile("-?\\d+");

	public static int extractSumOfIntegers(String s) {
		int result = 0;
		Matcher numberMatcher = numberPattern.matcher(s);
		while (numberMatcher.find()) {
			result += Integer.valueOf(numberMatcher.group());
		}
		return result;
	}

	public static int addIntegersInJson(JsonNode node, int sum) {
		int result = sum;
		if (node.isInt())
			result += sum + node.asInt();
		if (node.isArray()) {
			for (JsonNode n : node) {
				result += addIntegersInJson(n, sum);
			}
		}
		if (node.isObject() && !objectHasRedAsValue(node)) {
			Iterator<JsonNode> it = node.elements();
			while (it.hasNext()) {
				JsonNode elem = it.next();
				result += addIntegersInJson(elem, sum);
			}
		}
		return result;
	}

	private static boolean objectHasRedAsValue(JsonNode node) {
		boolean result = false;
		Iterator<JsonNode> it = node.iterator();
		while (it.hasNext()) {
			if (it.next().asText().equals("red")) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int part1total = InputProcessor.readFile("files/day12-input.txt").mapToInt(s -> extractSumOfIntegers(s)).sum();
		System.out.println("Part 1 solution (using Regex): " + part1total);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode root = mapper.readTree(new File("src/main/resources/files/day12-input.txt"));
			System.out.println("Part 2 solution (using Jackson): " + addIntegersInJson(root, 0));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
