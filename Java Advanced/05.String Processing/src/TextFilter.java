import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(",\\s+");
        String text = reader.readLine();

        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord, newString(bannedWord));
        }

        System.out.println(text);
    }

    private static String newString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("*");
        }

        System.out.println();

        return sb.toString();
    }
}
