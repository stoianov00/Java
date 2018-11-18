import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split("\\s+");
        String[] numbersInput = scanner.nextLine().split("\\s+");

        int numberOfElements = Integer.parseInt(inputTokens[0]);
        int pops = Integer.parseInt(inputTokens[1]);
        int target = Integer.parseInt(inputTokens[2]);

        Deque<String> queue = new ArrayDeque<>();

        fillQueue(numberOfElements, queue, numbersInput);

        for (int i = 0; i < pops; i++) {
            queue.poll();
        }

        if (queue.contains(Integer.toString(target))) {
            System.out.println(queue.contains(Integer.toString(target)));
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(smallestElementInQueue(queue));
        }
    }

    private static void fillQueue(int numberOfElements, Deque<String> queue, String[] numbersInput) {
        for (int i = 0; i < numberOfElements; i++) {
            queue.offer(numbersInput[i]);
        }
    }

    private static int smallestElementInQueue(Deque<String> queue) {
        int min = Integer.MAX_VALUE;
        for (String element :
                queue) {
            if (Integer.parseInt(element) < min) {
                min = Integer.parseInt(element);
            }
        }

        return min;
    }
}
