import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	private Scanner scanner = new Scanner(System.in);
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	/*
	 * asks the user which feature they would like to use 
	 * and invokes the appropriate methods in the appropriate classes. 
	 * 
	 * Once the output has been displayed, the program should terminate. 
	 */
	public void start() {
		System.out.println("***************************************");
		System.out.println("\t1. Find book titles by author.");
		System.out.println("\t2. Find number of books in year");
		System.out.print("Which feature do you want to use?");
		String input = scanner.nextLine();
		
		if (input.equals("1")) {
			showBookTitlesByAuthor();
		} else if (input.equals("2")) {
			showNumberOfBooksInYear();
		} else {
			System.out.println("Sorry, wrong input");
		}
		
	}
	
	/*
	 * using the command-line (i.e., reading from System.in), 
	 * ask the user to enter part or all of an author’s name, 
	 * then display (using System.out) the titles of those books 
	 * whose author name includes the input name.
	 */
	public void showBookTitlesByAuthor() {
		System.out.print("Which author: ");
		String author = scanner.nextLine();
		Set<String> books = logicTier.findBookTitlesByAuthor(author);
		System.out.println("Books of " + author + ":");
		for (String book : books) {
			System.out.println(book);
		}
	}
	
	/*
	 * using the command-line (i.e., reading from System.in), 
	 * ask the user to enter a year, 
	 * then display (using System.out) the number of books published in that year
	 */
	public void showNumberOfBooksInYear() {
		System.out.print("Which year: ");
		int year = scanner.nextInt();		
		int numberOfBooks = logicTier.findNumberOfBooksInYear(year);
		
		System.out.println("Number of books in " + year + " is " + numberOfBooks);
	}
	
	

}
