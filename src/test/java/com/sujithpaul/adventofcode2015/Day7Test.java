package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Day7Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testProcessWiringInstruction() {
		Day7.processWiringInstruction("123 -> x");
		Day7.processWiringInstruction("456 -> y");
		Day7.processWiringInstruction("x AND y -> d");
		Day7.processWiringInstruction("x OR y -> e");
		Day7.processWiringInstruction("x LSHIFT 2 -> f");
		Day7.processWiringInstruction("y RSHIFT 2 -> g");
		Day7.processWiringInstruction("NOT x -> h");
		Day7.processWiringInstruction("NOT y -> i");
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
