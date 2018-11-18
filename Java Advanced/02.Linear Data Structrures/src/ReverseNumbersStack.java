import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputTokens = Arrays.stream(scanner.nextLine()
                .split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int number :
                inputTokens) {
            stack.push(number);
        }

        for (int number :
                stack) {
            System.out.printf("%d ", number);
        }

    }
}
