package leetcode;

public class Num79_Exist {
    boolean flag = false;
    int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int[][] book = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, book, 0, i , j, word, row, col);
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, int[][] book, int curPos, int x, int y,
                     String work, int row, int col) {

        if(board[x][y] == work.charAt(curPos)) {
            if(curPos == work.length() - 1) {
                flag = true;
                return;
            }
            book[x][y] = 1;
            for (int k = 0; k < 4; k++) {
                int newX = pos[k][0];
                int newY = pos[k][1];
                if(newX < 0 || newX >= row || newY < 0 || newY >= col || book[newX][newY] == 1) {
                    continue;
                }
                dfs(board, book, curPos + 1, newX, newY, work, row, col);
                if(flag) {
                    return;
                }
            }
            book[x][y] = 0;
        }
    }
}
