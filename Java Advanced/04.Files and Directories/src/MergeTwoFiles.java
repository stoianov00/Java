import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String firstPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String secondPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String resultPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt";

        Path firstPath = Paths.get(firstPathString);
        Path secondPath = Paths.get(secondPathString);
        Path resultPath = Paths.get(resultPathString);

        try {
            List<String> firstLines = Files.readAllLines(firstPath);
            List<String> secondLines = Files.readAllLines(secondPath);

            firstLines.addAll(secondLines);
            firstLines.sort(Comparator.naturalOrder());

            Files.write(resultPath, firstLines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
