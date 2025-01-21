package leetcode.editor.cn.mycode.ID34;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int first = -1;
            int last = -1;
            //先找出first

            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    first = mid;//找到了，先标记
                    right = mid - 1;//下次再从它的左边找
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 最后一个等于target的位置
            //再找出last
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    last = middle;
                    left = middle + 1; //重点，下次再从它的右边找
                } else if (nums[middle] > target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            return new int[]{first, last};
        }
    }
}
