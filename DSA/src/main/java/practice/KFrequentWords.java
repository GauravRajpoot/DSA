package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KFrequentWords {

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(getkFrequentWords(words, 2));
	}

	private static List<String> getkFrequentWords(String[] str, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String element : str) {
			map.put(element, map.getOrDefault(element, 0) + 1);
		}

		PriorityQueue<String> pr = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int frequency1 = map.get(o1);
				int frequency2 = map.get(o2);
				if (frequency1 == frequency2)
					return o1.compareTo(o2); // Sort by lexi order
				return frequency1 - frequency2;// Sort by lesser frequency
			}
		});
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pr.add(entry.getKey());
			if (pr.size() > k)
				pr.poll();
		}
		List<String> result = new ArrayList<>();
		while (!pr.isEmpty())
			result.add(pr.poll());
		Collections.sort(result);
		return result;
	}
}
