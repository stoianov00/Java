package custom_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomListImpl<>();
        String command = reader.readLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");

            dispatchCommand(customList, tokens);

            command = reader.readLine();
        }
    }

    private static void dispatchCommand(CustomList<String> customList, String[] tokens) {
        switch (tokens[0]) {
            case "Add":
                customList.add(tokens[1]);
                break;
            case "Remove":
                String elementToRemove = customList.remove(Integer.parseInt(tokens[1]));
                System.out.println(elementToRemove);
                break;
            case "Contains":
                System.out.println(customList.contains(tokens[1]));
                break;
            case "Swap":
                customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "Greater":
                System.out.println(customList.countGreaterThan(tokens[1]));
                break;
            case "Max":
                System.out.println(customList.getMax());
                break;
            case "Min":
                System.out.println(customList.getMin());
                break;
            case "Print":
                customList.print();
                break;
        }
    }


}
