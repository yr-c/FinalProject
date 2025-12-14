# Final project

### Author: Yoonchan Rhie
#### *Vanier ID: 2549299*

This is the final project for the Introduction to Programming course
at Vanier college. It is an object-oriented Java application 
designed to simulate a basic management system for students, courses, and assignments 
in a college setting.

## Features
The system is built upon a relational model managing six core components:

- **Student Registration:** Allows students to register for and drop courses, 
ensuring synchronization between student and course records.

- **Data Validation:** Implements strict checks for data integrity, 
particularly for Canadian postal codes (CDCDCD format) and department/student IDs.

- **Assignment Grading:** Manages assignment weights and generates random scores 
based on a specified probability distribution.

- **Weighted Average Calculation:** Automatically calculates the final course 
score for each student based on the weighted contributions of all assignments.

- **Score Display:** Displays course scores, including individual student 
grades and assignment averages, in a cleanly formatted, aligned table.

- **Utility Methods:** Includes a utility class (Util) for common string formatting 
(Title Case conversion).

## Class structure
The project is structured into six core classes and two enumerations (`Gender` and `Province`).

| Class      | Description                                                                                  |
|------------|----------------------------------------------------------------------------------------------|
| Address    | Holds street, city, province, and postal code data.                                          |
| Department | Manages unique department identification.                                                    |
| Student    | Represents a student with personal details and course enrollment.                            |
| Assignment | Defines an assignment with a weight, name, and maximum score.                                |
| Course     | Manages assignments and student enrollment for a specific subject.                           |
| Util       | A static class containing the toTitleCase method used for formatting names in other classes. |

| Enum     | Contains                                |
|----------|-----------------------------------------|
| Gender   | MALE, FEMALE                            |
| Province | AB, BC, MB, NB, NL, NS, ON, PE, QC, SK  |
