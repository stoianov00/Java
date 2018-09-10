package froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numberOfLakes = Arrays.stream(reader.readLine().split("[, ]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(numberOfLakes);

        List<Integer> result = new ArrayList<>();
        lake.forEach(result::add);

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
