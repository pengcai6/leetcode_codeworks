package leetcode.editor.cn.mycode.ID136;

import java.util.HashMap;
import java.util.Set;

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
    int res=0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num))map.remove(num);
            else {
                map.put(num, 1) ;
            };
        }
        Set<Integer> keySet = map.keySet();
        Object[] array = keySet.stream().toArray();
        res=(int )array[0];
        return res;
    }

    public static void main(String[] args) {
        int i = new 只出现一次的数字().singleNumber(new int[]{1});
        System.out.println("i = " + i);
    }
}
