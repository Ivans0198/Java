package general;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

public class CheckedVsUnchecked {

    public static void main(String[] args) {

        // Checked
        try {
            FileReader fileReader = new FileReader("myfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
        }

        try {
            readFile("myfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
        }


        // Unchecked
        printLength(null);
    }

    // If throws, the exception will have to be dealt outside the method
    public static void readFile(String filename) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filename);
    }

    public static void printLength(String string) {
        try {
            System.out.println(string.length());
        } catch (NullPointerException e) {
            System.out.println("parameter cannot be null");
        }
    }

    public static void runCheckedException() {
        try {
            throw new SQLException();
        } catch (SQLException e) {}
    }

    public static void runUncheckedException() {
        throw new RuntimeException();
    }
}

/**
 * checked: at compile time
 * - Read file (FileNotFoundException)
 * -
 * unchecked: at runtime time
 *
 * If I wanted to have my own exceptions I would need to extend to RuntimeException() otherwise I would need to wrap in try catch
 * -
 */
