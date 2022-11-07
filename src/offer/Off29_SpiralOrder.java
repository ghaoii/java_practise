package offer;

import java.util.Arrays;

public class Off29_SpiralOrder {
    public static void main(String[] args) {
        Off29_SpiralOrder test = new Off29_SpiralOrder();
        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        int[] ret = test.spiralOrder(arr);
        System.out.println(Arrays.toString(ret));
    }

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }
        // 定义数组，表示每个方向上，走下一步所需的步数
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] book = new int[row][col];// 标记数组
        int len = row * col;
        int[] ret = new int[len];
        int index = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        while(index < len) {
            ret[index++] = matrix[i][j];
            book[i][j] = 1;// 标记已经打印过的元素
            // 计算下一个位置
            int newX = i + next[k][0];
            int newY = j + next[k][1];
            if(newX < 0 || newX >= row || newY < 0 ||
                    newY >= col || book[newX][newY] == 1) {
                // 如果下一个位置不合法，则换到下一个方向
                k = (k + 1) % 4;
                i += next[k][0];
                j += next[k][1];
            }else {
                i = newX;
                j = newY;
            }
        }
        return ret;
    }

    // 题解
//    public int[] spiralOrder(int[][] matrix) {
//        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//            return new int[0];
//        }
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int[] ret = new int[row * col];
//        int index = 0;
//        int start = 0;// 起始位置
//        int endX = row - 1;
//        int endY = col - 1;
//        while(start <= endX && start <= endY) {
//            int i = start;
//            int j = start;
//            if(start == endX) {
//                // 说明只剩下最后一行了
//                for ( ; j <= endY; j++) {
//                    ret[index++] = matrix[i][j];
//                }
//                break;
//            }
//
//            if(start == endY) {
//                // 说明只剩下最后一列了
//                for ( ; i <= endX; i++) {
//                    ret[index++] = matrix[i][j];
//                }
//                break;
//            }
//
//            // 从左到右打印每一圈的上行
//            for ( ; j < col - start - 1; j++) {
//                ret[index++] = matrix[i][j];
//            }
//
//            // 从上到下打印每一圈的右列
//            for ( ; i < row - start - 1; i++) {
//                ret[index++] = matrix[i][j];
//            }
//
//            // 从右到左打印每一圈的下行
//            for( ; j > start; j--) {
//                ret[index++] = matrix[i][j];
//            }
//
//            // 从下到上打印每一圈的左列
//            for( ; i > start; i--) {
//                ret[index++] = matrix[i][j];
//            }
//
//            start++;
//            endX--;
//            endY--;
//        }
//        return ret;
//    }

    // 自己写的版本，比较麻烦，看起来思路不清晰
//    public int[] spiralOrder(int[][] matrix) {
//        int row = matrix.length;
//        if(row == 0 || matrix[0] == null) {
//            return new int[0];
//        }
//        int col = matrix[0].length;
//        int count = 0;
//        int[] ret = new int[row * col];
//        if(col == 0) {
//            return ret;
//        }
//        int index = 0;
//        while(row > count * 2 && col > count * 2) {
//            boolean flag = false;
//            for (int i = count; i < col - count; i++) {
//                ret[index++] = matrix[count][i];
//                flag = true;
//            }
//            if(!flag)
//                break;
//            flag = false;
//            for (int i = count + 1; i < row - count; i++) {
//                ret[index++] = matrix[i][col - 1 - count];
//                flag = true;
//            }
//            if(!flag)
//                break;
//            flag = false;
//            for (int i = col - 2 - count; i >= count; i--) {
//                ret[index++] = matrix[row - 1 - count][i];
//                flag = true;
//            }
//            if(!flag)
//                break;
//            flag = false;
//            for (int i = row - 2 - count; i > count; i--) {
//                ret[index++] = matrix[i][count];
//            }
//            count++;
//        }
//        return ret;
//    }
}
