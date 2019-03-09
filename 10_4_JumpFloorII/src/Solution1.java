import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-03-09 10:54
 */

//面试题10_4:一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
// 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//方法二：数学推导
public class Solution2 {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}

