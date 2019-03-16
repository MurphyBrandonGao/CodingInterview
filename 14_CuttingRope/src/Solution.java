/**
 * @author Dell
 * @create 2019-03-12 22:53
 */
// 面试题14：剪绳子
// 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。

//动态规划法 时间复杂度O(n^2),空间复杂度O(n)
public class Solution {
    public int integerBreak(int n) {
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
        for (int i = 4; i <= n; i++)
            for (int j = 1; j <= i/2; j++)
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);

        return dp[n];
    }
}
