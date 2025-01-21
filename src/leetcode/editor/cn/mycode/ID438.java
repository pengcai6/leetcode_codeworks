package leetcode.editor.cn.mycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ID438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cntS = new int[30];
        int[] cntP = new int[30];

        for (char c : p.toCharArray()) {
            cntP[c-'a']++;
        }
        for(int r=0;r<s.length();r++)
        {
            char c = s.charAt(r);
            cntS[c-'a']++;
            int l=r-p.length()+1;
            if (l<0) {
                continue;
            }
            if(Arrays.equals(cntS,cntP)){
                res.add(l);
            }

            cntS[s.charAt(l)-'a']--;

        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println("anagrams = " + anagrams);
    }

}
