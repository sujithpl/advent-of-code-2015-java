package com.sujithpaul.adventofcode2015.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputProcessorTest {

	@Test
	public void testReadFile() {
		String[] expectedStringArray = {"abc", "def", "123", "ghi"};
		String[] actualStringArray = InputProcessor.readFile("files/test-input.txt").toArray(size -> new String [size]);
		assertArrayEquals(expectedStringArray, actualStringArray);
	}

}
