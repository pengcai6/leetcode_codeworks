package leetcode.editor.cn.mycode.ID238;

public class 除自身以外数组的乘积 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] first = new int[n];
            int[] res = new int[n];
            int[] least = new int[n];
            first[0]=1;
            least[n-1]=1;
            //维护两个数组，一个前缀积数组，一个后缀积数组，两次遍历即可
            for (int i = 1; i < n; i++) {
                first[i]=first[i-1]*nums[i-1];
            }
            for (int i = n-2; i >=0; i--) {
                least[i]=least[i+1]*nums[i+1];
            }
            for (int i = 0; i < nums.length; i++) {
                res[i]=first[i]*least[i];
            }
        return res;
        }
    }

    class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] first = new int[n];
            first[0] = 1;
            int R = 1;
            for (int i = 1; i < n; i++) {
                first[i] = first[i - 1] * nums[i - 1];
            }
            //不新开后缀数组，而是使用遍历的时候累积后缀积R
            for (int i = n - 1; i >= 0; i--) {
                first[i] *= R;
                R *= nums[i];
            }
            return first;
        }
    }

}
