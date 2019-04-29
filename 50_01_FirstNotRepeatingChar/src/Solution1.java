import java.util.BitSet;

/**
 * @author Dell
 * @create 2019-04-28 15:03
 */

//考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有0,1,更大，使用两个比特位就能存储这些信息
public class Solution1 {
    public int FirstNotRepeatingChar(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                bs1.set(c); // 0 0 -> 0 1
            else if (bs1.get(c) && !bs2.get(c))
                bs2.set(c);// 0 1 -> 1 1
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c)) // 0 1
                return i;
        }

        return -1;
    }
}