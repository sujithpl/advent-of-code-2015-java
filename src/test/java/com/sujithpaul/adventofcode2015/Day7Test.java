package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class Day7Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProcessWiringInstruction() {
		String[] input = { "123 -> x", "456 -> y", "x AND y -> d", "x OR y -> e", "x LSHIFT 2 -> f", "y RSHIFT 2 -> g",
				"NOT x -> h", "NOT y -> i" };
		Arrays.stream(input) //
				.map(str -> str.split(" -> ")) //
				.forEach(str -> Day7.setValue(str[1], str[0]));
		assertEquals(72, Day7.getIntValue("d"));
		assertEquals(507, Day7.getIntValue("e"));
		assertEquals(492, Day7.getIntValue("f"));
		assertEquals(114, Day7.getIntValue("g"));
		assertEquals(65412, Day7.getIntValue("h"));
		assertEquals(65079, Day7.getIntValue("i"));
		assertEquals(123, Day7.getIntValue("x"));
		assertEquals(456, Day7.getIntValue("y"));
	}
}
