package generic_box.generic_box_integers;

import generic_box.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int linesCount = Integer.parseInt(reader.readLine());
        while (linesCount-- > 0) {
            int line = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>(line);
            System.out.println(box);
        }
    }
}
