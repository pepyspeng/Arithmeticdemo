package j.com.lib.offer;


/**
 * @author     : zhupp
 * @date       : 2021/12/10
 * description :
 */
public class offer_39_majorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }

    /**
     * 数组中出现次数超过一半的数字
     * @param nums  {3, 3, 4}
     * @return  3
     */
    public static int majorityElement(int[] nums) {
        int condit = -1;
        int picket = 0;
        for (int num : nums) {
            if (picket == 0) {
                condit = num;
                picket++;
            } else {
                if (condit == num) {
                    picket++;
                } else {
                    picket--;
                }
            }
        }
        return condit;
    }
}
