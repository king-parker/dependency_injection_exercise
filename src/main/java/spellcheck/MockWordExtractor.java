package spellcheck;

import java.util.ArrayList;
import java.util.List;

public class MockWordExtractor implements Extractor {
    @Override
    public List<String> extract(String content) {
        List<String> words = new ArrayList<>();
        words.add("This");
        words.add("is");
        words.add("a");
        words.add("Test");

        return words;
    }
}
