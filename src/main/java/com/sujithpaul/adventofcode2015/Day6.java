package com.sujithpaul.adventofcode2015;

public class Day6 {

	private static int lightGrid[][];
	private static int numberOfRows;
	private static int numberOfColumns;

	public Day6(int rows, int cols) {
		numberOfRows = rows;
		numberOfColumns = cols;
		lightGrid = new int[numberOfRows][numberOfColumns];
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

	public void turnOnLights(int leftRow, int leftColumn, int rightRow, int rightColumn) {
		for (int row = leftRow; row <= rightRow; row++) {
			for (int col = leftColumn; col <= rightColumn; col++) {
				lightGrid[row][col] = 1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
