import java.util.Scanner;

public class Lab2_b {

    private static int maxProfit;

    public static void findMaxProfit(int[] prices) {
        maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int firstTransactionProfit = prices[j] - prices[i];

                    for (int k = j + 1; k < prices.length; k++) {
                        for (int l = k + 1; l < prices.length; l++) {
                            if (prices[l] > prices[k]) {
                                int secondTransactionProfit = prices[l] - prices[k];
                                maxProfit = Math.max(maxProfit, firstTransactionProfit + secondTransactionProfit);
                            }
                        }
                    }
                }
            }
        }
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
        System.out.println("Maximum profit: " + maxProfit);
    }
}
