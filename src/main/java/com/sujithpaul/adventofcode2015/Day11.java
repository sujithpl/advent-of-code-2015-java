package com.sujithpaul.adventofcode2015;

public class Day11 {

	public static String getNextValidPassword(String password) {
		do {
			password = incrementString(password);
		} while (!isValidPassword(password));
		return password;
	}

	private static boolean isValidPassword(String password) {
		return !password.matches("[iol]");
	}

	private static String incrementString(String password) {
		return "abc";
	}

	public static void main(String[] args) {
		System.out.println(getNextValidPassword("klm"));
	}

}
