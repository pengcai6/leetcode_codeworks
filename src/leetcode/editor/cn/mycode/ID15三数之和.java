package leetcode.editor.cn.mycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ID15三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                for (int k = j+1; k < nums.length; k++) {
//                    if(nums[i] + nums[j] + nums[k] == 0){
//                        res.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
//                    }
//                }
//
//            }
//        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1])continue;
            int l=i+1;
            int r=nums.length-1;
            while (l<r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 去重l和r
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (sum<0) l++;
                else r--;


            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{0, 0, 0,0
        });
        System.out.println("lists = " + lists);
    }
}
