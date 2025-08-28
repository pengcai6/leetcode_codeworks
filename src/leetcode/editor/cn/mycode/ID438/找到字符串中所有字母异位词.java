package leetcode.editor.cn.mycode.ID438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        //进行遍历，一边加一边减少；
        List<Integer> res=new ArrayList<>();
        if(s.length()<p.length())
        {
            return res;
        }
        //分别统计
        final int [] target=count(p,0,p.length());
        //减少步数，此时长度和p的差不多，更容易匹配
        final int [] sCount=count(s,0,p.length()-1);
        //注意i的边界
        for(int i=0;i<s.length()-p.length()+1;i++)
        {   //增加上结尾的
            ++sCount[s.charAt(i+p.length()-1)-'a'];
            if(Arrays.equals(sCount,target))
            {
                res.add(i);
            }
            --sCount[s.charAt(i)-'a'];
            //去除掉开头的
        }



        return res;
    }

    private static int [] count(String s, int start, int end)
    {
        int [] res=new int [26];
        for (int i = start; i < end; i++) {
            res[s.charAt(i)-'a']++;
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println("anagrams = " + anagrams);
    }

}
