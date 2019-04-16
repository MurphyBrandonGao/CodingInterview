import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dell
 * @create 2019-04-16 19:38
 */
//面试题41_2:请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
// 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。

public class Solution {

    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
