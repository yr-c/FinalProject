import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Util;

public class UtilTest {
    @Test
    @DisplayName("toTitleCase: hello -> Hello")
    void testToTitleCase() {
        String input = "hello";
        String expected = "Hello";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }
}
