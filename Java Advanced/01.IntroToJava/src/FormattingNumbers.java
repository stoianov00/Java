import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", Integer.toHexString(a).toUpperCase(), String.format(Integer.toBinaryString(a), 10, '0'), b, c);
    }
}

