package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public abstract class BaseSchema<T>  {
    protected Map<String, Predicate<T>> parameters = new HashMap<>();
    protected Map<String, BaseSchema<String>> schemas = new HashMap<>();

    /**
     * Adds a validators into the parameters list
     *
     *
     */
    public void add(String parameterName, Predicate<T> parameter) {
        parameters.put(parameterName, parameter);
    }


    /**
     *
     * checks T object with every validator in the parameters returns false
     * when one of them is wrong
     *
     */
    public boolean isValid(T objectToTest) {
        Set<String> keys = parameters.keySet();
        for (String key : keys) {
            Predicate currentTest = parameters.get(key);
            if (!currentTest.test(objectToTest)) {
                return false;
            }
        }
        return true;
    }


}
