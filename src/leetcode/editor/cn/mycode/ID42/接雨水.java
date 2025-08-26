package leetcode.editor.cn.mycode.ID42;

import java.util.Deque;
import java.util.LinkedList;

public class 接雨水 {

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

    public int trap(int[] height) {
/*
        每一根柱子 i 上方能接到的水量，只取决于它左侧最高柱子 leftMax[ i]、右侧最高柱子 rightMax[ i]，
        以及它自身高度 height[ i]。
        该柱子的积水 = max(0, min(leftMax[i], rightMax[i]) - height[i])。
        整体答案 = 把每根柱子的积水加起来。
        */

        int sum = 0;
        int n = height.length;
        int[] plus = new int[n + 1];
        for (int i = 0; i < n; i++) {
            plus[i] = height[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length + 1; i++) {
            while (!stack.isEmpty() && plus[stack.peek()] < plus[i]) {
                //把比当前矮的都弹出
                //并且计算能容纳的水
                int curIndex = stack.pop();
                if (!stack.isEmpty()) {
                    //当前和左边界的距离
                    int w = i - stack.peek() - 1;
                    //左边界和右边界比较 再减去底部的高度
                    int h = Math.min(plus[i], plus[stack.peek()]) - plus[curIndex];
                    sum += w * h;
                }
            }
            stack.push(i);
        }
        return sum;
    }

}
