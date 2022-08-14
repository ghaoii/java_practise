package offer;

public class Off4_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col - 1;
        while(x < row && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
