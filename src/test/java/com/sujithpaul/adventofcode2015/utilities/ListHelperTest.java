package com.sujithpaul.adventofcode2015.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListHelperTest {

	@Test
	public void testGetAllPermutations() {
		List<Integer> aList = Arrays.asList(1, 2, 3);
		List<List<?>> allPermutations = ListHelper.getAllPermutations(aList);
		assertEquals(6, allPermutations.size());
		assertTrue(allPermutations.contains(aList));
		assertTrue(allPermutations.contains(Arrays.asList(2, 1, 3)));
		assertTrue(allPermutations.contains(Arrays.asList(3, 1, 2)));
		assertTrue(allPermutations.contains(Arrays.asList(3, 2, 1)));
	}

}
