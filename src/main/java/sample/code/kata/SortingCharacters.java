package sample.code.kata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class SortingCharacters {

    public String sortCharsInText(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {

            Map<String, Integer> charsBuckets = new HashMap<>();
            BufferedReader stringReader = new BufferedReader(new StringReader(str));
            String line = stringReader.readLine();
            while (line != null) {
                line = line.toLowerCase().replaceAll("[^a-z]", "");
                for (char ch : line.toCharArray()) {
                    Integer charCount = charsBuckets.get(String.valueOf(ch));
                    charsBuckets.put(String.valueOf(ch), charCount == null ? 1 : charCount + 1);
                }
                line = stringReader.readLine();
            }
            for (String ch : charsBuckets.keySet()) {
                int numOfRep = charsBuckets.get(ch);
                char[] chars = new char[numOfRep];
                Arrays.fill(chars, ch.toCharArray()[0]);
                stringBuilder.append(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
