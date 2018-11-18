import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.next();
        String input2 = scan.next();

        System.out.println(calculateSum(input1, input2));
    }

    private static int calculateSum(String input1, String input2) {
        int sum = 0;
        int len = Math.max(input1.length(), input2.length());

        for (int i = 0; i < len; i++) {
            if (input1.length() > i && input2.length() > i) {
                sum += input1.charAt(i) * input2.charAt(i);
            } else {
                if (input1.length() < input2.length()) {
                    sum += input2.charAt(i);
                } else {
                    sum += input1.charAt(i);
                }
            }
        }

        return sum;
    }
}
