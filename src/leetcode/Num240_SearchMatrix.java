package leetcode;

public class Num240_SearchMatrix {
    // 三叶姐写的
    public boolean searchMatrix(int[][] matrix, int target) {
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
            }else if(matrix[x][y] < target){
                x++;
            }
        }
        return false;
    }


    // 自己写的
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < row; i++) {
//            if(target > matrix[i][col - 1]) {
//                x++;
//            }
//        }
//        for (int i = 0; i < col; i++) {
//            if(target > matrix[row - 1][i]) {
//                y++;
//            }
//        }
//
//        for (int i = x; i < row; i++) {
//            if(matrix[i][y] > target) {
//                break;
//            }
//            for (int j = y; j < col; j++) {
//                if(matrix[i][j] == target) {
//                    return true;
//                }
//                if(matrix[i][j] > target) {
//                    break;
//                }
//            }
//        }
//        return false;
//    }
}
