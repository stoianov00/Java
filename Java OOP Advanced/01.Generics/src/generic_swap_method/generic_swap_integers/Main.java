package generic_swap_method.generic_swap_integers;

import generic_swap_method.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<Integer>> boxes = new ArrayList<>();

        int linesCount = Integer.parseInt(reader.readLine());
        while (linesCount-- > 0) {
            int line = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>(line);
            boxes.add(box);
        }

        int[] swapIndexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstIndex = swapIndexes[0];
        int secondIndex = swapIndexes[1];

        swap(boxes, firstIndex, secondIndex);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}
