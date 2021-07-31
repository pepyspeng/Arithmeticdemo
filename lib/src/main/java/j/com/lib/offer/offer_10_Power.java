package j.com.lib.offer;

// 数值的整数次方
public class offer_10_Power {

    /***
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        } else {
            if (exponent == 0) {
                return 1;
            } else if (exponent > 0) {
                return base * Power(base, exponent - 1);
            } else {
                return 1 / (base * Power(base, exponent - 1));
            }
        }
    }

    /**
     *  1.求数的次方问题，题目要求不得使用库函数
     *  2.判断次方正负
     *  3.正：递归，乘以自己本身
     *  4.负：递归，先求出正的次方然后1除
     *  5.0，直接返回1
     * @param base
     * @param exponent
     * @return
     */
//    public double Power(double base, int exponent) {
//        if(exponent == 0){
//            return 1;
//        }
//        double temp =base;
//        if (exponent > 0) {
//            for (int i =1;i<exponent;i++){
//                base = base*temp;
//            }
//        }else{
//            for (int i =1;i<Math.abs(exponent);i++){
//                base = base*temp;
//            }
//            base = 1/base;
//        }
//        return  base;
//    }
}
