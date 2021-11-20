package j.com.lib.offer;


/**
 * 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class offer_14_2_cuttingRope {

    /**
     * 求出当绳子以长度3，等分时，乘积最大
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n < 4) {
            // n=2时，只能分为1、1，结果为1 ;n=3时，只能分为1、2，结果为2。
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if(b == 0){
            //说明正好分隔完成， a个3相乘=3^a
            return (int) Math.pow(3,a);
        }else if(b== 1){
            //余1的话，相乘就浪费了。不如 将1和一个3合并(1*3<4)
            //例如n=10,则 3*3*3*1=27。3*3*4 = 36;
            return (int)Math.pow(3,a-1)*4;
        }else{
            //b=2，直接乘
            return (int)Math.pow(3,a)*2;
        }
    }
}
