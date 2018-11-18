import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = inputTokens[col];
            }
        }

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            try {
                String[] inputTokens = line.split("\\s+");

                if (!"swap".equals(inputTokens[0]) && inputTokens.length != 5) {
                    System.out.println("Invalid input!");
                }

                int row1 = Integer.parseInt(inputTokens[1]);
                int col1 = Integer.parseInt(inputTokens[2]);
                int row2 = Integer.parseInt(inputTokens[3]);
                int col2 = Integer.parseInt(inputTokens[4]);

                swap(row1, col1, row2, col2, matrix);
                printMatrix(matrix);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] col :
                matrix) {
            for (String row :
                    col) {
                System.out.printf("%s ", row);
            }

            System.out.println();
        }
    }

    private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
        String firstCell = matrix[row1][col1];
        String secondCell = matrix[row2][col2];

        matrix[row1][col1] = secondCell;
        matrix[row2][col2] = firstCell;
    }
}