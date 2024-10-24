public class MatrixMultiplication {
    private int[][] matrix1;
    private int[][] matrix2;

    public MatrixMultiplication(int[][] mat1, int[][] mat2) {
        matrix1 = mat1; 
        matrix2 = mat2;  
    }

    public int[][] multiplyMatrices() {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        // Check if matrices can be multiplied
        if (cols1 != rows2) {
            System.out.println("Matrix dimensions are not compatible for multiplication.");
            return null;
        }

        // Initialize result matrix
        int[][] result = new int[rows1][cols2];

        // Multiply matrices
        for (int i = 0; i < rows1; i++) { 
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public void printResult(int[][] result) {
        if (result == null) {
            System.out.println("No result to print.");
            return;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) { 
                System.out.print(result[i][j] + " ");
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        int[][] matrixA = { {1, 2, 3}, {4, 5, 6} };
        int[][] matrixB = { {7, 8}, {9, 10}, {11, 12} }; 

        MatrixMultiplication matrixMultiplier = new MatrixMultiplication(matrixA, matrixB);
        int[][] resultMatrix = matrixMultiplier.multiplyMatrices();

        matrixMultiplier.printResult(resultMatrix);
    }
}
