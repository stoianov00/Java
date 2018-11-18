import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String line = reader.readLine();
            int count = 1;
            while (line != null) {
                writer.write(String.format("%d. %s%n", count++, line));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
