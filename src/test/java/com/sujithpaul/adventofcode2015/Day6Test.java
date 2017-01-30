package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day6Test {

	private static Day6 testLightGrid;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testLightGrid = new Day6(10, 10);
	}

	@Before
	public void setUp() throws Exception {
		testLightGrid.resetAllLights();
	}

	@Test
	public void testCountNumberOfLitLights() {
		assertEquals(0, testLightGrid.countNumberOfLitLights());
	}

	@Test
	public void testTurnOnLights() {
//		testLightGrid.turnOnLights(1, 1, 8, 8);
		assertEquals(64, testLightGrid.countNumberOfLitLights());
	}

	@Test
	public void testTurnOffLights() {
//		testLightGrid.turnOnLights(0, 0, 8, 8);
		assertEquals(81, testLightGrid.countNumberOfLitLights());
		testLightGrid.turnOffLights(4, 4, 8, 8);
		assertEquals(56, testLightGrid.countNumberOfLitLights());
	}

}
