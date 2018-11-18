import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(inputTokens[0]);
        int cols = Integer.parseInt(inputTokens[1]);

        char a = 'a';
        char b = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(a);
                System.out.print(b);
                System.out.print(a);
                System.out.print(" ");
                b++;
            }

            System.out.println();
            a++;
            b = a;
        }
    }
}
