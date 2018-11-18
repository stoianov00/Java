import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        String inputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        Path inputPath = Paths.get(inputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line = reader.readLine();
            long sum = 0;

            while (line != null) {
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }

                line = reader.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
