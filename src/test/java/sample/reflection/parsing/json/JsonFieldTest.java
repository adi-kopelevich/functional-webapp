package sample.reflection.parsing.json;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by kopelevi on 02/09/2015.
 */
public class JsonFieldTest {

    public JsonFieldTest() {

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void initCalculator() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void whenGivenFiledKeyAndValuenReturnJsonFieldRepresentation() {

        String fieldKeyId = "fieldKeyId";
        String fieldKeyValue = "fieldKeyValue";
        String targetJson = "\"" + fieldKeyId + "\":\"" + fieldKeyValue + "\"";
        JsonField jsonField = new JsonField(fieldKeyId, fieldKeyValue);
        Assert.assertEquals(jsonField.toString(), targetJson);
    }

}
