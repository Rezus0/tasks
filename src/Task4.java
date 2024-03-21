import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[][] matrix = initMatrix(8);
        fillMatrix(matrix, 0 , matrix.length / 2 - 1);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void fillMatrix(int[][] matrix, int startPosition, int valueToFill) {
        if (valueToFill > 0) {
            fillMatrix(matrix, startPosition + 1, valueToFill - 1);
        }
        for (int i = startPosition; i < matrix.length - startPosition; i++) {
            matrix[startPosition][i] = valueToFill;
        }
        for (int i = startPosition + 1; i < matrix[0].length - startPosition; i++) {
            matrix[i][startPosition] = valueToFill;
        }
        for (int i = matrix.length - 1 - startPosition; i > startPosition; i--) {
            matrix[matrix.length - 1 - startPosition][i] = valueToFill;
        }
        for (int i = matrix.length - 1 - startPosition - 1; i > startPosition; i--) {
            matrix[i][matrix.length - 1 - startPosition] = valueToFill;
        }
    }

    private static int[][] initMatrix(int n) {
        if (n == 0 || n % 2 != 0)
            throw new IllegalArgumentException(String.format("Wrong matrix dimension: %d", n));
        return new int[n][n];
    }
}
