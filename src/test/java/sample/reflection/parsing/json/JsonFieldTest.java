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

    //"fieldKeyId":"fieldKeyValue"
    @Test
    public void whenGivenFiledKeyAndValuenReturnJsonFieldRepresentation() {
        String fieldKeyId = "fieldKeyId";
        String fieldKeyValue = "fieldKeyValue";
        String targetJson = "\"" + fieldKeyId + "\":\"" + fieldKeyValue + "\"";
        JsonField jsonField = new JsonField(fieldKeyId, fieldKeyValue);
        Assert.assertEquals(jsonField.toString(), targetJson);
    }

    //"fieldKeyId":777
    @Test
    public void whenGivenIntValuenReturnJsonFieldIntRepresentation() {
        String fieldKeyId = "fieldKeyId";
        int fieldKeyValue = 777;
        String targetJson = "\"" + fieldKeyId + "\":" + fieldKeyValue;
        JsonField jsonField = new JsonField(fieldKeyId, fieldKeyValue);
        Assert.assertEquals(jsonField.toString(), targetJson);
    }

    //"fieldKeyId":[1, 2, "3", 4, "5"]
    @Test
    public void whenGivenArrayReturnJsonArrayRepresentation() {
        String fieldKeyId = "fieldKeyId";
        Object[] fieldKeyValue = {1, 2, "3", 4, "5"};
        String targetJson = "\"" + fieldKeyId + "\":" + "[1,2,\"3\",4,\"5\"]";
        JsonField jsonField = new JsonField(fieldKeyId, fieldKeyValue);
        Assert.assertEquals(targetJson, jsonField.toString());
    }

    //"fieldKeyId":{"key1":"val1"}
    @Test
    public void whenGivenFiledOfFieldsReturnJsonJsonHirarchyRepresentation() {
        String fieldKey = "fieldKey";
        String innerfieldKey = "innerFieldKey";
        String innerfieldValue = "innerfieldValue";
        String targetJson = "\"" + fieldKey + "\":{" + "\"" + innerfieldKey + "\":\"" + innerfieldValue + "\"" + "}";
        JsonField jsonField = new JsonField(fieldKey, new JsonField(innerfieldKey, innerfieldValue));
        Assert.assertEquals(targetJson, jsonField.toString());
    }

}
