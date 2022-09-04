package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num52_TotalNQueens {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        dfs(board, 0, n);
        return count;
    }

    private void dfs(int[][] board, int row, int n) {
        if(row >= n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isValid(board, row, i, n)) {
                continue;
            }
            board[row][i] = 1;
            dfs(board, row + 1, n);
            board[row][i] = 0;
        }
    }

    private boolean isValid(int[][] board, int row, int col, int n) {
        for (int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
