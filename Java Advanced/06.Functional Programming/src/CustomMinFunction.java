import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallestElement = numbers -> {
            int min = Integer.MAX_VALUE;
            for (int n : numbers) {
                if (min > n) {
                    min = n;
                }
            }

            return min;
        };

        System.out.println(smallestElement.apply(input));
    }
}
