package leetcode.editor.cn.mycode.ID11;

public class ID11盛最多水的容器 {
    public static int maxArea(int[] height) {

        //简易推理：当长度达到最大的时候，只能移动最矮的一边
        // 希望遇到一个更高的高度使得面积变大，如果移动高的一边，那么面积一定是变小的，不符合
        int res=0;
       int l=0,r= height.length-1;
       int area;
       while (l<=r)
       {
        area=(r-l)*Math.min(height[l],height[r]);
        res=Math.max(res,area);
        if(height[l]>height[r])r--;
        else l++;


       }

        return res;
}


    public static void main(String[] args) {
        int i = maxArea(new int[]{1, 1});
        System.out.println("i = " + i);
    }
}
