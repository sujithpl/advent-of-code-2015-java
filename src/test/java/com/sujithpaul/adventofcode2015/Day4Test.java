package com.sujithpaul.adventofcode2015;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Day4Test {

	@Test
	public void testGetMD5Hash() throws NoSuchAlgorithmException {
		assertEquals("e80b5017098950fc58aad83c8c14978e", Day4.getMD5Hash("abcdef"));
		assertEquals("827ccb0eea8a706c4c34a16891f84e7b", Day4.getMD5Hash("12345"));
	}

	@Test
	public void testMineAdventCoin() {
		assertEquals(609043, Day4.mineAdventCoin("abcdef", "00000"));
		assertEquals(1048970, Day4.mineAdventCoin("pqrstuv", "00000"));
	}

}
