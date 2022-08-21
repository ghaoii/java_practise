package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Off12_Exist {
    int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};// 上下左右
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int x, int y, int k) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(k)) {
            return false;
        }
        if(k == word.length() - 1) {
            // 到这里说明work全部匹配上了
            return true;
        }
        board[x][y] = ' ';
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            if(dfs(board, word, newX, newY, k + 1)) {
                return true;
            }
        }
        board[x][y] = word.charAt(k);
        return false;
    }
}
