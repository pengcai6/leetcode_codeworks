package leetcode.editor.cn.mycode.ID128;

import java.util.*;

public class 最长连续序列 {

    static class Solution {
        public int longestConsecutive(int[] nums) {
            int res = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (Integer i : set) {
                if (set.contains(i - 1)) continue;
                int x = i + 1;
                while (set.contains(x)) {
                    x++;
                }
                res = Math.max(res, x - i);
            }

            return res;

        }
    }

    public static void main(String[] args) {
        int i = new Solution().longestConsecutive(new int[]{1, 2, 0, 1});
        System.out.println("i = " + i);
    }

}
