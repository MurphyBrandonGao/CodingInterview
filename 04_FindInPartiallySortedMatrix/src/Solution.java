/**
 * @author Dell
 * @create 2019-03-02 15:56
 */

// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class Solution {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;

        int rows = array.length, cols = array[0].length;
        int i = 0, j = cols - 1; //从右上角开始
        while (i < rows && j >= 0) {
            if (target == array[i][j])
                return true;
            else if (target > array[i][j])
                i++;
            else
                j--;
        }

        return false;
    }

}