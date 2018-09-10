package stackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyStack<Integer> myStack = new MyStack<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] tokens = Arrays.stream(line.split("\\s+"))
                    .map(e -> e.replace(",", "")).toArray(String[]::new);

            switch (tokens[0]) {
                case "Push":
                    int[] numbers = Arrays.stream(tokens).skip(1).mapToInt(Integer::parseInt).toArray();
                    for (int token : numbers) {
                        myStack.push(token);
                    }
                    break;
                case "Pop":
                    try {
                        myStack.pop();
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        ex.getMessage();
                    }
                    break;
                default:
                    break;
            }

            line = reader.readLine();
        }

        printElements(myStack);
        printElements(myStack);
    }

    private static void printElements(MyStack<Integer> myStack) {
        for (Integer integer : myStack) {
            System.out.println(integer);
        }
    }

}
