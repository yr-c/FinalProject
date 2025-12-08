package org.yoonchan;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Assignment {
    private String assignmentId; // This id should be increased automatically.
    private String assignmentName;
    private double weight; // the sum of weights of all assignment should be 100
    private ArrayList<Integer> scores;
    private static int nextId; // indicates the next ID that will be used
}
