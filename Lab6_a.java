import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lab6_a {

    static void findCombinations(int[] coins, int sum, int n, List<Integer> combination) {
        // Base case: if sum is 0, print the combination
        if (sum == 0) {
            System.out.println(combination);
            return;
        }
        // If sum becomes negative or no coins left
        if (sum < 0 || n <= 0) {
            return;
        }

        // Include the last coin and recurse
        combination.add(coins[n - 1]);
        findCombinations(coins, sum - coins[n - 1], n, combination);
        // Exclude the last coin and recurse
        combination.remove(combination.size() - 1);
        findCombinations(coins, sum, n - 1, combination);
    }

    static int countWays(int[] coins, int sum, int n) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || n <= 0) {
            return 0;
        }
        return countWays(coins, sum - coins[n - 1], n) + countWays(coins, sum, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for number of coins
        System.out.print("Enter the number of coin denominations: ");
        int N = scanner.nextInt();

        // User input for coin denominations
        int[] coins = new int[N];
        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }

        // User input for the target sum
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(4); // Increased thread pool size

        // Create a task for counting the number of ways to make the target sum
        Runnable countTask = () -> {
            int ways = countWays(coins, sum, coins.length);
            System.out.println("Number of ways to make sum " + sum + ": " + ways);
        };

        // Create a task for finding and printing the combinations
        Runnable combinationTask = () -> {
            System.out.println("Possible combinations to make sum " + sum + ":");
            findCombinations(coins, sum, coins.length, new ArrayList<>());
        };

        // Submit the tasks to the executor
        executor.submit(countTask);
        executor.submit(combinationTask);

        // Shutdown the executor
        executor.shutdown();

        // Close the scanner
        scanner.close();
    }
}

/* DESCRIPTION
Calculates the number of ways to achieve a target sum using specified coin
denominations. It prompts the user for input, including the number of coin
types, their values, and the target sum. The program employs two recursive
methods: one to count the total combinations and another to find and print
all possible combinations of coins that sum to the target. It utilizes
multithreading with an ExecutorService to run these tasks concurrently,
ensuring efficient computation and output of results.
*/

/* OUTPUT
Enter the number of coin denominations: 4
Enter the coin denominations: 3
1 2 3
Enter the target sum: 4
Possible combinations to make sum 4:
[3, 1]
[2, 2]
[2, 1, 1]
[1, 1, 1, 1]
[1, 3]
Number of ways to make sum 4: 5
*/