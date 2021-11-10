package spellcheck;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class RealModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Fetcher.class).to(URLFetcher.class);
        bind(Extractor.class).to(WordExtractor.class);
        bind(KnowledgeBank.class).to(Dictionary.class);
    }

    @Provides
    @Named("Filename")
    public String dictionaryName() {
        return "dict.txt";
    }
}
