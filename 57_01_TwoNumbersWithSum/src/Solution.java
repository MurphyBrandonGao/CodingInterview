import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-05-04 10:45
 */
// 面试题57（一）：和为s的两个数字
// 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
// 的和正好是s。如果有多对数字的和等于s，输出任意一对即可
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];
            if (cur == sum)
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            if (cur < sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }
}
