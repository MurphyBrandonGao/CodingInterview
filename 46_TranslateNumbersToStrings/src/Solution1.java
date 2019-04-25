/**
 * @author Dell
 * @create 2019-04-25 17:55
 */
public class Solution1 {
    public int getTranslationCount(String s) {
        if (s == null || s.length() == 0)
            return 1;

        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[n];
        res[0] = 1;
        res[1] = isInRange(chars[0], chars[1]) ? 2 : 1;
        for (int i = 2; i < n; ++i)
            res[i] = res[i - 1] + (isInRange(chars[i - 1], chars[i]) ? res[i - 2] : 0);

        return res[n - 1];
    }

    private boolean isInRange(char a, char b) {
        int s = (a - '0') * 10 + (b - '0');
        return s >= 10 && s <= 25;
    }

}
