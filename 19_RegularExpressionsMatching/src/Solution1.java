/**
 * @author Dell
 * @create 2019-03-24 15:30
 */
public class Solution1 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return  false;

        return isMatch(str, 0, str.length, pattern, 0, pattern.length);
    }

    private boolean isMatch(char[] str, int i, int len1, char[] pattern, int j, int len2) {
        if (i == len1 && j == len2)
            return true;

        //pattern已经走到最后，而str还有未匹配的
        //str已经走到最后，而pattern还没走完，此时是允许的
        if (j == len2)
            return false;

        if (j + 1 < len2 && pattern[j + 1] == '*') {
            if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                return isMatch(str, i, len1, pattern, j + 2, len2)
                        || isMatch(str, i + 1, len1, pattern, j, len2)
                        || isMatch(str, i + 1, len1, pattern, j + 2, len2);
            }
            return isMatch(str, i, len1, pattern, j + 2, len2);
        }

        if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
            return isMatch(str, i + 1, len1, pattern, j + 1, len2);
        }

        return false;
    }
}
