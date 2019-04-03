import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dell
 * @create 2019-04-03 13:38
 */
// 面试题32（一）：不分行从上往下打印二叉树
// 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。

public class Solution {
    /**
     * 从上到下打印二叉树
     * @param root 二叉树根节点
     * @return 结果list
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

            list.add(node.val);
        }
        return list;
    }
}
