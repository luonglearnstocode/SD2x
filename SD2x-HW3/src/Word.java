



public class Word implements Comparable<Word> {
	protected String text;
	protected int count;
	protected int total;
	
	/*
	 * Note that this does not set the value or increment the counter.
	 * It just creates an object with no count and no total so far.
	 */
	public Word(String text) {
		this.text = text;
		count = 0;
		total = 0;
	}
	
	public void increaseTotal(int value) {
		total += value;
		count++;
	}
	
	public double calculateScore() {
		if (count == 0) {
			return 0;
		}
		return ((double) total) / count;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getTotal() {
		return total;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Word == false) return false;
		Word otherWord = (Word)other;
		return text.equals(otherWord.text);
	}
	
	@Override
	public int hashCode() {
		return text.hashCode();
	}

	@Override
	public int compareTo(Word o) {
		return text.compareTo(o.text);
	}
}
