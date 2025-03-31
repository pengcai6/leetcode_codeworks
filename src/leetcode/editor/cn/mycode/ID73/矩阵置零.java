package leetcode.editor.cn.mycode.ID73;

public class 矩阵置零 {

    class Solution {
        public void setZeroes(int[][] matrix) {
            int a = matrix.length;
            int b = matrix[0].length;
            // 标记需要置 0 的行和列
            boolean[] rowZero = new boolean[a]; // 标记行
            boolean[] colZero = new boolean[b]; // 标记列
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (matrix[i][j] == 0) {
                        rowZero[i] = true;
                        colZero[j] = true;
                    }
                }
            }
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if(rowZero[i] || colZero[j])
                    {
                        matrix[i][j]=0;
                    }

                }
            }
        }
    }
}
