/**
 * @author Dell
 * @create 2019-03-05 13:39
 */

// 面试题8：二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    private class TreeLinkNode {
        public int val;
        public TreeLinkNode left = null;
        public TreeLinkNode right = null;
        public TreeLinkNode next = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;

        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parentNode = pNode.next;
                if (parentNode.left == pNode)
                    return parentNode;

                pNode = pNode.next;
            }
        }

        return null;
    }
}
