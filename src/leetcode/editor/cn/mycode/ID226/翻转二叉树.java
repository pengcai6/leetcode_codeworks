package leetcode.editor.cn.mycode.ID226;

import leetcode.editor.util.TreeNode;

public class 翻转二叉树 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null){
                return null;
            }
            TreeNode l = invertTree(root.left);
            TreeNode r = invertTree(root.right);
            root.left=r;
            root.right=l;
            return root;
        }
    }
}
