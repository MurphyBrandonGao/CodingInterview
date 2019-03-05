/**
 * @author Dell
 * @create 2019-03-02 18:31
 */

// 面试题5：替换空格
// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
public class Solution1 {
    public String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        if(str1.equals(""))
            return str1;

        //把字符串数组转化为字符数组
        char[] strArray = str1.toCharArray();
        int i = 0;
        int lengthSpace = 0;
        while (i < strArray.length) {
            if (strArray[i] == ' ')
                lengthSpace++;
            i++;
        }

        int newStringLength = strArray.length + lengthSpace * 2;
        char[] newStr = new char[newStringLength];
        int j = newStringLength - 1;
        i = strArray.length - 1;
        while (i >= 0) {
            if(strArray[i] != ' ') {
                newStr[j--] = strArray[i--];
            } else {
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
                i--;
            }
        }

        return new String(newStr);
    }
}
