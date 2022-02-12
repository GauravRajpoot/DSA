package com.nagarro.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestElementInArray {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 1, 4 };
		LargestElementInArray element = new LargestElementInArray();
		System.out.println(element.getLargestElement(arr).get("Element"));
		System.out.print(element.getLargestElementUsingStream(arr));
	}

	/**
	 * Find the largest element through loop
	 */
	private Map<String, Integer> getLargestElement(int[] array) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int maxElement = array[0];
		int index;
		for (index = 1; index < array.length; index++) {
			if (maxElement < array[index])
				maxElement = array[index];
		}
		hash.put("Element", maxElement);
		hash.put("Index", index - 1);
		return hash;
	}

	/**
	 * Find the largest element through stream api
	 */
	private int getLargestElementUsingStream(final int[] array) {
		return Arrays.stream(array).max().getAsInt();
	}

}