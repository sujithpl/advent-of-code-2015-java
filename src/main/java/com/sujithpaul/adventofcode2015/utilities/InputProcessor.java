package com.sujithpaul.adventofcode2015.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputProcessor {
	public Stream<String> readFile(String path) {
		Stream<String> strStream = null;
		try {
			strStream = Files.lines(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strStream;
	}
}
