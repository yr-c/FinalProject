package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department, ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
    }

    /**
     * Checks if the sum of weights of all assignments of that course equals to 100%.
     * @return Whether the assignment weight is valid.
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum == 100;
    }

    /**
     * Adds a student to the student list of the course.
     * Also adds a new null element to each assignment of this course, and add a new null element for the finalScores.
     * @param student The student to be registered.
     * @return Whether the student has successfully been registered.
     */
    public boolean registerStudent(Student student) {
        if (this.registeredStudents.contains(student)) {
            return false;
        }

        this.registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }
}
