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
    private ArrayList<Integer> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department, ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = new ArrayList<>();
    }

    @Override
    public String toString() {
        String studentDetails = "";

        for (Student student : registeredStudents) {
            studentDetails += '{' + student.getStudentId() + ", ";
            studentDetails += student.getStudentName() + ", ";
            studentDetails += student.getDepartment().getDepartmentName() + "}, ";
        }

        String courseDetails = "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                '}';

        return courseDetails + ", registeredStudents=" + studentDetails + "\b\b}"; // Backspaces the redundant "}," at the end of string.
    }

    /**
     * Converts a course to a simple string with only the courseId, courseName, credits, and departmentName.
     * @return The simple string with only the courseId, courseName, credits, and departmentName.
     */
    public String toSimplifiedString() {
        return String.format("{%s, %s, %f, %s}\n", courseId, courseName, credits, department.getDepartmentName());
    }

    /**
     * Checks if the sum of weights of all assignments of that course equals to 100.
     * @return Whether the assignment weight is valid.
     */
    public boolean isAssignmentWeightValid(boolean isLastAssignment) {
        double sum = 0;

        if (isLastAssignment) {
            for (Assignment assignment : assignments) {
                sum += assignment.getWeight();
            }
            return sum == 100;
        }
        return true;
    }

    /**
     * Adds a student to the student list of the course.
     * <p>
     * Also adds a new null element to each assignment of this course, and adds a new null element for the finalScores list.
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

        finalScores.add(null);

        return true;
    }

    /**
     * Calculates the weighted average score of the students in the course.
     * @return The weighted averages score of the students in the course, in an int array.
     */
    public int[] calcStudentsAverage() {
        int[] studentAverages = new int[this.getRegisteredStudents().size()];

        // For every student
        for (int i = 0; i < this.registeredStudents.size(); i++) {
            double cumulatedGrade = 0;

            // For every assignment
            for (Assignment currentIterationAssignment : this.assignments) {

                if (i < currentIterationAssignment.getScores().size()) {
                    Integer score = currentIterationAssignment.getScores().get(i);

                    if (score != null) {
                        double weight = currentIterationAssignment.getWeight();
                        int maxScore = currentIterationAssignment.getMaxScore();

                        double percentageScore = (score / (double) maxScore);
                        double weightedContribution = percentageScore * (weight / 100d);
                        cumulatedGrade += weightedContribution * 100;
                    }
                }
            }
            studentAverages[i] = (int) cumulatedGrade;
        }

        return studentAverages;
    }

    /**
     * Adds a new assignment to the course.
     * @param assignmentName The assignment to be added.
     * @param weight The weight of the assignment to be added (0-100).
     * @param maxScore The maximum score of the exam. <br>
     *        (e.g. A quiz /10 would mean a max score of 10.)
     * @return Whether the assignment was successfully added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore, boolean isLastAssignment) {

        ArrayList<Integer> scores = new ArrayList<>();
        for (Student student : this.registeredStudents) {
            scores.add(null);
        }

        Assignment newAssignment = new Assignment(assignmentName, scores, weight, maxScore);

        this.assignments.add(newAssignment);
        if (!this.isAssignmentWeightValid(isLastAssignment)) {
            assignments.removeLast();
            return false;
        }

        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student.
     * Prints the result.
     */
    public void generateScores() {
        for (Assignment assignment : this.assignments) {
            assignment.generateRandomScore();
        }

        int[] weightedAverages = this.calcStudentsAverage();
        this.finalScores.clear();

        for (int score : weightedAverages) {
            this.finalScores.add(score);
        }

        System.out.println("Final scores in " + this.courseName + " class: " + this.finalScores);
    }

    /**
     * Displays the scores of a course in a table, with the assignment averages and student weighted average.
     * <p>
     * - The table header will be the course name. <br>
     * - The rows will be the students. <br>
     * - The last row will be the average of all students. <br>
     * - The column will be the assignments. <br>
     * - The last column will be the final score.
     */
    public void displayScores() {
        if (this.assignments.isEmpty() && this.registeredStudents.isEmpty()) {
            System.out.println("Nothing to show.");
            return;
        }

        // Printing header row
        System.out.printf("Course: %s(%s)\n\t\t\t\s\s", this.courseName, this.courseId);

        int nameWidth = 14;
        int colWidth = 15;

        for (Assignment assignment : this.assignments) {
            System.out.printf("%-" + colWidth + "s", assignment.getAssignmentName());
        }
        System.out.printf("%-" + colWidth + "s\n", "Final Score");

        // Printing student rows
        for (int i = 0; i < this.registeredStudents.size(); i++) {
            System.out.printf("%-" + nameWidth + "s", this.registeredStudents.get(i).getStudentName());

            for (Assignment assignment : this.assignments) {
                Integer score = assignment.getScores().get(i);
                String scoreString = (score != null) ? String.valueOf(score) : "-";
                System.out.printf("%-" + colWidth + "s", scoreString);
            }

            System.out.printf("%-" + colWidth + "d\n", this.finalScores.get(i));
        }

        // Printing assignment average row
        System.out.printf("%-14s", "Average");
        for (Assignment assignment : this.assignments) {
            System.out.printf("%-" + colWidth + "d", (int) assignment.calcAssignmentAvg());
        }
    }
}
