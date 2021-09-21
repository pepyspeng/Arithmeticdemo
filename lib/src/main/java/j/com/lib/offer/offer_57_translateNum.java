package j.com.lib.offer;

/**
 * 把数字翻译成字符串
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class offer_57_translateNum {

    public int translateNum(int num){
        if(num<10){
            return 1;
        }
        if(num%100>9 && num%100<25){
            return translateNum(num/10)+translateNum(num/100);
        }else{
            return translateNum(num/10);
        }
    }

}
