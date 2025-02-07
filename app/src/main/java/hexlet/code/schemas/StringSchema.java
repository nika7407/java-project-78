package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class StringSchema {
    protected Map<String, Predicate<String>> parameters = new  HashMap<>();

    public StringSchema minLength(int minimum) {
        Predicate<String> minLength = str -> str.length() > minimum;
        parameters.put("minlength", minLength);
        return this;
    }

    public StringSchema contains(String something) {
        Predicate<String> contains = str -> str.contains(something);
        parameters.put("contains", contains);
        return this;
    }

    public  StringSchema required() {
        Predicate<String> required = str -> !str.isEmpty() && str != null;
        parameters.put("required", required);
        return this;
    }

    public boolean isValid(String textToTest) {
        Set<String> keys = parameters.keySet();
        for (String key : keys) {
            Predicate currentTest = parameters.get(key);
            if (!currentTest.test(textToTest)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }




}
