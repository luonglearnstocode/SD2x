/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {
	
	/*
	 * return a List of movie titles in alphabetical order
	 */
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		if (movieRatings == null || movieRatings.isEmpty()) {
			return new ArrayList<String>();
		}
		
		List<String> keys = new ArrayList<>(movieRatings.keySet());
		
		return keys; 
	}
	
	/*
	 *  given an input int rating, 
	 *  return a List of movie titles in alphabetical order, 
	 *  where all movies in the List do not have any ratings less than or equal to rating 
	 *  
	 *  hint: the PriorityQueue is a min-heap, 
	 *  meaning that the smallest rating is at the front of the queue!
	 */
	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if (movieRatings == null || movieRatings.isEmpty()) {
			return new ArrayList<String>();
		}
		
		List<String> movies = new ArrayList<>();
		
		for (String title : movieRatings.keySet()) {
			if (movieRatings.get(title).peek() > rating) {
				movies.add(title);
			}
		}
		
		return movies;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}
}
