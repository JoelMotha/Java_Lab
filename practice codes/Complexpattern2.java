class Complexpattern2{
    public static void main(String[] args) {
        int n = 5;  // Number of rows in the diamond

        for (int i = 1; i <=n; i++) {
            // Print spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // Print numbers for the left side of the diamond
            for (int k = 1; k <i; k++) {
                System.out.print(k + " ");
            }

            for (int m = 1; m <=i; m++) {
                System.out.print(m + " ");
            }

            // Move to the next line for the next row
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            // Print spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            // Print numbers for the left side of the diamond
            for (int k = 1; k <i; k++) {
                System.out.print(k + " ");
            }


            for (int m = 1; m <= i; m++) {
                System.out.print(m + " ");
            }

            // Move to the next line for the next row
            System.out.println();
        }
    }
}