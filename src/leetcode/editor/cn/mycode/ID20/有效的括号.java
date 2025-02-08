package leetcode.editor.cn.mycode.ID20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 有效的括号 {
    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) { // s 长度必须是偶数
                return false;
            }
            Deque<Character> st = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if(aChar=='{')
                {
                    st.push('}');
                } else if (aChar=='(') {
                    st.push(')');
                } else if (aChar=='[') {
                    st.push(']');
                }else if (st.isEmpty() || st.pop() != aChar)
                {
                    return false;
                }
            }
            return st.isEmpty();
        }
    }
}
