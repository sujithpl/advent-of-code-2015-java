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
	public void testCalculateTotalValueOfLights() {
		assertEquals(0, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testResetAllLights() {
		testLightGrid.operateSetOfLights(1, 1, 8, 8, Day6.turnOn);
		assertEquals(64, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.resetAllLights();
		assertEquals(0, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testTurnOnLights() {
		testLightGrid.operateSetOfLights(1, 1, 8, 8, Day6.turnOn);
		assertEquals(64, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testTurnOffLights() {
		testLightGrid.operateSetOfLights(0, 0, 8, 8, Day6.turnOn);
		assertEquals(81, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.operateSetOfLights(4, 4, 8, 8, Day6.turnOff);
		assertEquals(56, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testToggleLights() {
		testLightGrid.operateSetOfLights(0, 0, 6, 7, Day6.turnOn);
		assertEquals(56, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.operateSetOfLights(3, 4, 8, 8, Day6.toggle);
		assertEquals(54, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testTurnUpLights() {
		testLightGrid.operateSetOfLights(1, 1, 8, 8, Day6.turnUp);
		assertEquals(64, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testTurnDownLights() {
		testLightGrid.operateSetOfLights(0, 0, 8, 8, Day6.turnUp);
		assertEquals(81, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.operateSetOfLights(4, 4, 9, 9, Day6.turnDown);
		assertEquals(56, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testTurnUpTwiceLights() {
		testLightGrid.operateSetOfLights(0, 0, 6, 7, Day6.turnUp);
		assertEquals(56, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.operateSetOfLights(3, 4, 8, 8, Day6.turnUpTwice);
		assertEquals(116, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testProcessLightingInstructionRuleSet1(){
		testLightGrid.processLightingInstruction("turn on 0,0 through 4,9", 1);
		assertEquals(50, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.processLightingInstruction("turn off 0,6 through 9,9", 1);
		assertEquals(30, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.processLightingInstruction("toggle 1,4 through 7,8", 1);
		assertEquals(49, testLightGrid.calculateTotalValueOfLights());
	}

	@Test
	public void testProcessLightingInstructionRuleSet2(){
		testLightGrid.processLightingInstruction("turn on 0,0 through 4,9", 2);
		assertEquals(50, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.processLightingInstruction("turn off 0,6 through 9,9", 2);
		assertEquals(30, testLightGrid.calculateTotalValueOfLights());
		testLightGrid.processLightingInstruction("toggle 1,4 through 7,8", 2);
		assertEquals(100, testLightGrid.calculateTotalValueOfLights());
	}
}
