/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * This class represents a simple Grade Book application using JavaFX
 */
public class KalaharGradeBookApp extends Application {

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
        //Load lists from file
        GradeBookListManager.reloadLists();
        // Create UI layout using BorderPane
        BorderPane root = new BorderPane();
        //Create tables
        GradeBookTable gradeBookTable = new GradeBookTable();
        GradeBookViewTable gradeBookViewTable = new GradeBookViewTable();
        //Set left of pane to hold input fields/buttons
        root.setLeft(new GradeBookInputPane());
        //Set bottom of pane to hold save and view grade
        root.setBottom(new GradeBookControlHBox(gradeBookTable, gradeBookViewTable));
        //Set right of pane to hold table
        root.setCenter(gradeBookTable);

        //Create new default scene
        Scene scene = new Scene(root, 600, 400);
        //Add css
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        //Add scene to stage
        primaryStage.setScene(scene);
        //Set title
        primaryStage.setTitle("Kalahar Grade Book Application");
        //Show the stage
        primaryStage.show();
    }
}