package sample.replace.string;

/**
 * Created by kopelevi on 17/11/2015.
 */
public class StringReplace {

    public String replace(String str, char character) {
        StringBuilder retVal = new StringBuilder().append("");
        if (str == null) {
            throw new IllegalArgumentException(MessagesUtils.GIVEN_NULL_STR);
        } else {
            for (char strChar : str.toCharArray()) {
                if (strChar != character) {
                    retVal.append(strChar);
                }
            }
        }
        return retVal.toString();
    }
}
