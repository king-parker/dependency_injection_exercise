package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.SortedMap;

public class Test {
    public static void main(String[] args) {
        String fileLocation = "fileLocation";

        Injector injector = Guice.createInjector(new TestModule());
        SpellingChecker testChecker = injector.getInstance(SpellingChecker.class);

        try {
            SortedMap<String, Integer> mistakes = testChecker.check(fileLocation);
            System.out.println(mistakes);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
