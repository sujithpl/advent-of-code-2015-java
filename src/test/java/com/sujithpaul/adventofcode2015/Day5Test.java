package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Day5Test {

	@Test
	public void testContainsDoubleLettersPredicate() {
		assertTrue(Day5.containsRepeatingLetters.test("abcddefgh"));
		assertTrue(Day5.containsRepeatingLetters.test("abcdeeefgh"));
		assertTrue(Day5.containsRepeatingLetters.test("aabcdefghh"));

		assertFalse(Day5.containsRepeatingLetters.test("abcbdefgha"));
		assertFalse(Day5.containsRepeatingLetters.test("abababab"));
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

	@Test
	public void testNiceStringPart1RulesPredicate() {
		assertTrue(Day5.niceStringPart1Rules.test("ugknbfddgicrmopn"));
		assertTrue(Day5.niceStringPart1Rules.test("aaa"));

		assertFalse(Day5.niceStringPart1Rules.test("jchzalrnumimnmhp"));
		assertFalse(Day5.niceStringPart1Rules.test("haegwjzuvuyypxyu"));
		assertFalse(Day5.niceStringPart1Rules.test("dvszwmarrgswjxmb"));
	}

	@Test
	public void testContainsRepeatingPairOfLettersPredicate() {
		assertTrue(Day5.containsRepeatingPairOfLetters.test("aabcdefgaa"));
		assertTrue(Day5.containsRepeatingPairOfLetters.test("bcdeebecbfgbch"));
		assertTrue(Day5.containsRepeatingPairOfLetters.test("xyzhhupqszhtio"));

		assertFalse(Day5.containsRepeatingPairOfLetters.test("abcddefghikk"));
		assertFalse(Day5.containsRepeatingPairOfLetters.test("xaaay"));
	}

	@Test
	public void testcontainsRepeatingLettersWithAnotherInBetweenPredicate() {
		assertTrue(Day5.containsRepeatingLettersWithAnotherInBetween.test("aabcadcecfga"));
		assertTrue(Day5.containsRepeatingLettersWithAnotherInBetween.test("bcdeebecbfgbch"));
		assertTrue(Day5.containsRepeatingLettersWithAnotherInBetween.test("xaaay"));

		assertFalse(Day5.containsRepeatingLettersWithAnotherInBetween.test("abcddefghikk"));
		assertFalse(Day5.containsRepeatingLettersWithAnotherInBetween.test("abcabcabc"));
	}

	@Test
	public void testNiceStringPart2RulesPredicate() {
		assertTrue(Day5.niceStringPart2Rules.test("qjhvhtzxzqqjkmpb"));
		assertTrue(Day5.niceStringPart2Rules.test("xxyxx"));

		assertFalse(Day5.niceStringPart2Rules.test("uurcxstgmygtbstg"));
		assertFalse(Day5.niceStringPart2Rules.test("ieodomkazucvgmuy"));
	}

}
