package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void testDoesNotContainAbCdPqXyPredicate() {
		assertTrue(Day5.doesNotContainAbCdPqXy.test("ddefghijk"));
		assertTrue(Day5.doesNotContainAbCdPqXy.test("axzbdefcgdpy"));
		assertTrue(Day5.doesNotContainAbCdPqXy.test("yxqpdcba"));

		assertFalse(Day5.doesNotContainAbCdPqXy.test("mnoabcbdefgh"));
		assertFalse(Day5.doesNotContainAbCdPqXy.test("badcjklpqqlmk"));
		assertFalse(Day5.doesNotContainAbCdPqXy.test("cccddd"));
		assertFalse(Day5.doesNotContainAbCdPqXy.test("ccadddxyp"));
	}

	@Test
	public void testContainsAtLeastThreeVowelsPredicate() {
		assertTrue(Day5.containsAtLeastThreeVowels.test("abcddefghikk"));
		assertTrue(Day5.containsAtLeastThreeVowels.test("bcdeeefgh"));
		assertTrue(Day5.containsAtLeastThreeVowels.test("xyzhhupqstio"));

		assertFalse(Day5.containsAtLeastThreeVowels.test("abcbdefghpg"));
		assertFalse(Day5.containsAtLeastThreeVowels.test("xzstrouklpmn"));
	}
}
