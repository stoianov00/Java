import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        int maxSum = 0;
        int rowIndex = 0;
        int colIndex = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentRowSum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row][col + 2]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1]
                        + matrix[row + 1][col + 2]
                        + matrix[row + 2][col]
                        + matrix[row + 2][col + 1]
                        + matrix[row + 2][col + 2];

                if (currentRowSum > maxSum) {
                    maxSum = currentRowSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        System.out.printf("%d %d %d%n", matrix[rowIndex][colIndex],
                matrix[rowIndex][colIndex + 1],
                matrix[rowIndex][colIndex + 2]);

        System.out.printf("%d %d %d%n", matrix[rowIndex + 1][colIndex],
                matrix[rowIndex + 1][colIndex + 1],
                matrix[rowIndex + 1][colIndex + 2]);

        System.out.printf("%d %d %d", matrix[rowIndex + 2][colIndex],
                matrix[rowIndex + 2][colIndex + 1],
                matrix[rowIndex + 2][colIndex + 2]);
    }
}