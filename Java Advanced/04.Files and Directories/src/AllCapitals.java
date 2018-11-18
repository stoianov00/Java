import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            String line = reader.readLine();

            while (line != null) {
                writer.write(String.format("%s%n", line.toUpperCase()));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


