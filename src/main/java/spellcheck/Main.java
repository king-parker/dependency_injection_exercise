
package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
		String fileLocation = args[0];

		Injector injector = Guice.createInjector(new RealModule());
		SpellingChecker realChecker = injector.getInstance(SpellingChecker.class);
	
		try {
			SortedMap<String, Integer> mistakes = realChecker.check(fileLocation);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

