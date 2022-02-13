package j.com.lib.leetcode.top;

import java.util.HashMap;

/**
 * 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class lt_560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        //可以用一个map，记录每个前缀和 出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        //base case 和为0的，出现一次
        map.put(0, 1);
        int res = 0;
        int num0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            //记录前缀和
            num0_i += nums[i];
            // 记录前缀和 与 k 之间的差值，主要为了查询在之前是否出现过，
            int num0_j = num0_i - k;
            // 如果出现过说明，有前缀和等于k
            if (map.containsKey(num0_j)) {
                res += map.get(num0_j);
            }
            map.put(num0_i, map.getOrDefault(num0_i, 0) + 1);
        }
        return res;
    }
}
