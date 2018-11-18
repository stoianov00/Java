import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        while (!"end".equals(line)) {
            String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

            if (Pattern.matches(regex, line)) {
                System.out.println(line);
            }

            line = reader.readLine();
        }


    }
}
