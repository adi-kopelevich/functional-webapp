package sample.code.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class AnagramsFinderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void whenGivenSetOfWordsThenReturnMapOfAnagrmas() {
        String wordsString = "kinship pinkish enlist inlets listen silent boaster boaters borates fresher refresh sinks skins knits stink rots sort";
        String[] wordsArray = wordsString.split(" ");
        Set<String> words = new HashSet<String>();
        words.addAll(Arrays.asList(wordsArray));
        Map<String, Set<String>> anagramsMap = new AnagramsFinder().getAnagrams(words);
        for (Map.Entry entry : anagramsMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
