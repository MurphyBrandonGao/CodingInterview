/**
 * @author Dell
 * @create 2019-05-17 14:42
 */
// 面试题67：把字符串转换成整数
// 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
// 能使用atoi或者其他类似的库函数

public class Solution {
    public int StrToInt(String str) {
        if (str.length() == 0 || str == null)
            return 0;

        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) //符号判定
                continue;
            if (c < '0' || c > '9') //非法输入
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
