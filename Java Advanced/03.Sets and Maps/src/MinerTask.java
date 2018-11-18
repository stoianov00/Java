import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!"stop".equals(input)) {
            String resourceType = input;

            if (!resources.containsKey(resourceType)) {
                resources.put(resourceType, 0);
            }

            int quantity = Integer.parseInt(scanner.nextLine());
            resources.put(resourceType, resources.get(resourceType) + quantity);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
