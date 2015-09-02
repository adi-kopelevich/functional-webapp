package sample.reflection.parsing.json;

import sample.reflection.parsing.json.constants.JsonTokens;

/**
 * Created by kopelevi on 02/09/2015.
 */
public class JsonField {


    private String key;
    private Object val;

    public JsonField(String key, Object val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer newVal = new StringBuffer("");
        if (val instanceof String) {
            newVal.append(JsonTokens.JSON_STRING_TOKEN).append(val).append(JsonTokens.JSON_STRING_TOKEN);
        } else {
            newVal.append(val);
        }
        return new StringBuffer().append(JsonTokens.JSON_STRING_TOKEN).append(key).append(JsonTokens.JSON_STRING_TOKEN)
                .append(JsonTokens.JSON_FIELD_KEY_VAL_SEPERATOR)
                .append(newVal).toString();

    }
}
