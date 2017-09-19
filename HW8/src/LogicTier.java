import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	/*
	 * for a given name, search through all of the books and 
	 * return the titles of those books whose author name includes the input name
	 */
	public Set<String> findBookTitlesByAuthor(String author) {
		Set<String> titles = new HashSet<>();
		List<Book> books = dataTier.getAllBooks();
		
		for (Book book : books) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				titles.add(book.getTitle());
			}
		}
		
		return titles;
	}
	
	/*
	 * for a given year, search through all of the books and 
	 * return the number of books published in that year 
	 */
	public int findNumberOfBooksInYear(int year) {
		List<Book> books = dataTier.getAllBooks();
		int count = 0;
		
		for (Book book : books) {
			if (book.getPublicationYear() == year)
				count++;
		}
		
		return count;
	}

}
