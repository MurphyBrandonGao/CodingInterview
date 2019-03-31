/**
 * @author Dell
 * @create 2019-03-31 16:43
 */

// 面试题27：二叉树的镜像
// 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像

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

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        //如果是叶子节点则直接退出
        if (root.left == null && root.right == null)
            return;

        //交换非叶子节点的左右子树
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        //继续遍历左右子树
        Mirror(root.left);
        Mirror(root.right);
    }
}
