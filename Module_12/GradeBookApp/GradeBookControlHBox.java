/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Provides a hbox for user to save and view student grades
 */
public class GradeBookControlHBox extends HBox {
    //Table to show current active grades in modification mode
    private GradeBookTable gradeTable;
    //Table for showing readonly grades of what is in file
    private GradeBookViewTable viewGradeTable;
    //Input pane for adding students
    private GradeBookInputPane gradeBookInputPane;
    /**
     * Constructor for GradeBookControlHBox
     * @param gradeTable The TableView displaying the editable grade book
     * @param viewGradeTable The TableView displaying the master saved grades
     * @param gradeBookInputPane The Input Pane for adding new students
     */
    public GradeBookControlHBox(GradeBookTable gradeTable, GradeBookViewTable viewGradeTable, GradeBookInputPane gradeBookInputPane) {
        super();
        //Set fields for tables
        this.gradeTable = gradeTable;
        this.viewGradeTable = viewGradeTable;
        this.gradeBookInputPane = gradeBookInputPane;

        //Set padding and spacing
        this.setSpacing(10);
        //Set padding
        this.setPadding(new Insets(10));
        //Set alignment to bottom right
        this.setAlignment(Pos.BOTTOM_RIGHT);

        //Create save button
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveChanges());

        //Create view button
        Button viewButton = new Button("View Saved Grades");
        viewButton.setOnAction(event -> viewGrades());
        //Add buttons to pane
        this.getChildren().addAll(saveButton, viewButton);
    }
    /**
     * Saves the current displayed list to file and to master list
     */
    private void saveChanges() {
        try {
            //Call save in list manager
            GradeBookListManager.saveDisplayedList();
        } catch (IOException e) {
            gradeBookInputPane.setErrorLabel("Unable to save to file");
            e.printStackTrace();
        }
        //Remove modified classes
        gradeTable.resetModifiedClass();
        //Refresh the table
        gradeTable.refresh();
    }

    /**
     * Displays the saved grades in a separate window, checks for unsaved changes and alerts if needed
     */
    private void viewGrades() {
        //Check for unsaved changes
        if(GradeBookListManager.hasUnsavedChanges()) {
            //Show confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Unsaved Changes");
            alert.setHeaderText("You have unsaved changes.");
            alert.setContentText("Viewing saved grades will discard any unsaved changes. Do you want to continue?");
            //Add buttons
            ButtonType yesButton = new ButtonType("Yes");
            ButtonType noButton = new ButtonType("No");
            //Set buttons
            alert.getButtonTypes().setAll(yesButton, noButton);
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == yesButton) {
                    // User confirmed, proceed with loading grades from file
                    loadGradesAndDisplay();
                } // Else, do nothing - the dialog will close and the user can continue editing
            });
        } else {
            //No unsaved changes, load grades from file
            loadGradesAndDisplay();
        }
    }

    /**
     * Loads grades from the file and displays them in readonly list
     */
    private void loadGradesAndDisplay() {
        try {
            //Load grades from file
            GradeBookListManager.reloadLists();
        } catch (IOException e) {
            gradeBookInputPane.setErrorLabel("Unable to read from file");
            e.printStackTrace();
        }
        //Reset the modified classes
        gradeTable.resetModifiedClass();
        //Display the grades
        viewGradeTable.display();
    }
}
