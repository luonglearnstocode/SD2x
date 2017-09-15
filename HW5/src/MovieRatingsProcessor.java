/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	
	/*
	 * given an input int rating, modify the TreeMap object that was passed as an argument 
	 * so that you remove all ratings in the PriorityQueue that are below 
	 * (but not equal to) rating for every movie in the Map. 
	 * 
	 * If all ratings are removed from a movie’s PriorityQueue, then remove the mapping from the TreeMap. 
	 * 
	 * Additionally, this method should return a new TreeMap that maps a movie title 
	 * to the number of ratings that were removed from its corresponding PriorityQueue.
	 * The TreeMap that is returned should only contain movies that had ratings removed from its PriorityQueue.
	 */
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if (movieRatings == null || movieRatings.isEmpty()) {
			return new TreeMap<String, Integer>();
		}
		
		TreeMap<String, Integer> result = new TreeMap<>();
		
		/*
		 * use Iterator to iterate the Map and the PriorityQueue of ratings 
		 * in order to avoid ConcurrentModificationException
		 */
		Iterator<Map.Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, PriorityQueue<Integer>> entry = entries.next();
			
			Iterator<Integer> ratingsIT = entry.getValue().iterator();
			while (ratingsIT.hasNext()) {
				if (ratingsIT.next() < rating) {
		    		ratingsIT.remove();
		    		
		    		if (!result.containsKey(entry.getKey())) { // title already in the result map
		    			result.put(entry.getKey(), 1);
		    		} else {
		    			result.put(entry.getKey(), result.get(entry.getKey()) + 1);
		    		}
		    	}
			}
		    
		    if (entry.getValue().isEmpty()) { // all ratings are removed
		    	entries.remove();
		    }
		}

		return result;
	}
}
