package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Day12Test {

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testExtractSumOfIntegers() {
		assertEquals(6, Day12.extractSumOfIntegers("{\"a\":2,\"b\":4}"));
		assertEquals(6, Day12.extractSumOfIntegers("[1,2,3]"));
		assertEquals(3, Day12.extractSumOfIntegers("[[[3]]]"));
		assertEquals(3, Day12.extractSumOfIntegers("{\"a\":{\"b\":4},\"c\":-1}"));
		assertEquals(0, Day12.extractSumOfIntegers("{\"a\":[-1,1]}"));
		assertEquals(0, Day12.extractSumOfIntegers("[-1,{\"a\":1}]"));
		assertEquals(0, Day12.extractSumOfIntegers("[]"));
		assertEquals(0, Day12.extractSumOfIntegers("{}"));
	}

	@Test
	public void testAddIntegersInJson() throws IOException {
		assertEquals(6, Day12.addIntegersInJson(mapper.readTree("[1,2,3]"), 0));
		assertEquals(4, Day12.addIntegersInJson(mapper.readTree("[1,{\"c\":\"red\",\"b\":2},3]"), 0));
		assertEquals(0, Day12.addIntegersInJson(mapper.readTree("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"), 0));
		assertEquals(6, Day12.addIntegersInJson(mapper.readTree("[1,\"red\",5]"), 0));
	}

}
