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
