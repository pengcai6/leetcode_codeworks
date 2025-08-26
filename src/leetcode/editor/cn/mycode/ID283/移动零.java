package leetcode.editor.cn.mycode.ID283;

public class 移动零 {
    public void moveZeroes(int[] nums) {
        //将不是0的往前面搬运
        //记录搬运的位置
        int index=0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]==0)continue;

            if(index<i)
                nums[index++]=nums[i];

        }
        for(int i=index;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }




}
