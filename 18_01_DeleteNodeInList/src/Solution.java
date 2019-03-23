import java.util.List;

/**
 * @author Dell
 * @create 2019-03-23 16:44
 */
// 面试题18（一）：在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点

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
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除链表的节点
     * @param head 链表头结点
     * @param tobeDelete 待删除的节点
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null)
            return null;

        if (tobeDelete.next != null) {
            //待删除的节点不是尾节点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            if (head == tobeDelete)
                //链表只有一个节点
                head = null;
            else {
                //待删除节点是尾节点
                ListNode cur = head;
                while (cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }
}
