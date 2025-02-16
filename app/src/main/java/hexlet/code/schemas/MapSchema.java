package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        Predicate<Map> required = map -> map != null;
        add("required", required);
        return this;
    }
  // meow
    public MapSchema sizeof(int maxSize) {
        Predicate<Map> sizeOf = map -> map != null && map.size() == maxSize;
        add("sizeof", sizeOf);
        return this;
    }

    public void shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map> mapContentTest = map -> {
            return schemas.entrySet().stream().allMatch(currentMap -> {
                String currentkey = currentMap.getKey();
                BaseSchema<String> currentSchema = currentMap.getValue();
                return currentSchema.isValid((String) map.get(currentkey));
            });
        };
        add("mapContentTest", mapContentTest);
    }

}
