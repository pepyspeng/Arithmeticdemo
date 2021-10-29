package j.com.lib.offer;


import java.util.Arrays;

/**
 * @author : zhupp
 * @date : 2021/10/26
 * description : 把数组排成最小的数
 * 输入: [10,2]
 * 输出: "102"
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class offer_45_minNumber {

    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        Arrays.sort(array, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String s :
                array) {
            sb.append(s);
        }
        return sb.toString();
    }
}
