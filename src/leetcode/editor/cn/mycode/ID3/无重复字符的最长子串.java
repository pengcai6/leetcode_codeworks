package leetcode.editor.cn.mycode.ID3;

public class 无重复字符的最长子串 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n == 1) return 1;
            if (n == 0) return 0;
            int l = 0, r = 1;
            int res = 0;
            while (r < n) {
                boolean foundDuplicate = false;
                for (int k = l; k < r; k++) {
                    if (s.charAt(k) == s.charAt(r)) {
                        res = Math.max(res, r - l); // 更新最大长度
                        l = k + 1; // 更新左指针
                        foundDuplicate = true;
                        break;
                    }
                }
                if (!foundDuplicate) {
                    res = Math.max(res, r - l + 1); // 如果没有重复字符，更新最大长
                }
                r++;
            }
            return res;
        }
    }


}
