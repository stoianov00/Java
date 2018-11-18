import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> userNames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String username = scanner.next();
            userNames.add(username);
        }

        userNames.forEach(System.out::println);
    }
}
