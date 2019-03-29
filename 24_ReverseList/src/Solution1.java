/**
 * @author Dell
 * @create 2019-03-29 20:05
 */
//方法二：递归法(一）
public class Solution1 {

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = ReverseList(head.next);
        ListNode cur = node;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        head.next = null;
        return node;
    }
}
