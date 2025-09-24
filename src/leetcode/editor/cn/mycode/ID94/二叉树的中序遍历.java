package leetcode.editor.cn.mycode.ID94;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            while (root != null || !deque.isEmpty()) {
                while (root != null) {
                    deque.push(root);
                    root = root.left;
                }
                final TreeNode pop = deque.pop();
                res.add(pop.val);
                root = pop.right;
            }
            return res;

        }
    }

}

