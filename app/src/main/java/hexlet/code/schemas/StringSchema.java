package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends AbstractScheme<String> {

    public StringSchema minLength(int minimum) {
        Predicate<String> minLength = str -> str.length() > minimum;
        add("minlength", minLength);
        return this;
    }

    public StringSchema contains(String something) {
        Predicate<String> contains = str -> str.contains(something);
        add("contains", contains);
        return this;
    }

    public  StringSchema required() {
        Predicate<String> required = str -> !str.isEmpty() && str != null;
        add("required", required);
        return this;
    }
}
