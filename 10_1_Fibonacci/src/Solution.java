/**
 * @author Dell
 * @create 2019-03-08 10:01
 */

// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
public class Solution {
    public int Fibonacci(int n) {
        if(n <= 1)
            return n;

        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }

        return fib;
    }
}
