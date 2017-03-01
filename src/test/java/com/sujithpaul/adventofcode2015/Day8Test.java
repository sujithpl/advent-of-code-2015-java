package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Day8Test {

	@Test
	public void testCountCharsInStream() {
		String[] input = {"\"\"", "\"abc\"", "\"aaa\\\"aaa\"","\"\\x27\"", "\"def\\\\ghi\""};

		int numberOfTextChars = Day8.countCharsInStream(Arrays.stream(input), (s) -> (s));
		assertEquals(33, numberOfTextChars);
		
		int numberOfInMemoryChars = Day8.countCharsInStream(Arrays.stream(input), Day8.convertToInMemoryStringEquivalent);
		assertEquals(18, numberOfInMemoryChars);
		
		int numberOfEncodedChars = Day8.countCharsInStream(Arrays.stream(input), Day8.convertToEncodedTextEquivalent);
		assertEquals(58, numberOfEncodedChars);
	}

}
