/**
 * @author Dell
 * @create 2019-03-29 19:54
 */
// 面试题24：反转链表
// 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
// 头结点。

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//方法一：头插法
public class Solution {

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

        ListNode dummyNode = new ListNode(-1);
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            p.next = dummyNode.next;
            dummyNode.next = p;
            p = q;
            q = q.next;
        }
        p.next = dummyNode.next;
        return p;
    }
}
