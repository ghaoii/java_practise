package interview;

import java.util.HashSet;
import java.util.Set;

public class Num1_8_SetZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    flag = true;
                    if(!set.contains(j)) {
                        set.add(j);
                    }
                }
            }

            if(flag) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i : set) {
            setColZeroes(matrix, i);
        }
    }

    private void setColZeroes(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
