import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String s, key = null;
        boolean odd = true;

        while (!(s = scanner.nextLine()).equals("stop")) {
            if (odd) {
                key = s;
                odd = false;
            } else {
                if (!s.toLowerCase().endsWith(".uk")
                        && !s.toLowerCase().endsWith(".us")
                        && !s.toLowerCase().endsWith(".com")) {
                    emails.put(key, s);
                }

                odd = true;
            }
        }

        emails.keySet().forEach((String _item) -> System.out.printf("%s -> %s\n", _item, emails.get(_item)));

    }
}
