package leetcode.editor.cn.mycode.ID33;

import java.util.Arrays;

public class 搜索旋转排序数组 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int l=0,r=n-1;
            while (l<=r)
            {
                int mid=(l+r)/2;
                if(nums[mid]==target){
                    return mid;
                }
                //如果左边为有序
                if(nums[l]<=nums[mid])
                {
                    //利用左边有序判断是否在左边
                    if(nums[l]<=target&&nums[mid]>target)
                    {
                       r=mid-1;
                    }
                    else  l=mid+1;
                }
                else //右边有序
                {
                    //利用左边有序判断是否在左边
                    if (nums[mid] < target && nums[r] >= target) {
                        l = mid + 1;
                    } else r = mid - 1;
                }
            }
            return -1;
        }

    }

}
