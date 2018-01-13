package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day11Test {

	@Test
	public void testGetNextValidPassword() {
		assertEquals("abcdffaa", Day11.getNextValidPassword("abcdefgh"));
		assertEquals("ghjaabcc", Day11.getNextValidPassword("ghijklmn"));
	}

}
