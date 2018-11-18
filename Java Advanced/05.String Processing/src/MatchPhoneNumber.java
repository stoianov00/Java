import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "\\+359(-|\\s)2(\\1)(\\d{3})(\\1)(\\d{4})$";

        String phoneNumber = reader.readLine();
        while (!"end".equals(phoneNumber)) {
            if (phoneNumber.matches(pattern)) {
                System.out.println(phoneNumber);
            }

            phoneNumber = reader.readLine();
        }

    }
}
