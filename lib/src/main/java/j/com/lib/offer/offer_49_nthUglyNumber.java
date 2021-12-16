package j.com.lib.offer;

public class offer_49_nthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public  static int nth(int index){

         int[] dp = new int[index+1];
         dp[1]=1;
         int p2 = 1;
         int p3 = 1;
         int  p5 = 1;
         for(int i = 2;i<=index;i++){
             int num2 = dp[p2] * 2;
             int num3 = dp[p3] * 3;
             int num5 = dp[p5] * 5;
             dp[i] = Math.min(Math.min(num2,num3),num5);
             if(dp[i] == num2){
                 p2++;
             }
              if(dp[i] == num3){
                 p3++;
             }
              if(dp[i] == num5){
                 p5++;
             }
         }
         return dp[index];
    }

    public static int nthUglyNumber(int index) {
        int[] dp = new int[index + 1];
        dp[1] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        for (int i = 2; i <= index; i++) {
            int num2 = dp[index2] * 2;
            int num3 = dp[index3] * 3;
            int num5 = dp[index5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                index2++;
            }
            if (dp[i] == num3) {
                index3++;
            }
            if (dp[i] == num5) {
                index5++;
            }
        }
        return dp[index];
    }

}
