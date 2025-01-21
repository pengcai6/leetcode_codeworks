package leetcode.editor.cn.mycode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class ID42接雨水 {
    public static int trap1(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxL = 0, maxR = 0;
            int l = 0, r = height.length - 1;
            while (l < i) {
                if (height[l] >= height[i]) {
                    maxL = Math.max(maxL, height[l]);
                }
                l++;
            }
            while (r > i) {
                if (height[l] >= height[i]) {
                    maxR = Math.max(maxR, height[r]);
                }
                r--;
            }
            if(Math.min(maxL, maxR)> height[i])
            res += (Math.min(maxL, maxR) - height[i]);
        }
        return res;
    }


    public static int trap2(int[] height) {
        int res = 0;
      int n=height.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int cur=stack.pop();

                if(stack.isEmpty()){
                    break;
                }
                int width=i-stack.peek()-1;
                int height_diff=Math.min(height[i],height[stack.peek()] )-height[cur];

                res+=width*height_diff;

            }
            stack.push(i);
        }

        return res;
    }


    public static void main(String[] args) {
        int trap = trap2(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println("trap1 = " + trap);
    }
}
