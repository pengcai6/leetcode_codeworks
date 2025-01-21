package leetcode.editor.cn.mycode;

import java.util.HashMap;

public class ID560和为K的子数组 {
    public int subarraySum1(int[] nums, int k) {
//        子数组是数组中元素的连续非空序列
        int n = nums.length;
        int count=0;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
//        子数组是数组中元素的连续非空序列
        //暴力枚举优化
        int n = nums.length;
        int count = 0;
        for (int left = 0; left < n; left++) {
            int sum = 0;
            for (int right = left; right < n; right++) {
                    sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
      //使用hashmap存<key,number>
        //存储前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            //满足条件的前缀和
            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }

    public int subarraySum4(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum - k))
            {
                count += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum-k,0)+1);

        }


        return count;
    }

    public static void main(String[] args) {
        int i = new ID560和为K的子数组().subarraySum2(new int[]{1, -1, 0}, 0);
        System.out.println("i = " + i);

    }
}
