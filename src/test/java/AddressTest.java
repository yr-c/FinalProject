import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Address;

public class AddressTest {
    @Test
    @DisplayName("isPostalCodeValid: 'A1B2C3' -> true")
    void testIsPostalCodeValid() {
        String input = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected,actual);
    }
}
