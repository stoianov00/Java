import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EvenOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String evenOrOddInput = reader.readLine();

        Function<String, String> evenOrOdd = f -> {
            if ("odd".equals(f)) {
                return "odd";
            }

            return "even";
        };

        String condition = evenOrOdd.apply(evenOrOddInput);

    }
}
