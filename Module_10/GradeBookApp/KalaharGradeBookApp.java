/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * This class represents a simple Grade Book application using JavaFX
 */
public class KalaharGradeBookApp extends Application {

    //TableView to display student grade data
    private TableView<Student> gradeTable = new TableView<>();
    //Textfields for user input of a new grade
    private TextField firstNameField, lastNameField, courseField;
    //ComboBox for selecting a letter grade
    private ComboBox<String> gradeComboBox;
    //List of student grades to display in the tableview
    private ObservableList<Student> displayedStudentList = FXCollections.observableArrayList();


    /**
     * Main method to launch the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String [] args) {
        launch(args);
    }
    
    /**
     * Entry point of the JavaFX application.
     * Sets up the UI, creates the table, and displays the window.
     *
     * @param primaryStage The primary stage of the GUI.
     */
    @Override
    public void start(Stage primaryStage) {
        //Initialize text fields
        firstNameField = new TextField();
        lastNameField = new TextField();
        courseField = new TextField();
        //Initialize combobox with letter grades
        gradeComboBox = new ComboBox<>(FXCollections.observableArrayList("A", "B", "C", "D", "F"));

        // Create table columns based on textfield vs combobox
        TableColumn<Student, String> firstNameColumn = createTableColumn("First Name", "firstName");
        TableColumn<Student, String> lastNameColumn = createTableColumn("Last Name", "lastName");
        TableColumn<Student, String> courseColumn = createTableColumn("Course", "course");
        TableColumn<Student, String> gradeColumn = createGradeColumn();

        //Add columns to the table
        gradeTable.getColumns().addAll(firstNameColumn, lastNameColumn, courseColumn, gradeColumn);
        //Add list of student grades to table
        gradeTable.setItems(displayedStudentList);
        //Allow editing for the tableview
        gradeTable.setEditable(true);

        // Create UI layout using BorderPane
        BorderPane root = new BorderPane();
        //Set top of pane to hold input fields/buttons
        root.setTop(createInputPane());
        //Set center to hold the grade tableview
        root.setCenter(gradeTable);

        //Create new default scene
        Scene scene = new Scene(root, 600, 400);
        //Add scene to stage
        primaryStage.setScene(scene);
        //Set title
        primaryStage.setTitle("Kalahar Grade Book Application");
        //Show the stage
        primaryStage.show();
    }

    /**
     * Creates and configures the top input pane for student grade info and buttons
     * @return GridPane containing UI elements for fields and buttons
     */
    private GridPane createInputPane() {
        //Create grid pane to organize elements
        GridPane inputPane = new GridPane();
        inputPane.setPadding(new Insets(10));
        inputPane.setHgap(10);
        inputPane.setVgap(10);

        //Add first name label
        inputPane.add(new Label("First Name:"), 0, 0);
        //Add first name field
        inputPane.add(firstNameField, 1, 0);
        //Add last name label
        inputPane.add(new Label("Last Name:"), 0, 1);
        //Add last name field
        inputPane.add(lastNameField, 1, 1);
        //Add course label
        inputPane.add(new Label("Course:"), 0, 2);
        //Add course field
        inputPane.add(courseField, 1, 2);
        //Add grade label
        inputPane.add(new Label("Grade:"), 0, 3);
        //Add grade combobox
        inputPane.add(gradeComboBox, 1, 3);

        //Add buttons to pane
        //Create add button
        Button addButton = new Button("Add");
        //Add add button to pane
        inputPane.add(addButton, 0, 4);

        //Create save button
        Button saveButton = new Button("Save");
        //Add save button to pane
        inputPane.add(saveButton, 3, 0);

        //Create clear button
        Button clearButton = new Button("Clear");
        //Add clear button to pane
        inputPane.add(clearButton, 1, 4);

        //Create view button
        Button viewButton = new Button("View Saved Grades");
        //Add view button to pane
        inputPane.add(viewButton, 4, 0);

        return inputPane;
    }

    /**
     * Creates a textfield type table column for grade table
     * 
     * @param columnName The name to display in column header
     * @param propertyName The name of the property to use
     * @return TableColumn configured for specific property
     */
    private TableColumn<Student, String> createTableColumn(String columnName, String propertyName) {
        //Create table column
        TableColumn<Student, String> column = new TableColumn<>(columnName);
        // Set the cell value factory based on the provided property name.
        column.setCellValueFactory(cellData -> {
            switch (propertyName) {
                case "firstName": return cellData.getValue().firstNameProperty();
                case "lastName": return cellData.getValue().lastNameProperty();
                case "course": return cellData.getValue().courseProperty();
                default: throw new IllegalArgumentException("Invalid property name: " + propertyName);
            }
        });
        // Set the cell factory to use TextFieldTableCell for editable text fields.
        column.setCellFactory(col -> new TextFieldTableCell<>());
        return column;
    }

    /**
     * Creates the TableColumn for the Grade column, using a ComboBoxTableCell
     * for selecting grades from a predefined list.
     *
     * @return Configured TableColumn for the "Grade" column.
     */
    private TableColumn<Student, String> createGradeColumn() {
        // Create a TableColumn for the Grade column.
        TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");
        //Set the cell value factory to grade property of student
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
        // Set the cell factory to use ComboBoxTableCell for selecting grades from predefined list
        gradeColumn.setCellFactory(col -> new ComboBoxTableCell(FXCollections.observableArrayList("A", "B", "C", "D", "F")));
        return gradeColumn;
    }
}