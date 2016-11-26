package com.sujithpaul.adventofcode2015.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputProcessor {
	public static Stream<String> readFile(String filename) {
		Stream<String> strStream = null;
		try {
			strStream = Files.lines(Paths.get("src/main/resources/files/" + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strStream;
	}

	public static int[] convertStringsArrayToIntsArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		return intArray;
	}
}
