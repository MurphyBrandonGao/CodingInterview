/**
 * @author Dell
 * @create 2019-05-01 10:30
 */
// 面试题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。
public class Solution {
    /**
     * 获取0 ~ n - 1缺失的数字
     * @param nums 数组
     * @return 缺失的数字
     */
    public int getMissingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return start == n ? n : -1;
    }
}
