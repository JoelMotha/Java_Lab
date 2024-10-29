import java.util.*;

public class Lab2_a {

    private static int[] numbers;

    public static void findTopKFrequentNumbers(int K) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : numbers) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> {
            if (b.getValue().equals(a.getValue())) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        System.out.print("Top " + K + " numbers with highest frequencies: ");
        for (int i = 0; i < K; i++) {
            System.out.print(list.get(i).getKey() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int N = sc.nextInt();

        numbers = new int[N];
        System.out.println("Enter " + N + " numbers:");
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int K = sc.nextInt();

        if (K > N) {
            System.out.println("K cannot be greater than the number of elements in the array.");
            return;
        }

        findTopKFrequentNumbers(K);
    }
}

/* DESCRIPTION
Identifies and prints the top K most frequently occurring numbers from an input array. 
It first collects the frequency of each number using a HashMap, then sorts these entries based 
on frequency (and value in case of ties). The program prompts the user for the array size, numbers, 
and the value of K, ensuring K does not exceed the array length before displaying the results.
*/

/* OUTPUT
Enter the size of the array: 15
Enter 15 numbers:
5 5 5 5 5 4 4 4 4 3 3 3 2 2 1
Enter the value of K: 3
Top 3 numbers with highest frequencies: 5 4 3
*/