package com.sujithpaul.adventofcode2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day11 {

	private static Pattern p1 = Pattern.compile("[iol]");
	private static Pattern p2 = Pattern
			.compile("(abc|bcd|cde|def|efg|fgh|ghi|hij|ijk|jkl|klm|lmn|mno|nop|opq|pqr|qrs|rst|tuv|uvw|vwx|wxy|xyz)");
	private static Pattern p3 = Pattern.compile("(.)\\1.*(.)\\2");

	public static String getNextValidPassword(String password) {
		do {
			password = incrementString(password);
		} while (!isValidPassword(password));
		return password;
	}

	private static boolean isValidPassword(String password) {
		Matcher m1 = p1.matcher(password);
		Matcher m2 = p2.matcher(password);
		Matcher m3 = p3.matcher(password);
		return !m1.find() && m2.find() && m3.find();
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
		String newPassword = getNextValidPassword("hxbxwxba");
		System.out.println("Part 1 answer: " + newPassword);
		System.out.println("Part 2 answer: " + getNextValidPassword(newPassword));
	}

}
