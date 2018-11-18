import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int aX = in.nextInt();
        int aY = in.nextInt();

        int bX = in.nextInt();
        int bY = in.nextInt();

        int cX = in.nextInt();
        int cY = in.nextInt();

        System.out.println(triangleArea(aX, aY, bX, bY, cX, cY));
    }

    private static int triangleArea(int aX, int aY, int bX, int bY, int cX, int cY) {
        int calculateAX = aX * (bY - cY);
        int calculateBX = bX * (cY - aY);
        int calculateCX = cX * (aY - bY);

        return Math.abs(calculateAX + calculateBX + calculateCX) / 2;
    }
}
