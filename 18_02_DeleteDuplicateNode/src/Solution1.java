/**
 * @author Dell
 * @create 2019-03-23 19:50
 */
public class Solution1 {
    private class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除重复节点
     * @param pHead 链表头结点
     * @return 删除重复节点后的链表
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = pHead;
        ListNode pre = node;
        ListNode p = pHead;
        boolean deletedMode = false;
        while (p != null) {
            if (p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
                deletedMode = true;
            } else if (!deletedMode) {
                pre.next = p.next;
                p = pre.next;
                deletedMode = false;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return node.next;
    }
}
