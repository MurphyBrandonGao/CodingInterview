/**
 * @author Dell
 * @create 2019-03-10 16:37
 */

// 面试题12：矩阵中的路径
// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length != rows * cols || str == null)
            return false;

        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                //以矩阵中的每个点作为起点尝试走出str对应的路径
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, visited))
                    return true;

        return false;
    }

    //当前在矩阵的(i,j)位置上
    //index -> 匹配到了str中的第几个字符
    private boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int index, boolean[] visited) {
        if (index == str.length)
            return true;

        //越界或字符不匹配或该位置已在路径上
        if (!match(matrix, rows, cols, i, j, str[index]) || visited[i * cols + j] == true)
            return false;

        visited[i * cols + j] = true;
        boolean res = hasPathCore(matrix, rows, cols, i + 1, j, str, index + 1, visited)
                || hasPathCore(matrix, rows, cols, i - 1, j, str, index + 1, visited)
                || hasPathCore(matrix, rows, cols, i, j + 1, str, index + 1, visited)
                || hasPathCore(matrix, rows, cols, i, j - 1, str, index + 1, visited);
        visited[i * cols + j] = false;
        return res;
    }

    private boolean match(char[] matrix, int rows, int cols, int i, int j, char c) {
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1)
            return false;

        return matrix[i * cols + j] == c;
    }
}
