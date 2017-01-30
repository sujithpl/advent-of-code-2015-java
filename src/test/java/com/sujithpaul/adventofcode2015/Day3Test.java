package com.sujithpaul.adventofcode2015;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.TestCase;

@RunWith(Parameterized.class)
public class Day3Test extends TestCase {

	private String instructions;
	private int housesVisited;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ ">", 2 }, //
				{ "^>v<", 4 }, //
				{ "^v^v^v^v^v", 2 } //
		});
	}
	
	public Day3Test(String instructions, int housesVisited) {
		this.instructions = instructions;
        this.housesVisited = housesVisited;
    }

	@Test
	public void testNumberOfHousesVisited() {
		Day3 obj = new Day3(instructions);
		assertEquals(housesVisited, obj.getNumberOfHousesVisited());
	}

}
