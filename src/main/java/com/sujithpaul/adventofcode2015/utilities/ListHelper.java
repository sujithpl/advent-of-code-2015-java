package com.sujithpaul.adventofcode2015.utilities;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {
	static List<List<?>> result = new ArrayList<>();

	public static <E> List<List<?>> getAllPermutations(List<E> list) {
		getNextPermutation(list, new ArrayList<>());
		return result;
	}

	private static <E> List<E> getNextPermutation(List<E> inList, List<E> outList) {
		if (inList.size() == 1) {
			outList.add(inList.get(0));
			result.add(outList);
		} else {
			for (E item: inList) {
				List<E> newOutList = new ArrayList<>(outList);
				List<E> newInList = new ArrayList<>(inList);
				newOutList.add(item);
				newInList.remove(item);
				getNextPermutation(newInList, newOutList);
			}
		}
		return outList;
	}
}
