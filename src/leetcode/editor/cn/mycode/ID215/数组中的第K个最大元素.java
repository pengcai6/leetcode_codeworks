package leetcode.editor.cn.mycode.ID215;

import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

public class 数组中的第K个最大元素 {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
                int n= nums.length;
                int l=0,r=n-1;
                k=n-k;
                while (l<=r) {
                    final int[] range = partition(nums, l, r);
                    if (range[0] <= k && range[1] >= k) {
                        return nums[range[0]];
                    } else if (range[0] > k) {
                        r = range[0] - 1;
                    } else if (range[1] < k) {
                        l = range[1] + 1;
                    }
                }
                return 0;
        }
        public int []partition(int []nums,int l,int r)
        {
            int choosIndex=  (l+ (int)(Math.random()*(r-l)));
            int target=nums[choosIndex];
            int index=l;
            int start=l-1;
            int end=r;
            while (index<=end){
                if(nums[index]>target){
                    swap(nums,end--,index);
                } else if (nums[index]<target) {
                    swap(nums,++start,index++);
                }else{
                    index++;
                }
            }
            return new int[]{start+1,end};
        }
        private void  swap(int[]nums,int a,int b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
        }


    }
}
