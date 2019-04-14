/**
 * @author Dell
 * @create 2019-04-14 18:23
 */
// 面试题39：数组中出现次数超过一半的数字
// 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
// 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
// 出现了5次，超过数组长度的一半，因此输出2。

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int majority = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            cnt = array[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = array[i];
                cnt = 1;
            }
        }
        int i = 0;
        for (int val : array)
            if (val == majority)
                i++;

        return i > array.length / 2 ? majority : 0;
    }
}
