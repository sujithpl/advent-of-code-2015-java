package com.sujithpaul.adventofcode2015;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day6 {

	private static Integer lightGrid[][];
	private static int numberOfRows;
	private static int numberOfColumns;

	public Day6(int rows, int cols) {
		numberOfRows = rows;
		numberOfColumns = cols;
		lightGrid = new Integer[numberOfRows][numberOfColumns];
		this.resetAllLights();
	}

	public void operateSetOfLights(int leftRow, int leftColumn, int rightRow, int rightColumn,
			Function<Integer, Integer> operation) {
		for (int row = leftRow; row <= rightRow; row++) {
			for (int col = leftColumn; col <= rightColumn; col++) {
				lightGrid[row][col] = operation.apply(lightGrid[row][col]);
			}
		}
	}

	private static Function<Integer, Integer> turnOff = i -> 0;

	private static Function<Integer, Integer> turnOn = i -> 1;

	private static Function<Integer, Integer> toggle = i -> i == 1 ? 0 : 1;

	public void turnOnLights(int leftRow, int leftColumn, int rightRow, int rightColumn) {
		this.operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, turnOn);
	}

	public void turnOffLights(int leftRow, int leftColumn, int rightRow, int rightColumn) {
		this.operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, turnOff);
	}

	public void toggleLights(int leftRow, int leftColumn, int rightRow, int rightColumn) {
		this.operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, toggle);
	}

	public void resetAllLights() {
		this.operateSetOfLights(0, 0, numberOfRows - 1, numberOfColumns - 1, turnOff);
	}

	public int countNumberOfLitLights() {
		int numOfLitLights = 0;
		for (int row = 0; row < numberOfRows; row++) {
			for (int col = 0; col < numberOfColumns; col++) {
				if (lightGrid[row][col] == 1) {
					numOfLitLights++;
				}
			}
		}
		return numOfLitLights;
	}

	private static final Pattern lightingInstructionPattern = Pattern
			.compile("(.+) (\\d+),(\\d+) through (\\d+),(\\d+)");

	public void processLightingInstruction(String instruction) {
		Matcher matcher = lightingInstructionPattern.matcher(instruction);
		if (matcher.find()) {
			String operation = matcher.group(1);
			int leftRow = Integer.parseInt(matcher.group(2));
			int leftColumn = Integer.parseInt(matcher.group(3));
			int rightRow = Integer.parseInt(matcher.group(4));
			int rightColumn = Integer.parseInt(matcher.group(5));

			switch (operation) {
			case "turn on":
				turnOnLights(leftRow, leftColumn, rightRow, rightColumn);
				break;
			case "turn off":
				turnOffLights(leftRow, leftColumn, rightRow, rightColumn);
				break;
			case "toggle":
				toggleLights(leftRow, leftColumn, rightRow, rightColumn);
				break;
			default:
				break;
			}
		}
	}

	private static Function<Integer, Integer> turnUp = i -> ++i;

	private static Function<Integer, Integer> turnDown = i -> i == 0 ? 0 : --i;

	private static Function<Integer, Integer> turnUpTwice = i -> i += 2;

	public void processLightingInstructionPartTwo(String instruction) {
		Matcher matcher = lightingInstructionPattern.matcher(instruction);
		if (matcher.find()) {
			String operation = matcher.group(1);
			int leftRow = Integer.parseInt(matcher.group(2));
			int leftColumn = Integer.parseInt(matcher.group(3));
			int rightRow = Integer.parseInt(matcher.group(4));
			int rightColumn = Integer.parseInt(matcher.group(5));

			switch (operation) {
			case "turn on":
				operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, turnUp);
				break;
			case "turn off":
				operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, turnDown);
				break;
			case "toggle":
				operateSetOfLights(leftRow, leftColumn, rightRow, rightColumn, turnUpTwice);
				break;
			default:
				break;
			}

		}
	}

	public int calculateTotalValueOfLights() {
		int value = 0;
		for (int row = 0; row < numberOfRows; row++) {
			for (int col = 0; col < numberOfColumns; col++) {
					value += lightGrid[row][col];
			}
		}
		return value;
	}

	public static void main(String[] args) {
		Day6 day6 = new Day6(1000, 1000);
		InputProcessor.readFile("files/day6-input.txt").forEach(str -> day6.processLightingInstruction(str));
		System.out.println("Number of lit lights according to part 1 rules: " + day6.calculateTotalValueOfLights());
		day6.resetAllLights();
		InputProcessor.readFile("files/day6-input.txt").forEach(str -> day6.processLightingInstructionPartTwo(str));
		System.out.println("Total Brightness of lights according to part 2 rules: " + day6.calculateTotalValueOfLights());
	}

}
