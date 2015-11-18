package sample.code.kata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class DictionaryWordCompositeScanner {

    private static final int WORD_LENGTH_TO_CHECK = 6;
    private static final Set<String> dictionary = new HashSet<>();

    private void loadDictionaryFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File wordListFile = new File(classLoader.getResource("wordlist.txt").getFile());
        try (BufferedReader fileReader = new BufferedReader(new FileReader(wordListFile))) {
            String line = fileReader.readLine();
            while (line != null) {
                dictionary.add(line.trim().toLowerCase());
                line = fileReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanDictionaryForWordsWhichAreComposites() {
        for (String word : dictionary) {
            if (word.length() == WORD_LENGTH_TO_CHECK) {
                scanCompositeOf2Words(word);
            }
        }
    }

    private void scanCompositeOf2Words(String word) {
        for (int i = 2; i < word.length()-1; i++) {
            String firstSubString = word.substring(i);
            String secondSubString = word.substring(0, i);
            if (isValidWord(firstSubString) && isValidWord(secondSubString)) {
                System.out.println(firstSubString + " + " + secondSubString + " = " + word);
            }
        }
    }

    private boolean isValidWord(String word) {
        return dictionary.contains(word);
    }

    public static void main(String[] args) {
        DictionaryWordCompositeScanner dictionaryWordCompositeScanner = new DictionaryWordCompositeScanner();
        dictionaryWordCompositeScanner.loadDictionaryFromFile();
        dictionaryWordCompositeScanner.scanDictionaryForWordsWhichAreComposites();
    }
}
