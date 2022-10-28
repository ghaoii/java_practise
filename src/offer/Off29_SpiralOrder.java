package offer;

public class Off29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int[] ret = new int[row * col];
        int index = 0;
        while(row > count * 2 && col > count * 2) {
            boolean flag = false;
            for (int i = count; i < col - count; i++) {
                ret[index++] = matrix[count][i];
                flag = true;
            }
            if(!flag)
                break;
            flag = false;
            for (int i = count + 1; i < row - count; i++) {
                ret[index++] = matrix[i][row - 1 - count];
                flag = true;
            }
            if(!flag)
                break;
            flag = false;
            for (int i = col - 2 - count; i >= count; i--) {
                ret[index++] = matrix[row - 1 - count][i];
                flag = true;
            }
            if(!flag)
                break;
            flag = false;
            for (int i = row - 2 - count; i > count; i--) {
                ret[index++] = matrix[i][count];
            }
            count++;
        }
        return ret;
    }
}
