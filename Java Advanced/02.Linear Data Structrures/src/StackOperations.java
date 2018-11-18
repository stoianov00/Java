import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split("\\s+");
        String[] numbersInput = scanner.nextLine().split("\\s+");

        int numberOfElements = Integer.parseInt(inputTokens[0]);
        int pops = Integer.parseInt(inputTokens[1]);
        int target = Integer.parseInt(inputTokens[2]);

        Deque<String> stack = new ArrayDeque<>();

        fillStack(numberOfElements, stack, numbersInput);

        for (int i = 0; i < pops; i++) {
            stack.pop();
        }

        if (stack.contains(Integer.toString(target))) {
            System.out.println(stack.contains(Integer.toString(target)));
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(smallestElementInStack(stack));
        }
    }

    private static void fillStack(int numberOfElements, Deque<String> stack, String[] numbersInput) {
        for (int i = 0; i < numberOfElements; i++) {
            stack.push(numbersInput[i]);
        }
    }

    private static int smallestElementInStack(Deque<String> stack) {
        int min = Integer.MAX_VALUE;
        for (String element :
                stack) {
            if (Integer.parseInt(element) < min) {
                min = Integer.parseInt(element);
            }
        }

        return min;
    }

}