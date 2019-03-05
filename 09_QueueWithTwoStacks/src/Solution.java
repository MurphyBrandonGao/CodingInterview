import java.util.Stack;

/**
 * @author Dell
 * @create 2019-03-05 20:26
 */

// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        if (stack2.isEmpty())
            try {
                throw new Exception("queue is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }

        return stack2.pop();
    }
}
