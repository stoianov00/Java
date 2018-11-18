import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setsCount = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(setsCount[0]);
        int m = Integer.parseInt(setsCount[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        fillSet(scanner, n, firstSet);
        fillSet(scanner, m, secondSet);

        StringBuilder result = new StringBuilder();
        for (String number : firstSet) {
            if (secondSet.contains(number)) {
                result.append(number).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }

    private static void fillSet(Scanner scanner, int n, Set<String> set) {
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextLine());
        }
    }

}
