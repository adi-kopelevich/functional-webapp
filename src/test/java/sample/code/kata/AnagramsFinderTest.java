package sample.code.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class AnagramsFinderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void whenGivenSetOfWordsThenReturnMapOfAnagrmas() {
        Set<String> words = new HashSet<String>();

        ClassLoader classLoader = getClass().getClassLoader();
        File wordListFile = new File(classLoader.getResource("wordlist.txt").getFile());
        try (BufferedReader fileReader = new BufferedReader(new FileReader(wordListFile))) {
            String line = fileReader.readLine();
            while (line != null) {
                words.add(line.trim());
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String wordsString = "kinship pinkish enlist inlets listen silent boaster boaters borates fresher refresh sinks skins knits stink rots sort";
//        String[] wordsArray = wordsString.split(" ");
//        words.addAll(Arrays.asList(wordsArray));

        Map<String, Set<String>> anagramsMap = new AnagramsFinder().getAnagrams(words);
//        for (Map.Entry entry : anagramsMap.entrySet()) {
//            System.out.println(entry.getValue());
//        }
    }


}
