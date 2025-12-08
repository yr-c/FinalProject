import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Address;

public class AddressTest {
    @Test
    @DisplayName("isPostalCodeValid: 'A1B2C3' -> true")
    void testIsPostalCodeValid1() {
        String input = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'AAB2C3' -> false")
    void testIsPostalCodeValid2() {
        String input = "AAB2C3";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'a1b2c3' -> true")
    void testIsPostalCodeValid3() {
        String input = "a1b2c3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'A1B2C3D4' -> false")
    void testIsPostalCodeValid4() {
        String input = "A1B2C3D4";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'A1B2C$' -> false")
    void testIsPostalCodeValid5() {
        String input = "A1B2C$";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'A1 B2C3' -> false")
    void testIsPostalCodeValid6() {
        String input = "A1 B2C3";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'A B2C3' -> false")
    void testIsPostalCodeValid7() {
        String input = "A B2C3";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'B9R0P2' -> true")
    void testIsPostalCodeValid8() {
        String input = "B9R0P2";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 'Q4RM2M' -> false")
    void testIsPostalCodeValid9() {
        String input = "Q4RM2M";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: ' ' -> false")
    void testIsPostalCodeValid10() {
        String input = " ";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: '' -> false")
    void testIsPostalCodeValid11() {
        String input = "";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: null -> false")
    void testIsPostalCodeValid12() {
        String input = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }
}
