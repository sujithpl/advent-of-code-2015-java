package com.sujithpaul.adventofcode2015;

public class Day2 {

	public int areaOfWrappingPaper(int side1, int side2, int side3) {
		int area1 = side1 * side2;
		int area2 = side2 * side3;
		int area3 = side3 * side1;
		int minArea = Math.min(area1, Math.min(area2, area3));
		return minArea + 2 * (area1 + area2 + area3);
	}

	public static void main(String[] args) {
		Day2 obj = new Day2();
		System.out.println(obj.areaOfWrappingPaper(2, 3, 4));
		System.out.println(obj.areaOfWrappingPaper(1, 1, 10));
	}

}
