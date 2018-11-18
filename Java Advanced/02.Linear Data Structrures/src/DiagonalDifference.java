import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = Integer.parseInt(inputTokens[col]);
            }
        }

        int primaryDiagonal = sumPrimaryDiagonal(matrix);
        int secondaryDiagonal = sumSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }

        return sum;
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0, col = matrix.length - 1; row < matrix.length; row++) {
            sum += matrix[row][col];
            col--;
        }

        return sum;
    }
}
