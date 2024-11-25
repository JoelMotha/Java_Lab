import java.util.Scanner;

interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

abstract class RainySeasonConservation implements WaterConservationSystem {
    public abstract int calculateTrappedWater(int[] blockHeights);
}

class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length < 3) {
            return 0;
        }

        int left = 0;
        int right = blockHeights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (blockHeights[left] < blockHeights[right]) {
                if (blockHeights[left] >= leftMax) {
                    leftMax = blockHeights[left];
                } else {
                    trappedWater += leftMax - blockHeights[left];
                }
                left++;
            } else {
                if (blockHeights[right] >= rightMax) {
                    rightMax = blockHeights[right];
                } else {
                    trappedWater += rightMax - blockHeights[right];
                }
                right--;
            }
        }

        return trappedWater;
    }
}

public class Lab5_b {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of blocks: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Number of blocks must be at least 1.");
            return;
        }

        int[] blockHeights = new int[n];
        System.out.println("Enter the heights of the blocks:");

        for (int i = 0; i < n; i++) {
            blockHeights[i] = scanner.nextInt();
        }

        WaterConservationSystem conservationSystem = new CityBlockConservation();
        int result = conservationSystem.calculateTrappedWater(blockHeights);

        System.out.println("Total trapped water: " + result);

        scanner.close();
    }
}

/* DESCRIPTION
 Calculates the total volume of water trapped between city blocks after
 rainfall. It uses an interface WaterConservationSystem and an abstract class
 RainySeasonConservation as the foundation. The CityBlockConservation class
 implements the two-pointer technique to calculate trapped water efficiently.
 The program takes the number of blocks and their heights as user input,
 processes the data, and outputs the total trapped water.
*/

/* OUTPUT
Enter the number of blocks: 4                                                                                                                              
Enter the heights of the blocks:
4 0 2 4
Total trapped water: 6
*/