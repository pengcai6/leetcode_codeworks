package leetcode.editor.cn.mycode.ID49;

import java.util.*;

public class 字母异位词分组 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //题目的意思是，把同为字母异位词的，分在一个组里，然后返回
            //由于他们的排序后的值是相同的，所以作为key;
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
//                String key=chars.toString();
//                chars.toString()
//                调用的是Object类的toString() 方法
//                        返回的是数组对象的哈希码的字符串表示
                String key = new String(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());

        }

    }

}
