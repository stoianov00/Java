import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> symbolsCount = new TreeMap<>();
        String[] textInput = scanner.nextLine().split("");

        if (textInput.length == 1 && "".equals(textInput[0])) {
            return;
        }

        for (String symbol : textInput) {
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 0);
            }

            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
        }

        for (Map.Entry<String, Integer> symbolEntry : symbolsCount.entrySet()) {
            System.out.printf("%s: %d time/s%n", symbolEntry.getKey(), symbolEntry.getValue());
        }

    }
}


