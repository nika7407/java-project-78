package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        Predicate<Map> required = map -> map != null;
        add("required", required);
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        Predicate<Map> sizeOf = map -> map != null && map.size() == maxSize;
        add("sizeof", sizeOf);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        this.schemas = new HashMap<>(schemas);
    }

    @Override
    public boolean isValid(Map mapToTest) {

        if (!super.isValid(mapToTest)) {
            return false;
        }

        if (mapToTest == null) {
            return true;
        }
        for (Map.Entry<String, BaseSchema<String>> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema<String> schema = entry.getValue();
            String value = (String) mapToTest.get(key);

            if (!schema.isValid(value)) {
                return false;
            }
        }

        return true;
    }
}
