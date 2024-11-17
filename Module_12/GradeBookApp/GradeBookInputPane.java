/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;

/**
 * Provides a grid pane for user input to adding and clearing form
 */
public class GradeBookInputPane extends GridPane {
    //Textfields for user input of a new grade
    private TextField firstNameField, lastNameField, courseField;
    //ComboBox for selecting a letter grade
    private ComboBox<String> gradeComboBox;
    //Labels to display error messages
    private Label firstNameErrorLabel, lastNameErrorLabel, courseErrorLabel, gradeErrorLabel, generalErrorLabel;

    /**
     * Constructor for GradeBookInputPane
     */
    public GradeBookInputPane() {
        super();
        //Initialize text fields
        firstNameField = new TextField();
        lastNameField = new TextField();
        courseField = new TextField();
        //Initialize combobox with letter grades
        gradeComboBox = new ComboBox<>(FXCollections.observableArrayList("A", "B", "C", "D", "F"));

        //Initialize error labels
        firstNameErrorLabel = new Label();
        firstNameErrorLabel.setTextFill(Color.RED);
        lastNameErrorLabel = new Label();
        lastNameErrorLabel.setTextFill(Color.RED);
        courseErrorLabel = new Label();
        courseErrorLabel.setTextFill(Color.RED);
        gradeErrorLabel = new Label();
        gradeErrorLabel.setTextFill(Color.RED);
        generalErrorLabel = new Label();
        generalErrorLabel.setTextFill(Color.RED);
        //Hide the error labels when text is blank
        firstNameErrorLabel.setText("");
        firstNameErrorLabel.setVisible(false); // Hide the label when it's empty
        firstNameErrorLabel.managedProperty().bind(firstNameErrorLabel.visibleProperty());

        lastNameErrorLabel.setText("");
        lastNameErrorLabel.setVisible(false); // Hide the label when it's empty
        lastNameErrorLabel.managedProperty().bind(lastNameErrorLabel.visibleProperty());

        courseErrorLabel.setText("");
        courseErrorLabel.setVisible(false); // Hide the label when it's empty
        courseErrorLabel.managedProperty().bind(courseErrorLabel.visibleProperty());

        gradeErrorLabel.setText("");
        gradeErrorLabel.setVisible(false); // Hide the label when it's empty
        gradeErrorLabel.managedProperty().bind(gradeErrorLabel.visibleProperty());

        generalErrorLabel.setText("");
        generalErrorLabel.setVisible(false);
        generalErrorLabel.managedProperty().bind(generalErrorLabel.visibleProperty());
        try {
            //Load lists from file
            GradeBookListManager.reloadLists();
        } catch (IOException e) {
            setErrorLabel("Unable to load grades from file");
            e.printStackTrace();
        }

        //Set padding and spacing
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

        //Add first name label
        this.add(new Label("First Name:"), 0, 0);
        //Add first name field
        this.add(firstNameField, 1, 0);
        //Add first name error label
        this.add(firstNameErrorLabel, 1, 1);
        //Add last name label
        this.add(new Label("Last Name:"), 0, 2);
        //Add last name field
        this.add(lastNameField, 1, 2);
        //Add last name error label
        this.add(lastNameErrorLabel, 1, 3);
        //Add course label
        this.add(new Label("Course:"), 0, 4);
        //Add course field
        this.add(courseField, 1, 4);
        //Add course error label
        this.add(courseErrorLabel, 1, 5);
        //Add grade label
        this.add(new Label("Grade:"), 0, 6);
        //Add grade combobox
        this.add(gradeComboBox, 1, 6);
        //Add grade error label
        this.add(gradeErrorLabel, 1, 7);

        //Add buttons to pane
        //Create add button
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addStudent());
        //Add add button to pane
        this.add(addButton, 0, 8);

        //Create clear button
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> clearFields());
        //Add clear button to pane
        this.add(clearButton, 1, 8);

        //Add general error label
        this.add(generalErrorLabel, 0, 10);
    }

    /**
     * Validates form data and displays error if necessary, otherwise adds student through list manager
     */
    private void addStudent() {
        //Create variable to contain if errors occurred
        boolean hasError = false;

        //Clear and hide error labels
        clearErrorLabels();

        // Validate input fields
        if (firstNameField.getText().isEmpty()) {
            firstNameErrorLabel.setText("First name is required.");
            firstNameErrorLabel.setVisible(true);
            hasError = true;
        } else if(!GradeBookValidator.isValidName(firstNameField.getText())) {
            firstNameErrorLabel.setText("Please only enter letters and spaces.");
            firstNameErrorLabel.setVisible(true);
            hasError = true;
        }

        if (lastNameField.getText().isEmpty()) {
            lastNameErrorLabel.setText("Last name is required.");
            lastNameErrorLabel.setVisible(true);
            hasError = true;
        } else if(!GradeBookValidator.isValidName(lastNameField.getText())) {
            lastNameErrorLabel.setText("Please only enter letters and spaces.");
            lastNameErrorLabel.setVisible(true);
            hasError = true;
        }

        if (courseField.getText().isEmpty()) {
            courseErrorLabel.setText("Course is required.");
            courseErrorLabel.setVisible(true);
            hasError = true;
        } else if(!GradeBookValidator.isValidCourse(courseField.getText())) {
            courseErrorLabel.setText("Please only enter letters, numbers, and spaces.");
            courseErrorLabel.setVisible(true);
            hasError = true;
        }

        if (gradeComboBox.getValue() == null) {
            gradeErrorLabel.setText("Grade is required.");
            gradeErrorLabel.setVisible(true);
            hasError = true;
        }

        // If any errors, stop further processing
        if (hasError) {
            return;
        }
        // Create a new student object and add it to the list
        Student newStudent = new Student(
                firstNameField.getText(),
                lastNameField.getText(),
                courseField.getText(),
                gradeComboBox.getValue()
        );
        try {
            GradeBookListManager.addStudent(newStudent);
        } catch (IOException e) {
            setErrorLabel("Unable to load grades from file");
            e.printStackTrace();
        }
        // Clear input fields
        clearFields();
    }

    public void setErrorLabel(String errorMessage) {
        generalErrorLabel.setText(errorMessage);
        generalErrorLabel.setVisible(true);
    }


    /**
     * Clears all input fields
     */
    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();

        //Clear and hide error labels
        firstNameErrorLabel.setText("");
        firstNameErrorLabel.setVisible(false);

        lastNameErrorLabel.setText("");
        lastNameErrorLabel.setVisible(false);

        courseErrorLabel.setText("");
        courseErrorLabel.setVisible(false);

        gradeErrorLabel.setText("");
        gradeErrorLabel.setVisible(false);

        clearErrorLabels();
    }

    /**
     * Clear all error labels
     */
    private void clearErrorLabels() {
        firstNameErrorLabel.setText("");
        firstNameErrorLabel.setVisible(false);

        lastNameErrorLabel.setText("");
        lastNameErrorLabel.setVisible(false);

        courseErrorLabel.setText("");
        courseErrorLabel.setVisible(false);

        gradeErrorLabel.setText("");
        gradeErrorLabel.setVisible(false);

        generalErrorLabel.setText("");
        generalErrorLabel.setVisible(false);
    }
}
