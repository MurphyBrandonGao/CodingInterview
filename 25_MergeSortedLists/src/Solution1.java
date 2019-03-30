/**
 * @author Dell
 * @create 2019-03-30 16:55
 */
//方法二：递归法
public class Solution1 {

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        }

        list2.next = Merge(list1, list2.next);
        return list2;
    }

}
