package leetcode.editor.cn.mycode;

public class 最长重复子串 {

    public static void main(String[] args) {
        String s1="12acbd123";
        String s2="a2cbd";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int [][]dp=new int[s1.length()+2][s2.length()+2];
        int max=0,end=0;
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if(chars1[i]==chars2[j])
                {
                    dp[i+1][j+1]=dp[i][j]+1;
                    if(dp[i + 1][j + 1]>max){
                        max = Math.max(max, dp[i + 1][j + 1]);
                        end=i+1;
                    }
                }



            }
        }
        System.out.println(s1.substring(end - max, end));

    }


}
