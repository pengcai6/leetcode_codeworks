package leetcode.editor.cn.mycode.ID108;

import leetcode.editor.util.TreeNode;

public class 将有序数组转换为二叉搜索树 {

    class Solution {
        private int[] nums;
        public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        int l=0,r=nums.length-1;
        return getTree(l,r);
        }

        public TreeNode getTree(int l,int r)
        {
            if(l>r)
            {
             return null;
            }
            int mid=l+(r-l)/2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left= getTree(l,mid-1);
            treeNode.right=getTree(mid+1,r);
            return treeNode;
        }


    }

}
