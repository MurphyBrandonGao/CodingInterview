import jdk.nashorn.internal.ir.IfNode;

/**
 * @author Dell
 * @create 2019-03-15 17:55
 */
public class Solution1 {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        //尽可能多地减去长度为3的绳子段
        int timesOf3 = n / 3;

        //当绳子最后剩下的长度为4时，不能再减去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段，因为2*2>3*1
        if (n - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) ((Math.pow(3, timesOf3)) * (Math.pow(2, timesOf2)));
    }
}
