package listyIterator;

import listyIterator.collection.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator collection = new ListyIterator();

        while (true) {
            String input = reader.readLine();
            if ("END".equals(input)) {
                break;
            }

            List<String> inputTokens = Arrays.asList(input.split("\\s+"));
            String command = inputTokens.get(0);
            inputTokens = inputTokens.stream().skip(1).collect(Collectors.toList());

            try {
                collection = dispatchCommand(collection, inputTokens, command);
            } catch (IllegalArgumentException ex) {
                ex.getMessage();
            }

        }

    }

    private static ListyIterator dispatchCommand(ListyIterator collection, List<String> inputTokens, String command) {
        switch (command) {
            case "Create":
                collection = new ListyIterator(inputTokens);
                break;
            case "Move":
                System.out.println(collection.move());
                break;
            case "Print":
                collection.print();
                break;
            case "HasNext":
                System.out.println(collection.hasNext());
                break;
            case "PrintAll":
                collection.printAll();
                break;
            default:
                break;
        }

        return collection;
    }

}
