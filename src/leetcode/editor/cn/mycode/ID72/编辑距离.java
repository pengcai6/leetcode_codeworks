package leetcode.editor.cn.mycode.ID72;

import java.util.Arrays;
import java.util.Collections;

public class 编辑距离 {
    public int minDistance(String word1, String word2) {
       return dp(word1.length()-1,word2.length()-1,word1,word2);
    }

    public static int dp(int i,int j,String s1,String s2)
    {
        if(i==-1)return j+1;
        if(j==-1)return i+1;
        if(s1.charAt(i)==s2.charAt(j))return dp(i-1,j-1,s1,s2);
        else return Collections.min(Arrays.asList(dp(i-1,j,s1,s2),dp(i,j-1,s1,s2),dp(i-1,j-1,s1,s2)));
    }


    public static int dp1( String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        dp[i][0]=i;
        for(int i=1;i<=n;i++)
            dp[0][i]=i;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else dp[i][j]= Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) , dp[i - 1][ j - 1])+1;
            }
        return dp[m][n];
            }
}
