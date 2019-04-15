/**
 * @author Dell
 * @create 2019-04-15 15:28
 */
//利用快速排序中的partition思想
//时间复杂度为O(n),会改变输入的数组
public class Solution1 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int n = array.length;
        int start = 0;
        int end = n - 1;
        int mid = n >> 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index > mid)
                end = index - 1;
            else
                start = index + 1;

            index = partition(array, start, end);
        }

        return isMoreThanHalf(array, array[index]) ? array[index] : 0;
    }

    private boolean isMoreThanHalf(int[] array, int val) {
        int cnt = 0;
        for (int e : array) {
            if (e == val)
                ++cnt;
        }
        return cnt * 2 > array.length;
    }

    /**
     * 快排中的partition方法
     * @param array 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */
    private int partition(int[] array, int start, int end) {
        int small = start - 1;
        for (int i = start; i < end; ++i) {
            if (array[i] < array[end])
                swap(array, i, ++small);
        }
        ++small;
        swap(array, small, end);
        return small;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
