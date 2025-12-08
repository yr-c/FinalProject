import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yoonchan.Department;

public class DepartmentTest {
    @Test
    @DisplayName("isDepartmentNameValid: 'Mathematics' -> true")
    void testIsDepartmentNameValid1() {
        String input = "Mathematics";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: 'Computer Science' -> true")
    void testIsDepartmentNameValid2() {
        String input = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: 'Commerce$' -> false")
    void testIsDepartmentNameValid3() {
        String input = "Commerce$";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: '?' -> false")
    void testIsDepartmentNameValid4() {
        String input = "?";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: 'Computer_science' -> false")
    void testIsDepartmentNameValid5() {
        String input = "Computer_science";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: ' History ' -> true")
    void testIsDepartmentNameValid6() {
        String input = " History ";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: '' -> false")
    void testIsDepartmentNameValid7() {
        String input = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: ' ' -> false")
    void testIsDepartmentNameValid8() {
        String input = " ";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: null -> false")
    void testIsDepartmentNameValid() {
        String input = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected,actual);
    }
}
