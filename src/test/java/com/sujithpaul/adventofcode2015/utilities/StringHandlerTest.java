package com.sujithpaul.adventofcode2015.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHandlerTest {

	@Test
	public void testConvertStringsArrayToIntsArray() {
		String[] stringArray = {"-100", "0", "1"};
		int[] intArray = {-100,  0, 1};
		assertArrayEquals(intArray, StringHandler.convertStringsArrayToIntsArray(stringArray));
	}

	@Test
	public void testSplitStringByAlternatingChars() {
		String combinedString = "abababab";
		String[] splitStrings = StringHandler.splitStringByAlternatingChars(combinedString);
		assertEquals("aaaa", splitStrings[0]);
		assertEquals("bbbb", splitStrings[1]);
	}

}
