package spellcheck;

import com.google.inject.AbstractModule;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Fetcher.class).to(MockURLFetcher.class);
        bind(Extractor.class).to(MockWordExtractor.class);
        bind(KnowledgeBank.class).to(MockDictionary.class);
    }
}
