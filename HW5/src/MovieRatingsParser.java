/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {
	
	/*
	 *  Takes a List of UserMovieRatings as input and creates a TreeMap data structure from it. 
	 *  The TreeMap is a mapping from the movie’s title to a PriorityQueue of all its associated ratings.
	 *  
	 *  If the input List is null or empty, parseMovieRatings should return an empty TreeMap.
	 *  
	 *  If the input List contains any null UserMovieRatings object, 
	 *  or a UserMovieRatings object whose movie title is null or an empty string, 
	 *  or a UserMovieRatings object whose rating is negative, 
	 *  parseMovieRatings should ignore that UserMovieRatings object
	 *  
	 *  The movie titles should be considered case-insensitive, 
	 *  i.e. if two UserMovieRatings objects have the same title that differ only in case (upper or lower), 
	 *  they should be considered the same movie. The movie titles stored in the TreeMap must use lowercase letters.
	 */
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
		
		if (allUsersRatings == null || allUsersRatings.isEmpty()) 
			return map;
		
		for (UserMovieRating rating : allUsersRatings) {
			if (!(rating == null || 
				  rating.getMovie() == null || rating.getMovie().isEmpty() ||
				  rating.getUserRating() < 0)) {
				String title = rating.getMovie().toLowerCase();
				if (!map.containsKey(title)) { // new movie
					PriorityQueue<Integer> ratings = new PriorityQueue<>();
					ratings.add(rating.getUserRating());
					map.put(title, ratings);
				} else { // movie already in database
					map.get(title).add(rating.getUserRating());
				}
			}
		}		
		
		return map; 
	}

}
