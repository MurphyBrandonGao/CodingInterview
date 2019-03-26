/**
 * @author Dell
 * @create 2019-03-26 17:50
 */
// 面试题22：链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 1)
            return null;

        ListNode pre = head;
        for (int i = 0; i < k - 1; i++) {
            if (pre.next != null)
                pre = pre.next;
            else
                return null;
        }
        ListNode cur = head;
        while (pre.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
