import java.util.Scanner;

public class Lab2_b {

    public static void findMaxProfit(int[] prices) {
        if (prices.length < 2) {
            System.out.println("Not enough data to calculate profit.");
            return;
        }

        int firstBuy = Integer.MAX_VALUE;
        int firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Variables to track transaction prices
        int firstSellPrice = 0;
        int secondSellPrice = 0;

        for (int price : prices) {
            // First transaction: Buy at the lowest price so far
            if (price < firstBuy) {
                firstBuy = price; // Update buy price for the first transaction
            }
            // Calculate profit for the first transaction
            if (price - firstBuy > firstProfit) {
                firstProfit = price - firstBuy; // Update first profit
                firstSellPrice = price; // Record sell price for the first transaction
            }

            // Second transaction: Buy at the lowest price after the first transaction profit
            if (price - firstProfit < secondBuy) {
                secondBuy = price - firstProfit; // Update buy price for the second transaction
            }
            // Calculate profit for the second transaction
            if (price - secondBuy > maxProfit) {
                maxProfit = price - secondBuy; // Update maximum profit
                secondSellPrice = price; // Record sell price for the second transaction
            }
        }

        // Calculate individual transaction profits based on recorded sell prices
        int firstTransactionProfit = firstSellPrice - firstBuy;
        int secondTransactionProfit = secondSellPrice - secondBuy;
        System.out.println("Maximum profit: " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        findMaxProfit(prices);
    }
}


/*  DESCRIPTION
Calculates the maximum profit from stock prices over multiple days by simulating up to two buy-sell transactions. 
The user inputs the number of stock prices and the prices themselves, after which the program iterates through the 
prices to determine potential profits. It identifies two distinct transactions that yield the highest combined profit, 
outputting the maximum profit achievable based on the provided prices. 
*/

/* OUTPUT
Enter the number of stock prices: 7
Enter the stock prices:
100 180 260 310 40 300 500
Maximum profit: 670
*/