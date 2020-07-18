import java.util.Arrays;

public class TestClass {

    // mxn 90 degreee
    // number of rotations

    /**
     * rotate matrix 90 degrees
     * 
     * @return
     */
    public static int[][] rotateMatix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(rows + ":" + cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                int val = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = val;
            }
        }
        reveseCols(matrix, rows, cols);
        return matrix;
    }

    private static void reveseCols(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = matrix[i][j];
                matrix[i][j] = matrix[rows - i - 1][j];
                matrix[rows - i - 1][j] = val;
            }
        }
    }

    public static int[][] rotateloop(int[][] matix, int rotationNumber) {
        int[][] result = new int[matix.length][matix[0].length];
        if (rotationNumber % 4 == 0) {
            return matix;
        }
        for (int i = 0; i < rotationNumber; i++) {
            result = rotateMatix(matix);
        }
        return result;
    }

    public static void main(String args[]) {
        int[][] matrix = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 },{10, 11, 12} };

        int[][] result = rotateloop(matrix, 8);
        for (int[] arr : result) {
            System.out.print(Arrays.toString(arr));
        }

        // 9631
        // 10742
        // 11853

        // 1 3 6 9
        // 2 4 7 10
        // 3 5 8 11

    }
    // anuraj@centime.com
}
