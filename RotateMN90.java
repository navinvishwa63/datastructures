import java.util.Arrays;

public class RotateMN90 {

    // mxn 90 degreee
    // number of rotations

    /**
     * For MxN matrix. non square.
     * 
     * @param matrix
     * @return
     */
    public static int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {

        int rows = matrix[0].length; // Total columns of Original Matrix
        int cols = matrix.length; // Total rows of Original Matrix

        int[][] rotatedMatrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][(cols - 1) - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
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
            result = rotateMatrixBy90DegreeClockwise(matix);
        }
        return result;
    }

    public static void main(String args[]) {
        int[][] matrix = { { 1, 2, 3 }, 
                           { 3, 4, 5 }, 
                           { 6, 7, 8 }, 
                           { 9, 10, 11 } };

        int[][] result = rotateloop(matrix, 1);
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
}
