/**
 * @author Dell
 * @create 2019-03-02 16:12
 */

// 面试题4：二维数组中的查找
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        //特殊情况处理
        if(array == null || array.length == 0 || array[0].length == 0)
            return false;

        int h = array.length - 1;
        int w = array[0].length - 1;

        //如果目标值小于最小值 或者 目标值大于最大值，那肯定不存在
        if (array[0][0] > target || array[h][w] < target)
            return false;

        return binarySearchIn2DArray(array, target, 0, h, 0, w);
    }

    private boolean binarySearchIn2DArray(int[][] array, int target, int startX, int endX, int startY, int endY) {
        if(startX > endX || startY > endY)
            return false;

        //首先，根据二分法找出中间行
        int x = (startX + endX) / 2;
        //对该行进行二分查找
        int result = binarySearch(array[x], target, startY, endY);
        //找到的值位于x行，result列
        if(array[x][result] == target)
            return true;

        //对剩余的两部分分别进行递归查找
        return binarySearchIn2DArray(array, target, x + 1, endX, startY, result) ||
                binarySearchIn2DArray(array, target, startX, x - 1, result + 1, endY);
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        int i = (start + end) / 2;
        if(array[i] == target || start > end) {
            return i;
        } else if (array[i] > target) {
            return binarySearch(array, target, start, i - 1);
        } else {
            return binarySearch(array, target, i + 1, end);
        }
    }

}
