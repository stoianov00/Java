import java.util.Scanner;

public class FirstOddEvenElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String[] input2 = in.nextLine().split(" ");

        int target = Integer.parseInt(input2[1]);
        int counter = 0;

        if (input2[2].equals("odd")) {
            for (String anInput : input) {
                int num = Integer.parseInt(anInput);
                if (num % 2 != 0) {
                    System.out.print(anInput + " ");
                    counter++;
                    if (counter == target) {
                        break;
                    }
                }
            }
        } else {
            for (String anInput : input) {
                int num = Integer.parseInt(anInput);
                if (num % 2 == 0) {
                    System.out.print(anInput + " ");
                    counter++;
                    if (counter == target) {
                        break;
                    }
                }
            }
        }
    }

}
