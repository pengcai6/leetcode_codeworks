package leetcode.editor.cn.mycode.ID53;

public class 最大子数组和 {
    /**
     * 会超时
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        //循环长度
        for (int len = 1; len <= n; len++) {
            //循环起始
            for (int i = 0; i <= n - len; i++) { //直接覆盖掉前边对应的情况就⾏
                dp[i] = dp[i] + nums[i + len - 1];
                // 更新 max
                if (dp[i] > max) {
                    max = dp[i];
                }
            }

        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0]=nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i-1]<0)
            {
                dp[i]=nums[i];
            }
            else{
                dp[i]=dp[i-1]+nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }


}