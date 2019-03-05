/**
 * @author Dell
 * @create 2019-03-04 22:50
 */

// 面试题7：重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
// 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {

    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinary(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length ==0 ||
                pre.length != in.length)
            return null;

        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode rebuild(int[] pre, int i, int j, int[] in, int m, int n) {
        int rootVal = pre[i];
        int index = findIndex(rootVal, in, m, n);
        if (index < 0)
            return null;

        int leftNodes = index - m;
        int rightNodes = n - index;
        TreeNode root = new TreeNode(rootVal);

        if (leftNodes == 0) {
            root.left = null;
        } else {
            root.left = rebuild(pre, i + 1, i + leftNodes, in, m, m + leftNodes -1);
        }

        if (rightNodes == 0) {
            root.right = null;
        } else {
            root.right = rebuild(pre, i + leftNodes + 1, j, in, n - rightNodes + 1, n);
        }

        return root;
    }

    private int findIndex(int target, int[] arr, int from, int to) {
        for (int i = from; i < to; i++) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }

}

