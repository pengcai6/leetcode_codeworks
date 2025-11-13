package leetcode.editor.cn.mycode.ID230;

import leetcode.editor.util.TreeNode;

public class 二叉搜索树中第K小的元素 {

    class Solution {
        class NodeRes {
            int SumCount;
            boolean isFind;
            int target;
        }
        //二叉树题目主要以递归解决为主

        public int kthSmallest(TreeNode root, int k) {


            return process(root, k).target;
        }

        public NodeRes process(TreeNode root, int k) {
            int SumCount = 1;
            //左
            if (root.left != null) {
                final NodeRes left = process(root.left, k);
                if (left.isFind) {
                    return left;
                }
                SumCount += left.SumCount;
            }
            //中
            if (SumCount == k) {
                NodeRes res = new NodeRes();
                res.isFind = true;
                res.target = root.val;
                return res;
            }
            //右
            if (root.right != null) {
                //注意，右边需要剪掉左中的数量
                final NodeRes right = process(root.right, k-SumCount);
                if (right.isFind) {
                    return right;
                }
                SumCount -= right.SumCount;
            }
            //都没找到

            NodeRes res = new NodeRes();
            res.isFind = false;
            res.SumCount = SumCount;
            return res;

        }

    }

}
