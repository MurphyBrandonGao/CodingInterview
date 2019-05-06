import java.util.ArrayList;

/**
 * @author Dell
 * @create 2019-05-04 11:35
 */
public class Solution1 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3)
            return res;

        int p = 1;
        int q = 2;
        int mid = (1 + sum) >> 1;
        int curSum = p + q;
        while (p < mid) {
            if (curSum == sum)
                res.add(getList(p, q));
            while (curSum > sum && p < mid) {
                curSum -= p;
                p++;
                if (curSum == sum)
                    res.add(getList(p, q));
            }
            ++q;
            curSum += q;
        }
        return res;
    }

    private ArrayList<Integer> getList(int from, int to) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = from; i <= to; i++)
            res.add(i);
        return res;
    }
}