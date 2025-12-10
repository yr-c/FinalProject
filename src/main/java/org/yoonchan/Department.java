package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;
        }

        this.departmentId = String.format("D%02d", nextId++);
        this.departmentName = Util.toTitleCase(departmentName);
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
            if (!(Character.isSpaceChar(c) || Character.isLetter(c))) {
                return false;
            }
        }
        return true;
    }
}
