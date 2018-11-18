import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MagicExchange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = reader.readLine().trim().split("\\s+");

        Set<String> firstWord = new HashSet<>();
        firstWord.add(inputArray[0]);

        Set<String> secondWord = new HashSet<>();
        secondWord.add(inputArray[1]);

        System.out.println(firstWord.size() == secondWord.size() ? "true" : "false");
    }

}
