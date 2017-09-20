/*
 * SD2x Homework #9
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
import java.util.*;

public class NewspaperArticle {
	private String title;
	private String author;
	private int startPage;
	private int endPage;
	private Set<String> editors;
	private String newspaper;
	private Date date;
	private String city;
	private String state;
	private String postCode;
	
	public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors, String newspaper, Date date, String city, String state, String postCode) {
		this.title = title;
		this.author = author;
		this.startPage = startPage;
		this.endPage = endPage;
		this.editors = editors;
		this.newspaper = newspaper;
		this.date = date;
		this.city = city;
		this.state = state;
		this.postCode  = postCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
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
	
	public Date getDate() {
		return date;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public int numPages(){
		return endPage - startPage + 1;
	}
	
	public boolean sameAuthor(NewspaperArticle article){
		return this.author.equals(article.author);
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
	
	public int compareDates(NewspaperArticle article){
		return this.date.compareTo(article.date);
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}
	
}
