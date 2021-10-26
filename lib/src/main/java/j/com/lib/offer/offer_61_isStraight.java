package j.com.lib.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class offer_61_isStraight {

    /**
     * 思路就是找到最大值，最小值
     * max-min<5
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int max = 0;
        int min = 13;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(i == 0){
                continue;
            }
            max = Math.max(max, i);
            min = Math.min(min, i);
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
        }
        return max - min < 5;
    }

}
