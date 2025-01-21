package leetcode.editor.cn.mycode.ID74;

public class ID74搜索二维矩阵 {
    /**
     * 使用二分进行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, tail = m - 1;

        // 先找到可能所在的行
        while (top < tail) {
            int mid = (top + tail) / 2;
            if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            } else {
                tail = mid;
            }
        }

        // 在确定的行中二分查找
        int row = top;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 使用排除法，根据右上角的值进行判断
      * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i< matrix.length&&j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        boolean b = new ID74搜索二维矩阵().searchMatrix1(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);
        System.out.println("b = " + b);
    }
}
