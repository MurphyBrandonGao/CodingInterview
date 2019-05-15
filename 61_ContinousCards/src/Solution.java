import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-05-08 15:44
 */
// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5)
            return false;

        Arrays.sort(numbers);

        //统计0（大小王）的数量
        int cnt = 0;
        for (int num : numbers)
            if (num == 0)
                cnt++;

        //使用0去补全不连续的顺子
        for (int i = cnt; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i])
                return false;
            cnt -= numbers[i + 1] - numbers[i] - 1;
        }

        return cnt >= 0;
    }
}
