package sample.reflection.parsing.json;

/**
 * Created by kopelevi on 02/09/2015.
 */
public class JsonField {


    private String key;
    private String val;

    public JsonField(String key, String val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return new StringBuffer().append(JsonTokens.JSON_STRING_TOKEN).append(key).append(JsonTokens.JSON_STRING_TOKEN)
                .append(JsonTokens.JSON_FIELD_KEY_VAL_SEPERATOR)
                .append(JsonTokens.JSON_STRING_TOKEN).append(val).append(JsonTokens.JSON_STRING_TOKEN).toString();
    }
}
