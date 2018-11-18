import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == n) {
                    System.out.printf("%d + %d = %d%n", i, j, n);
                }
                if (i - j == n) {
                    System.out.printf("%d - %d = %d%n", i, j, n);
                }
            }
        }

    }
}
