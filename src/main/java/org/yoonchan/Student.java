package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<Course>();
    }

    /**
     * Registers a course. This method: <p>
     * 1. Adds the course to the student's registeredCourses list, <br>
     * 2. Adds the student to the course's registeredStudents list, <br>
     * 3. appends a null for the scores of each assignment of the course. <p>
     * If the course is already registered (exists in the student's registeredCourses list), directly returns false
     * without adding anything.
     * @param course The course to be added to the student.
     * @return Whether the course had successfully been added to the student.
     */
    public boolean registerCourse(Course course) {
        if (this.registeredCourses.contains(course)) {
            return false;
        }

        this.registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * Converts a student to a simple string with only the studentId, the studentName, and departmentName.
     * @return The simplified string with studentId, the studentName, and departmentName.
     */
    public String toSimplifiedString() {
        return String.format("%s, %s, %s", studentId, studentName, department.getDepartmentName());
    }

    /**
     * Drops a course. This method:
     * <p>
     * 1. Removes the course from the student's registeredCourses list, <br>
     * 2. Removes the student from the course's registeredStudents list.
     * <p>
     * If the course is not registered yet (not in the student's registeredCourses list), directly returns
     * false without removing anything.
     * @param course The course to be removed.
     * @return Whether the course has successfully been removed.
     */
    public boolean dropCourse(Course course) {
        if (!this.registeredCourses.contains(course)) {
            return false;
        }

        this.registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }
}
