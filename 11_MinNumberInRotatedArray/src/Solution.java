/**
 * @author Dell
 * @create 2019-03-09 15:03
 */

// 面试题11：旋转数组的最小数字
// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;

        if (array[0] < array[array.length - 1])
            return array[0];
        int start = 0;
        int end = array.length - 1;
        while (start + 1 != end) {
            int mid = (start + end) / 2;
            if (array[mid] > array[start])
                start = mid;
            else if (array[mid] < array[end])
                end = mid;
            else
                start++;
        }
        return array[end];
    }
}
