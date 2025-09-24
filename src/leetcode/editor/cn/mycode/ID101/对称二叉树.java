package leetcode.editor.cn.mycode.ID101;

import leetcode.editor.util.TreeNode;

public class 对称二叉树 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root==null)
            {
                return true;
            }
            return isSy(root.left,root.right);

        }
        public boolean isSy(TreeNode l,TreeNode r){
            if(l==null&&r==null){
                return  true;
            }
            if(l==null||r==null){
                return false;
            }
            if(l.val!=r.val){
                return false;
            }

        return  isSy(l.right,r.left)&&isSy(l.left,r.right);

        }




    }

}
