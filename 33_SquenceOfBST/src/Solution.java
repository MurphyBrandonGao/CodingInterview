/**
 * @author Dell
 * @create 2019-04-07 16:39
 */
// 面试题33：二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        return verity(sequence, 0, sequence.length - 1);
    }

    private boolean verity(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;

        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;
        for (int i = cutIndex; i < last; i++)
            if (sequence[i] < rootVal)
                return false;
        return verity(sequence, first, cutIndex - 1) && verity(sequence, cutIndex, last - 1);
    }
}
