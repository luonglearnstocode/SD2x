/*
 * SD2x Homework #8
 * This class represents a single book.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */

public class Book implements Comparable<Book> {

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author
				+ ", publicationYear=" + publicationYear + "]";
	}

	protected String title;
	protected String author;
	protected int publicationYear;
	
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.publicationYear = year;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (publicationYear != other.publicationYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Book other) {
		return this.publicationYear - other.publicationYear;
	}
	
	@Override
	public int hashCode() {
		return this.author.hashCode();
	}
	
}
