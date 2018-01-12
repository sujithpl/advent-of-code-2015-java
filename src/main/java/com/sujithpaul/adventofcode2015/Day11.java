package com.sujithpaul.adventofcode2015;

public class Day11 {

	public static String getNextValidPassword(String password) {
		do {
			password = incrementString(password);
		} while (!isValidPassword(password));
		return password;
	}

	private static boolean isValidPassword(String password) {
		return !password.matches(".*[iol].*");
	}

	private static String incrementString(String s) {
		int lastCharPosition = s.length() - 1;
		char lastChar = s.charAt(lastCharPosition);
		String subString = s.substring(0, lastCharPosition);
		String nextString = "";
		if (lastChar == 'z') {
			nextString = lastCharPosition == 0 ? "a" : incrementString(subString) + "a";
		} else {
			nextString = lastCharPosition == 0 ? String.valueOf((char) (lastChar + 1))
					: subString + (char) (lastChar + 1);
		}
		return nextString;
	}

	public static void main(String[] args) {
		System.out.println(getNextValidPassword("kkz"));
		System.out.println(getNextValidPassword("zz"));
	}

}
