package j.com.lib.offer;


/**
 * Created by pepys on 2019/6/26
 * description:给一个数。求其转化为2进制后，1的个数
 * 例如：10转1010  返回2
 */
public class offer_10_NumberFor1 {

    public static void main(String[] args){
        System.out.println(
                "count:"+numberFor1(1087865780)
        );
    }

    /**
     * 一个数减一后与它本身做与运算运算是相当于把二进制最右边的1变成0
     *
     * 9的二进制  1001
     * 8的二进制  1000
     * 做与运算     &
     * 结果       1000
     * @param n
     * @return
     */
    public static int numberFor1(int n) {
        int count = 0;
        System.out.println(n+"转二进制："+Integer.toBinaryString(n));
        while (n != 0) {
            count++;
            n = (n - 1) & n;
            System.out.println(
                    "n:"+n
            );
        }

        return count;
    }

}
