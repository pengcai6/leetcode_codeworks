package leetcode.editor.cn.mycode;

public class ID11盛最多水的容器 {
    public static int maxArea(int[] height) {
        int res = 0;
        for (int l = 0, r = height.length-1;l<r; ) {
            //移动右边的面积比移动左边的面积大，那么就移动右边的否则移动左边
            //计算面积
            int are = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(are, res);
            if (height[l] < height[r]) {
               l++;
            } else {
                r--;
            }
        }
        return res;
}


    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 1});
        System.out.println("i = " + i);
    }
}
