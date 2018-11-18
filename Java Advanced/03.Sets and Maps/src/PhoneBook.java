import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("-");

        while (!"search".equals(input[0])) {
            String name = input[0];
            String phone = input[1];

            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, "");
            }

            phoneBook.put(name, phone);

            input = scanner.nextLine().split("-");
        }

        String searchName = scanner.nextLine();
        System.out.println();
        while (!"stop".equals(searchName)) {
            if (!phoneBook.containsKey(searchName)) {
                System.out.printf("Contact %s does not exist.%n", searchName);
            } else {
                System.out.printf("%s -> %s%n", searchName, phoneBook.get(searchName));
            }

            searchName = scanner.nextLine();
        }

    }

}
