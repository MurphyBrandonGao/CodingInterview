/**
 * @author Dell
 * @create 2019-03-15 19:38
 */
// 面试题15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2

//方法一：n有多少位，i就要左移多少位
public class Solution {
    /**
     *
     * @param n 整数
     * @return 该整数的二进制中1的个数
     */
    public int NumberOf1(int n) {
        int i = 1;
        int cnt = 0;
        while (i != 0) {
            if ((n & i) != 0)
                ++cnt;

            i <<= 1;
        }

        return cnt;
    }
}
