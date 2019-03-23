import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-03-18 19:45
 */

// 面试题17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。

//方法一:对字符数组表示的数进行递增操作，输出数字（0开头的需要把0去掉）
public class Solution {
    /**
     * 打印从1到最大的n位数
     * @param n n位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n < 1)
            return;

        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (increament(chars))
            printNumber(chars);
    }

    /**
     * 打印字符数组表示的数字（需要省略前n个0）
     * @param chars 字符数组
     */
    private void printNumber(char[] chars) {
        int i = 0;
        int n = chars.length;
        for (; i < n; ++i)
            if (chars[i] != '0')
                break;

        StringBuilder sb = new StringBuilder();
        for (; i < n; ++i)
            sb.append(chars[i]);

        System.out.println(sb.toString());
    }

    private boolean increament(char[] chars) {
        int n = chars.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; --i) {
            int sum = chars[i] - '0' + carry;
            if (sum > 9) {
                if (i == 0)
                    return false;

                chars[i] = '0';
            } else {
                ++chars[i];
                break;
            }
        }
        return true;
    }

}
