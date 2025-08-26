package leetcode.editor.cn.mycode.ID42;

import java.util.Deque;
import java.util.LinkedList;

public class 接雨水 {

    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] plus = new int[n + 1];
        for (int i = 0; i < n; i++) {
            plus[i] = height[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <height.length+1; i++) {
            while (!stack.isEmpty() && plus[stack.peek()] < plus[i]) {
                int curIndex = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = Math.min(plus[i], plus[stack.peek()]) - plus[curIndex];
                    sum+=w*h;
                }
            }
            stack.push(i);
        }
        return sum;
    }

    //需要实现一个单调栈
    public static void monotoneStack(int[] nums) {
        //存储的是nums的位置
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int curIndex = stack.pop();
                System.out.println(curIndex);
            }
            stack.push(i);
        }

    }

}
