package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class BaseSchema<T>  {
    protected Map<String, Predicate<T>> parameters = new HashMap<>();

    public void add(String parameterName, Predicate<T> parameter) {
        parameters.put(parameterName, parameter);
    }

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
