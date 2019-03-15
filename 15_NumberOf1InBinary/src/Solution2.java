/**
 * @author Dell
 * @create 2019-03-15 21:19
 */
// 面试题15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2

//方法三：利用java中的API
public class Solution2 {
    /**
     *
     * @param n 整数
     * @return 该整数的二进制中1的个数
     */
    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }
}
