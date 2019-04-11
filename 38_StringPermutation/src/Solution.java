import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-04-11 15:23
 */

// 面试题38：字符串的排列
// 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
// 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。

public class Solution {

    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder stringBuilder) {
        if (stringBuilder.length() == chars.length) {
            ret.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) // 保证不重复
                continue;

            hasUsed[i] = true;
            stringBuilder.append(chars[i]);
            backtracking(chars, hasUsed, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            hasUsed[i] = false;
        }
    }
}
