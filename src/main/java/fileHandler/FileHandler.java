package fileHandler;

import java.io.*;

/**
 * A class to handle all file read/write operations for this program
 */
public class FileHandler {

    /**
     * Writes a string to a file.
     * @param filepath Filepath to the file to write to. The file must exist
     * @param input String which will be written to the file
     * @throws IOException If something goes wrong
     */
    public static void writeFile(String filepath, String input) throws IOException {
        if(!new File(filepath).exists()) throw new FileNotFoundException("The file to write notes to not found!\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false))) {
            writer.write(input);

        } catch (IOException e){
            throw new IOException("Something went wrong with writing notes to a file!", e);
        }
    }

    /**
     * Reads a string from a file. Reads only the first line of the file
     * @param filepath Filepath to the file to be read. The file must exist
     * @return The string read from the file
     * @throws IOException If something goes wrong
     * @throws FileNotFoundException If the file is not found
     */
    public static String readFile(String filepath) throws IOException {
        String output = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            output = reader.readLine();

        } catch (FileNotFoundException e){
            throw new FileNotFoundException("The file to read notes from was not found!\n" + e.getMessage());
        } catch (IOException e){
            throw new IOException("Something went wrong with reading notes from a file!", e);
        }

        return output;
    }
}
