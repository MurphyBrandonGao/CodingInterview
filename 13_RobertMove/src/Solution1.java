/**
 * @author Dell
 * @create 2019-03-11 21:15
 */

// 面试题13：机器人的运动范围
// 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
// 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
// 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
// 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

public class Solution1 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0)
            return 0;

        boolean[] visited = new boolean[rows * cols];
        return walk(threshold, rows, cols, 0, 0, visited);

    }

    //walk方法能统计从rows行col列的矩阵中的(i,j)开始所能到达的格子并返回
    private int walk(int threshold, int rows, int cols, int i, int j, boolean[] visited) {
        if (!isLegalPosition(rows, cols, i, j) || visited[i * cols + j] == true
                || bitSum(i) + bitSum(j) > threshold)
            return 0;

        int res = 1;
        visited[i * cols + j] = true;
        res += walk(threshold, rows, cols, i + 1, j, visited)
                + walk(threshold, rows, cols, i - 1, j, visited)
                + walk(threshold, rows, cols, i, j + 1, visited)
                + walk(threshold, rows, cols, i, j - 1, visited);

        return res;
    }

    private boolean isLegalPosition(int rows, int cols, int i, int j) {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1)
            return false;

        return true;
    }

    private int bitSum(int num) {
        int res = num % 10;
        while ((num /= 10) != 0)
            res += num % 10;

        return res;
    }
}
