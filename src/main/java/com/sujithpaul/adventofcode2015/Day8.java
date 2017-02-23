package com.sujithpaul.adventofcode2015;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import com.sujithpaul.adventofcode2015.utilities.InputProcessor;

public class Day8 {

	static Function<String, String> removeStartingQuotes = s -> s.replaceAll("^\"", "");

	static Function<String, String> removeEndingQuotes = s -> s.replaceAll("\"$", "");

	static Function<String, String> replaceBackSlashWithAt = s -> s.replaceAll("\\\\", "@");

	static Function<String, String> replaceBackSlashAtWithExclamationMark = s -> s.replaceAll("@\\\"", "!");

	static Function<String, String> replaceDoubleAtWithPound = s -> s.replaceAll("@@", "#");

	static Function<String, String> replaceHexWithPercentageSign = s -> s.replaceAll("@x..", "%");

	static Function<String, String> convertToInMemoryStringEquivalent = removeStartingQuotes //
			.andThen(removeEndingQuotes) //
			.andThen(replaceBackSlashWithAt) //
			.andThen(replaceBackSlashAtWithExclamationMark) //
			.andThen(replaceDoubleAtWithPound) //
			.andThen(replaceHexWithPercentageSign);

	static ToIntFunction<? super String> getStringLength = s -> s.length();

	static int countCharsInStream(Stream<String> stringStream, Function<String, String> streamConverter) {
		return stringStream //
				.map(streamConverter) //
				.mapToInt(getStringLength) //
				.sum();
	}

	public static void main(String[] args) {
		int numberOfTextChars = countCharsInStream(InputProcessor.readFile("files/day8-input.txt"), (s) -> (s));
		System.out.println(numberOfTextChars);
		int numberOfInMemoryChars = countCharsInStream(InputProcessor.readFile("files/day8-input.txt"),
				convertToInMemoryStringEquivalent);
		System.out.println(numberOfInMemoryChars);
		System.out.println("Diff: " + (numberOfTextChars - numberOfInMemoryChars));
	}

}
