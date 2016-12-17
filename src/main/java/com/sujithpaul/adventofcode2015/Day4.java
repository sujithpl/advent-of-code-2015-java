package com.sujithpaul.adventofcode2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {

	public static String mda5(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String secret = "bgvyzdsv";
		boolean found = false;
		int i = 0;
		do {
			String input = secret + i;
			try {
				if (mda5(input).substring(0, 5).equals("00000")) {
					found = true;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			i++;
		} while (!found);
		System.out.println(i-1);

	}

}
