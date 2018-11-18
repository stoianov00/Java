import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> lastStrings = new ArrayDeque<>();
        String currentString = "";
        lastStrings.push(currentString);

        for (int i = 0; i < n; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");

            switch (currentCommand[0]) {
                case "1":
                    currentString += currentCommand[1];
                    lastStrings.push(currentString);
                    break;

                case "2":
                    int countOfLastEl = Integer.parseInt(currentCommand[1]);
                    currentString = currentString.substring(0, currentString.length() - countOfLastEl);

                    lastStrings.push(currentString);
                    break;

                case "3":
                    int indexForPrint = Integer.parseInt(currentCommand[1]);
                    System.out.println(currentString.charAt(indexForPrint - 1));
                    break;

                case "4":
                    lastStrings.pop();
                    currentString = lastStrings.peek();
                    break;

                default:
                    break;
            }
        }
    }
}
