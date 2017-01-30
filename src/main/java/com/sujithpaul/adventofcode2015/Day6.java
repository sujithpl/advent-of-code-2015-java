package com.sujithpaul.adventofcode2015;

import java.util.function.Consumer;
import java.util.function.Function;

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

	public void resetAllLights() {
		for (int row = 0; row < numberOfRows; row++) {
			for (int col = 0; col < numberOfColumns; col++) {
				lightGrid[row][col] = 0;
			}
		}
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

	public void turnOnLights(int leftRow, int leftColumn, int rightRow, int rightColumn, Function<Integer, Integer> behavior) {
		for (int row = leftRow; row <= rightRow; row++) {
			for (int col = leftColumn; col <= rightColumn; col++) {
				lightGrid[row][col] = behavior.apply(lightGrid[row][col]);
			}
		}
	}

	public void turnOffLights(int leftRow, int leftColumn, int rightRow, int rightColumn) {
		for (int row = leftRow; row <= rightRow; row++) {
			for (int col = leftColumn; col <= rightColumn; col++) {
				lightGrid[row][col] = 0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day6 day6 = new Day6(1000,1000);
		
//		long numOfNiceStrings = InputProcessor.readFile("files/day6-input.txt")
//				.map(Day6::instructionConverter)
//				.forEach({
//					if(on)
//						day6.turnOnLights(x, y, x1, x2, value -> 1);
//					if(off)
//						day6.turnOnLights(x, y, x1, x2, value -> 0);
//					if(toggle)
//						day6.turnOnLights(x, y, x1, x2, value -> value==0?1:0);
//				})

	}

}
