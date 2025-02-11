package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int minimum) {
        Predicate<String> minLength = str -> str == null || str.length() > minimum;
        add("minlength", minLength);
        return this;
    }

    public StringSchema contains(String something) {
        Predicate<String> contains = str -> str != null && str.contains(something);
        add("contains", contains);
        return this;
    }

    public  StringSchema required() {
        Predicate<String> required = str -> str != null && !str.isEmpty();
        add("required", required);
        return this;
    }
}
