/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages saving and loading student data to/from a file
 */
public class GradeBookFileManager {
    //Default file name
    private static final String GRADES_CSV = "grades.csv";

    /**
     * Saves the provided list of students to the file
     * @param students List<Student> The list of students to save
     *
     * @throws IOException Unable to write to file
     */
    public static void writeStudentsToFile(List<Student> students) throws IOException{
        //Open a file writer to write to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(GRADES_CSV))) {
            // Write the header line
            writer.println("firstName,lastName,course,grade");

            // Write student data
            for (Student student : students) {
                writer.println(student);
            }
        }
    }

    /**
     * Loads student data from the file and returns the list of Student Objects
     * @return List<Student> A list of students loaded from the file
     *
     * @throws IOException Unable to write to file
     */
    public static List<Student> readStudentsFromFile() throws IOException {
        //Create a list to hold student objects
        List<Student> students = new ArrayList<>();
        //Create a file object to read from the file
        File gradesFile = new File(GRADES_CSV);

        //Check if the file exists
        if (gradesFile.exists()) {
            //Open a file reader to read from the file
            try (BufferedReader reader = new BufferedReader(new FileReader(gradesFile))) {
                String line;
                //Skip the header line
                reader.readLine();
                //Read each line of the file
                while ((line = reader.readLine()) != null) {
                    //Split the line by commas
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        //Create a new student object and add it to the list
                        students.add(new Student(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                    }
                }
            }
        }

        //Return the list of students
        return students;
    }
}
