import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-04-27 14:37
 */
// 面试题48：最长不含重复字符的子字符串
// 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
// 字符串的长度。假设字符串中只包含从'a'到'z'的字符
public class Solution {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        //preIndexs存储每个字符上次出现在字符串中的位置
        int[] preIndexs = new int[26];
        //-1表示该元素对应字符在字符串中还没出现过
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen)
                curLen++;
            else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
