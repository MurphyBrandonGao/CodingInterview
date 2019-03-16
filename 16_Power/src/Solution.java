/**
 * @author Dell
 * @create 2019-03-16 13:37
 */
// 面试题16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent
// 次方。不得使用库函数，同时不需要考虑大数问题。

//方法一 时间复杂度O(n)
public class Solution {
    /**
     *
     * @param base 底数
     * @param exponent 指数
     * @return 数值的整数次方
     */
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res *= base;
        }

        return exponent > 0 ? res : 1 / res;
    }
}
