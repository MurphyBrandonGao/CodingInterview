/**
 * @author Dell
 * @create 2019-04-30 14:44
 */
//方法二：先遍历两链表，求出两链表的长度，再求长度差|n1-n2|,较长的链先走|n1-n2|步，之后两链表
//再同时走，首次相遇时的节点即为两链表的第一个公共节点
public class Solution1 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;

        int len1 = len(pHead1);
        int len2 = len(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; ++i)
                p1 = p1.next;
        } else if (len1 < len2) {
            for (int i = 0; i < len2 - len1; ++i)
                p2 = p2.next;
        }
        while (p1 != p2 && p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return (p1 == null || p2 == null) ? null : p1;
    }

    private int len(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return n;
    }
}