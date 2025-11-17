public class 二叉树展开为链表{

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);
        //先暂时存下 右边的
        TreeNode r = root.right;
        //将左边接到右边去/
        root.right = root.left;
        //将原来的左清空
        root.left = null;

        //找到接上的结尾
        while (root.right != null) {
            root = root.right;
        }
        //将暂存的右边接上
        root.right = r;
    }
}

}