import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Util;

public class UtilTest {
    @Test
    @DisplayName("toTitleCase: 'hello' -> 'Hello'")
    void testToTitleCase1() {
        String input = "hello";
        String expected = "Hello";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("toTitleCase: 'hEllO' -> 'Hello'")
    void testToTitleCase2() {
        String input = "hEllO";
        String expected = "Hello";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("toTitleCase: '' -> ''")
    void testToTitleCase3() {
        String input = "";
        String expected = "";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("toTitleCase: null -> null")
    void testToTitleCase4() {
        String input = null;
        String expected = null;
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("toTitleCase: 'hi there!' -> 'Hi There!'")
    void testToTitleCase5() {
        String input = "hi there!";
        String expected = "Hi There!";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("toTitleCase: 'aBc dE f ' -> 'Abc De F'")
    void testToTitleCase6() {
        String input = "aBc dE f ";
        String expected = "Abc De F";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected,actual);
    }
}
