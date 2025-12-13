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
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
        this.finalScores = new ArrayList<>();
    }

    /**
     * Checks if the sum of weights of all assignments of that course equals to 100.
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

                        double percentageScore = ((double) score / maxScore);
                        double weightedContribution = percentageScore * (weight / 100d);
                        cumulatedGrade += weightedContribution;
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
     * @param maxScore The maximum score of the exam. (e.g. A quiz /10 would mean a max score of 10.)
     * @return Whether the assignment was successfully added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment newAssignment = new Assignment(assignmentName, new ArrayList<Integer>(), weight, maxScore);

        this.assignments.add(newAssignment);
        if (!this.isAssignmentWeightValid()) {
            assignments.removeLast();
            return false;
        }

        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student. Prints the result.
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
}
