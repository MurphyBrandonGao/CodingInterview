import java.util.ArrayList;
/**
 * @author Dell
 * @create 2019-04-08 18:09
 */
// 面试题34：二叉树中和为某一值的路径
// 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

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

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    /**
     * 找出二叉树中和为某一值的路径（必须从根节点到叶子节点）
     * @param node 二叉树的根节点
     * @param target 目标值
     * @param path 结果path
     */
    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)
            return;

        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null)
            ret.add(new ArrayList<>(path));
        else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }

        path.remove(path.size()  - 1);
    }
}
