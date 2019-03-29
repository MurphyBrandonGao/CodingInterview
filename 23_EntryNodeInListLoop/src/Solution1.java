import java.util.List;

/**
 * @author Dell
 * @create 2019-03-27 20:18
 */
public class Solution1 {
    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead != null || pHead.next != null)
            return null;

        ListNode slow = pHead;
        ListNode fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
