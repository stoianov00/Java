package telephony;

import telephony.contracts.Browsable;
import telephony.contracts.Callable;

public class SmartPhone implements Callable, Browsable {
    @Override
    public void call(String[] phoneNumbers) {
        for (String phoneNumber : phoneNumbers) {
            System.out.printf("Calling... %s%n", phoneNumber);
        }
    }

    @Override
    public void browse(String[] links) {
        for (String link : links) {
            if (link.matches(".*\\d+.*")) {
                System.out.println("Invalid URL!");
            } else {
                System.out.printf("Browsing: %s!%n", link);
            }
        }
    }

}