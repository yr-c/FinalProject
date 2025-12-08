import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Department;
import org.yoonchan.Util;

public class DepartmentTest {
    @Test
    @DisplayName("isDepartmentNameValid: 'Mathematics' -> true")
    void testIsDepartmentNameValid() {
        String input = "Mathematics";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }
}
