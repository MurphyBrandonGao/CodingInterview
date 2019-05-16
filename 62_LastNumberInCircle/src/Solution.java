/**
 * @author Dell
 * @create 2019-05-09 9:15
 */
// 面试题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字。

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) // 特殊输入的处理
            return -1;
        if (n == 1) // 递归返回条件
            return 0;

        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
