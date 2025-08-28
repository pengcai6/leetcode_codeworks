package leetcode.editor.cn.mycode.ID3;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //无重复的串，是由当前无重复的串+一个当前串中不包含的字符积累而成的
            //使用hashmap保存每一个字符上一次出现的位置即可
            HashMap<Character, Integer> map = new HashMap<>();
            int maxLen = 0;
            for (int i = 0, j = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (map.containsKey(c)) {
                    j = Math.max(map.get(c), j);
                }
                maxLen = Math.max(maxLen, i - j + 1);
                //需要跳过上一次重复的字符，所以需要+1
                map.put(c, i+1);
            }
            return maxLen;
        }
    }
}
