package leetcode.editor.cn.mycode.ID56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            ArrayList<int[]> list = new ArrayList<>();
            int n=intervals.length;
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            list.add(intervals[0]);
            for (int i = 1; i < n; i++) {
                int[] curr = intervals[i];
                // 获取list中最后一个区间
                int[] last = list.get(list.size() - 1);
                if(curr[0]<=last[1])
                {
                    //有重叠
                    last[1]=Math.max(curr[1],last[1]);
                }
                else {
                    list.add(curr);
                }

            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
