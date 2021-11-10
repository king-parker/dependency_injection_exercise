package spellcheck;

import java.io.IOException;

public class MockURLFetcher implements Fetcher {
    @Override
    public String fetch(String fileLocation) throws IOException {
        return "42";
    }
}
