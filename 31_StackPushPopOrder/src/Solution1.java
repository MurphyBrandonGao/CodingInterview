import java.util.Stack;

/**
 * @author Dell
 * @create 2019-04-02 10:40
 */
public class Solution1 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int n = pushA.length;
        boolean flag = false;
        for (int val : popA) {
            while (stack.isEmpty() || stack.peek() != val) {
                if (i >= n) {
                    flag = true;
                    break;
                }
                stack.push(pushA[i++]);
            }
            if (flag)
                break;

            stack.pop();
        }

        return stack.isEmpty();
    }
}
