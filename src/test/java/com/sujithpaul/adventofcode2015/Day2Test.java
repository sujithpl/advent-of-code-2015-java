package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day2Test {

	@Test
	public void testAreaOfWrappingPaper() {
		assertEquals(58, Day2.areaOfWrappingPaper(new int[] {2, 3, 4}));
		assertEquals(43, Day2.areaOfWrappingPaper(new int[] {1, 1, 10}));
	}

	@Test
	public void testLengthOfRibbon() {
		assertEquals(34, Day2.lengthOfRibbon(new int[] {2, 3, 4}));
		assertEquals(14, Day2.lengthOfRibbon(new int[] {1, 1, 10}));
	}

}
