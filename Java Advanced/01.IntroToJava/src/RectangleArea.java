import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        rectangleArea(a, b);
    }

    private static void rectangleArea(int a, int b) {
        double area = a * b;
        System.out.printf("%.2f", area);
    }
}
