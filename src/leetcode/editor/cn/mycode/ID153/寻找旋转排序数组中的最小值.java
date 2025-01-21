package leetcode.editor.cn.mycode.ID153;

public class 寻找旋转排序数组中的最小值 {
    class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            int res = 6000;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[l] <= nums[mid]) {
                    res = Math.min(res, nums[l]);
                    l = mid + 1;
                } else {
                    res = Math.min(res, nums[mid]);
                    r = mid - 1;
                }
            }
            return res;
        }
    }
}
