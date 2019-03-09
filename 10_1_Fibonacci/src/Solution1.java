/**
 * @author Dell
 * @create 2019-03-08 10:23
 */
// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。

//由于待求解的n小于40.因此可以将前40项的结果先进行计算，之后就能以O（1）的时间复杂度得到第n项的值了
public class Solution1 {

    private int[] fib = new int[40];

    public Solution1() {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
    }

    public int Fibonacci(int n) {
        return fib[n];
    }
}
