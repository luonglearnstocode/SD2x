
/*
 * SD2x Homework #3
 * This class represents a single sentence.
 * Please do not change this code! Your solution will be evaluated using this version of the class.
 */

public class Sentence implements Comparable<Sentence> {
	protected int score;
	protected String text;
	
	public Sentence(int score, String text) {
		this.score = score;
		this.text = text;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		if (score != other.score)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public int compareTo(Sentence o) {
		return this.score - o.score;
	}
	
	
}
