package j.com.lib.offer;

/**
 * Created by pepys on 2019/6/26
 * description:斐波那契
 * 一次可以走一步台阶。也可行走二步台阶。走n个台阶的
 * f(n) = f(n-1)+f(n-2)
 */
public class offer_9_Fibonacci {

    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int getFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 斐波那契
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
