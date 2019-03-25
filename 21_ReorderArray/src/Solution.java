/**
 * @author Dell
 * @create 2019-03-25 13:53
 */

// 面试题21：调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分，且保证奇数与奇数，偶数与偶数之间的相对位置不变
public class Solution {
    /**
     * 调整数组元素，使得奇数元素位于偶数元素前面，且保证奇数与奇数，偶数与偶数之间的相对位置不变
     * @param nums 数组
     */
    public void reOrderArray(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int oddCnt = 0;
        for (int val : nums)
            if (val % 2 == 1)
                oddCnt++;

        int[] copy = nums.clone();
        int i = 0;
        int j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1)
                nums[i++] = num;
            else
                nums[j++] = num;
        }
    }
}
