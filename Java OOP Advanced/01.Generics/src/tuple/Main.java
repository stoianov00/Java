package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Tuple<String, String> tuple = new TupleImpl<>();

        String[] inputTokens = reader.readLine().split("\\s+");
        tuple.setItem1(inputTokens[0] + " " + inputTokens[1]);
        tuple.setItem2(inputTokens[2]);
        printTuple(tuple);

        inputTokens = reader.readLine().split("\\s+");
        tuple.setItem1(inputTokens[0]);
        tuple.setItem2(inputTokens[1]);
        printTuple(tuple);

        inputTokens = reader.readLine().split("\\s+");
        tuple.setItem1(inputTokens[0]);
        tuple.setItem2(inputTokens[1]);

        printTuple(tuple);
    }

    private static void printTuple(Tuple<String, String> tuple) {
        System.out.printf("%s -> %s%n", tuple.getItem1(), tuple.getItem2());
    }
}
