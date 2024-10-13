/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */

package FutureValueApp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class creates a GUI application for calculating future value
 */

public class KalaharFutureValueApp extends Application {
    // Declare GUI components
    // Label for monthly payment
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    //Label for interest rate
    private Label lblInterestRate = new Label("Interest Rate:");
    //Label for years
    private Label lblYears = new Label("Years:");
    //Label for interest rate format
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    //Unused fifth label
    private Label lbl = new Label();

    //Declare buttons
    //Calculate button
    private Button btnCalculate = new Button("Calculate");
    //Clear button
    private Button btnClear = new Button("Clear");

    //Declare text fields
    //Monthly payment text field
    private TextField tfMonthlyPayment = new TextField();
    //Interest rate text field
    private TextField tfInterestRate = new TextField();

    //Declare text area
    //Text area for output
    private TextArea textArea = new TextArea();

    //Declare combo box
    //Combo box for years
    private ComboBox<Integer> integerComboBox = new ComboBox<>();

     /**
     * This method is the entry point of the JavaFX application.
     *
     * @param primaryStage The primary stage of the GUI.
     */
    @Override
    public void start(Stage primaryStage) {
        //Create a new GridPane layout
        GridPane gridPane = new GridPane();
        //Set alignment to center
        gridPane.setAlignment(Pos.CENTER);
        //Set padding
        gridPane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        //Set horizontal gap
        gridPane.setHgap(5.5);
        //Set vertical gap
        gridPane.setVgap(5.5);

        //Set interest rate format text color to red
        lblInterestRateFormat.setTextFill(Color.RED);

        //Create a HBox for buttons
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setAlignment(Pos.CENTER_RIGHT);
        //Set padding
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        //Set spacing
        actionBtnContainer.setSpacing(10);
        //Add clear button to HBox
        actionBtnContainer.getChildren().add(btnClear);
        //Add calculate button to HBox
        actionBtnContainer.getChildren().add(btnCalculate);

        //Add monthly payment label to grid
        gridPane.add(lblMonthlyPayment, 0, 0);
        //Add monthly payment text field to grid
        gridPane.add(tfMonthlyPayment, 1, 0);
        //Add interest rate label to grid
        gridPane.add(lblInterestRate, 0, 1);
        //Add interest rate text field to grid
        gridPane.add(tfInterestRate, 1, 1);
        //Add interest rate format label to grid
        gridPane.add(lblInterestRateFormat, 1, 2);
        //Set horizontal alignment for interest rate format in pane to right
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        //Add years label to grid
        gridPane.add(lblYears, 0, 3);
        //Add combobox to grid
        gridPane.add(integerComboBox, 1, 3);
        //Set horizontal alignment for combobox in pane to right
        GridPane.setHalignment(integerComboBox, HPos.RIGHT);
        //Set max width for combobox to fill area
        integerComboBox.setMaxWidth(Double.MAX_VALUE);
        //Add action button container to grid
        gridPane.add(actionBtnContainer, 1, 4);
        GridPane.setHalignment(integerComboBox, HPos.RIGHT);
        //Add text area to grid
        gridPane.add(textArea, 0, 5, 2, 1);

        // Create a new scene
        Scene scene = new Scene(gridPane, 300, 300);
        // Set stage title
        primaryStage.setTitle("Kalahar Future Value App");
        // Set scene on stage
        primaryStage.setScene(scene);
        // Show the stage
        primaryStage.show();
    }

    /**
     * Main method to launch the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String [] args) {
        launch(args);
    }
}