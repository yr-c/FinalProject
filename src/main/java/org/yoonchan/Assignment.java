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
    private ArrayList<Integer> scores;
    private double weight;
    private int maxScore;
    private static int nextId = 1;

    public Assignment(String assignmentName, ArrayList<Integer> scores, double weight, int maxScore) {
        this.assignmentId = String.format("%04d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = scores;
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore + '}';
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
     * the scores are generated with the following rule:
     * <p>
     * Firstly generate a random number in range [0, 10], then <br>
     * - if the number is 0, then generate a random score in range [0, 60) for the student; <br>
     * - if the number is 1, 2, then generate a random score in range [60, 70) for the student; <br>
     * - if the number is 3, 4, then generate a random score in range [70, 80) for the student; <br>
     * - if the number is 5, 6, 7, 8, then generate a random score in range [80, 90) for the student; <br>
     * - if the number is 9, 10, then generate a random score in range [90, 100] for the student.
     * <p>
     * All scores are generated as a relative percentage with respect to the assignment's maxScore.
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            switch (random.nextInt(0, 11)) {
                case 0 -> {
                    int score = (int) (random.nextDouble(0, 0.6) * this.maxScore);
                    scores.set(i, score);
                }
                case 1, 2 -> {
                    int score = (int) (random.nextDouble(0.6, 0.7) * this.maxScore);
                    scores.set(i, score);
                }
                case 3, 4 -> {
                    int score = (int) (random.nextDouble(0.7, 0.8) * this.maxScore);
                    scores.set(i, score);
                }
                case 5, 6, 7, 8 -> {
                    int score = (int) (random.nextDouble(0.8, 0.9) * this.maxScore);
                    scores.set(i, score);
                }
                case 9, 10 -> {
                    int score = (int) (random.nextDouble(0.9, 1 + Double.MIN_VALUE) * this.maxScore);
                    scores.set(i, score);
                }
            }
        }
    }
}
