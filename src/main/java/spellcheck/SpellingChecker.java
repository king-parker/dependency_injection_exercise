
package spellcheck;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class SpellingChecker {
    private Fetcher fetcher;
    private Extractor extractor;
    private KnowledgeBank knowledgeBank;

    public SpellingChecker(Fetcher fetcher, Extractor extractor, KnowledgeBank knowledgeBank) {
        this.fetcher = fetcher;
        this.extractor = extractor;
        this.knowledgeBank = knowledgeBank;
    }

	public SortedMap<String, Integer> check(String fileLocation) throws IOException {

		// download the document content
		//
		String content = fetcher.fetch(fileLocation);

		// extract words from the content
		//
		List<String> words = extractor.extract(content);

		// find spelling mistakes
		//
		Dictionary dictionary = new Dictionary("dict.txt");
		SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionary.isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

