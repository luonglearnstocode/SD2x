

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		if (list != null) {
			if (list.isEmpty()) {
				list.add(value);
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) >= value) {
						list.add(i, value);
						break;
					}
					if (i == list.size() - 1) {
						list.add(value);
						break;
					}
				}
			}
		}
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		if (list != null && !list.isEmpty()) {
			if (list.size() <= N) {
				list.removeAll(list);
				return;
			}
			for (int i = 0; i < N; i++) {
				LinkedList<String> sortedList = new LinkedList<>(list);
				Collections.sort(sortedList, Collections.reverseOrder());
				list.removeAll(Arrays.asList(sortedList.get(0)));
			}
		}
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
			return false;
		}
		
		for (int i = 0; i <= one.size() - two.size(); i++) {
			boolean result = true;
			for (int j = 0; j < two.size(); j++) {
				if (one.get(i + j) != two.get(j)) {
					result = false;
					break;
				}
			}
			if (result) {
				return true;
			}
		}
		
		return false; 
	}
}
