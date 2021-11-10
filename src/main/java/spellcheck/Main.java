
package spellcheck;

import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			String fileLocation = args[0];
			Fetcher fetcher = new URLFetcher();
			Extractor extractor = new WordExtractor();
			KnowledgeBank knowledgeBank = new Dictionary("dict.txt");
			SpellingChecker checker = new SpellingChecker(fetcher, extractor, knowledgeBank);
			SortedMap<String, Integer> mistakes = checker.check(fileLocation);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

