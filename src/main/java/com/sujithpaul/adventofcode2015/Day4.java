package com.sujithpaul.adventofcode2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

	public static String getMD5Hash(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	public static int mineAdventCoin(String secret, String startingSequence) {
		boolean found = false;
		int i = 0;
		do {
			String input = secret + i;
			try {
				if (getMD5Hash(input).substring(0, startingSequence.length()).equals(startingSequence)) {
					found = true;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			i++;
		} while (!found);
		return i - 1;
	}

	public static void main(String[] args) {
		 System.out.println("Input for coin 1: " + mineAdventCoin("bgvyzdsv", "00000"));
		 System.out.println("Input for coin 2: " + mineAdventCoin("bgvyzdsv", "000000"));
	}

}
