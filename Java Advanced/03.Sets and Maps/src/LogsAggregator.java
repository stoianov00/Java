import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> users = new TreeMap<>();

        Set<String> IPs = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String username = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!users.containsKey(username)) {
                users.put(username, 0);
            }

            users.put(username, users.get(username) + duration);

            IPs.add(ip);
        }

        for (Map.Entry<String, Integer> user : users.entrySet()) {
            System.out.printf("%s: %d ", user.getKey(), user.getValue());
            System.out.println("[" + String.join(", ", IPs) + "]");
        }

    }
}
