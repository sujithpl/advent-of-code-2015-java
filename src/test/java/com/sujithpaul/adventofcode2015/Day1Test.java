package com.sujithpaul.adventofcode2015;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class Day1Test extends TestCase {

	private Day1 obj;

	@Before
	public void setUp() {
		this.obj = new Day1();
	}

	@Test
	public void testfinalFloorPositionMethod() {
		assertEquals(0, this.obj.finalFloorPosition("(())"));
		assertEquals(0, this.obj.finalFloorPosition("()()"));
		assertEquals(3, this.obj.finalFloorPosition("((("));
		assertEquals(3, this.obj.finalFloorPosition("(()(()("));
		assertEquals(-3, this.obj.finalFloorPosition(")))"));
		assertEquals(-3, this.obj.finalFloorPosition(")())())"));
	}
	
	@Test
	public void testBasementEntryPointMethod(){
		assertEquals(1, obj.basementEntryPoint(")"));
		assertEquals(5, obj.basementEntryPoint("()())"));
	}
}
