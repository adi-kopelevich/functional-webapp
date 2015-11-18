package sample.code.kata;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class SpellCheckBloomFilterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void whenGivenSetOfWordsThenReturnMapOfAnagrmas() {
        SpellCheckBloomFilter spellCheckBloomFilter = new SpellCheckBloomFilter(400000);

        ClassLoader classLoader = getClass().getClassLoader();
        File wordListFile = new File(classLoader.getResource("wordlist.txt").getFile());
        try (BufferedReader fileReader = new BufferedReader(new FileReader(wordListFile))) {
            String line = fileReader.readLine();
            while (line != null) {
                spellCheckBloomFilter.addWordToDic(line.trim());
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(false, spellCheckBloomFilter.isValidWord("Hiasd"));
        Assert.assertEquals(true, spellCheckBloomFilter.isValidWord("Hello"));
    }
}
