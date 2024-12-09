import java.util.Scanner;

public class TargetSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask for the number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        
        // Get the item prices
        System.out.println("Enter the item prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        // Ask for the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        
        // Count unique pairs
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] + prices[j] == target) {
                    count++;
                }
            }
        }
        
        // Print the result
        System.out.println("Number of unique pairs: " + count);
        
        scanner.close();
    }
}