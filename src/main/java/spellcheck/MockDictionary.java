package spellcheck;

public class MockDictionary implements KnowledgeBank {
    @Override
    public boolean isValidWord(String word) {
        return word.length() <= 3;
    }
}
