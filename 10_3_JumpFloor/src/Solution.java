/**
 * @author Dell
 * @create 2019-03-09 10:14
 */

//面试题10_3:一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
public class Solution {
    public int JumpFloor(int target) {
        if (target <= 2)
            return target;

        int pre2 = 1;
        int pre1 = 2;
        int result = 1;
        for (int i = 2; i < target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }
}
