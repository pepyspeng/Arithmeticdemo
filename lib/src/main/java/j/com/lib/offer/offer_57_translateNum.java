package j.com.lib.offer;

import java.util.HashMap;

/**
 * 把数字翻译成字符串
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class offer_57_translateNum {


    public int translateNum1(int num) {
        String str = String.valueOf(num);
        int a = 1;
        int b = 1;

        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);
            int c = 0;
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                c = a + b;
            } else {
                c = a;
            }
            b = a;
            a = c;
        }
        return a;
    }


    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 > 9 && num % 100 <= 25) {
            // ba=[10, 25]时，既可以当做一个字母，也可以当做两个字母
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            //如果小于等于9或者大于等于26的时候，余数不能按照2位数字组合，比如56，只能拆分为5和6；反例25，可以拆分为2和5，也可以作为25一个整体进行翻译。
            return translateNum(num / 10);
        }
    }

}
