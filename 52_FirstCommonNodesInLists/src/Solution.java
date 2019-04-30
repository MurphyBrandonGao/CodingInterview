/**
 * @author Dell
 * @create 2019-04-30 11:50
 */
// 面试题52：两个链表的第一个公共结点
// 题目：输入两个链表，找出它们的第一个公共结点

//方法一：当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
// 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
// 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
