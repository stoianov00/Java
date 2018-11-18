import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String vowelsSymbols = "aeiou";
        String punctuationSymbols = "!.,?";
        int consonants = 0;
        int vowels = 0;
        int punctuation = 0;

        String inputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPathString = "/home/stoianov/home/Java Advanced/04.Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        int symbol;
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            while ((symbol = reader.read()) != -1) {
                char ch = (char) symbol;
                if (vowelsSymbols.contains(ch + "")) {
                    vowels++;
                } else if (punctuationSymbols.contains(ch + "")) {
                    punctuation++;
                } else if (Character.isLetter(ch)) {
                    consonants++;
                }
            }

            writer.write(String.format("Vowels: %d%n", vowels));
            writer.write(String.format("Consonants: %d%n", consonants));
            writer.write(String.format("Punctuation: %d%n", punctuation));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
