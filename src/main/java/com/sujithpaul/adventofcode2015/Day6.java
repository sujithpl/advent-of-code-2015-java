package com.sujithpaul.adventofcode2015;

import java.util.function.Function;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day6 day6 = new Day6(1000, 1000);

		// long numOfNiceStrings =
		// InputProcessor.readFile("files/day6-input.txt")
		// .map(Day6::instructionConverter)
		// .forEach({
		// if(on)
		// day6.turnOnLights(x, y, x1, x2, value -> 1);
		// if(off)
		// day6.turnOnLights(x, y, x1, x2, value -> 0);
		// if(toggle)
		// day6.turnOnLights(x, y, x1, x2, value -> value==0?1:0);
		// })

	}

}
