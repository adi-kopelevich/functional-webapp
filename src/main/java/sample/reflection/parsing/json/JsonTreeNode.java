package sample.reflection.parsing.json;

import sample.reflection.parsing.json.constants.JsonTokens;

/**
 * Created by kopelevi on 02/09/2015.
 */
public class JsonTreeNode {


    private String key;
    private Object val;

    public JsonTreeNode(String key, Object val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer newVal = new StringBuffer("");
        if (val instanceof JsonTreeNode) {
            newVal.append(JsonTokens.JSON_START_BARACKET).append(val.toString()).append(JsonTokens.JSON_END_BARCKET);
        } else if (val instanceof String) {
            newVal.append(JsonTokens.JSON_STRING_TOKEN).append(val).append(JsonTokens.JSON_STRING_TOKEN);
        } else if (val instanceof Object[]) { //array
            newVal.append(JsonTokens.JSON_START_ARRAY_TOKEN);
            for (Object o : (Object[]) val) {
                if (o instanceof String) {
                    newVal.append(JsonTokens.JSON_STRING_TOKEN).append(o.toString()).append(JsonTokens.JSON_STRING_TOKEN);
                } else {
                    newVal.append(o.toString());
                }
                newVal.append(JsonTokens.JSON_FIELD_SEPERATOR);
            }
            int startInd = newVal.lastIndexOf(JsonTokens.JSON_FIELD_SEPERATOR);
            newVal.replace(startInd, startInd + 1, JsonTokens.JSON_END_ARRAY_TOKEN);
        } else { //int value
            newVal.append(val);
        }
        return new StringBuffer().append(JsonTokens.JSON_STRING_TOKEN).append(key).append(JsonTokens.JSON_STRING_TOKEN)
                .append(JsonTokens.JSON_FIELD_KEY_VAL_SEPERATOR)
                .append(newVal).toString();

    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

//
//    public JsonTreeNode pareseFromString(String jsonString) {
//        if (isNumeric(jsonString)) {            // simple number
//            return JsonTreeNode(jsonString)
//        } else if (String.valueOf(jsonString.charAt(0)).equals("\"")) {  //simple string without ":"
//            return JsonTreeNode(jsonString)
//        } else if {)  //compund string "" : ""
//            return JsonKeyValueTreeNode(pareseFromString(firstStr), pareseFromString(secondStr))
//
//        }else if () {// compond array
//            String[] arrayObj = splitByArraySepearotr
//            JsonTreeNode[] JsonTreeNodeArray = new JsonTreeNode[];
//            for (String s : arrayObj) {
//                JsonTreeNodeArray[i] = pareseFromString(s);
//            }
//            return JsonArrayTreeNode(JsonTreeNodeArray);
//        } else if(Json) { // json tree
//            split by
//            return newJsonBarcketNode()
//        }
//    }

}
