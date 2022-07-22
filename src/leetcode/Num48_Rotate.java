package leetcode;

public class Num48_Rotate {
    public void rotate(int[][] matrix) {
        revolve(matrix, 0, matrix.length - 1);
    }

    private void revolve(int[][] matrix, int a, int b) {
        if(a >= b) {
            return;
        }
        for (int i = 0; i < b - a; i++) {
            int temp1 = matrix[a + i][b];
            matrix[a + i][b] = matrix[a][a + i];
            int temp2 = matrix[b][b - i];
            matrix[b][b - i] = temp1;
            int temp3 = matrix[b - i][a];
            matrix[b - i][a] = temp2;
            matrix[a][a + i] = temp3;
        }
        revolve(matrix, a + 1, b - 1);
    }
}
