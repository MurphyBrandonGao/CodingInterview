import java.util.ArrayList;

/**
 * @author Dell
 * @create 2019-04-14 20:42
 */

// 面试题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > input.length || k <= 0)
            return ret;
        findKthSmallest(input, k - 1);
        //findKthSmallest会改变数组，使得前k个数都是最小的k个数
        for (int i = 0; i < k; i++)
            ret.add(input[i]);
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] nums, int l, int h) {
        int p = nums[l]; //切分元素
        int i = l;
        int j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p);
            while (j != l && nums[--j] > p);
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
