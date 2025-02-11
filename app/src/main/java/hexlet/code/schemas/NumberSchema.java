package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        Predicate<Integer> required = num -> num != null;
        add("required", required);
        return this;
    }

    public NumberSchema range(int from, int to) {
        add("range", num -> num == null || (num >= from && num <= to));
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = num -> {
            if (num == null) {
                return true;  // `null` is valid
            }
            return num > 0;
        };
        add("positive", positive);
        return this;
    }


}
