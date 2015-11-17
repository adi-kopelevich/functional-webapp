package sample.code.kata;

import java.util.*;

/**
 * Created by kopelevi on 17/11/2015.
 * m - length of single word
 * n - size of word set
 * O(n * m log(m))
 */
public class AnagramsFinder {

    public Map<String, Set<String>> getAnagrams(Set<String> words) {
        long startTime = System.currentTimeMillis();
        if (words == null || words.size() == 0) {
            throw new IllegalArgumentException("Expected set of strings but got: " + words);
        }

        int biggestAnagramSetSize = 0;
        String biggestAnagramSetKey = "";
        Map<String, Set<String>> anagramsMap = new HashMap<String, Set<String>>();
        for (String word : words) {
            String key = sortWord(word); // O(m log(m))
            Set<String> anagramSetForKey = anagramsMap.get(key);
            if (anagramSetForKey == null) {
                anagramSetForKey = new HashSet<>();
            }
            anagramSetForKey.add(word);
            anagramsMap.put(key, anagramSetForKey);
            if (anagramSetForKey.size() > biggestAnagramSetSize) {
                biggestAnagramSetSize = anagramSetForKey.size();
                biggestAnagramSetKey = key;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Set of anagrams containing the most words: " + anagramsMap.get(biggestAnagramSetKey));
        System.out.println("Total execution time [ms]: " + String.valueOf(endTime - startTime));

        return anagramsMap;
    }

    private String sortWord(String word) {
        char[] wordBytes = word.toCharArray();
        Arrays.sort(wordBytes);
        return String.valueOf(wordBytes);
    }
}
