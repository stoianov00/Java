package generic_count_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<String>> boxes = new ArrayList<>();

        int linesCount = Integer.parseInt(reader.readLine());
        while (linesCount-- > 0) {
            String line = reader.readLine();

            Box<String> box = new Box<>(line);
            boxes.add(box);
        }

        String line = reader.readLine();
        Box<String> elementToCompare = new Box<>(line);

        System.out.println(getCountGreaterElements(boxes, elementToCompare));
    }

    private static <T extends Comparable<T>> int getCountGreaterElements(List<Box<T>> elements, Box<T> singleElement) {
        return elements.stream().filter(element -> element.compareTo(singleElement) > 0).collect(Collectors.toList()).size();
    }

}
