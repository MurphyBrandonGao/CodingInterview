/**
 * @author Dell
 * @create 2019-05-05 14:39
 */
//先对字符串按空格切割成数组，再逆序数组后，最后将元素拼接并返回
public class Solution1 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() < 2 || str == " ")
            return str;

        String[] arr = str.split(" ");
        int p = 0;
        int q = arr.length - 1;
        while (p < q)
            swap(arr, p++, q--);

        return String.join(" ", arr);
    }

    private void swap(String[] arr, int p, int q) {
        String t = arr[p];
        arr[p] = arr[q];
        arr[q] = t;
    }
}