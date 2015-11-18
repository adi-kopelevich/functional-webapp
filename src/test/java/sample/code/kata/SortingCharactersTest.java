package sample.code.kata;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class SortingCharactersTest {

    @Test
    public void whenGivenTextThenReturnASortedStringWithTheTextChars() {
        String text = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";
        String expectedResult = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";
        String sortedChars = new SortingCharacters().sortCharsInText(text);
        Assert.assertEquals(expectedResult, sortedChars);
    }
}
