import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int first = command.indexOf("(");
        String number = command.substring(first + 1, command.length() - 1);
        int degrees = Integer.parseInt(number);

        List<String> list = new ArrayList<>();
        int maxLength = 0;
        int rows = 0;

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            rows++;
            list.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }

            input = scanner.nextLine();
        }

        char[][] matrix = new char[rows][maxLength];
        int index = 0;
        int item = 0;

        for (int row = 0; row < matrix.length; row++) {
            String word = list.get(item);
            int itemLength = word.length();

            for (int col = 0; col < matrix[row].length; col++) {
                if (index == itemLength) {
                    while (index < maxLength) {
                        matrix[row][col] = ' ';
                        index++;
                        col++;
                    }

                    break;
                } else {
                    matrix[row][col] = word.charAt(index);
                    index++;
                }
            }

            item++;
            index = 0;
        }

        rotate(matrix, degrees);
    }

    private static void rotate(char[][] matrix, int degrees) {
        switch (degrees) {
            case 90:
                for (int col = 0; col < matrix.length; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = matrix.length - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }
                break;
            case 270:
                for (int col = matrix.length - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.length - 1; row++) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }
                break;
            case 360:
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix.length; col++) {
                        System.out.print(matrix[row][col]);
                    }

                    System.out.println();
                }
                break;

            default:
                System.out.println("Invalid degrees!");
        }
    }

}

/*
Rotate(180)
hello
softuni
exam
END
 */
