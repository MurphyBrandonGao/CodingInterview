import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dell
 * @create 2019-04-15 9:01
 */
//时间复杂度为O(NlogK),空间复杂度为O(K)
//适合处理海量数据
public class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || k <= 0 || input == null || input.length == 0)
            return new ArrayList<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (o1, o2) -> o2 - o1);
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
