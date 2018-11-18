import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commandType = scanner.nextLine().split("\\s+");

            checkCommand(commandType, stack);
        }
    }

    private static void checkCommand(String[] commandType, Deque<Integer> stack) {
        switch (Integer.parseInt(commandType[0])) {
            case 1:
                int number = Integer.parseInt(commandType[1]);
                stack.push(number);
                break;

            case 2:
                stack.pop();
                break;

            case 3:
                System.out.println(biggestElementInStack(stack));
                break;
        }
    }

    private static int biggestElementInStack(Deque<Integer> stack) {
        return Collections.max(stack);
    }

}