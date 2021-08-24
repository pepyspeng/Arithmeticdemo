package j.com.lib.offer;

/**
 * 把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
 */
public class offer_43_GetUglyNumber {
    public static void main(String[] args) {
        System.out.println((GetUglyNumber_Solution(10)));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 6) {
            return index;
        }
        int[] dp = new int[index + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= index; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[index];
    }
}
