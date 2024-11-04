/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Represents a student with a first name, last name, course, and grade.
 * Uses JavaFX properties to allow for data binding and updates.
 */
public class Student {
    // String properties for last name, first name, course, and grade.
    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty course;
    private StringProperty grade;

    /**
     * Default constructor for the Student class.
     * Initializes all properties to empty strings.
     */
    public Student() {
        this("", "", "", "");
    }

    /**
     * Constructor for the Student class.
     * Initializes the student's information with the provided values.
     *
     * @param firstName The student's first name.
     * @param lastName  The student's last name.
     * @param course   The course the student is enrolled in.
     * @param grade    The student's grade in the course.
     */
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.course = new SimpleStringProperty(course);
        this.grade = new SimpleStringProperty(grade);
    }

    /**
     * Gets the student's last name.
     *
     * @return The student's last name.
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName The new last name for the student.
     */
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    /**
     * Returns the property representing the student's last name.
     *
     * @return The StringProperty for the student's last name.
     */
    public StringProperty lastNameProperty() {
        return lastName;
    }

    /**
     * Gets the student's first name.
     *
     * @return The student's first name.
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName The new first name for the student.
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    /**
     * Returns the property representing the student's first name.
     *
     * @return The StringProperty for the student's first name.
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }

    /**
     * Gets the course the student is enrolled in.
     *
     * @return The course name.
     */
    public String getCourse() {
        return course.get();
    }

    /**
     * Sets the course the student is enrolled in.
     *
     * @param course The new course name.
     */
    public void setCourse(String course) {
        this.course.set(course);
    }

    /**
     * Returns the property representing the course the student is enrolled in.
     *
     * @return The StringProperty for the course name.
     */
    public StringProperty courseProperty() {
        return course;
    }

    /**
     * Gets the student's grade in the course.
     *
     * @return The student's grade.
     */
    public String getGrade() {
        return grade.get();
    }

    /**
     * Sets the student's grade in the course.
     *
     * @param grade The new grade for the student.
     */
    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    /**
     * Returns the property representing the student's grade.
     *
     * @return The StringProperty for the student's grade.
     */
    public StringProperty gradeProperty() {
        return grade;
    }

    /**
     * Returns a string representation of the Student object.
     *
     * @return A string containing the student's information.
     */
    @Override
    public String toString() {
        return "Student{" +
                "lastName=" + lastName +
                ", firstName=" + firstName +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}
