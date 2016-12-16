package com.sujithpaul.adventofcode2015.utilities;

public class StringHandler {

	public static int[] convertStringsArrayToIntsArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		return intArray;
	}

	public static String[] splitStringByAlternatingChars(String str) {
		StringBuilder oddChars = new StringBuilder();
		StringBuilder evenChars = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if ((i + 1) % 2 == 0) {
				evenChars.append(str.charAt(i));
			} else {
				oddChars.append(str.charAt(i));
			}
		}
		return new String[] { oddChars.toString(), evenChars.toString() };
	}

}
