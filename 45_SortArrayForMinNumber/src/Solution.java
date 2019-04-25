import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-04-25 16:56
 */
// 面试题45：把数组排成最小的数
// 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
// 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
// 字能排成的最小数字321323。
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
//            nums[i] = numbers[i] + "";
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : nums)
            sb.append(str);

        return sb.toString();
    }
}
