import java.util.Arrays;

/**
 * @author Dell
 * @create 2019-03-25 15:10
 */
public class Solution1 {
    public void reOrderArray(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        Integer[] bak = new Integer[nums.length];
        Arrays.setAll(bak, i->nums[i]);
        Arrays.sort(bak, (x, y) -> (y & 1) - (x & 1));
        Arrays.setAll(nums, i -> bak[i]);
    }
}
