package j.com.lib.leetcode.top;

import java.util.HashMap;

/**
 * @author : zhupp
 * @date : 2021/10/22
 * description ://给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * //输入：nums = [2,7,11,15], target = 9
 * //输出：[0,1]
 * //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class lt_top_1_twoSum {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{
                -1, -1
        };
    }
}
