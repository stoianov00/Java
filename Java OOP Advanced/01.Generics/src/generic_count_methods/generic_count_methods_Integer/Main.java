package generic_count_methods.generic_count_methods_Integer;

import generic_count_methods.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Box<Double>> boxes = new ArrayList<>();

        int linesCount = Integer.parseInt(reader.readLine());
        while (linesCount-- > 0) {
            double line = Double.parseDouble(reader.readLine());

            Box<Double> box = new Box<>(line);
            boxes.add(box);
        }

        double line = Double.parseDouble(reader.readLine());
        Box<Double> elementToCompare = new Box<>(line);

        System.out.println(getCountGreaterElements(boxes, elementToCompare));
    }

    private static <T extends Comparable<T>> int getCountGreaterElements(List<Box<T>> elements, Box<T> singleElement) {
        return elements.stream().filter(element -> element.compareTo(singleElement) > 0).collect(Collectors.toList()).size();
    }

}
