package spellcheck;

import java.io.IOException;

public interface Fetcher {
    public String fetch(String fileLocation) throws IOException;
}
