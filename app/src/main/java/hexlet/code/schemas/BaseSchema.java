package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> parameters = new LinkedHashMap<>();

    /**
     * Adds a validator into the parameters list.
     *
     * @param parameterName The name of the validation rule.
     * @param parameter     The predicate that defines the validation rule.
     */
    public void add(String parameterName, Predicate<T> parameter) {
        parameters.put(parameterName, parameter);
    }

    /**
     * Checks the given object against all validation rules.
     * Returns false if any rule fails.
     *
     * @param objectToTest The object to be validated.
     * @return {@code true} if the object passes all validation rules, {@code false} otherwise.
     */
    public boolean isValid(T objectToTest) {
        Set<String> keys = parameters.keySet();
        for (String key : keys) {
            Predicate<T> currentTest = parameters.get(key);
            if (!currentTest.test(objectToTest)) {
                return false;
            }
        }
        return true;
    }
}

