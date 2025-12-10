package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

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
}
