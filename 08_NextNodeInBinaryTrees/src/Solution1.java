/**
 * @author Dell
 * @create 2019-03-05 18:54
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
public class Solution1 {

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
            //如果右子树不为空，那么中序遍历的下一个节点就是右子树中的最左的那个节点
            TreeLinkNode temp = pNode.right;
            while (temp.left != null)
                temp = temp.left;

            return temp;
        }

        TreeLinkNode temp = pNode.next; //父节点
        TreeLinkNode pre = pNode; //当前节点
        while (temp != null) {
            if (temp.left == pre)
                return temp;//如果当前节点pre是父节点的左子树，那么父节点就是下一个节点，终止循环
            pre = temp;//如果不是，那么pre就指向父节点
            temp = temp.next;//父节点指向自己的父节点，也就是向上一层移动
        }

        return temp;
    }
}
