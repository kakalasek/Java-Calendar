package fileHandler;

import java.io.*;

public class FileHandler {

    public static void writeFile(String filepath, String input) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true));
        writer.write(input);
        writer.close();
    }

    public static String readFile(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String output = reader.readLine();
        reader.close();
        return output;
    }

    public static void clearFile(String filepath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
        writer.write("");
        writer.close();
    }
}
