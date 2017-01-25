package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.*;

import org.junit.Test;

public class Day5Test {

	@Test
	public void testContainsDoubleLettersPredicate() {
		assertTrue(Day5.containsDoubleLetters.test("abcddefgh"));
		assertTrue(Day5.containsDoubleLetters.test("abcdeeefgh"));
		assertTrue(Day5.containsDoubleLetters.test("aabcdefghh"));

		assertFalse(Day5.containsDoubleLetters.test("abcbdefgha"));
		assertFalse(Day5.containsDoubleLetters.test("abababab"));
	}

}
