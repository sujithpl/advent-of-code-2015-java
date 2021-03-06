package com.sujithpaul.adventofcode2015.utilities;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputProcessor {
	public static Stream<String> readFile(String filename) {
		Stream<String> strStream = null;
		try {
			URL url = InputProcessor.class.getClassLoader().getResource(filename);
			strStream = Files.lines(Paths.get(url.toURI()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strStream;
	}
}
