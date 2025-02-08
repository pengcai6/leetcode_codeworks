package leetcode.editor.cn.mycode.ID41;

import java.util.HashSet;

public class 缺失的第一个正数 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            //使用额外的哈希表
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            for (int i = 1; i <= nums.length; i++) {
                if(!set.contains(i))return i;
            }
            return nums.length+1;
        }
    }

    class Solution2 {
        public int firstMissingPositive(int[] nums) {
            //使用本身数组作为哈希表
            for (int i = 0; i < nums.length; i++) {
                while (nums[i]>=0&&nums[i]<nums.length)
                {
                    swap(nums,i,nums[i]-1);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=(i-1))
                {
                    return nums[i];
                }
            }

            return nums.length + 1;
        }
        public void swap(int[]nums,int i,int j)
        {
            int mid=nums[i];
            nums[i]=nums[j];
            nums[j]=mid;
        }
    }



}
