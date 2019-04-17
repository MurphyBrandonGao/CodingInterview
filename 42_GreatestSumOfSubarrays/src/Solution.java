/**
 * @author Dell
 * @create 2019-04-17 15:36
 */
// 面试题42：连续子数组的最大和
// 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
// 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(sum, greatestSum);
        }
        return greatestSum;
    }
}
