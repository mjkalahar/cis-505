/*
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package GradeBookApp;

import java.util.regex.Pattern;

/**
 * Class for validating input from user
 */
public class GradeBookValidator {

    //Regex pattern for First Name and Last Name
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z ]+$");
    //Regex pattern for Course
    private static final Pattern COURSE_PATTERN = Pattern.compile("^[a-zA-Z\\d ]+$");

    /**
     * Validate string against name pattern
     * @return boolean if regex and string match
     */
    public static boolean isValidName(String text) {
        if(NAME_PATTERN.matcher(text).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validate string against course pattern
     * @return boolean if regex and string match
     */
    public static boolean isValidCourse(String text) {
        if(COURSE_PATTERN.matcher(text).matches()) {
            return true;
        } else {
            return false;
        }
    }
}
