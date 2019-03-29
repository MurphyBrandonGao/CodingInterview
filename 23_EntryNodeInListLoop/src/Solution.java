/**
 * @author Dell
 * @create 2019-03-27 19:58
 */
// 面试题23：链表中环的入口结点
// 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
// 环的入口结点是结点3。

/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 求链表环的入口，若没有环，则返回Null
     * @param pHead 链表头
     * @return 环的入口点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }

        //快指针与慢指针没有相遇，说明无环，返回null
        if (!flag)
            return null;

        //求出环的节点个数
        ListNode cur = slow.next;
        int cnt = 1;
        while (cur != slow) {
            cur = cur.next;
            ++cnt;
        }

        //指针先走环的节点个数步
        ListNode p1 = pHead;
        for (int i = 0; i < cnt; i++)
            p1 = p1.next;

        //p2指向链表头，然后p1 p2同时走，首先相遇的地方就是入口
        ListNode p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p1 = p2.next;
        }
        return p1;
    }
}
