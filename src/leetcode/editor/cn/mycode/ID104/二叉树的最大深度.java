package leetcode.editor.cn.mycode.ID104;

import leetcode.editor.util.TreeNode;

public class 二叉树的最大深度 {

    class Solution {
        public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.right),maxDepth(root.left))+1;
        }
    }

}
