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

/*
Checks if an 8- or 9-digit credit card number is valid using a variation of the Luhn algorithm. 
First, it takes the input credit card number and separates out the last digit, which serves as the “check digit.” 
The code then reverses the rest of the digits to process them in the required order. 
It doubles every second digit in this reversed sequence; if doubling any digit results in a number greater than 9, 
it sums the individual digits of that result to keep everything as single digits. 
Next, it calculates the total sum of all processed digits and derives a new check digit from this sum. 
To determine if the card number is valid, it compares this new check digit with the original last digit of the input. 
If they match, the card is valid; if not, it’s flagged as potentially fraudulent.
*/

/* 
Enter the credit card number: 12345674
Valid credit card number
*/

/*
Enter the credit card number: 12345679
Fraud credit card number
*/

