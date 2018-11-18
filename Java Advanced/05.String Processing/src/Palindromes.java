import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split("[,!.?\\s]+");

        Set<String> palindromes = new TreeSet<>();

        for (String word : text) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (isPalindrome(word)) {
                    palindromes.add(word);
                }
            }
        }

        System.out.printf("[%s]%n", String.join(", ", palindromes));
    }

    private static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

}
