package j.com.lib.offer;


/**
 * @author     : zhupp
 * @date       : 2021/8/19
 * description : 数组中连续最大和
 */
public class offer_40_sumOfSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
//        System.out.println(FindGreatestSumOfSubArray(array));

        System.out.println(1234/10);
        System.out.println(1234%10);
        System.out.println(112/10);
        System.out.println(112%10);
        System.out.println(13772/10%10);
    }




    public static int FindGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        int temp = 0;
        for (int a : array) {
            temp = Math.max(temp+a,a);
            result = Math.max(result, temp);
        }
        return result;
    }
}
