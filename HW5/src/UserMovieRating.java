/*
 * SD2x Homework #5
 * This class represents a single rating for a movie.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */

public class UserMovieRating implements Comparable<UserMovieRating> {

	protected String movie;
	protected int userRating;
	
	public UserMovieRating(String movie, int userRating) {
		this.movie = movie;
		this.userRating = userRating;
	}
	
	public String getMovie() {
		return movie;
	}
	
	public int getUserRating() {
		return userRating;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMovieRating other = (UserMovieRating) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (userRating != other.userRating)
			return false;
		return true;
	}

	@Override
	public int compareTo(UserMovieRating other) {
		return this.userRating - other.userRating;
	}
	
	
}
