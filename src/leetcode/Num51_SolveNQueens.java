package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num51_SolveNQueens {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(".");
            }
            board.add(list);
        }
        dfs(board, 0, n);
        return ret;
    }

    private void dfs(List<List<String>> board, int row, int n) {
        if(row >= n) {
            ret.add(transform(board, n));
            return;
        }
        List<String> list = board.get(row);
        for (int i = 0; i < n; i++) {
            if(!isValid(board, row, i, n)) {
                continue;
            }
            list.set(i, "Q");
            dfs(board, row + 1, n);
            list.set(i, ".");
        }
    }

    private List<String> transform(List<List<String>> board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(board.get(i).get(j));
            }
            list.add(sb.toString());
        }
        return list;
    }

    private boolean isValid(List<List<String>> board, int row, int col, int n) {
        for (int i = row - 1; i >= 0; i--) {
            if(board.get(i).get(col).equals("Q")) {
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board.get(i).get(j).equals("Q")) {
                return false;
            }
        }
        return true;
    }
}
