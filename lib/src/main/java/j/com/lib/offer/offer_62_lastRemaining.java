package j.com.lib.offer;


/**
 * 约瑟夫环  圆圈中最后剩下的数字
 * <p>
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class offer_62_lastRemaining {
    /**
     * 约瑟夫环定义是
     * dp[1] =0;
     * dp[i] = (dp[i-1]+m)%i
     *
     * @param m
     * @param n
     * @return
     */
    public int lastRemaining(int m, int n) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
