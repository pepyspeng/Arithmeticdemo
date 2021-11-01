package j.com.lib.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数组中数字出现的次数
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 */
public class offer_56_2_singleNumbers {

    public int singleNumbers1(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num :
                nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }


}
