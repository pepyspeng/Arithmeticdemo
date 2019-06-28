package j.com.lib.offer;


/**
 * Created by pepys on 2019/6/26
 * description:给一个数。求其转化为2进制后，1的个数
 * 例如：10转1010  返回2
 */
public class offer_10_NumberFor1 {


    public static int numberFor1(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }

}
