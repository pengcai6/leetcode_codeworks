package leetcode.editor.cn.mycode.ID189;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 轮转数组 {
    class Solution {
        private int[] nums;

        public void rotate(int[] nums, int k) {
            int n = nums.length;
            this.nums = nums;
            k %= n;
            // 修改翻转顺序
            reverse(0, n - 1);    // 先整体翻转
            reverse(0, k - 1);    // 再翻转前k个元素
            reverse(k, n - 1);    // 最后翻转剩余元素
        }

        public void reverse(int i, int j) {
            for (; i < j; i++, j--) {
                int mid = nums[i];
                nums[i] = nums[j];
                nums[j] = mid;
            }
        }
    }



}
