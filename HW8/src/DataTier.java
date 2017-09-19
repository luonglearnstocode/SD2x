import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	/*
	 * read the data file containing information about the books, 
	 * create Book objects for each, and then return the Book objects. 
	 */
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		List<String> lines = null;
		
		/*
		 * http://www.vogella.com/tutorials/JavaIO/article.html
		 */
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String line : lines) {
			String[] tokens = line.split("\t");
			books.add(new Book(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
		}
		
		return books;
	}
}
