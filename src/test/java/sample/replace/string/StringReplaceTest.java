package sample.replace.string;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class StringReplaceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {

    }

    @Test
    public void whenGivenNullStringThenIllegalArgThrown() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(MessagesUtils.GIVEN_NULL_STR);
        String str = null;
        char character = (char) (new Random().nextInt(26) + 'a');
        new StringReplace().replace(str, character);
    }

    @Test
    public void whenGivenEmptyStringThenReturnEmptyString() {
        String str = "";
        char character = (char) (new Random().nextInt(26) + 'a');
        String updatedStr = new StringReplace().replace(str, character);
        Assert.assertEquals("", updatedStr);
    }

    @Test
    public void whenGivenStringThatDosentContainGivenCharThenReturnTheGivenString() {
        String str = "abcdefghijklmnopqrstuvwxy";
        char character = 'z';
        String updatedStr = new StringReplace().replace(str, character);
        Assert.assertEquals(str, updatedStr);
    }

    @Test
    public void whenGivenStringThatContainGivenCharThenReturnTheStringWithoutTheGivenChar() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        char character = 'k';
        String expectedResult = str.replaceAll(String.valueOf(character), "");
        String updatedStr = new StringReplace().replace(str, character);
        Assert.assertEquals(expectedResult, updatedStr);
    }

    @Test
    public void whenGivenStringThatContainGivenCharMultipleThenReturnTheStringWithoutTheGivenChar() {
        String str = "abcdabcdabcd";
        char character = 'c';
        String expectedResult = str.replaceAll(String.valueOf(character), "");
        String updatedStr = new StringReplace().replace(str, character);
        Assert.assertEquals(expectedResult, updatedStr);
    }
}
