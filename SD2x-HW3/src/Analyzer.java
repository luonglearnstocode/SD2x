import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Takes the name of the file to read and read it one line at a time, creating Sentence objects and putting them into the List. 
	 * Returns a List containing Sentence objects.
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> sentences = new ArrayList<>();
		List<String> lines = new ArrayList<>();
		
		/*
		 * https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
		 */
		try {
			lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
		} catch (Exception e) {
			return new ArrayList<Sentence>(); // if the file cannot be opened for reading or if the input filename is null, this method should return an empty List.
		}
		
		for (String line : lines) {
			int spaceIndex = line.indexOf(" ");
			 
			try { 
				int score = Integer.parseInt(line.substring(0, spaceIndex));
				String text = line.substring(spaceIndex + 1); 
				
				if (score <= 2 && score >= -2 && !text.isEmpty()) { // well formatted
					sentences.add(new Sentence(score, text));
				}
			} catch(Exception e) {
				continue;
			}
			
		}
		
		return sentences; 
	}
	
	/*
	 * This method should find all of the individual tokens/words in the text field of each Sentence in the List and create Word objects for each distinct word. 
	 * The Word objects should keep track of the number of occurrences of that word in all Sentences, and the total cumulative score of all Sentences in which it appears. 
	 * Return a Set of those Word objects.
	 * 
	 * If the input List of Sentences is null or is empty, the allWords method should return an empty Set.
	 * If a Sentence object in the input List is null, this method should ignore it and process the non-null Sentences.
	 * Ignores any token that does not start with a letter and convert all strings to lowercase. 
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		List<Word> wordList = new ArrayList<>();
		
		if (!(sentences == null || sentences.isEmpty())) { // sentences list not null or empty
			for (Sentence sentence : sentences) {
				if (sentence != null) {
					String[] tokens = sentence.getText().toLowerCase().split(" ");
					for (String token : tokens) {
						if (Character.isLetter(token.charAt(0))) { // token starts with a letter
							Word word = new Word(token);
							word.increaseTotal(sentence.getScore());
							
							if (wordList.contains(word)) {
								wordList.get(wordList.indexOf(word)).increaseTotal(word.getTotal()); // update word 
							} else {
								wordList.add(word);
							}
						}
					}
				}
			}
		}
		
		return new HashSet<Word>(wordList);
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.out.println("Please specify the name of the input file");
//			System.exit(0);
//		}
//		String filename = args[0];
//		System.out.print("Please enter a sentence: ");
//		Scanner in = new Scanner(System.in);
//		String sentence = in.nextLine();
//		in.close();
//		List<Sentence> sentences = Analyzer.readFile(filename);
//		Set<Word> words = Analyzer.allWords(sentences);
//		Map<String, Double> wordScores = Analyzer.calculateScores(words);
//		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
//		System.out.println("The sentiment score is " + score);
		
		/*
		 * Test readFile
		 */
		String filename = "reviews.txt";
		List<Sentence> sentences = Analyzer.readFile(filename);
//		for (Sentence sentence : sentences) {
//			System.out.println(sentence.getScore() + " " + sentence.getText());
//		}
		
		
		/*
		 * Test allWords
		 */
		Set<Word> words = Analyzer.allWords(sentences);
		for (Word word : words) {
			System.out.println(word.getText() + " " + word.getCount());
		}
		
	}
}
