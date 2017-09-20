/*
 * SD2x Homework #9
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
import java.util.*;

public class NewspaperArticle extends Document {
	private int startPage;
	private int endPage;
	private Set<String> editors;
	private String newspaper;
	
	public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors, String newspaper, Date date, String city, String state, String postCode) {
		super(title, author, date, city, state, postCode);
		this.startPage = startPage;
		this.endPage = endPage;
		this.editors = editors;
		this.newspaper = newspaper;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public Set<String> getEditors() {
		return editors;
	}
	
	public String getNewspaper() {
		return newspaper;
	}
	
	
	public int numPages(){
		return endPage - startPage + 1;
	}
	
	
	public boolean sameNewspaper(NewspaperArticle article) {
		return this.newspaper.equals(article.newspaper);
	}
	
	public int numEditors(){
		return editors.size();
	}
	
	public Set<String> commonEditors(NewspaperArticle article){
		Set<String> sameEditors = new HashSet<String>();
		for(String ed : article.editors){
			if(this.editors.contains(ed)){
				sameEditors.add(ed);
			}
		}
		return sameEditors;
	}
	
}
