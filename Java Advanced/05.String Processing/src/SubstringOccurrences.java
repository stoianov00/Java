import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine().toLowerCase();
        String searchString = reader.readLine().toLowerCase();
        int index = 0;
        int counter = 0;

        while (true) {
            int found = text.indexOf(searchString, index);
            if (found >= 0) {
                counter++;
                index = found + 1;
            } else {
                break;
            }

        }

        System.out.println(counter);
    }
}