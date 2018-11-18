import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        for (char letter : input.toCharArray()) {
            System.out.print("\\u" + Integer.toHexString(letter | 0x10000).substring(1));
        }
    }
}
