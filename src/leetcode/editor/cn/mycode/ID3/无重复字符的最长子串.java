package leetcode.editor.cn.mycode.ID3;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(),maxLen=0;
            Map<Character,Integer> map=new HashMap<>();
            for (int i = 0,j=0; j <n; j++) {
                if(map.containsKey(s.charAt(j)))
                {   //找到上一次出现的位置，并且更新
                    i=Math.max(map.get(s.charAt(j)),i);
                }
                //计算当前到上一个相同的出现位置的距离
                maxLen=Math.max(maxLen,j-i+1);
                //更新当前出现的位置
                map.put(s.charAt(j),j+1);
            }
            return maxLen;
        }
    }


}
