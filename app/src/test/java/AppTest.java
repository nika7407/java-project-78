
import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public final class AppTest {

    @Test
    public void testAlwaysTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    public void testString() {
        Validator v = new Validator();
        var test = v.string().required().minLength(20)
                .minLength(5).contains("hex");

        var test1 = v.string();
        assertTrue(test1.isValid(null));
        assertTrue(test.isValid("hexlet"));
        assertTrue(test1.isValid(""));
        assertFalse(test1.required().isValid(""));
        assertFalse(test.isValid("IHATEJAVA"));
        assertTrue(test1.contains("HATE").isValid("IHATEJAVA"));

    }

    @Test
    public void testInteger() {
        Validator v = new Validator();
        var test = v.number();


        assertTrue(test.isValid(null));
        assertTrue(test.range(5, 10).isValid(7));
        assertFalse(test.range(5, 10).isValid(42));
        assertTrue(test.positive().isValid(10));
        assertFalse(test.positive().isValid(-42));
        assertTrue(test.positive().isValid(null));
        assertFalse(test.required().isValid(null));
    }

    @Test
    public void testMap() {
        var v = new Validator();
        var schema = v.map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");

        assertTrue(schema.isValid(null));
        assertFalse(schema.required().isValid(null));
        assertTrue(schema.sizeof(2).isValid(data));
    }


    @Test
    public void testMapShape() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);


        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));


        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));
    }


}
