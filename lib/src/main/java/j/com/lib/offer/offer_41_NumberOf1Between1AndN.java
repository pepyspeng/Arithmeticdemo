package j.com.lib.offer;

public class offer_41_NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int bitNum = 1;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (cur != 0 || high != 0) {
            if (cur < 0) {
                // case 1 : cur == 0
                // cur = 0 时，高位需要借位用于低位计算
                // count = (high-1)*bitNum +(99+1)
                // count = high*bitNum - bitNum +(99+1)
                count += high*bitNum;
            }else if(cur == 1){
                // case 2: cur == 1
                // 相当于 高位+低位
                // count = （high*bitNum）+ (low+1)
                count+= high*bitNum+low+1;
            }else{
                // case3 : cur>1
                //相当于 为 0的情况 ，不需要借位来计算
                //count = （high*bitNum）+(低位计算结果)
                count += (high+1)*bitNum;
            }
            //low 、 cur 、 high 都向左偏移一位
            low += cur*bitNum;
            cur = high%10;
            high = high/10;
            bitNum = bitNum*10;
        }
        return count;
    }
}
