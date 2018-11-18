import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimension][dimension];

        if (checkPattern(pattern)) {
            matrix = patternA(dimension, matrix);
            printMatrix(matrix);
        } else {
            matrix = patternB(dimension, matrix);
            printMatrix(matrix);
        }
    }

    private static boolean checkPattern(String pattern) {
        return "A".equals(pattern);
    }

    private static int[][] patternA(int dimension, int[][] matrix) {
        int currentNumber = 1;
        for (int col = 0; col < dimension; col++) {
            for (int row = 0; row < dimension; row++) {
                matrix[row][col] = currentNumber;

                currentNumber++;
            }
        }

        return matrix;
    }

    private static int[][] patternB(int dimension, int[][] matrix) {
        int number = 1;
        for (int col = 0; col < dimension; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimension; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            } else {
                for (int row = dimension - 1; row >= 0; row--) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] col :
                matrix) {
            for (int row :
                    col) {
                System.out.printf("%d ", row);
            }

            System.out.println();
        }
    }

}
