/**
 * @author Dell
 * @create 2019-03-30 17:40
 */

// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        boolean res = false;
        if (root1.val == root2.val)
            res = isSubtreeWithRoot(root1, root2);

        if (!res)
            res = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

        return res;
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;

        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
