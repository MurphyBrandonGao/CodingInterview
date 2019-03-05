import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Dell
 * @create 2019-03-03 17:49
 */

// 面试题6：从尾到头打印链表
// 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
// 方法三：使用栈
public class Solution3 {

    private class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //使用栈这种数据结构
        Stack<Integer> stack = new Stack<>();
        //将链表元素全部放在栈里面
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        //取出栈里面的元素
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }

        return ret;
    }
}