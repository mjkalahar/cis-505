/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Represents the readonly TableView for displaying saved grades
 */
public class GradeBookViewTable extends TableView<Student> {

    //Hold instance of stage view window
    private static Stage gradeStage;

    /**
     * Creates a read-only TableColumn for the given column name and property.
     * @param columnName The name to display for the column.
     * @param propertyName The property of the Student object to bind to the column.
     * @return The created TableColumn.
     */
    private static TableColumn<Student, String> createReadyOnlyColumn(String columnName, String propertyName) {
        //Create table column
        TableColumn<Student, String> column = new TableColumn<>(columnName);
        // Set the cell value factory based on the provided property name.
        column.setCellValueFactory(cellData -> {
            switch (propertyName) {
                case "firstName": return cellData.getValue().firstNameProperty();
                case "lastName": return cellData.getValue().lastNameProperty();
                case "course": return cellData.getValue().courseProperty();
                case "grade": return cellData.getValue().gradeProperty();
                default: throw new IllegalArgumentException("Invalid property name: " + propertyName);
            }
        });
        return column;
    }

    /**
     * Displays the saved grades in a separate window, ensuring only one instance of the window is shown.
     */
    public void display() {
        //Initialize the stage if it doesn't exist
        if(gradeStage == null) {
            gradeStage = new Stage();
            gradeStage.setTitle("View Grades");
            BorderPane gradeRoot = new BorderPane();
            gradeRoot.setCenter(this);
            Scene gradeScene = new Scene(gradeRoot, 600, 400);
            gradeStage.setScene(gradeScene);
        }
        //If table has not had columns added
        if (this.getColumns().isEmpty()) {
            // Create columns and add all
            this.getColumns().addAll(
                    createReadyOnlyColumn("First Name", "firstName"),
                    createReadyOnlyColumn("Last Name", "lastName"),
                    createReadyOnlyColumn("Course", "course"),
                    createReadyOnlyColumn("Grade", "grade")
            );
        }
        //Add list of student grades to table
        this.setItems(GradeBookListManager.getMasterStudentList());
        //Make read only
        this.setEditable(false);
        //Show the stage
        gradeStage.show();
        //Bring to front
        gradeStage.toFront();
    }
}
