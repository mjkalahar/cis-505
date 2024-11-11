/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Manages the lists of Student objects, loading, saving, and checking for modifications
 */
public class GradeBookListManager {

    //List of student grades to display in the tableview
    private static ObservableList<Student> masterStudentList = FXCollections.observableArrayList();
    private static ObservableList<Student> displayedStudentList = FXCollections.observableArrayList();

    /**
     * Returns the master list of students.
     * @return The ObservableList containing all students.
     */
    public static ObservableList<Student> getMasterStudentList() {
        return masterStudentList;
    }

    /**
     * Returns the list of students currently displayed.
     * @return The ObservableList containing the displayed students.
     */
    public static ObservableList<Student> getDisplayedStudentList() {
        return displayedStudentList;
    }

    /**
     * Saves the currently displayed list to the file and updates the master list.
     */
    public static void saveDisplayedList() {
        masterStudentList.clear();
        masterStudentList.addAll(displayedStudentList.stream().map(Student::new).toList());
        //Write to file
        GradeBookFileManager.writeStudentsToFile(displayedStudentList);
    }

    /**
     * Checks if there are unsaved changes.
     * @return boolean true if there are unsaved changes, false otherwise.
     */
    public static boolean hasUnsavedChanges() {
        //Compare all students in lists
        for (int i = 0; i < displayedStudentList.size(); i++) {
            Student displayedStudent = displayedStudentList.get(i);
            Student masterStudent = masterStudentList.get(i);
            if (!displayedStudent.equals(masterStudent)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new student to both the master and displayed lists, then writes to file
     * @param newStudent The Student object to add.
     */
    public static void addStudent(Student newStudent) {
        masterStudentList.add(newStudent);
        displayedStudentList.add(new Student(newStudent));
        //Write to file
        GradeBookFileManager.writeStudentsToFile(displayedStudentList);
    }


    /**
     * Updates the displayed list from the master list
     */
    private static void refreshDisplayList() {
        displayedStudentList.clear();
        for(Student student: masterStudentList) {
            displayedStudentList.add(new Student(student));
        }
    }

    /**
     * Reloads the lists from the saved file.
     */
    public static void reloadLists() {
        //Read from file
        masterStudentList = FXCollections.observableArrayList(GradeBookFileManager.readStudentsFromFile());
        //Update display list
        refreshDisplayList();
    }
}
