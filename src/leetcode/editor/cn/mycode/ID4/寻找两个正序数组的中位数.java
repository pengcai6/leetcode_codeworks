package leetcode.editor.cn.mycode.ID4;

public class 寻找两个正序数组的中位数 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length + nums2.length;
            // 找中位数转化为找第k大问题
            if (n % 2 == 0) {
                int left = find(nums1, 0, nums2, 0, n / 2);
                int right = find(nums1, 0, nums2, 0, n / 2 + 1);
                return (left + right) / 2.0;
            } else {
                return find(nums1, 0, nums2, 0, n / 2 + 1);
            }

        }

        private int find(int[] nums1, int i, int[] nums2, int j, int k) {
            // 如果数组nums1用光了，返回nums2的第k大
            if (i >= nums1.length)
                return nums2[j + k - 1];
            // 如果数组nums2用光了，返回nums1的第k大
            if (j >= nums2.length)
                return nums1[i + k - 1];
            // 如果只要第一大
            if (k == 1) { // 两者排序，第一大就是两个中最小的
                return Math.min(nums1[i], nums2[j]);
            }
            //防止溢出，就算溢出了，直接取最大值，这样减少的就是另外一个数组的
            int mid1 = i + k / 2 - 1 < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int mid2 = j + k / 2 - 1 < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
            if (mid1 > mid2) {
                return find(nums1, i, nums2, j + k / 2, k - k / 2);
            } else {
                return find(nums1, i + k / 2, nums2, j, k - k / 2);
            }
        }

    }

}
