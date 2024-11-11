/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import javafx.scene.AccessibleAttribute;

/**
 * Represents the editable TableView for the grade book
 */
public class GradeBookTable extends TableView<Student> {
    /**
     * Constructor for GradeBookTable
     */
    public GradeBookTable() {
        super();
        // Create table columns based on textfield vs combobox
        TableColumn<Student, String> firstNameColumn = createTableColumn("First Name", "firstName");
        TableColumn<Student, String> lastNameColumn = createTableColumn("Last Name", "lastName");
        TableColumn<Student, String> courseColumn = createTableColumn("Course", "course");
        TableColumn<Student, String> gradeColumn = createGradeColumn();

        //Add columns to the table
        this.getColumns().addAll(firstNameColumn, lastNameColumn, courseColumn, gradeColumn);
        //Add list of student grades to table
        this.setItems(GradeBookListManager.getDisplayedStudentList());
        //Allow editing for the tableview
        this.setEditable(true);
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
        column.setCellFactory(col -> new TextFieldTableCell<>(new DefaultStringConverter()) {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                //Set modified class for this cell
                updateModifiedStyle(this, item, empty, propertyName);
            }
        });
        //Set the on edit funtionality
        column.setOnEditCommit(event -> {
            Student student = event.getRowValue();
            switch (propertyName) {
                case "firstName": student.setFirstName(event.getNewValue()); break;
                case "lastName": student.setLastName(event.getNewValue()); break;
                case "course": student.setCourse(event.getNewValue()); break;
            }
        });
        column.setSortable(false);
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
        gradeColumn.setCellFactory(col -> new ModifiedComboBoxTableCell(FXCollections.observableArrayList("A", "B", "C", "D", "F")));
        //Set the on edit funtionality
        gradeColumn.setOnEditCommit(event -> event.getRowValue().setGrade(event.getNewValue()));
        gradeColumn.setSortable(false);
        return gradeColumn;
    }

    /**
     * Determines if cell needs to have modfied class style added or removed, runs on updateItem for TextFields
     * @param cell Cell being edited
     * @param item Value that has been edited to
     * @param empty If the value is empty
     * @param propertyName Which property has been updated
     */
    private void updateModifiedStyle(TableCell<Student, String> cell, String item, boolean empty, String propertyName) {
        //If empty or no value, remove modified
        if (empty || item == null) {
            cell.getStyleClass().remove("modified");
            return;
        }

        //Get index
        int rowIndex = cell.getIndex();
        //Get master list
        ObservableList<Student> masterStudentList = GradeBookListManager.getMasterStudentList();
        //Check if index is valid
        if (rowIndex >= 0 && rowIndex < cell.getTableView().getItems().size() && rowIndex < masterStudentList.size()) {
            //Get displayed and master student
            Student displayedStudent = cell.getTableView().getItems().get(rowIndex);
            Student masterStudent = masterStudentList.get(rowIndex);

            //Ensure students are instances
            if (displayedStudent != null && masterStudent != null) {
                //Compare values
                String masterValue = getMasterValue(masterStudent, propertyName);
                //If not equal, add modified, if equal, remove modified
                if (!masterValue.equals(item)) {
                    cell.getStyleClass().add("modified");
                } else {
                    cell.getStyleClass().remove("modified");
                }
            }
        }
    }


    /**
     * Gets the correct propery from the master student based on property name of column
     * @return String value of master student for specified property
     */
    private static String getMasterValue(Student masterStudent, String propertyName) {
        switch (propertyName) {
            case "firstName": return masterStudent.getFirstName();
            case "lastName": return masterStudent.getLastName();
            case "course": return masterStudent.getCourse();
            default: return "";
        }
    }

    /**
     * Reset all modified classes (remove from all cells)
     */
    public void resetModifiedClass() {
        //Iterate through all cells
        for (int row = 0; row < this.getItems().size(); row++) {
            for (int col = 0; col < this.getColumns().size(); col++) {
                //Get cell by row column
                TableCell cell = (TableCell) this.queryAccessibleAttribute(AccessibleAttribute.CELL_AT_ROW_COLUMN, row, col);
                if (cell != null) {
                    //Remove modified class
                    cell.getStyleClass().remove("modified");
                }
            }
        }
    }

    /**
     * Class for Grade combobox editing, overrides commitEdit for modified class usage
     */
    private class ModifiedComboBoxTableCell extends ComboBoxTableCell<Student, String> {

        /**
         * ModifiedComboBoxTableCell constructor with list of values
         * @param items List of Combobox options to display
         */
        public ModifiedComboBoxTableCell(ObservableList<String> items) {
            super(items);
        }

        /**
         * Determines if cell needs to have modfied class style added or removed
         * @param newValue String of value being edited to
         */
        @Override
        public void commitEdit(String newValue) {
            //Call super
            super.commitEdit(newValue);

            //Get as cell
            TableCell<Student, String> cell = this;
            //Get index
            int rowIndex = getIndex();

            //Get master list
            ObservableList<Student> masterStudentList = GradeBookListManager.getMasterStudentList();
            //Check if index is valid
            if (rowIndex >= 0 && rowIndex < getTableView().getItems().size() && rowIndex < masterStudentList.size()) {
                //Get displayed and master student
                Student displayedStudent = getTableView().getItems().get(rowIndex);
                Student masterStudent = masterStudentList.get(rowIndex);

                //Ensure students are instances
                if (displayedStudent != null && masterStudent != null) {
                    //Compare values
                    if (!masterStudent.getGrade().equals(newValue)) {
                        //Add modified class
                        cell.getStyleClass().add("modified");
                    } else {
                        //Remove modified class
                        cell.getStyleClass().remove("modified");
                    }
                } else {
                    //Remove modified class
                    cell.getStyleClass().remove("modified");
                }
            } else {
                //Remove modified class
                cell.getStyleClass().remove("modified");
            }
        }
    }
}
