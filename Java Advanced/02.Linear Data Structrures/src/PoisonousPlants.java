import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine()
                .split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] days = new int[n];

        Deque<Integer> proximityDeque = new ArrayDeque<>();
        proximityDeque.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;

            while (proximityDeque.size() > 0 && plants[proximityDeque.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[proximityDeque.pop()]);
            }

            if (proximityDeque.size() > 0) {
                days[i] = maxDays + 1;
            }

            proximityDeque.push(i);
        }

        System.out.println(max(days));
    }

    private static int max(int[] days) {
        return Arrays.stream(days).max().getAsInt();
    }
}
