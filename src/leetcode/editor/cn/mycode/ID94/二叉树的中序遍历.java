package leetcode.editor.cn.mycode.ID94;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                getValue(root, res);
            }
            return res;
        }

        public void getValue(TreeNode root, List<Integer> res) {
            //中序遍历
            if (root.left != null) {
                getValue(root.left, res);
            }
            res.add(root.val);

            if (root.right != null) {
                getValue(root.right, res);
            }
        }

    }
}

