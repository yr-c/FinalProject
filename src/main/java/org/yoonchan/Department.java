package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentId, String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("%04d", nextId++);
            this.departmentName = departmentName;
        }
        this.departmentId = null;
        this.departmentName = null;
    }

    /**
     * Checks if a department name is valid. A department name is valid when it contains only letters and/or spaces.
     * @param departmentName The input department name to be checked.
     * @return Whether the department name is valid.
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return false;
        }
        for (char c : departmentName.toCharArray()) {
            // 32 = space, 65 = A, 90 = Z, 97 = a, 122 = z
            if (!(c == 32 || c >= 65 && c <= 90 || c >= 97 && c <= 122)) {
                return false;
            }
        }
        return true;
    }
}
