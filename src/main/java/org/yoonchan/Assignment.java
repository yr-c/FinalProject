package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight; // the sum of weights of all assignment should be 100
    private ArrayList<Integer> scores;
    private static int nextId;

    public Assignment(ArrayList<Integer> scores, double weight, String assignmentName) {
        this.scores = scores;
        this.weight = weight;
        this.assignmentName = assignmentName;
        this.assignmentId = String.format("%04d", nextId++);
    }

    /**
     * Calculates the average score for the assignment.
     */
    public void calcAssignmentAvg() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println("Average score: " + (sum / scores.toArray().length));
    }

    /**
     * Generates random scores for all students in an assignment,
     * the scores are generated with the following rule: <p>
     * Firstly generate a random number in range [0, 10], then <br>
     * - if the number is 0, then generate a random score in range [0, 60) for the student; <br>
     * - if the number is 1, 2, then generate a random score in range [60, 70) for the student; <br>
     * - if the number is 3, 4, then generate a random score in range [70, 80) for the student; <br>
     * - if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student; <br>
     * - if the number is 9, 10, then generate a random score in range [90, 100] for the student;
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.toArray().length; i++) {
            switch (random.nextInt(0, 11)) {
                case 0 -> scores.add(i, random.nextInt(0, 60));
                case 1, 2 -> scores.add(i, random.nextInt(60, 70));
                case 3, 4 -> scores.add(i, random.nextInt(70, 80));
                case 5, 6, 7, 8 -> scores.add(i, random.nextInt(80, 90));
                case 9, 10 -> scores.add(i, random.nextInt(90, 101));
            }
        }
    }
}
