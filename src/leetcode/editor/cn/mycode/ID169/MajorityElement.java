package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.util.*;

public class ID169MajorityElement{
	public static void main(String[] args) {
		Solution solution = new ID169MajorityElement().new Solution();
		StringBuilder sb = new StringBuilder();
		
		//执行测试
		
		System.out.println(sb);		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int len=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<len/2;i++)
		{
			if(nums[i]==nums[len/2+i])
			{
				return nums[i];
			}
		}


		return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}