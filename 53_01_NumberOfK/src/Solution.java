/**
 * @author Dell
 * @create 2019-04-30 15:23
 */
// 面试题53（一）：数字在排序数组中出现的次数
// 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
// 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int k) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int m = l + (h - l) >> 1;
            if (nums[m] >= k)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }

}
