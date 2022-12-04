package interview;

public class Num1_7_Rotate {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length);
    }


    private void rotate(int[][] matrix, int start, int len) {
        if(len <= 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            int temp = matrix[start + i][start + len - 1];
            matrix[start + i][start + len - 1] = matrix[start][start + i];

            int temp2 = matrix[start + len - 1][start + len - 1 - i];
            matrix[start + len - 1][start + len - 1 - i] = temp;

            temp = matrix[start + len - 1 - i][start];
            matrix[start + len - 1 - i][start] = temp2;

            matrix[start][start + i] = temp;
        }

        rotate(matrix, start + 1, len - 2);
    }
}
