package fileHandler;

import java.io.*;

/**
 * A class to handle all file read/write operations for this program
 */
public class FileHandler {

    /**
     * Writes a string to a file.
     * @param filepath Filepath to the file to write to. If it does not exist, it will be created
     * @param input String which will be written to the file
     * @throws IOException If something goes wrong
     */
    public static void writeFile(String filepath, String input) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false));
        writer.write(input);
        writer.close();
    }

    /**
     * Reads a string from a file. Reads only the first line of the file
     * @param filepath Filepath to the file to be read. The file must exist
     * @return The string read from the file
     * @throws IOException If something goes wrong
     */
    public static String readFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String output = reader.readLine();
        reader.close();
        return output;
    }
}
