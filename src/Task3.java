import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = initMatrix(5);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
            int j = matrix.length - 1 - i;
                if (i == j) {
                    continue;
                }
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
        }
        System.out.printf("Minimal value: %d", min);
    }

    private static int[][] initMatrix(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
            }
        }
        return matrix;
    }
}
