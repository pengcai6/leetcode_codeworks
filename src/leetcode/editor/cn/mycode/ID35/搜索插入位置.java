package leetcode.editor.cn.mycode.ID35;

import javax.sound.midi.MidiChannel;

public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r)
        {   int mid=l+(r-l)/2;
            if(nums[mid]==target)return mid;
            else if (nums[mid]>target) {
                r=mid-1;
            }
            else l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int i = new 搜索插入位置().searchInsert(new int[]{1, 3, 5, 6}, 6);
        System.out.println("i = " + i);
    }
}
