package j.com.lib.offer;

public class offer_20_isNumber {

    public static void main(String[] args) {
        System.out.println(strToInt1("+1"));
    }

    public static int strToInt1(String str) {
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }

        //用来表示符号位
        int sign = 1;
        //用来表示循环index
        int index= 1;
        //查看首位是什么
        char first = str.charAt(0);
        if(first == '-'){
            //如果是首位是负号
            sign = -1;
        }else if (first != '+'){
            //如果是正号，那么从第二个开始遍历
            index= 0;
        }
        int max = Integer.MAX_VALUE / 10;
        int result = 0;
        for(int i = index;i<str.length();i++){
            char c = str.charAt(i);
            if(c <'0'|| c>'9'){
                //如果不是数字
                break;
            }
            if(result>max || (result == max && c>'7')){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result*10 + (c-'0');

        }
        return sign*result;
    }

    /**
     * 表示数值的字符串:判断字符串是否是数字类型
     *
     * 难点是列出所有状态。
     * '.'出现的正确情况：只出现一次，且在e的前面
     * 'e'出现的正确情况：只出现一次，且出现前有数字
     * '+'，'-'出现的正确情况：只能在开头或者e后一位
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c >= '0' && c <= '9') {
                //说明是数字
                numFlag = true;
            } else if (c == '.' && !eFlag && !dotFlag) {
                //字符是'.',没有出现过e,并且没有出现过 '.'
                dotFlag = true;
            } else if ((c == 'e' || c == 'E') && numFlag && !eFlag) {
                //字符是e/E，前面必须出现过数字，并且没有出现过 e/E
                eFlag = true;
                //为了避免123e这种请求，出现e之后就标志为false
                numFlag = false;
            } else if ((c == '+' || c == '-') && (i == 0 || array[i - 1] == 'e' || array[i - 1] == 'E')) {
                //如果是 + - ,那么要么出现在首为，要么出现在e/E后面
            } else {
                return false;
            }
        }
        return numFlag;
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
        // index 代表array从何处开始遍历
        int index = 1;
        if (array[0] == '-') {
            //说明是负数
            sign = -1;
        } else if (array[0] != '+') {
            //说明是正数
            index = 0;
        }
        for (int i = index; i < array.length; i++) {
            //比较ASCII
            if (array[i] < '0' || array[i] > '9') {
                //说明不是数字了
                break;
            }

            //判断遍历到j-1的位置后  res是否大于limit 如果当前res已经大于limit  加上array[j]一定越界
            //当res等于limit时，我们需要判断array[j]是否大于Integer.MAX_VALUE的末位数7
            if (result > max || (result == max && array[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //字符获取数字需要 - '0' 的位移
            result = result * 10 + (array[i] - '0');
        }
        return sign * result;
    }
}
