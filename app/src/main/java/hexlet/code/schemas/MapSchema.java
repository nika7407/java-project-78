package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        Predicate<Map> required = map -> map != null;
        add("required", required);
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        Predicate<Map> sizeOf = map ->  map.size() <= maxSize;
        add("sizeof", sizeOf);
        return this;
    }

}
