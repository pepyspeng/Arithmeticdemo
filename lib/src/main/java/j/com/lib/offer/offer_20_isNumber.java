package j.com.lib.offer;

public class offer_20_isNumber {

    public static void main(String[] args) {
        System.out.println(strToInt("42"));
    }

    /**
     * 把字符串转换成整数
     *
     * @param s
     * @return
     */
    public static int strToInt(String s) {
        char[] array = s.trim().toCharArray();
        if (array.length == 0) {
            return 0;
        }
        int result = 0;
        //用来计算最后一位是不是越界。
        int max = Integer.MAX_VALUE / 10;
        //代码符号位
        int sign = 1;
        int index = 1;
        if (array[0] == '-') {
            //说明是负数
            sign = -1;
        } else if (array[1] != '+') {
            //说明是正数
            index = 0;
        }
        for (int i = index; i < array.length; i++) {
            //比较ASCII
            if (array[i] < '0' || array[i] > '9') {
                //说明不是数字了
                break;
            }
            if (result > max || (result == max && array[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (array[i] - '0');
        }
        return sign * result;
    }
}
