import java.util.*;

public class Lab1_a {
    private String ccNumber;

    public Lab1_a(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void validate() {
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number");
            return;
        }

        char lastDigitChar = ccNumber.charAt(ccNumber.length() - 1);
        int lastDigit = Character.getNumericValue(lastDigitChar);
        String remainingDigits = ccNumber.substring(0, ccNumber.length() - 1);

        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        int sum = 0;
        for (int i = 0; i < reversedDigits.length(); i++) {
            int currentDigit = Character.getNumericValue(reversedDigits.charAt(i));
            if (i % 2 == 0) {
                currentDigit *= 2;
                if (currentDigit > 9) {
                    currentDigit = currentDigit / 10 + currentDigit % 10;
                }
            }
            sum += currentDigit;
        }

        int calculatedCheckDigit = 10 - (sum % 10);

        if (calculatedCheckDigit == lastDigit) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Fraud credit card number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the credit card number: ");
        String ccNumber = sc.nextLine();

        Lab1_a validator = new Lab1_a(ccNumber);
        validator.validate();
    }
}
