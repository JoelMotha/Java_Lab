import java.util.*;

public class Lab1_a {
    // Instance variable to store the credit card number
    private String ccNumber;

    // Constructor to initialize the credit card number
    public Lab1_a(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    // Method to validate the credit card number
    public void validate() {
        // Check if the length of the credit card number is valid (8 or 9 characters)
        if (ccNumber.length() < 8 || ccNumber.length() > 9) {
            System.out.println("Invalid credit card number");
            return; // Exit the method if the credit card number is not valid
        }

        // Extract the last digit (check digit) of the credit card number
        char lastDigitChar = ccNumber.charAt(ccNumber.length() - 1);
        int lastDigit = Character.getNumericValue(lastDigitChar); // Convert last digit to an integer
        String remainingDigits = ccNumber.substring(0, ccNumber.length() - 1); // Get the remaining digits

        // Reverse the remaining digits for processing according to the algorithm
        String reversedDigits = new StringBuilder(remainingDigits).reverse().toString();

        int sum = 0; // Variable to hold the sum of processed digits
        // Loop through each digit in the reversed number
        for (int i = 0; i < reversedDigits.length(); i++) {
            int currentDigit = Character.getNumericValue(reversedDigits.charAt(i)); // Convert character to integer

            // Double every other digit (those in even index positions of reversedDigits)
            if (i % 2 == 0) {
                currentDigit *= 2;
                // If the doubled value is greater than 9, adjust it by summing the digits
                if (currentDigit > 9) {
                    currentDigit = currentDigit / 10 + currentDigit % 10;
                }
            }
            // Add the current digit (adjusted if necessary) to the sum
            sum += currentDigit;
        }

        // Calculate the expected check digit to make the total sum a multiple of 10
        int calculatedCheckDigit = 10 - (sum % 10);

        // Compare the calculated check digit with the actual last digit
        if (calculatedCheckDigit == lastDigit) {
            System.out.println("Valid credit card number"); // Valid if they match
        } else {
            System.out.println("Fraud credit card number"); // Fraudulent if they do not match
        }
    }

    public static void main(String[] args) {
        // Prompt the user to enter a credit card number
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the credit card number: ");
        String ccNumber = sc.nextLine(); // Read user input

        // Create an instance of Lab1_a and validate the entered credit card number
        Lab1_a validator = new Lab1_a(ccNumber);
        validator.validate(); // Invoke the validate method
    }
}

/* DESCRIPTION
Checks if an 8- or 9-digit credit card number is valid using a variation of the Luhn algorithm. 
First, it takes the input credit card number and separates out the last digit, which serves as the “check digit.” 
The code then reverses the rest of the digits to process them in the required order. 
It doubles every second digit in this reversed sequence; if doubling any digit results in a number greater than 9, 
it sums the individual digits of that result to keep everything as single digits. 
Next, it calculates the total sum of all processed digits and derives a new check digit from this sum. 
To determine if the card number is valid, it compares this new check digit with the original last digit of the input. 
If they match, the card is valid; if not, it’s flagged as potentially fraudulent.
*/

/* OUTPUT
Enter the credit card number: 12345674
Valid credit card number

Enter the credit card number: 12345679
Fraud credit card number
*/

