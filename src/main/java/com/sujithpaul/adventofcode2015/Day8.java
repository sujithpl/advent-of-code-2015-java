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

	static Function<String, String> encodeStartingQuotes = s -> s.replaceAll("^\"", "!@!");

	static Function<String, String> encodeEndingQuotes = s -> s.replaceAll("\"$", "!@!");

	static Function<String, String> encodeBackSlash = s -> s.replaceAll("\\\\", "@@");

	static Function<String, String> encodeQuotes = s -> s.replaceAll("\"", "@!");

	static Function<String, String> convertToEncodedTextEquivalent = encodeStartingQuotes //
			.andThen(encodeEndingQuotes) //
			.andThen(encodeBackSlash) //
			.andThen(encodeQuotes);

	static ToIntFunction<? super String> getStringLength = s -> s.length();

	static int countCharsInStream(Stream<String> stringStream, Function<String, String> streamConverter) {
		return stringStream //
				.map(streamConverter) //
				.mapToInt(getStringLength) //
				.sum();
	}

	public static void main(String[] args) {
		int numberOfTextChars = countCharsInStream(InputProcessor.readFile("files/day8-input.txt"), (s) -> (s));
		System.out.println("Number of characters in file: " + numberOfTextChars);

		int numberOfInMemoryChars = countCharsInStream(InputProcessor.readFile("files/day8-input.txt"),
				convertToInMemoryStringEquivalent);
		System.out.println("Number of charecters in memory: " + numberOfInMemoryChars);

		System.out.println("Part 1 Difference: " + (numberOfTextChars - numberOfInMemoryChars));
		
		int numberOfEncodedChars = countCharsInStream(InputProcessor.readFile("files/day8-input.txt"),
				convertToEncodedTextEquivalent);
		System.out.println("Number of characters in encoded text: " + numberOfEncodedChars);
		
		System.out.println("Part 2 Difference: " + (numberOfEncodedChars - numberOfTextChars));
	}

}
