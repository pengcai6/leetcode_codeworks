package leetcode.editor.cn.mycode.ID560;

import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {

    public static void main(String[] args) {

    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            //记录前缀和
            int n = nums.length;
            int[] sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int count=0;
            //利用hashmap，也就是两数之和
            for(int i=0;i<n;i++){
                count+=map.getOrDefault(sums[i]-k,0);
                map.put(sums[i],map.getOrDefault(sums[i],0)+1);

            }

            return count;

        }
    }
}
