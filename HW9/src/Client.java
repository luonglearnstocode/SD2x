/*
 * SD2x Homework #9
 * This class represents the code that uses the NewspaperArticle class.
 * You should not need to modify this code as a result of your refactoring!
 * You do not need to submit this code.
 */

import java.util.*;


public class Client {

	public void test() {
		
		String title = "Software maintenance is fun!";
		String author = "John Doe";
		int startPage = 5;
		int endPage = 6;
		Set<String> editors = new HashSet<String>();
		editors.add("Rachel Smith");
		editors.add("Arvind Bhusnurmath");
		String newspaper = "The edX Times";
		Date date = new Date();
		String city = "Philadelphia";
		String state = "PA";
		String postCode = "19104";
		
		NewspaperArticle article = new NewspaperArticle(title, author, startPage, endPage, editors, newspaper, date, city, state, postCode);
		
		System.out.println(article.getTitle());		
		System.out.println(article.getAuthor());
		System.out.println(article.getStartPage());
		System.out.println(article.getEndPage());
		for (String editor : article.getEditors()) {
			System.out.println(editor);
		}
		System.out.println(article.getNewspaper());
		System.out.println(article.getDate());
		System.out.println(article.getCity());
		System.out.println(article.getState());
		System.out.println(article.getPostCode());

		System.out.println(article.numEditors());
		System.out.println(article.numPages());


	}
	
	public void compare(NewspaperArticle article1, NewspaperArticle article2) {
		System.out.println(article1.sameAuthor(article2));
		System.out.println(article1.sameNewspaper(article2));
		System.out.println(article1.commonEditors(article2).size());
		System.out.println(article1.compareDates(article2));
				
		System.out.println(article1.compareWithGeneralDate(new Date()));
	}

	
}
