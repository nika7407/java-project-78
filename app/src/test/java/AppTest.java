
import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        assertTrue(test.isValid("hexlet"));
        assertTrue(test1.isValid(""));
        assertFalse(test1.required().isValid(""));
        assertFalse(test.isValid("IHATEJAVA"));
        assertTrue(test1.contains("HATE").isValid("IHATEJAVA"));

    }

    @Test
    public void testInteger(){
        Validator v = new Validator();
        var test = v.number();



        assertTrue(test.isValid(null));
        assertFalse(test.required().isValid(null));
        assertTrue(test.range(5,10).isValid(7));
        assertFalse(test.range(5,10).isValid(42));
        assertTrue(test.positive().isValid(10));
        assertFalse(test.positive().isValid(-42));
        assertTrue(test.positive().isValid(null));
    }



}
