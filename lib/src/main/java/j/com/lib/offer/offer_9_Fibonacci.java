package j.com.lib.offer;

/**
 * Created by pepys on 2019/6/26
 * description:斐波那契
 * 一次可以走一步台阶。也可行走二步台阶。走n个台阶的
 * f(n) = f(n-1)+f(n-2)
 */
public class offer_9_Fibonacci {

    public static void main(String[] args) {
        System.out.println(jumpFloor(4));
    }

    public static int jumpFloor(int target) {

        int[] result = new int[target+1];
        result[0]=1;
        result[1]=1;
        for(int i =2;i<=target;i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[target];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int getFibonacci(int n) {
        if(n ==0 ||n ==1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 斐波那契
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
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
