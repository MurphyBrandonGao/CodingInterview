import java.util.Stack;
/**
 * @author Dell
 * @create 2019-04-09 19:22
 */

//方法二：非递归
public class Solution1 {

    /**
     * 将二叉搜索树转换为双向链表
     * @param pRootOfTree 二叉搜索树根节点
     * @return 双向链表头结点
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode res = null;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null) {
                    pre = cur;
                    res = pre;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}
