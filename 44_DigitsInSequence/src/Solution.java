/**
 * @author Dell
 * @create 2019-04-25 16:25
 */
// 面试题44：数字序列中某一位的数字
// 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
// 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
// 个函数求任意位对应的数字
public class Solution {
    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;

        int place = 1;//1表示个位，2表示十位...
        while (true) {
            int amount = getAmountOfPlace(place);
            int totalAmount = amount * place;
            if (index < totalAmount)
                return getDigitAtIndex(index, place);
            index -= totalAmount;
            place++;
        }
    }

    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }

    /**
     *
     * @param place 位数的其实数字
     * @return
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;

        return (int) Math.pow(10, place - 1);
    }

    /**
     *
     * @param place 位数的数字组成的字符串长度
     * @return
     */
    private int getAmountOfPlace(int place) {
        if (place == 1)
            return 10;

        return (int) Math.pow(10, place - 1) * 9;
    }
}
