

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {
	@Test
	public void testInsertSorted() { // add to the end
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		LinkedListUtils.insertSorted(list, 4);
		assertEquals(list.get(0), Integer.valueOf(1));
		assertEquals(list.get(1), Integer.valueOf(2));
		assertEquals(list.get(2), Integer.valueOf(3));
		assertEquals(list.get(3), Integer.valueOf(4));
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testInsertSorted2() { // add to the beginning
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		LinkedListUtils.insertSorted(list, 1);
		assertEquals(list.get(0), Integer.valueOf(1));
		assertEquals(list.get(1), Integer.valueOf(2));
		assertEquals(list.get(2), Integer.valueOf(3));
		assertEquals(list.get(3), Integer.valueOf(4));
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testInsertSorted3() { // add value equals to the smallest element
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		LinkedListUtils.insertSorted(list, 2);
		assertEquals(list.get(0), Integer.valueOf(2));
		assertEquals(list.get(1), Integer.valueOf(2));
		assertEquals(list.get(2), Integer.valueOf(3));
		assertEquals(list.get(3), Integer.valueOf(4));
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testInsertSorted4() { // add value equals to the biggest element
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		LinkedListUtils.insertSorted(list, 4);
		assertEquals(list.get(0), Integer.valueOf(2));
		assertEquals(list.get(1), Integer.valueOf(3));
		assertEquals(list.get(2), Integer.valueOf(4));
		assertEquals(list.get(3), Integer.valueOf(4));
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testInsertSorted5() { // list is null
		LinkedListUtils.insertSorted(null, 4);
	}
	
	@Test
	public void testInsertSorted6() { // add to empty list
		LinkedList<Integer> list = new LinkedList<>();
		LinkedListUtils.insertSorted(list, 4);
		assertEquals(list.get(0), Integer.valueOf(4));
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void testRemoveMaximumValues1() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("a", "b", "c"));
		LinkedListUtils.removeMaximumValues(list, 2);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), "a");
	}
	
	@Test
	public void testRemoveMaximumValues3() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("a", "b", "c"));
		LinkedListUtils.removeMaximumValues(list, 3);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testRemoveMaximumValues2() {
		LinkedList<String> list = new LinkedList<>();
		list.addAll(Arrays.asList("a", "b", "c", "b", "c"));
		LinkedListUtils.removeMaximumValues(list, 2);
		assertEquals(list.size(), 1);
		assertEquals(list.get(0), "a");
	}
	
	@Test
	public void testContainsSubsequence1() { // one list is empty
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3, 4, 5));
		assertFalse(LinkedListUtils.containsSubsequence(one, two));
	}
	
	@Test
	public void testContainsSubsequence2() { // one list is null
		LinkedList<Integer> one = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3, 4, 5));
		assertFalse(LinkedListUtils.containsSubsequence(one, null));
	}
	
	@Test
	public void testContainsSubsequence3() { // subsequence of 1 element
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3));
		two.addAll(Arrays.asList(2));
		assertTrue(LinkedListUtils.containsSubsequence(one, two));
	}
	
	@Test
	public void testContainsSubsequence4() { // subsequence of 2 element at the beginning
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3));
		two.addAll(Arrays.asList(1, 2));
		assertTrue(LinkedListUtils.containsSubsequence(one, two));
	}
	
	@Test
	public void testContainsSubsequence5() { // subsequence of 3 element in middle
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3, 4, 5));
		two.addAll(Arrays.asList(2, 3, 4));
		assertTrue(LinkedListUtils.containsSubsequence(one, two));
	}
	
	@Test
	public void testContainsSubsequence6() {
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3, 4, 5));
		two.addAll(Arrays.asList(2, 4));
		assertFalse(LinkedListUtils.containsSubsequence(one, two));
	}
	
	@Test
	public void testContainsSubsequence7() {
		LinkedList<Integer> one = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<>();
		one.addAll(Arrays.asList(1, 2, 3, 4, 5));
		two.addAll(Arrays.asList(1, 4, 5));
		assertFalse(LinkedListUtils.containsSubsequence(one, two));
	}

}
