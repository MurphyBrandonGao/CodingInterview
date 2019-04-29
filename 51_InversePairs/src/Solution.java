/**
 * @author Dell
 * @create 2019-04-29 20:51
 */
// 面试题51：数组中的逆序对
// 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
// 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class Solution {

    private long cnt = 0;
    private int[] tmp;//在这里申明辅助数组，而不是在merge()递归函数中申明

    public int InversePairs(int [] array) {
        tmp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] array, int l, int h) {
        if (h - l < 1)
            return;

        int m = l + (h - l) / 2;
        mergeSort(array, l , m);
        mergeSort(array, m + 1, h);
        merge(array, l, m, h);
    }

    private void merge(int[] array, int l, int m, int h) {
        int i = l;
        int j = m + 1;
        int k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = array[j++];
            else if (j > h)
                tmp[k] = array[i++];
            else if (array[i] < array[j])
                tmp[k] = array[i++];
            else {
                tmp[k] = array[j++];
                this.cnt += m - i + 1; //nums[i] >= nums[j],说明nums[i...mid]都大于nums[j]
            }
            k++;
        }
        for (k = l; k <= h; k++)
            array[k] = tmp[k];
    }
}
