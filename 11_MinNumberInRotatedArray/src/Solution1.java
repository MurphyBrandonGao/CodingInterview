/**
 * @author Dell
 * @create 2019-03-10 15:14
 */

// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
public class Solution1 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;

        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            //当array[l] == array[m] == array[h]时，那么此时无法确定解在哪个区间，需要切换到顺序查找。
            if (array[l] == array[m] && array[m] == array[h])
                return minNumber(array, l, h);
            else if (array[m] <= array[h])
                h = m;
            else
                l = m + 1;
        }

        return array[l];
    }

    //顺序查找
    private int minNumber(int[] array, int l, int h) {
        for (int i = l; i < h; i++)
            if (array[i] > array[i + 1])
                return array[i + 1];

        return array[l];
    }
}
